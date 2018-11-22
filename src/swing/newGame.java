package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entity.*;

public class newGame extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTecnico;
	public static int ano = 2019;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newGame frame = new newGame();
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
	public newGame() {
		// Criando o campeonato
		Campeonato campeonato = new Campeonato(ano);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 399);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox times = new JComboBox();
		times.setFont(new Font("Tahoma", Font.PLAIN, 20));
		times.addItem(campeonato.getTimes().get(4).getNome());
		times.addItem(campeonato.getTimes().get(6).getNome());
		times.addItem(campeonato.getTimes().get(7).getNome());
		times.addItem(campeonato.getTimes().get(14).getNome());
		times.setSelectedItem(null);
		times.setBounds(114, 191, 142, 32);
		contentPane.add(times);

		JButton btnAvancar = new JButton("Avan\u00E7ar");
		btnAvancar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nomeTecnico.getText() == null || nomeTecnico.getText().trim().equals("")
						|| times.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "Selecione todas as opções para continuar", "Erro",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int index = 0;
					if(times.getSelectedIndex()==0) {
						index = 4;
					}else if(times.getSelectedIndex()==1) {
						index = 6;
					}else if(times.getSelectedIndex()==2) {
						index = 7;
					}else if(times.getSelectedIndex()==3){
						index = 14;
					}
					Campeonato carioca = new Campeonato(2019);
					gerenciaTime jogo = new gerenciaTime(carioca.getTimes().get(index),nomeTecnico.getText(),times.getSelectedIndex(),carioca);
					jogo.setVisible(true);
					newGame.this.dispose();
				}
			}
		});
		btnAvancar.setBounds(234, 268, 115, 32);
		contentPane.add(btnAvancar);

		JLabel lblTime = new JLabel("Selecione o time que deseja comandar:");
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime.setBounds(114, 159, 367, 26);
		contentPane.add(lblTime);

		nomeTecnico = new JTextField();
		nomeTecnico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeTecnico.setBounds(114, 111, 228, 32);
		contentPane.add(nomeTecnico);
		nomeTecnico.setColumns(10);

		JLabel lblTecnico = new JLabel("Insira o nome do t\u00E9cnico:");
		lblTecnico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTecnico.setForeground(Color.WHITE);
		lblTecnico.setBounds(114, 76, 267, 32);
		contentPane.add(lblTecnico);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(newGame.class.getResource("/Imagens/campo.jpg")));
		bg.setBounds(0, -23, 600, 399);
		contentPane.add(bg);
	}
}
