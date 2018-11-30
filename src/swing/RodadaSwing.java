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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRodada = new JLabel("Rodada: " + Integer.toString(futirio.getCarioca().getIndexRodadaAtual()));
		lblRodada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRodada.setForeground(Color.WHITE);
		lblRodada.setBounds(26, 11, 91, 25);
		contentPane.add(lblRodada);

		JLabel lblTempo = new JLabel("Tempo: ");
		lblTempo.setForeground(Color.WHITE);
		lblTempo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTempo.setBounds(318, 11, 75, 25);
		contentPane.add(lblTempo);

		JLabel intTempo = new JLabel("00");
		intTempo.setBounds(396, 11, 22, 25);
		contentPane.add(intTempo);
		intTempo.setForeground(Color.WHITE);
		intTempo.setFont(new Font("Tahoma", Font.PLAIN, 20));

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
				if(futirio.getCarioca().getIndexRodadaAtual()!=16) {
					GerenciaTime telaTime = new GerenciaTime(futirio);
					telaTime.setLocationRelativeTo(null);
					telaTime.setVisible(true);
					dispose();
				}else {
					//vai pra tela de campeão
					/*Campeao campeao = new Campeao(primeiroColocadoNaTabela, campeonato);
					campeao.setLocationRelativeTo(null);
					campeao.setVisible(true);
					dispose();*/
				}
			}
		});
		continuar.setBounds(490, 326, 89, 23);
		contentPane.add(continuar);

		JButton começar = new JButton("Come\u00E7ar");
		começar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				começar.setVisible(false);
				new Thread(new Runnable() {

					public void run() {
						for (int i = 1; i <= 90; i++) {
							rodada.run();
							intTempo.setText(Integer.toString(rodada.getMinuto()));
							progressBar.setValue(rodada.getMinuto());

							for (int j = 0; j < 8; j++) {
								golsA.get(j)
										.setText(" " + Integer.toString(rodada.getPartidas().get(j).getTime1Gols()));
								golsB.get(j)
										.setText(" " + Integer.toString(rodada.getPartidas().get(j).getTime2Gols()));
							}

							if (i == 90) {
								JOptionPane.showMessageDialog(null, "A rodada acabou!");
								continuar.setVisible(true);
								futirio.getCarioca().PassarRodada();
							}

						}
					}
				}).start();

			}
		});
		começar.setBounds(5, 326, 89, 23);
		contentPane.add(começar);

		bg.setIcon(new ImageIcon(RodadaSwing.class.getResource("/Imagens/fundo.png")));
		bg.setBounds(0, 0, 584, 360);
		contentPane.add(bg);

	}
}
