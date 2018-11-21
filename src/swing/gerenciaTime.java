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
import java.awt.Color;

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
		setResizable(false);
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
		// pegando o time adversário
		int intAdver = 2; // número do adversário
		String nomeAdver = new String("");
		for (Time getTime : Time.values()) {
			if (getTime.getIndex() == intAdver) {
				nomeAdver = getTime.name().toString();
				intAdver = getTime.getIndex();
			}
		}

		JLabel escudoTime = new JLabel();
		Image escudo = new ImageIcon(this.getClass().getResource("/Imagens/" + Integer.toString(index) + ".png"))
				.getImage();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 132, 457, 302);
		contentPane.add(scrollPane);

		String[] colunas = { "Posição", "Nome", "Habilidade", "Chute", "Passe", "Desarme", "Defesa" };
		String[][] players = {{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk" , "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" }};
		JTable jogadores = new JTable(players, colunas);
		jogadores.setShowVerticalLines(false);
		scrollPane.setViewportView(jogadores);
		escudoTime.setIcon(new ImageIcon(escudo));
		escudoTime.setBounds(21, 11, 110, 110);
		contentPane.add(escudoTime);

		JLabel nomeTime = new JLabel(nome);
		nomeTime.setForeground(Color.WHITE);
		nomeTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeTime.setBounds(152, 11, 336, 33);
		contentPane.add(nomeTime);

		JLabel nomeTecnico = new JLabel("Técnico: " + tecnico);
		nomeTecnico.setForeground(Color.WHITE);
		nomeTecnico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeTecnico.setBounds(152, 50, 336, 33);
		contentPane.add(nomeTecnico);

		JLabel lblPrximoJogo = new JLabel("Pr\u00F3ximo jogo:");
		lblPrximoJogo.setForeground(Color.WHITE);
		lblPrximoJogo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrximoJogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrximoJogo.setBounds(498, 133, 110, 23);
		contentPane.add(lblPrximoJogo);

		// Dados do Adversário

		JLabel escudoAdversario = new JLabel("");
		escudoAdversario.setBounds(498, 201, 110, 110);
		Image escudoAdver = new ImageIcon(
				this.getClass().getResource("/Imagens/" + Integer.toString(intAdver) + ".png")).getImage();
		escudoAdversario.setIcon(new ImageIcon(escudoAdver));
		contentPane.add(escudoAdversario);

		JLabel nomeAdversario = new JLabel(nomeAdver);
		nomeAdversario.setForeground(Color.WHITE);
		nomeAdversario.setHorizontalAlignment(SwingConstants.CENTER);
		nomeAdversario.setBounds(498, 322, 110, 23);
		contentPane.add(nomeAdversario);

		JLabel lblPosio = new JLabel("Posi\u00E7\u00E3o: 3\u00BA");
		lblPosio.setForeground(Color.WHITE);
		lblPosio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosio.setBounds(498, 356, 110, 23);
		contentPane.add(lblPosio);

		////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblCampeonato = new JLabel("Campeonato Carioca");
		lblCampeonato.setForeground(Color.WHITE);
		lblCampeonato.setHorizontalAlignment(SwingConstants.CENTER);
		lblCampeonato.setBounds(498, 167, 110, 33);
		contentPane.add(lblCampeonato);

		JButton btnJogar = new JButton("Jogar");
		btnJogar.setBounds(508, 390, 89, 23);
		contentPane.add(btnJogar);

		JButton btnTabela = new JButton("Tabela");
		btnTabela.setBounds(508, 20, 89, 23);
		contentPane.add(btnTabela);

		JLabel lblNewLabel = new JLabel("Posi\u00E7\u00E3o: 1\u00BA");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(152, 94, 123, 27);
		contentPane.add(lblNewLabel);

		JLabel lblAno = new JLabel("Ano: 2019");
		lblAno.setForeground(Color.WHITE);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAno.setBounds(378, 94, 110, 27);
		contentPane.add(lblAno);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(gerenciaTime.class.getResource("/Imagens/fundoGrande.png")));
		bg.setBounds(0, 0, 628, 467);
		contentPane.add(bg);
	}
}
