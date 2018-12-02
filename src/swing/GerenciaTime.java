package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entity.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class GerenciaTime extends JFrame {

	private JPanel contentPane;
	private JTable jogadores;
	private JTable TabelaTitulares;
	private JTable TabelaReservas;

	public GerenciaTime(OJogo futirio) {
		setTitle(futirio.getTimeJogador().getNome() + " - " + futirio.getNomeTecnico());
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
			if (futirio.getIndexENUM() == getTime.getIndex()) {
				nomeCompleto = getTime.getNomeCompleto();
				break;
			}
		}

		// ==================================================================== //
		String[] colunas = { "Posição", "Nome", "Habilidade" };
		String[][] teste = { { "   ", "   e", "    " }, { "  o", "    ", "   " } };

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 154, 207, 273);
		contentPane.add(scrollPane);
		String[][] playersTitulares = futirio.getCarioca().getTimes().get(futirio.getIndexTime())
				.getAtributosJogadoresTitulares();
		String[][] playersReservas = futirio.getCarioca().getTimes().get(futirio.getIndexTime())
				.getAtributosJogadoresReservas();

		// ISSO DAKI É PARA NÃO DEIXAR EDITAR A TABLE
		boolean[] falsesTitulares = new boolean[playersTitulares.length];
		for (int i = 0; i < playersTitulares.length; i++) {
			falsesTitulares[i] = false;
		}

		// TabelaTitulares = new JTable(teste, colunas);

		// SE FOR MEXER NO DESIGN TEM Q COMENTAR DAKI \/ E DESCOMENTAR O DE CIMA
		// ======================================================================== //
		TabelaTitulares = new JTable(playersTitulares, colunas);
		TabelaTitulares.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		TabelaTitulares.setModel(new DefaultTableModel(playersTitulares, colunas) {
			boolean[] columnEditables = falsesTitulares;

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		TabelaTitulares.getColumnModel().getColumn(0).setResizable(false);
		TabelaTitulares.getColumnModel().getColumn(1).setResizable(false);
		TabelaTitulares.getColumnModel().getColumn(2).setResizable(false);
		// ======================================================================== //
		// ATÉ AKI

		scrollPane.setViewportView(TabelaTitulares);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(281, 154, 207, 273);
		contentPane.add(scrollPane_1);

		// ISSO DAKI É PARA NÃO DEIXAR EDITAR A TABLE
		boolean[] falsesReservas = new boolean[playersReservas.length];
		for (int i = 0; i < playersReservas.length; i++) {
			falsesReservas[i] = false;
		}

		// TabelaReservas = new JTable(teste, colunas);

		// SE FOR MEXER NO DESIGN TEM Q COMENTAR DAKI \/ E DESCOMENTAR O DE CIMA
		// ======================================================================== //
		TabelaReservas = new JTable(playersReservas, colunas);
		TabelaReservas.setModel(new DefaultTableModel(playersReservas, colunas) {
			boolean[] columnEditables = falsesReservas;

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		TabelaReservas.getColumnModel().getColumn(0).setResizable(false);
		TabelaReservas.getColumnModel().getColumn(1).setResizable(false);
		TabelaReservas.getColumnModel().getColumn(2).setResizable(false);
		TabelaReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// ======================================================================== //
		// ATÉ AKI

		scrollPane_1.setViewportView(TabelaReservas);
		// ==================================================================== //

		JLabel escudoTime = new JLabel();
		Image escudo = new ImageIcon(Main.carregarEscudo(futirio.getTimeJogador())).getImage();
		escudoTime.setIcon(new ImageIcon(escudo));
		escudoTime.setBounds(21, 11, 110, 110);
		contentPane.add(escudoTime);

		JLabel nomeTime = new JLabel(nomeCompleto);
		nomeTime.setForeground(Color.WHITE);
		nomeTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeTime.setBounds(152, 20, 336, 33);
		contentPane.add(nomeTime);

		JLabel lblFundosR = new JLabel("Fundos: R$" + futirio.getTimeJogador().getFundos());
		lblFundosR.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFundosR.setForeground(Color.WHITE);
		lblFundosR.setBounds(281, 99, 207, 20);
		contentPane.add(lblFundosR);

		JLabel nomeTecnico = new JLabel("Técnico: " + futirio.getNomeTecnico());
		nomeTecnico.setForeground(Color.WHITE);
		nomeTecnico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeTecnico.setBounds(152, 56, 251, 33);
		contentPane.add(nomeTecnico);

		JLabel lblPrximoJogo = new JLabel("Próximo jogo:");
		lblPrximoJogo.setForeground(Color.WHITE);
		lblPrximoJogo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrximoJogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrximoJogo.setBounds(498, 154, 120, 23);
		contentPane.add(lblPrximoJogo);

		// Dados do Adversário
		Time adversario = futirio.getTimeJogador().getAdversario((futirio.getCarioca().getIndexRodadaAtual() - 1));

		JLabel escudoAdversario = new JLabel("");
		escudoAdversario.setBounds(503, 244, 110, 110);
		Image escudoAdver = new ImageIcon(Main.carregarEscudo(adversario)).getImage();
		escudoAdversario.setIcon(new ImageIcon(escudoAdver));
		contentPane.add(escudoAdversario);

		JLabel nomeAdversario = new JLabel(adversario.getNome());
		nomeAdversario.setForeground(Color.WHITE);
		nomeAdversario.setHorizontalAlignment(SwingConstants.CENTER);
		nomeAdversario.setBounds(498, 365, 120, 23);
		contentPane.add(nomeAdversario);

		JLabel lblPosio = new JLabel("Posição: ");// +time.getposicao();
		lblPosio.setForeground(Color.WHITE);
		lblPosio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosio.setBounds(498, 399, 120, 23);
		contentPane.add(lblPosio);
		////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblCampeonato = new JLabel("Campeonato Carioca");
		lblCampeonato.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCampeonato.setForeground(Color.WHITE);
		lblCampeonato.setHorizontalAlignment(SwingConstants.CENTER);
		lblCampeonato.setBounds(498, 188, 120, 23);
		contentPane.add(lblCampeonato);

		JButton btnJogar = new JButton("Jogar");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RodadaSwing partida = new RodadaSwing(futirio);
				partida.setLocationRelativeTo(null);
				partida.setVisible(true);
				dispose();

			}
		});
		btnJogar.setBounds(503, 433, 110, 23);
		contentPane.add(btnJogar);

		JButton btnTabela = new JButton("Tabela");
		btnTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tabela tabela = new Tabela(futirio);
				tabela.setLocationRelativeTo(null);
				tabela.setVisible(true);
				dispose();
			}
		});
		btnTabela.setBounds(498, 20, 120, 23);
		contentPane.add(btnTabela);

		JButton btnStatus = new JButton("Status dos jogadores");
		btnStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StatusJogadores telaStatus = new StatusJogadores(futirio);
				telaStatus.setLocationRelativeTo(null);
				telaStatus.setVisible(true);
				dispose();
			}
		});

		JButton btnSubstituir = new JButton("Substituir");
		btnSubstituir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				futirio.getCarioca().getTimes().get(futirio.getIndexTime()).substituicao(
						futirio.getCarioca().getTimes().get(futirio.getIndexTime())
								.getJogadorTitular(TabelaTitulares.getSelectedRow()),
						futirio.getCarioca().getTimes().get(futirio.getIndexTime())
								.getJogadorReserva(TabelaReservas.getSelectedRow()));

				atualizarTabelas(TabelaTitulares, TabelaReservas, futirio, scrollPane, scrollPane_1);
			}
		});
		btnSubstituir.setBounds(302, 433, 168, 23);
		contentPane.add(btnSubstituir);
		btnStatus.setBounds(42, 433, 168, 23);
		contentPane.add(btnStatus);

		JButton btnNegociarJogador = new JButton("Negociar Jogador");
		btnNegociarJogador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaDeTransferenciaSwing telaLista = new ListaDeTransferenciaSwing(futirio);
				telaLista.setLocationRelativeTo(null);
				telaLista.setVisible(true);
				dispose();
			}
		});
		btnNegociarJogador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNegociarJogador.setBounds(498, 59, 120, 23);
		contentPane.add(btnNegociarJogador);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//salva o jogo
			}
		});
		btnSalvar.setBounds(498, 99, 120, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblNewLabel = new JLabel("Posição: ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(152, 94, 123, 27);
		contentPane.add(lblNewLabel);

		JLabel lblAno = new JLabel(futirio.getCarioca().getAno()+"");
		lblAno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAno.setForeground(Color.WHITE);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAno.setBounds(498, 210, 120, 22);
		contentPane.add(lblAno);

		JLabel lblReservas = new JLabel("Reservas");
		lblReservas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReservas.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservas.setForeground(Color.WHITE);
		lblReservas.setBounds(281, 130, 207, 22);
		contentPane.add(lblReservas);

		JLabel labelTitulares = new JLabel("Titulares");
		labelTitulares.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulares.setForeground(Color.WHITE);
		labelTitulares.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelTitulares.setBounds(21, 130, 207, 22);
		contentPane.add(labelTitulares);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(GerenciaTime.class.getResource("/Imagens/fundoGrande.png")));
		bg.setBounds(0, 0, 628, 467);
		contentPane.add(bg);

		// TODO: Criar um botão que quando clicado, chama o método abaixo
		// salvarJogo(campeonato);
	}

	public void atualizarTabelas(JTable TabelaTitulares, JTable TabelaReservas, OJogo futirio, JScrollPane scrollPane,
			JScrollPane scrollPane_1) {
		String[] colunas = { "Posição", "Nome", "Habilidade" };

		String[][] playersTitulares = futirio.getCarioca().getTimes().get(futirio.getIndexTime())
				.getAtributosJogadoresTitulares();
		String[][] playersReservas = futirio.getCarioca().getTimes().get(futirio.getIndexTime())
				.getAtributosJogadoresReservas();

		// ISSO DAKI É PARA NÃO DEIXAR EDITAR A TABLE
		boolean[] falsesTitulares = new boolean[playersTitulares.length];
		for (int i = 0; i < playersTitulares.length; i++) {
			falsesTitulares[i] = false;
		}

		// ISSO DAKI É PARA NÃO DEIXAR EDITAR A TABLE
		boolean[] falsesReservas = new boolean[playersReservas.length];
		for (int i = 0; i < playersReservas.length; i++) {
			falsesReservas[i] = false;
		}

		TabelaTitulares.setModel(new DefaultTableModel(playersTitulares, colunas) {
			boolean[] columnEditables = falsesTitulares;

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		TabelaReservas.setModel(new DefaultTableModel(playersReservas, colunas) {
			boolean[] columnEditables = falsesReservas;

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}

	public void salvarJogo(Campeonato campeonato) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("src/entity/save")));
			objOut.writeObject(campeonato);
			objOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

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
}
