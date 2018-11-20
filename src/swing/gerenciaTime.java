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
import javax.swing.SwingConstants;
import javax.swing.JButton;

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
		//pegando o time adversário
		int intAdver = 3; //número do adversário
		String nomeAdver = new String("");
		for (Time getTime : Time.values()) {
			if (getTime.getIndex() == intAdver) {
				nomeAdver = getTime.name().toString();
				intAdver = getTime.getIndex();
			}
		}
		
		JLabel escudoTime = new JLabel();
		Image escudo = new ImageIcon(this.getClass().getResource("/Imagens/"+Integer.toString(index)+".png")).getImage();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 132, 457, 302);
		contentPane.add(scrollPane);
		
		jogadores = new JTable();
		scrollPane.setViewportView(jogadores);
		escudoTime.setIcon(new ImageIcon(escudo));
		escudoTime.setBounds(21, 11, 110, 110);
		contentPane.add(escudoTime);

		JLabel nomeTime = new JLabel(nome);
		nomeTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeTime.setBounds(152, 11, 336, 33);
		contentPane.add(nomeTime);

		JLabel nomeTecnico = new JLabel("Técnico: " + tecnico);
		nomeTecnico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeTecnico.setBounds(152, 50, 336, 33);
		contentPane.add(nomeTecnico);
		
		JLabel lblPrximoJogo = new JLabel("Pr\u00F3ximo jogo:");
		lblPrximoJogo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrximoJogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrximoJogo.setBounds(498, 133, 110, 23);
		contentPane.add(lblPrximoJogo);
		
		//Dados do Adversário
		
		JLabel escudoAdversario = new JLabel("");
		escudoAdversario.setBounds(498, 201, 110, 110);
		Image escudoAdver = new ImageIcon(this.getClass().getResource("/Imagens/"+Integer.toString(intAdver)+".png")).getImage(); 
		escudoAdversario.setIcon(new ImageIcon(escudoAdver));
		contentPane.add(escudoAdversario);
		
		JLabel nomeAdversario = new JLabel(nomeAdver);
		nomeAdversario.setText(nomeAdver);
		nomeAdversario.setHorizontalAlignment(SwingConstants.CENTER);
		nomeAdversario.setBounds(498, 322, 110, 23);
		contentPane.add(nomeAdversario);
		
		JLabel lblPosio = new JLabel("Posi\u00E7\u00E3o:");
		lblPosio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosio.setBounds(498, 356, 110, 23);
		contentPane.add(lblPosio);
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		JLabel lblCampeonato = new JLabel("Campeonato");
		lblCampeonato.setHorizontalAlignment(SwingConstants.CENTER);
		lblCampeonato.setBounds(498, 167, 110, 23);
		contentPane.add(lblCampeonato);
		
		JButton btnJogar = new JButton("Jogar");
		btnJogar.setBounds(508, 390, 89, 23);
		contentPane.add(btnJogar);
		
		JButton btnTabela = new JButton("Tabela");
		btnTabela.setBounds(508, 20, 89, 23);
		contentPane.add(btnTabela);
		
		JLabel lblNewLabel = new JLabel("Posi\u00E7\u00E3o: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(152, 94, 336, 27);
		contentPane.add(lblNewLabel);
		
		JLabel bg = new JLabel("");
		bg.setBounds(0, 0, 618, 457);
		contentPane.add(bg);
	}
}
