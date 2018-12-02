package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import entity.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RodadaSwing extends JFrame {

	private JPanel contentPane;
	private final JLabel bg = new JLabel("");

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public RodadaSwing(OJogo futirio) {

		Rodada rodada = futirio.getCarioca().getRodadaAtual();
		PartidaSwing[] partidas = new PartidaSwing[8];

		for (int i = 0; i < 8; i++) {
			int y = 60;
			partidas[i] = new PartidaSwing((y + (36 * i)), rodada.getPartidas().get(i).getTime1().getNome(),
					rodada.getPartidas().get(i).getTime2().getNome());

		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 399);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRodada = new JLabel("Rodada: " + Integer.toString(futirio.getCarioca().getIndexRodadaAtual()));
		lblRodada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRodada.setForeground(Color.WHITE);
		lblRodada.setBounds(26, 11, 112, 25);
		contentPane.add(lblRodada);

		JLabel lblTempo = new JLabel("Tempo: ");
		lblTempo.setForeground(Color.WHITE);
		lblTempo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTempo.setBounds(318, 11, 75, 25);
		contentPane.add(lblTempo);

		JLabel intTempo = new JLabel("00");
		intTempo.setBounds(396, 11, 22, 25);
		intTempo.setForeground(Color.WHITE);
		intTempo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(intTempo);

		ArrayList<JPanel> timesA = new ArrayList<JPanel>();
		ArrayList<JPanel> timesB = new ArrayList<JPanel>();
		ArrayList<JLabel> labelsTimes = new ArrayList<JLabel>();
		ArrayList<JPanel> placares = new ArrayList<JPanel>();
		ArrayList<JLabel> golsA = new ArrayList<JLabel>();
		ArrayList<JLabel> golsB = new ArrayList<JLabel>();
		ArrayList<JLabel> Xs = new ArrayList<JLabel>();

		for (int i = 0; i < 8; i++) {

			timesA.add(partidas[i].getTimeA());
			timesB.add(partidas[i].getTimeB());
			placares.add(partidas[i].getPlacar());
			contentPane.add(timesA.get(i));
			contentPane.add(timesB.get(i));
			contentPane.add(placares.get(i));
			labelsTimes.add(partidas[i].getLblTimeA());
			labelsTimes.add(partidas[i].getLblTimeB());
			golsA.add(partidas[i].getPartidaGolsA());
			golsB.add(partidas[i].getPartidaGolsB());
			Xs.add(partidas[i].getX());

		}

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(SystemColor.controlLtHighlight);
		progressBar.setMaximum(89);
		progressBar.setBounds(428, 11, 146, 25);
		contentPane.add(progressBar);

		JButton continuar = new JButton("Continuar");
		continuar.setVisible(false);
		continuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (futirio.getCarioca().getIndexRodadaAtual() != 16) {
					GerenciaTime telaTime = new GerenciaTime(futirio);
					telaTime.setLocationRelativeTo(null);
					telaTime.setVisible(true);
					dispose();
				} else {
					futirio.getCarioca().setCampeao(futirio.getCarioca().getTabela().get(0).getTime());
					System.out.println(futirio.getCarioca().getCampeao().getNome());
					Campeao campeao = new Campeao(futirio);
					campeao.setLocationRelativeTo(null);
					campeao.setVisible(true);
					dispose();
				}
			}
		});
		continuar.setBounds(490, 326, 89, 23);
		contentPane.add(continuar);

		JButton comecar = new JButton("Começar");
		comecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comecar.setVisible(false);
				Thread jogo = new Thread(new RodaJogos(RodadaSwing.this, rodada, intTempo, progressBar, golsA, golsB,
						futirio, continuar));

				jogo.start();
			}
		});
		comecar.setBounds(5, 326, 89, 23);
		contentPane.add(comecar);

		bg.setIcon(new ImageIcon(RodadaSwing.class.getResource("/Imagens/fundoGrande.png")));
		bg.setBounds(0, 0, 594, 370);
		contentPane.add(bg);

	}

	public void terminarRodada(OJogo futirio) {
		ArrayList<Partida> partidas = futirio.getCarioca().getRodadaAtual().getPartidas();

		for (Partida partida : partidas) {
			TimeTabela time1 = partida.getTime1().getTimeTabela();
			TimeTabela time2 = partida.getTime2().getTimeTabela();

			if (partida.getTime1Gols() > partida.getTime2Gols()) {
				time1.addVitoria();
				time2.addDerrota();
			} else if (partida.getTime2Gols() > partida.getTime1Gols()) {
				time2.addVitoria();
				time1.addDerrota();
			} else {
				time1.addEmpate();
				time2.addEmpate();
			}

			time1.addQtGols(partida.getTime1Gols());
			time1.addGolsSofridos(partida.getTime2Gols());
			time2.addQtGols(partida.getTime2Gols());
			time2.addGolsSofridos(partida.getTime1Gols());
		}

		futirio.getCarioca().organizaTabela();
		futirio.getCarioca().criarListaDeTransferencia();
	}
}
