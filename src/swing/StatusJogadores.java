package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatusJogadores extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 *

	/**
	 * Create the frame.
	 */
	public StatusJogadores(OJogo futirio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 399);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStatusDosJogadores = new JLabel("Status dos Jogadores");
		lblStatusDosJogadores.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblStatusDosJogadores.setForeground(Color.WHITE);
		lblStatusDosJogadores.setBounds(123, 25, 272, 35);
		contentPane.add(lblStatusDosJogadores);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 73, 443, 259);
		contentPane.add(scrollPane);
		
		String[] colunas = {"Posição","Nome","Habilidade","Chute","Passe","Drible","Desarme","Defesa"};
		String[][] jogadores = futirio.getCarioca().getTimes().get(futirio.getIndexTime()).getAllAtributosJogador(); 
		
		table = new JTable(jogadores,colunas);
		//table = new JTable();
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setShowVerticalLines(false);
		scrollPane.setViewportView(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciaTime telaTime = new GerenciaTime(futirio);
				telaTime.setLocationRelativeTo(null);
				telaTime.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(487, 326, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(StatusJogadores.class.getResource("/Imagens/fundoGrande.png")));
		bg.setBounds(0, 0, 594, 370);
		contentPane.add(bg);
	}
}
