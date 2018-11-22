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
import javax.swing.JList;

public class teste extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teste frame = new teste();
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
	public teste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblListaDeTransferncias = new JLabel("Lista de Transfer\u00EAncias");
		lblListaDeTransferncias.setBounds(81, -1, 323, 56);
		lblListaDeTransferncias.setForeground(Color.WHITE);
		lblListaDeTransferncias.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblListaDeTransferncias);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(485, 24, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(485, 203, 89, 23);
		contentPane.add(btnComprar);

		String[] colunas = { "Posição", "Jogador", "Habilidade", "Salario", "Taxa de Contrato" };
		String[] jogadores = { "kk    blz    fera    das    asdasd", "kk    blz    fera    das    asdasd",
				"kk    blz    fera    das    asdasd", "kk    blz    fera    das    asdasd",
				"kk    blz    fera    das    asdasd", "kk    blz    fera    das    asdasd",
				"kk    blz    fera    das    asdasd", "kk    blz    fera    das    asdasd",
				"kk    blz    fera    das    asdasd", "kk    blz    fera    das    asdasd",
				"kk    blz    fera    das    asdasd", "kk    blz    fera    das    asdasd",
				"kk    blz    fera    das    asdasd", "kk    blz    fera    das    asdasd",
				"kk    blz    fera    das    asdasd", "kk    blz    fera    das    asdasd",
				"kk    blz    fera    das    asdasd", "kk    blz    fera    das    asdasd",
				"kk    blz    fera    das    asdasd", "kk    blz    fera    das    asdasd",
				"kk    blz    fera    das    asdasd", "kk    blz    fera    das    asdasd",
				"kk    blz    fera    das    asdasd", "kk    blz    fera    das    asdasd",
				"kk    blz    fera    das    asdasd", "kk    blz    fera    das    asdasd",
				"kk    blz    fera    das    asdasd", "kk    blz    fera    das    asdasd",
				"kk    blz    fera    das    asdasd", "kk    blz    fera    das    asdasd",
				"kk    blz    fera    das    asdasd", "kk    blz    fera    das    asdasd",
				"kk    blz    fera    das    asdasd", };

		JLabel bg = new JLabel("");
		bg.setBounds(0, 0, 584, 361);
		bg.setIcon(new ImageIcon(teste.class.getResource("/Imagens/fundo.png")));
		contentPane.add(bg);
		
		JList list = new JList();
		list.setBounds(10, 54, 463, 296);
		contentPane.add(list);
	}
}
