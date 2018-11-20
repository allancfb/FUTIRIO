package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class gerenciaTime extends JFrame {

	private JPanel contentPane;
	private JTable jogadores;

	static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public gerenciaTime(String nome, String tecnico, int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Pega o nome completo do time
		for (Time getTime : Time.values()) {
			if (getTime.name() == nome) {
				nome = getTime.getNomeCompleto();
				index = getTime.getIndex();
			}
		}
		
		JLabel escudoTime = new JLabel();
		Image escudo = new ImageIcon(this.getClass().getResource("/Imagens/"+Integer.toString(index)+".png")).getImage();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 132, 440, 302);
		contentPane.add(scrollPane);
		
		jogadores = new JTable();
		scrollPane.setViewportView(jogadores);
		escudoTime.setIcon(new ImageIcon(escudo));
		escudoTime.setBounds(21, 11, 110, 110);
		contentPane.add(escudoTime);

		JLabel nomeTime = new JLabel(nome);
		nomeTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeTime.setBounds(152, 11, 394, 33);
		contentPane.add(nomeTime);

		JLabel nomeTecnico = new JLabel("Técnico: " + tecnico);
		nomeTecnico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeTecnico.setBounds(152, 55, 394, 33);
		contentPane.add(nomeTecnico);
	}
}
