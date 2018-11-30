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

public class GerenciaTecnico extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTecnico;
	public static int ano = 2019;
	protected OJogo futirio;
	// Criando o campeonato
//	protected ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciaTecnico frame = new GerenciaTecnico();
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
	
	
	
	public GerenciaTecnico() {
		futirio = new OJogo();
		futirio.createCarioca(ano);
		
		setTitle("Escolha o time que deseja jogar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 399);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox times = new JComboBox();
		times.setFont(new Font("Tahoma", Font.PLAIN, 20));
		times.addItem(futirio.getCarioca().getTimes().get(4).getNome());
		times.addItem(futirio.getCarioca().getTimes().get(6).getNome());
		times.addItem(futirio.getCarioca().getTimes().get(7).getNome());
		times.addItem(futirio.getCarioca().getTimes().get(14).getNome());
		times.setSelectedItem(null);
		times.setBounds(114, 191, 142, 32);
		contentPane.add(times);

		JButton btnAvancar = new JButton("Avan\u00E7ar");
		btnAvancar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nomeTecnico.getText() == null || nomeTecnico.getText().trim().equals("")
						|| times.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "Selecione todas as op��es para continuar", "Erro",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int index = 0;
					if(times.getSelectedIndex()==0) {
						futirio.setIndexENUM(0);
						futirio.setIndexTime(4);
					}else if(times.getSelectedIndex()==1) {
						futirio.setIndexENUM(1);
						futirio.setIndexTime(6);
					}else if(times.getSelectedIndex()==2) {
						futirio.setIndexENUM(2);
						futirio.setIndexTime(7);
					}else if(times.getSelectedIndex()==3){
						futirio.setIndexENUM(3);
						futirio.setIndexTime(14);
					}
					
					futirio.setTimeJogador(futirio.getCarioca().getTimes().get(futirio.getIndexTime()));
					futirio.setNomeTecnico(nomeTecnico.getText());
					
					GerenciaTime jogo = new GerenciaTime(futirio);
					jogo.setLocationRelativeTo(null);
					jogo.setVisible(true);
					GerenciaTecnico.this.dispose();
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
		bg.setIcon(new ImageIcon(GerenciaTecnico.class.getResource("/Imagens/campo.jpg")));
		bg.setBounds(0, -23, 600, 399);
		contentPane.add(bg);
	}

}
