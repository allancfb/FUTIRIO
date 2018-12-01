package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import entity.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaDeTransferenciaSwing extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ListaDeTransferenciaSwing(OJogo futirio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 399);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblListaDeTransferncias = new JLabel("Lista de Transferências");
		lblListaDeTransferncias.setForeground(Color.WHITE);
		lblListaDeTransferncias.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblListaDeTransferncias.setBounds(81, -1, 323, 56);
		contentPane.add(lblListaDeTransferncias);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciaTime telaTime = new GerenciaTime(futirio);
				telaTime.setLocationRelativeTo(null);
				telaTime.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(485, 24, 89, 23);
		contentPane.add(btnVoltar);

		String[] colunas = { "Posição", "Jogador", "Habilidade", "Salário", "Taxa de Contrato" };
		String[][] jogadores = futirio.getCarioca().getListaDeTransferencia().getAllAtributosJogador();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 465, 284);
		contentPane.add(scrollPane);

		boolean[] falses = new boolean[jogadores.length];
		for (int i = 0; i < jogadores.length; i++) {
			falses[i] = false;
		}

		// table = new JTable();
		table = new JTable(jogadores, colunas);
		table.setModel(new DefaultTableModel(jogadores, colunas) {
			boolean[] columnEditables = falses;

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				futirio.getCarioca().getTimes().get(futirio.getIndexTime()).comprarJogador(
						futirio.getCarioca().getListaDeTransferencia().getJogadores().get(table.getSelectedRow()));
				futirio.getCarioca().getListaDeTransferencia().enviarJogadorComprado(
						futirio.getCarioca().getListaDeTransferencia().getJogadores().get(table.getSelectedRow()));

				futirio.getCarioca().getListaDeTransferencia().atualizaLista();

				String[] colunas = { "Posição", "Jogador", "Habilidade", "Salário", "Taxa de Contrato" };
				String[][] jogadores = futirio.getCarioca().getListaDeTransferencia().getAllAtributosJogador();

				table.setModel(new DefaultTableModel(jogadores, colunas) {
					boolean[] columnEditables = falses;

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});

				scrollPane.setViewportView(table);
			}
		});
		btnComprar.setBounds(485, 203, 89, 23);
		contentPane.add(btnComprar);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(ListaDeTransferenciaSwing.class.getResource("/Imagens/fundoGrande.png")));
		bg.setBounds(0, 0, 594, 370);
		contentPane.add(bg);
	}

}
