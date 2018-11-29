package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JLabel;
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
		ArrayList<Partida> partidas = rodada.getPartidas();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRodada = new JLabel("Rodada: ");
		lblRodada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRodada.setForeground(Color.WHITE);
		lblRodada.setBounds(26, 11, 91, 25);
		contentPane.add(lblRodada);

		JLabel lblTempo = new JLabel("Tempo: ");
		lblTempo.setForeground(Color.WHITE);
		lblTempo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTempo.setBounds(318, 11, 75, 25);
		contentPane.add(lblTempo);

		JLabel intRodada = new JLabel("00");
		intRodada.setForeground(Color.WHITE);
		intRodada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		intRodada.setBounds(109, 11, 26, 25);
		contentPane.add(intRodada);

		JLabel intTempo = new JLabel("00");
		intTempo.setBounds(396, 11, 22, 25);
		contentPane.add(intTempo);
		intTempo.setForeground(Color.WHITE);
		intTempo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JPanel TimeA = new JPanel();
		TimeA.setBackground(Color.WHITE);
		TimeA.setBounds(98, 60, 160, 25);
		contentPane.add(TimeA);

		JLabel lblTimeA = new JLabel(rodada.getPartidas().get(0).getTime1().getNome());
		TimeA.add(lblTimeA);

		JPanel TimeB = new JPanel();
		TimeB.setBackground(Color.WHITE);
		TimeB.setBounds(325, 60, 160, 25);
		contentPane.add(TimeB);

		JLabel lblTimeB = new JLabel(rodada.getPartidas().get(0).getTime2().getNome());
		TimeB.add(lblTimeB);

		JPanel TimeC = new JPanel();
		TimeC.setBackground(Color.WHITE);
		TimeC.setBounds(98, 96, 160, 25);
		contentPane.add(TimeC);

		JLabel lblTimeC = new JLabel(rodada.getPartidas().get(1).getTime1().getNome());
		TimeC.add(lblTimeC);

		JPanel TimeD = new JPanel();
		TimeD.setBackground(Color.WHITE);
		TimeD.setBounds(325, 96, 160, 25);
		contentPane.add(TimeD);

		JLabel lblTimeD = new JLabel(rodada.getPartidas().get(1).getTime2().getNome());
		TimeD.add(lblTimeD);

		JPanel TimeE = new JPanel();
		TimeE.setBackground(Color.WHITE);
		TimeE.setBounds(98, 132, 160, 25);
		contentPane.add(TimeE);

		JLabel lblTimeE = new JLabel(rodada.getPartidas().get(2).getTime1().getNome());
		TimeE.add(lblTimeE);

		JPanel TimeF = new JPanel();
		TimeF.setBackground(Color.WHITE);
		TimeF.setBounds(325, 132, 160, 25);
		contentPane.add(TimeF);

		JLabel lblTimeF = new JLabel(rodada.getPartidas().get(2).getTime2().getNome());
		TimeF.add(lblTimeF);

		JPanel TimeG = new JPanel();
		TimeG.setBounds(98, 168, 160, 25);
		contentPane.add(TimeG);
		TimeG.setBackground(Color.WHITE);

		JLabel lblTimeG = new JLabel(rodada.getPartidas().get(3).getTime1().getNome());
		TimeG.add(lblTimeG);

		JPanel TimeH = new JPanel();
		TimeH.setBackground(Color.WHITE);
		TimeH.setBounds(325, 168, 160, 25);
		contentPane.add(TimeH);

		JLabel lblTimeH = new JLabel(rodada.getPartidas().get(3).getTime2().getNome());
		TimeH.add(lblTimeH);

		JPanel TimeI = new JPanel();
		TimeI.setBackground(Color.WHITE);
		TimeI.setBounds(98, 204, 160, 25);
		contentPane.add(TimeI);

		JLabel lblTimeI = new JLabel(rodada.getPartidas().get(4).getTime1().getNome());
		TimeI.add(lblTimeI);

		JPanel TimeJ = new JPanel();
		TimeJ.setBackground(Color.WHITE);
		TimeJ.setBounds(325, 204, 160, 25);
		contentPane.add(TimeJ);

		JLabel lblTimeJ = new JLabel(rodada.getPartidas().get(4).getTime2().getNome());
		TimeJ.add(lblTimeJ);

		JPanel TimeK = new JPanel();
		TimeK.setBackground(Color.WHITE);
		TimeK.setBounds(98, 240, 160, 25);
		contentPane.add(TimeK);

		JLabel lblTimeK = new JLabel(rodada.getPartidas().get(5).getTime1().getNome());
		TimeK.add(lblTimeK);

		JPanel TimeL = new JPanel();
		TimeL.setBackground(Color.WHITE);
		TimeL.setBounds(325, 240, 160, 25);
		contentPane.add(TimeL);

		JLabel lblTimeL = new JLabel(rodada.getPartidas().get(5).getTime2().getNome());
		TimeL.add(lblTimeL);

		JPanel TimeM = new JPanel();
		TimeM.setBackground(Color.WHITE);
		TimeM.setBounds(98, 276, 160, 25);
		contentPane.add(TimeM);

		JLabel lblTimeM = new JLabel(rodada.getPartidas().get(6).getTime1().getNome());
		TimeM.add(lblTimeM);

		JPanel TimeN = new JPanel();
		TimeN.setBackground(Color.WHITE);
		TimeN.setBounds(325, 276, 160, 25);
		contentPane.add(TimeN);

		JLabel lblTimeN = new JLabel(rodada.getPartidas().get(6).getTime2().getNome());
		TimeN.add(lblTimeN);

		JPanel TimeO = new JPanel();
		TimeO.setBackground(Color.WHITE);
		TimeO.setBounds(98, 312, 160, 25);
		contentPane.add(TimeO);

		JLabel lblTimeO = new JLabel(rodada.getPartidas().get(7).getTime1().getNome());
		TimeO.add(lblTimeO);

		JPanel TimeP = new JPanel();
		TimeP.setBackground(Color.WHITE);
		TimeP.setBounds(325, 312, 160, 25);
		contentPane.add(TimeP);

		JLabel lblTimeP = new JLabel(rodada.getPartidas().get(7).getTime2().getNome());
		TimeP.add(lblTimeP);

		JPanel placar1 = new JPanel();
		placar1.setBackground(new Color(28, 104, 30));
		placar1.setBounds(262, 60, 60, 25);
		contentPane.add(placar1);
		placar1.setLayout(null);

		JLabel Partida1GolsA = new JLabel(" 0");
		Partida1GolsA.setBounds(0, 0, 20, 25);
		placar1.add(Partida1GolsA);
		Partida1GolsA.setForeground(Color.WHITE);
		Partida1GolsA.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel X1 = new JLabel(" X");
		X1.setBounds(19, 0, 20, 25);
		placar1.add(X1);
		X1.setForeground(Color.WHITE);
		X1.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel Partida1GolsB = new JLabel(" 0");
		Partida1GolsB.setBounds(40, 0, 20, 25);
		placar1.add(Partida1GolsB);
		Partida1GolsB.setForeground(Color.WHITE);
		Partida1GolsB.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JPanel placar2 = new JPanel();
		placar2.setLayout(null);
		placar2.setBackground(new Color(28, 104, 30));
		placar2.setBounds(262, 96, 60, 25);
		contentPane.add(placar2);

		JLabel Partida2GolsA = new JLabel(" 0");
		Partida2GolsA.setForeground(Color.WHITE);
		Partida2GolsA.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Partida2GolsA.setBounds(0, 0, 20, 25);
		placar2.add(Partida2GolsA);

		JLabel X2 = new JLabel(" X");
		X2.setForeground(Color.WHITE);
		X2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		X2.setBounds(19, 0, 20, 25);
		placar2.add(X2);

		JLabel Partida2GolsB = new JLabel(" 0");
		Partida2GolsB.setForeground(Color.WHITE);
		Partida2GolsB.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Partida2GolsB.setBounds(40, 0, 20, 25);
		placar2.add(Partida2GolsB);

		JPanel placar3 = new JPanel();
		placar3.setLayout(null);
		placar3.setBackground(new Color(28, 104, 30));
		placar3.setBounds(262, 132, 60, 25);
		contentPane.add(placar3);

		JLabel Partida3GolsA = new JLabel(" 0");
		Partida3GolsA.setForeground(Color.WHITE);
		Partida3GolsA.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Partida3GolsA.setBounds(0, 0, 20, 25);
		placar3.add(Partida3GolsA);

		JLabel X3 = new JLabel(" X");
		X3.setForeground(Color.WHITE);
		X3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		X3.setBounds(19, 0, 20, 25);
		placar3.add(X3);

		JLabel Partida3GolsB = new JLabel(" 0");
		Partida3GolsB.setForeground(Color.WHITE);
		Partida3GolsB.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Partida3GolsB.setBounds(40, 0, 20, 25);
		placar3.add(Partida3GolsB);

		JPanel placar4 = new JPanel();
		placar4.setLayout(null);
		placar4.setBackground(new Color(28, 104, 30));
		placar4.setBounds(262, 168, 60, 25);
		contentPane.add(placar4);

		JLabel Partida4GolsA = new JLabel(" 0");
		Partida4GolsA.setForeground(Color.WHITE);
		Partida4GolsA.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Partida4GolsA.setBounds(0, 0, 20, 25);
		placar4.add(Partida4GolsA);

		JLabel X4 = new JLabel(" X");
		X4.setForeground(Color.WHITE);
		X4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		X4.setBounds(19, 0, 20, 25);
		placar4.add(X4);

		JLabel Partida4GolsB = new JLabel(" 0");
		Partida4GolsB.setForeground(Color.WHITE);
		Partida4GolsB.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Partida4GolsB.setBounds(40, 0, 20, 25);
		placar4.add(Partida4GolsB);

		JPanel placar5 = new JPanel();
		placar5.setLayout(null);
		placar5.setBackground(new Color(28, 104, 30));
		placar5.setBounds(262, 204, 60, 25);
		contentPane.add(placar5);

		JLabel Partida5GolsA = new JLabel(" 0");
		Partida5GolsA.setForeground(Color.WHITE);
		Partida5GolsA.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Partida5GolsA.setBounds(0, 0, 20, 25);
		placar5.add(Partida5GolsA);

		JLabel X5 = new JLabel(" X");
		X5.setForeground(Color.WHITE);
		X5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		X5.setBounds(19, 0, 20, 25);
		placar5.add(X5);

		JLabel Partida5GolsB = new JLabel(" 0");
		Partida5GolsB.setForeground(Color.WHITE);
		Partida5GolsB.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Partida5GolsB.setBounds(40, 0, 20, 25);
		placar5.add(Partida5GolsB);

		JPanel placar6 = new JPanel();
		placar6.setLayout(null);
		placar6.setBackground(new Color(28, 104, 30));
		placar6.setBounds(262, 240, 60, 25);
		contentPane.add(placar6);

		JLabel Partida6GolsA = new JLabel(" 0");
		Partida6GolsA.setForeground(Color.WHITE);
		Partida6GolsA.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Partida6GolsA.setBounds(0, 0, 20, 25);
		placar6.add(Partida6GolsA);

		JLabel X6 = new JLabel(" X");
		X6.setForeground(Color.WHITE);
		X6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		X6.setBounds(19, 0, 20, 25);
		placar6.add(X6);

		JLabel Partida6GolsB = new JLabel(" 0");
		Partida6GolsB.setForeground(Color.WHITE);
		Partida6GolsB.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Partida6GolsB.setBounds(40, 0, 20, 25);
		placar6.add(Partida6GolsB);

		JPanel placar7 = new JPanel();
		placar7.setLayout(null);
		placar7.setBackground(new Color(28, 104, 30));
		placar7.setBounds(262, 276, 60, 25);
		contentPane.add(placar7);

		JLabel Partida7GolsA = new JLabel(" 0");
		Partida7GolsA.setForeground(Color.WHITE);
		Partida7GolsA.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Partida7GolsA.setBounds(0, 0, 20, 25);
		placar7.add(Partida7GolsA);

		JLabel X7 = new JLabel(" X");
		X7.setForeground(Color.WHITE);
		X7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		X7.setBounds(19, 0, 20, 25);
		placar7.add(X7);

		JLabel Partida7GolsB = new JLabel(" 0");
		Partida7GolsB.setForeground(Color.WHITE);
		Partida7GolsB.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Partida7GolsB.setBounds(40, 0, 20, 25);
		placar7.add(Partida7GolsB);

		JPanel placar8 = new JPanel();
		placar8.setLayout(null);
		placar8.setBackground(new Color(28, 104, 30));
		placar8.setBounds(262, 312, 60, 25);
		contentPane.add(placar8);

		JLabel Partida8GolsA = new JLabel(" 0");
		Partida8GolsA.setForeground(Color.WHITE);
		Partida8GolsA.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Partida8GolsA.setBounds(0, 0, 20, 25);
		placar8.add(Partida8GolsA);

		JLabel X8 = new JLabel(" X");
		X8.setForeground(Color.WHITE);
		X8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		X8.setBounds(19, 0, 20, 25);
		placar8.add(X8);

		JLabel Partida8GolsB = new JLabel(" 0");
		Partida8GolsB.setForeground(Color.WHITE);
		Partida8GolsB.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Partida8GolsB.setBounds(40, 0, 20, 25);
		placar8.add(Partida8GolsB);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(SystemColor.controlLtHighlight);
		progressBar.setMaximum(89);
		progressBar.setBounds(428, 11, 146, 25);
		contentPane.add(progressBar);

		JButton começar = new JButton("Come\u00E7ar");
		começar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Thread(new Runnable() {

					public void run() {
						for (int i = 1; i <= 90; i++) {

							rodada.run();
							intTempo.setText(Integer.toString(rodada.getMinuto()));
							intRodada.setText(Integer.toString(futirio.getCarioca().getIndexRodadaAtual()));
							progressBar.setValue(rodada.getMinuto());
							Partida1GolsA.setText(" " +Integer.toString(rodada.getPartidas().get(0).getTime1Gols()));
							Partida1GolsB.setText(" " +Integer.toString(rodada.getPartidas().get(0).getTime2Gols()));
							Partida2GolsA.setText(" " +Integer.toString(rodada.getPartidas().get(1).getTime1Gols()));
							Partida2GolsB.setText(" " +Integer.toString(rodada.getPartidas().get(1).getTime2Gols()));
							Partida3GolsA.setText(" " +Integer.toString(rodada.getPartidas().get(2).getTime1Gols()));
							Partida3GolsB.setText(" " +Integer.toString(rodada.getPartidas().get(2).getTime2Gols()));
							Partida4GolsA.setText(" " +Integer.toString(rodada.getPartidas().get(3).getTime1Gols()));
							Partida4GolsB.setText(" " +Integer.toString(rodada.getPartidas().get(3).getTime2Gols()));
							Partida5GolsA.setText(" " +Integer.toString(rodada.getPartidas().get(4).getTime1Gols()));
							Partida5GolsB.setText(" " +Integer.toString(rodada.getPartidas().get(4).getTime2Gols()));
							Partida6GolsA.setText(" " +Integer.toString(rodada.getPartidas().get(5).getTime1Gols()));
							Partida6GolsB.setText(" " +Integer.toString(rodada.getPartidas().get(5).getTime2Gols()));
							Partida7GolsA.setText(" " +Integer.toString(rodada.getPartidas().get(6).getTime1Gols()));
							Partida7GolsB.setText(" " +Integer.toString(rodada.getPartidas().get(6).getTime2Gols()));
							Partida8GolsA.setText(" " +Integer.toString(rodada.getPartidas().get(7).getTime1Gols()));
							Partida8GolsB.setText(" " +Integer.toString(rodada.getPartidas().get(7).getTime2Gols()));

							if (i == 90) {
								futirio.getCarioca().PassarRodada();
							}

						}
					}
				}).start();

			}
		});
		começar.setBounds(5, 326, 89, 23);
		contentPane.add(começar);

		JButton terminar = new JButton("Terminar");
		terminar.setBounds(490, 326, 89, 23);
		contentPane.add(terminar);
		bg.setIcon(new ImageIcon(RodadaSwing.class.getResource("/Imagens/fundo.png")));
		bg.setBounds(0, 0, 584, 360);
		contentPane.add(bg);

	}
}
