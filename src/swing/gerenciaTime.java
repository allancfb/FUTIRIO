package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

public class gerenciaTime extends JFrame {

	private JPanel contentPane;

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
		escudoTime.setBounds(10, 11, 525, 282);
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
