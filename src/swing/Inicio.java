package swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Campeonato;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setLocationRelativeTo(null);
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
	public Inicio() {
		setTitle("FUTIRIO");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton creditos = new JButton("Créditos");
		creditos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Creditos creditos = new Creditos();
				creditos.setLocationRelativeTo(null);
				creditos.setVisible(true);
				Inicio.this.dispose();
			}
		});
		creditos.setBounds(233, 268, 133, 23);
		contentPane.add(creditos);

		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton jogar = new JButton("Novo Jogo");
		jogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciaTecnico gerencia = new GerenciaTecnico();
				gerencia.setLocationRelativeTo(null);
				gerencia.setVisible(true);
				Inicio.this.dispose();
			}
		});
		jogar.setBounds(233, 200, 133, 23);
		contentPane.add(jogar);

		JButton btnCarregarJogo = new JButton("Carregar Jogo");
		btnCarregarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OJogo futirio = carregarJogo();
				futirio.setCarioca(carregarCarioca());
				GerenciaTime jogo = new GerenciaTime(futirio);
				jogo.setLocationRelativeTo(null);
				jogo.setVisible(true);
				dispose();
			}
		});
		btnCarregarJogo.setBounds(233, 234, 133, 23);
		contentPane.add(btnCarregarJogo);
		sair.setBounds(233, 302, 133, 23);
		contentPane.add(sair);

		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon(Inicio.class.getResource("/Imagens/mainBG.png")));
		background.setBounds(0, 0, 594, 370);
		contentPane.add(background);
	}

	public OJogo carregarJogo() {
		OJogo oJogo = new OJogo();

		try {
			ObjectInputStream objIn = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("src/saves/futirio")));
			oJogo = (OJogo) objIn.readObject();
			objIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return oJogo;
	}
	
	public Campeonato carregarCarioca() {
		Campeonato carioca = new Campeonato(0);

		try {
			ObjectInputStream objIn = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("src/saves/carioca")));
			carioca = (Campeonato) objIn.readObject();
			objIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return carioca;
	}
}
