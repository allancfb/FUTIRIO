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

import entity.Time;
import entity.Campeonato;
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
	public Campeao(Time time, Campeonato campeonato) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 426);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nomeTime = new JLabel(time.getNome());
		nomeTime.setFont(new Font("Tahoma", Font.PLAIN, 50));
		nomeTime.setForeground(Color.WHITE);
		nomeTime.setHorizontalAlignment(SwingConstants.CENTER);
		nomeTime.setBounds(156, 11, 428, 64);
		contentPane.add(nomeTime);
		
		JLabel lblCampeoCarioca = new JLabel("CAMPE\u00C3O CARIOCA "+campeonato.getAno());
		lblCampeoCarioca.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCampeoCarioca.setHorizontalAlignment(SwingConstants.CENTER);
		lblCampeoCarioca.setForeground(Color.WHITE);
		lblCampeoCarioca.setBounds(156, 86, 428, 36);
		contentPane.add(lblCampeoCarioca);
		
		JLabel escudo = new JLabel("");
		escudo.setIcon(new ImageIcon(Campeao.class.getResource(time.getEscudo())));
		escudo.setBounds(36, 11, 110, 111);
		contentPane.add(escudo);
		
		JLabel taca = new JLabel("");
		taca.setIcon(new ImageIcon(Campeao.class.getResource("/Imagens/taca.png")));
		taca.setBounds(140, 133, 277, 210);
		contentPane.add(taca);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Começa o campeonato do ano seguinte
				Campeonato carioca = new Campeonato(campeonato.getAno()+1);
				//gerenciaTime jogo = new gerenciaTime(carioca.getTimes().get(index),nomeTecnico.getText(),times.getSelectedIndex(),carioca);
				//jogo.setVisible(true);
				Campeao.this.dispose();
			}
		});
		btnContinuar.setBounds(461, 349, 89, 23);
		contentPane.add(btnContinuar);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(Campeao.class.getResource("/Imagens/fundo.png")));
		bg.setBounds(0, 0, 600, 399);
		contentPane.add(bg);
	}
}
