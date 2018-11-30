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

public class ListaDeTransferencia extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ListaDeTransferencia(OJogo futirio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaDeTransferncias = new JLabel("Lista de Transfer\u00EAncias");
		lblListaDeTransferncias.setForeground(Color.WHITE);
		lblListaDeTransferncias.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblListaDeTransferncias.setBounds(81, -1, 323, 56);
		contentPane.add(lblListaDeTransferncias);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(485, 24, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(485, 203, 89, 23);
		contentPane.add(btnComprar);
		
		String[] colunas = { "Posição", "Jogador", "Habilidade", "Salario", "Taxa de Contrato"};
//		String[][] jogadores = futirio.getCarioca().get
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 465, 284);
		contentPane.add(scrollPane);
		
		//table = new JTable(jogadores,colunas);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"kk", "blz", "fera", "das", "asdasd"},
				{"kk", "batata", "fera", "das", "asdasd"},
				{"kk", "blz", "fera", "das", "asdasd"},
				{"kk", "blz", "fera", "das", "asdasd"},
				{"kk", "blz", "fera", "das", "asdasd"},

		
			},
			new String[] {
				"Posi\u00E7\u00E3o", "Jogador", "Habilidade", "Salario", "Taxa de Contrato"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(ListaDeTransferencia.class.getResource("/Imagens/fundo.png")));
		bg.setBounds(0, 0, 584, 361);
		contentPane.add(bg);
	}

}
