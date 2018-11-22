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
import javax.swing.SwingConstants;

public class Partida extends JFrame {

	private JPanel contentPane;
	private final JLabel bg = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Partida frame = new Partida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Partida() {
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
		
		JLabel label_7 = new JLabel("00");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_7.setBounds(113, 11, 26, 25);
		contentPane.add(label_7);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(98, 60, 160, 25);
		contentPane.add(panel);
		
		JLabel lblTimeA = new JLabel("Time A");
		panel.add(lblTimeA);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(98, 96, 160, 25);
		contentPane.add(panel_1);
		
		JLabel lblTimeC = new JLabel("Time C");
		panel_1.add(lblTimeC);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(98, 132, 160, 25);
		contentPane.add(panel_2);
		
		JLabel lblTimeE = new JLabel("Time E");
		panel_2.add(lblTimeE);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(98, 168, 160, 25);
		contentPane.add(panel_16);
		panel_16.setBackground(Color.WHITE);
		
		JLabel lblTimeG = new JLabel("Time G");
		panel_16.add(lblTimeG);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(98, 204, 160, 25);
		contentPane.add(panel_4);
		
		JLabel lblTimeI = new JLabel("Time I");
		panel_4.add(lblTimeI);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(98, 240, 160, 25);
		contentPane.add(panel_5);
		
		JLabel lblTimeK = new JLabel("Time K");
		panel_5.add(lblTimeK);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(98, 276, 160, 25);
		contentPane.add(panel_6);
		
		JLabel lblTimeM = new JLabel("Time M");
		panel_6.add(lblTimeM);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(98, 312, 160, 25);
		contentPane.add(panel_7);
		
		JLabel lblTimeO = new JLabel("Time O");
		panel_7.add(lblTimeO);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(325, 60, 160, 25);
		contentPane.add(panel_8);
		
		JLabel lblTimeB = new JLabel("Time B");
		panel_8.add(lblTimeB);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(325, 96, 160, 25);
		contentPane.add(panel_9);
		
		JLabel lblTimeD = new JLabel("Time D");
		panel_9.add(lblTimeD);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(325, 132, 160, 25);
		contentPane.add(panel_10);
		
		JLabel lblTimeF = new JLabel("Time F");
		panel_10.add(lblTimeF);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_11.setBounds(325, 168, 160, 25);
		contentPane.add(panel_11);
		
		JLabel lblTimeH = new JLabel("Time H");
		panel_11.add(lblTimeH);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		panel_12.setBounds(325, 204, 160, 25);
		contentPane.add(panel_12);
		
		JLabel lblTimeJ = new JLabel("Time J");
		panel_12.add(lblTimeJ);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		panel_13.setBounds(325, 240, 160, 25);
		contentPane.add(panel_13);
		
		JLabel lblTimeL = new JLabel("Time L");
		panel_13.add(lblTimeL);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		panel_14.setBounds(325, 276, 160, 25);
		contentPane.add(panel_14);
		
		JLabel lblTimeN = new JLabel("Time N");
		panel_14.add(lblTimeN);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.WHITE);
		panel_15.setBounds(325, 312, 160, 25);
		contentPane.add(panel_15);
		
		JLabel lblTimeP = new JLabel("Time P");
		panel_15.add(lblTimeP);
		
		JLabel label = new JLabel(" 0");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(262, 96, 20, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel(" X");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(281, 96, 20, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel(" 0");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setBounds(302, 96, 20, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel(" 0");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_3.setBounds(262, 132, 20, 25);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel(" X");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_4.setBounds(281, 132, 20, 25);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel(" 0");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_5.setBounds(302, 132, 20, 25);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel(" 0");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_6.setBounds(262, 168, 20, 25);
		contentPane.add(label_6);
		
		JLabel label_10 = new JLabel(" X");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_10.setBounds(281, 168, 20, 25);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel(" 0");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_11.setBounds(302, 168, 20, 25);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel(" 0");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_12.setBounds(262, 204, 20, 25);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel(" X");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_13.setBounds(281, 204, 20, 25);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel(" 0");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_14.setBounds(302, 204, 20, 25);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel(" 0");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_15.setBounds(262, 240, 20, 25);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel(" X");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_16.setBounds(281, 240, 20, 25);
		contentPane.add(label_16);
		
		JLabel label_18 = new JLabel(" 0");
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_18.setBounds(302, 240, 20, 25);
		contentPane.add(label_18);
		
		JLabel label_19 = new JLabel(" 0");
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_19.setBounds(262, 276, 20, 25);
		contentPane.add(label_19);
		
		JLabel label_20 = new JLabel(" X");
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_20.setBounds(281, 276, 20, 25);
		contentPane.add(label_20);
		
		JLabel label_21 = new JLabel(" 0");
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_21.setBounds(302, 276, 20, 25);
		contentPane.add(label_21);
		
		JLabel label_22 = new JLabel(" 0");
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_22.setBounds(262, 312, 20, 25);
		contentPane.add(label_22);
		
		JLabel label_23 = new JLabel(" X");
		label_23.setForeground(Color.WHITE);
		label_23.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_23.setBounds(281, 312, 20, 25);
		contentPane.add(label_23);
		
		JLabel label_24 = new JLabel(" 0");
		label_24.setForeground(Color.WHITE);
		label_24.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_24.setBounds(302, 312, 20, 25);
		contentPane.add(label_24);
		
		JLabel label_17 = new JLabel(" 0");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_17.setBounds(302, 60, 20, 25);
		contentPane.add(label_17);
		
		JLabel label_9 = new JLabel(" 0");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_9.setBounds(262, 60, 20, 25);
		contentPane.add(label_9);
		
		JLabel lblX = new JLabel(" X");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblX.setForeground(Color.WHITE);
		lblX.setBounds(281, 60, 20, 25);
		contentPane.add(lblX);
		
		JLabel label_8 = new JLabel("00");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_8.setBounds(392, 11, 26, 25);
		contentPane.add(label_8);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(40);
		progressBar.setBackground(SystemColor.controlLtHighlight);
		progressBar.setMaximum(89);
		progressBar.setBounds(428, 11, 146, 25);
		contentPane.add(progressBar);
		bg.setIcon(new ImageIcon(Partida.class.getResource("/Imagens/fundo.png")));
		bg.setBounds(0, 0, 584, 360);
		contentPane.add(bg);
	}
}
