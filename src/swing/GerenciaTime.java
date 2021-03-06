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
		futirio.getCarioca().organizaTabela();

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
		String[] colunas = { "Posi��o", "Nome", "Habilidade" };
		String[][] teste = { { "   ", "   e", "    " }, { "  o", "    ", "   " } };

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 154, 222, 246);
		contentPane.add(scrollPane);
		String[][] playersTitulares = futirio.getTimeJogador().getAtributosJogadoresTitulares();
		String[][] playersReservas = futirio.getTimeJogador().getAtributosJogadoresReservas();

		// ISSO DAQUI � PARA N�O DEIXAR EDITAR A TABLE
		boolean[] falsesTitulares = new boolean[playersTitulares.length];
		for (int i = 0; i < playersTitulares.length; i++) {
			falsesTitulares[i] = false;
		}
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

		scrollPane.setViewportView(TabelaTitulares);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(260, 154, 228, 246);
		contentPane.add(scrollPane_1);
		
		// ISSO DAQUI � PARA N�O DEIXAR EDITAR A TABLE
		boolean[] falsesReservas = new boolean[playersReservas.length];
		for (int i = 0; i < playersReservas.length; i++) {
			falsesReservas[i] = false;
		}
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

		JLabel nomeTecnico = new JLabel("T�cnico: " + futirio.getNomeTecnico());
		nomeTecnico.setForeground(Color.WHITE);
		nomeTecnico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeTecnico.setBounds(152, 56, 251, 33);
		contentPane.add(nomeTecnico);

		JLabel lblPrximoJogo = new JLabel("Pr�ximo jogo:");
		lblPrximoJogo.setForeground(Color.WHITE);
		lblPrximoJogo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrximoJogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrximoJogo.setBounds(498, 154, 120, 23);
		contentPane.add(lblPrximoJogo);

		// Dados do Advers�rio
		Time adversario = futirio.getTimeJogador().getAdversario((futirio.getCarioca().getIndexRodadaAtual() - 1));

		JLabel escudoAdversario = new JLabel("");
		escudoAdversario.setBounds(503, 245, 110, 110);
		Image escudoAdver = new ImageIcon(Main.carregarEscudo(adversario)).getImage();
		escudoAdversario.setIcon(new ImageIcon(escudoAdver));
		contentPane.add(escudoAdversario);

		JLabel nomeAdversario = new JLabel(adversario.getNome());
		nomeAdversario.setForeground(Color.WHITE);
		nomeAdversario.setHorizontalAlignment(SwingConstants.CENTER);
		nomeAdversario.setBounds(498, 366, 120, 23);
		contentPane.add(nomeAdversario);

		JLabel lblPosio = new JLabel("Posi��o: " + adversario.getTimeTabela().getPosicao() + "�");
		lblPosio.setForeground(Color.WHITE);
		lblPosio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosio.setBounds(498, 399, 120, 23);
		contentPane.add(lblPosio);
		////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblCampeonato = new JLabel("Campeonato Carioca");
		lblCampeonato.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCampeonato.setForeground(Color.WHITE);
		lblCampeonato.setHorizontalAlignment(SwingConstants.CENTER);
		lblCampeonato.setBounds(498, 176, 120, 23);
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
		btnStatus.setFont(new Font("Tahoma", Font.PLAIN, 9));
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
				futirio.getTimeJogador().substituicao(
						futirio.getTimeJogador().getJogadorTitular(TabelaTitulares.getSelectedRow()),
						futirio.getTimeJogador().getJogadorReserva(TabelaReservas.getSelectedRow()));

				atualizarTabelas(TabelaTitulares, TabelaReservas, futirio, scrollPane, scrollPane_1);
			}
		});
		btnSubstituir.setBounds(166, 411, 168, 23);
		contentPane.add(btnSubstituir);
		btnStatus.setBounds(498, 98, 120, 23);
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

		JLabel lblNewLabel = new JLabel("Posi��o: " + futirio.getTimeJogador().getTimeTabela().getPosicao() + "�");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(152, 94, 123, 27);
		contentPane.add(lblNewLabel);

		JLabel lblAno = new JLabel(futirio.getCarioca().getAno() + "");
		lblAno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAno.setForeground(Color.WHITE);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAno.setBounds(498, 198, 120, 22);
		contentPane.add(lblAno);

		JLabel lblReservas = new JLabel("Reservas");
		lblReservas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReservas.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservas.setForeground(Color.WHITE);
		lblReservas.setBounds(260, 130, 228, 22);
		contentPane.add(lblReservas);

		JLabel labelTitulares = new JLabel("Titulares");
		labelTitulares.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulares.setForeground(Color.WHITE);
		labelTitulares.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelTitulares.setBounds(21, 130, 222, 22);
		contentPane.add(labelTitulares);

		JLabel lblNewLabel_1 = new JLabel("Rodada: " + futirio.getCarioca().getIndexRodadaAtual());
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(503, 220, 115, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblselecioneUmJogador = new JLabel("(Selecione um jogador de cada tabela para fazer a substitui\u00E7\u00E3o)");
		lblselecioneUmJogador.setHorizontalAlignment(SwingConstants.CENTER);
		lblselecioneUmJogador.setForeground(Color.WHITE);
		lblselecioneUmJogador.setBounds(21, 437, 467, 14);
		contentPane.add(lblselecioneUmJogador);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(GerenciaTime.class.getResource("/Imagens/fundoGrande.png")));
		bg.setBounds(0, 0, 628, 467);
		contentPane.add(bg);
	}

	public void atualizarTabelas(JTable TabelaTitulares, JTable TabelaReservas, OJogo futirio, JScrollPane scrollPane,
			JScrollPane scrollPane_1) {
		String[] colunas = { "Posi��o", "Nome", "Habilidade" };

		String[][] playersTitulares = futirio.getTimeJogador().getAtributosJogadoresTitulares();
		String[][] playersReservas = futirio.getTimeJogador().getAtributosJogadoresReservas();

		// ISSO DAQUI � PARA N�O DEIXAR EDITAR A TABLE
		boolean[] falsesTitulares = new boolean[playersTitulares.length];
		for (int i = 0; i < playersTitulares.length; i++) {
			falsesTitulares[i] = false;
		}

		// ISSO DAQUI � PARA N�O DEIXAR EDITAR A TABLE
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
