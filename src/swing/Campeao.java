package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class Campeao extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Campeao frame = new Campeao();
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
	public Campeao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 426);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nomeTime = new JLabel("VOLTA REDONDA");
		nomeTime.setFont(new Font("Tahoma", Font.PLAIN, 50));
		nomeTime.setForeground(Color.WHITE);
		nomeTime.setHorizontalAlignment(SwingConstants.CENTER);
		nomeTime.setBounds(156, 11, 428, 64);
		contentPane.add(nomeTime);
		
		JLabel lblCampeoCarioca = new JLabel("CAMPE\u00C3O CARIOCA 2019");
		lblCampeoCarioca.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCampeoCarioca.setHorizontalAlignment(SwingConstants.CENTER);
		lblCampeoCarioca.setForeground(Color.WHITE);
		lblCampeoCarioca.setBounds(156, 86, 428, 36);
		contentPane.add(lblCampeoCarioca);
		
		JLabel escudo = new JLabel("");
		escudo.setIcon(new ImageIcon(Campeao.class.getResource("/iconTimes/iconVoltaRedonda.png")));
		escudo.setBounds(36, 11, 110, 111);
		contentPane.add(escudo);
		
		JLabel taca = new JLabel("");
		taca.setIcon(new ImageIcon(Campeao.class.getResource("/Imagens/taca.png")));
		taca.setBounds(140, 133, 277, 210);
		contentPane.add(taca);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(461, 349, 89, 23);
		contentPane.add(btnContinuar);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(Campeao.class.getResource("/Imagens/fundo.png")));
		bg.setBounds(0, 0, 600, 399);
		contentPane.add(bg);
	}
}
