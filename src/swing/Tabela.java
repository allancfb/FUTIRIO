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
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;

public class Tabela extends JFrame {

	private JPanel contentPane;
	private final JLabel bg = new JLabel("");
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabela frame = new Tabela();
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
	public Tabela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTabela = new JLabel("Tabela");
		lblTabela.setForeground(Color.WHITE);
		lblTabela.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblTabela.setBounds(241, 11, 101, 41);
		contentPane.add(lblTabela);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(485, 326, 89, 23);
		contentPane.add(btnVoltar);
		
		String[] colunas = { "Time", "Pontos", "Vitorias", "Saldo de Gols", "Empates", "Derrotas"};
		String[][] times = { { "kk", "blz", "fera", "das", "asdasd", "asdasdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas"}};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 59, 480, 256);
		contentPane.add(scrollPane);
		
		table = new JTable(times,colunas);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas"},
			},
			new String[] {
				"Time", "Pontos", "Vitorias", "Saldo de Gols", "Empates", "Derrotas"
			}
		));
		table.setFillsViewportHeight(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		bg.setIcon(new ImageIcon(Tabela.class.getResource("/Imagens/fundo.png")));
		bg.setBounds(0, 0, 584, 360);
		contentPane.add(bg);
	}
}
