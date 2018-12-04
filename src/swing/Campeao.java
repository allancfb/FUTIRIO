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
import java.awt.Image;

import javax.swing.JButton;

import entity.Time;
import entity.Campeonato;
import entity.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Campeao extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Campeao(OJogo futirio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 426);
		setResizable(false);
		setTitle(futirio.getCarioca().getCampeao().getNome().toUpperCase()+" CAMPE�O!!!!");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel nomeTime = new JLabel(futirio.getCarioca().getCampeao().getNome().toUpperCase());
		nomeTime.setFont(new Font("Tahoma", Font.PLAIN, 50));
		nomeTime.setForeground(Color.WHITE);
		nomeTime.setHorizontalAlignment(SwingConstants.CENTER);
		nomeTime.setBounds(156, 11, 428, 64);
		contentPane.add(nomeTime);

		JLabel lblCampeoCarioca = new JLabel("CAMPE\u00C3O CARIOCA " + futirio.getCarioca().getAno());
		lblCampeoCarioca.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCampeoCarioca.setHorizontalAlignment(SwingConstants.CENTER);
		lblCampeoCarioca.setForeground(Color.WHITE);
		lblCampeoCarioca.setBounds(156, 86, 428, 36);
		contentPane.add(lblCampeoCarioca);

		JLabel escudo = new JLabel("");
		escudo.setBounds(36, 11, 110, 111);
		Image escudoCampeao = new ImageIcon(Main.carregarEscudo(futirio.getCarioca().getCampeao())).getImage();
		escudo.setIcon(new ImageIcon(escudoCampeao));
		contentPane.add(escudo);

		JLabel taca = new JLabel("");
		taca.setIcon(new ImageIcon(Campeao.class.getResource("/Imagens/taca.png")));
		taca.setBounds(140, 133, 277, 210);
		contentPane.add(taca);

		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnTerminar.setBounds(461, 349, 89, 23);
		contentPane.add(btnTerminar);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(Campeao.class.getResource("/Imagens/fundo.png")));
		bg.setBounds(0, 0, 600, 399);
		contentPane.add(bg);
	}
}
