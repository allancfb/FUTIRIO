package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

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

	public gerenciaTime(String nome, String tecnico) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nomeTime = new JLabel(nome);
		nomeTime.setBounds(124, 11, 98, 21);
		contentPane.add(nomeTime);
		
		JLabel nomeTecnico = new JLabel("Técnico: "+tecnico);
		nomeTecnico.setBounds(124, 32, 98, 21);
		contentPane.add(nomeTecnico);
	}
}
