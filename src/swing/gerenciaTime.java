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

import entity.*;
import javax.swing.table.DefaultTableModel;

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

	public gerenciaTime(Time time, String tecnico, int index, Campeonato campeonato) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 496);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		// Pega o nome completo do time e seu index no enum timesGrandes
		String nomeCompleto = new String("");
		for (timesGrandes getTime : timesGrandes.values()) {
			if (index == getTime.getIndex()) {
				nomeCompleto = getTime.getNomeCompleto();
				break;
			}
		}
		
		for (Partida partida : campeonato.getProximaRodada().getPartidas()) {
			if (partida.getTime1().getNome() == time.getNome()) {
				Time adversario = partida.getTime2();
			}else if(partida.getTime2().getNome() == time.getNome()) {
				Time adversario = partida.getTime1();
			}
		}

		JLabel escudoTime = new JLabel();
		Image escudo = new ImageIcon(this.getClass().getResource("/Imagens/" + Integer.toString(index) + ".png"))
				.getImage();
		escudoTime.setIcon(new ImageIcon(escudo));
		escudoTime.setBounds(21, 11, 110, 110);
		contentPane.add(escudoTime);

		JLabel nomeTime = new JLabel(nomeCompleto);
		nomeTime.setForeground(Color.WHITE);
		nomeTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeTime.setBounds(152, 20, 336, 33);
		contentPane.add(nomeTime);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 132, 457, 302);
		contentPane.add(scrollPane);

		String[] colunas = { "Posição", "Nome", "Habilidade", "Chute", "Passe", "Desarme", "Defesa" };
		String[][] players = { { "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" },
				{ "kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas" } };
		JTable jogadores = new JTable(players, colunas);
		jogadores.setModel(new DefaultTableModel(
			new Object[][] {
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
				{"kk", "blz", "fera", "das", "asdasd", "asdasdas", "asdsdas"},
			},
			new String[] {
				"Posi\u00E7\u00E3o", "Nome", "Habilidade", "Chute", "Passe", "Desarme", "Defesa"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jogadores.setBackground(new Color(255, 255, 255));
		jogadores.setForeground(Color.BLACK);
		jogadores.setShowVerticalLines(false);
		scrollPane.setViewportView(jogadores);

		JLabel lblFundosR = new JLabel("Fundos: R$");// +Time.getFundos()
		lblFundosR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFundosR.setForeground(Color.WHITE);
		lblFundosR.setBounds(498, 99, 110, 20);
		contentPane.add(lblFundosR);

		JLabel nomeTecnico = new JLabel("Técnico: " + tecnico);
		nomeTecnico.setForeground(Color.WHITE);
		nomeTecnico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeTecnico.setBounds(152, 56, 336, 33);
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
		Image escudoAdver = new ImageIcon(this.getClass().getResource("")).getImage();//getescudo
		escudoAdversario.setIcon(new ImageIcon(escudoAdver));
		contentPane.add(escudoAdversario);

		JLabel nomeAdversario = new JLabel();
		nomeAdversario.setForeground(Color.WHITE);
		nomeAdversario.setHorizontalAlignment(SwingConstants.CENTER);
		nomeAdversario.setBounds(498, 322, 110, 23);
		contentPane.add(nomeAdversario);

		JLabel lblPosio = new JLabel("Posição: ");// +time.getposicao();
		lblPosio.setForeground(Color.WHITE);
		lblPosio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosio.setBounds(498, 356, 110, 23);
		contentPane.add(lblPosio);
		////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblCampeonato = new JLabel(campeonato.getNome());
		lblCampeonato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampeonato.setForeground(Color.WHITE);
		lblCampeonato.setHorizontalAlignment(SwingConstants.CENTER);
		lblCampeonato.setBounds(498, 167, 110, 33);
		contentPane.add(lblCampeonato);

		JButton btnJogar = new JButton("Jogar");
		btnJogar.setBounds(508, 390, 89, 23);
		contentPane.add(btnJogar);

		JButton btnTabela = new JButton("Tabela");
		btnTabela.setBounds(508, 20, 110, 23);
		contentPane.add(btnTabela);

		JButton btnNegociarJogador = new JButton("Negociar Jogador");
		btnNegociarJogador.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNegociarJogador.setBounds(508, 59, 110, 23);
		contentPane.add(btnNegociarJogador);

		JLabel lblNewLabel = new JLabel("Posição: ");// +
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(152, 94, 123, 27);
		contentPane.add(lblNewLabel);

		JLabel lblAno = new JLabel("Ano: " + campeonato.getAno());
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
