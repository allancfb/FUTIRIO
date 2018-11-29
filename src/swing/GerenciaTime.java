package swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entity.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		scrollPane.setBounds(21, 133, 207, 294);
		contentPane.add(scrollPane);
		String[][] playersTitulares = futirio.getCarioca().getTimes().get(futirio.getIndexTime())
				.getAtributosJogadoresTitulares();
		String[][] playersReservas = futirio.getCarioca().getTimes().get(futirio.getIndexTime())
				.getAtributosJogadoresReservas();

		TabelaTitulares = new JTable(playersTitulares, colunas);
		// TabelaTitulares = new JTable(teste, colunas);
		scrollPane.setViewportView(TabelaTitulares);
		// TabelaTitulares.getse

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(281, 133, 207, 294);
		contentPane.add(scrollPane_1);

		TabelaReservas = new JTable(playersReservas, colunas);
		// TabelaReservas = new JTable(teste, colunas);
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
		lblFundosR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFundosR.setForeground(Color.WHITE);
		lblFundosR.setBounds(498, 99, 110, 20);
		contentPane.add(lblFundosR);

		JLabel nomeTecnico = new JLabel("Técnico: " + futirio.getNomeTecnico());
		nomeTecnico.setForeground(Color.WHITE);
		nomeTecnico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeTecnico.setBounds(152, 56, 251, 33);
		contentPane.add(nomeTecnico);

		JLabel lblPrximoJogo = new JLabel("Pr\u00F3ximo jogo:");
		lblPrximoJogo.setForeground(Color.WHITE);
		lblPrximoJogo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrximoJogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrximoJogo.setBounds(498, 133, 110, 23);
		contentPane.add(lblPrximoJogo);

		// Dados do Adversário
		Time adversario = futirio.getTimeJogador().getAdversario(futirio.getCarioca().getRodadaAtual() + 11);

		JLabel escudoAdversario = new JLabel("");
		escudoAdversario.setBounds(498, 201, 110, 110);
		Image escudoAdver = new ImageIcon(Main.carregarEscudo(adversario)).getImage();
		escudoAdversario.setIcon(new ImageIcon(escudoAdver));
		contentPane.add(escudoAdversario);

		JLabel nomeAdversario = new JLabel(adversario.getNome());
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

		JLabel lblCampeonato = new JLabel(futirio.getCarioca().getNome());
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

		JButton btnStatus = new JButton("Visualizar Status");
		btnStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JButton btnSubstituir = new JButton("Substituir");
		btnSubstituir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				futirio.getCarioca().getTimes().get(futirio.getIndexTime()).substituicao(
						futirio.getCarioca().getTimes().get(futirio.getIndexTime())
								.getJogador(TabelaTitulares.getSelectedRow()),
						futirio.getCarioca().getTimes().get(futirio.getIndexTime())
								.getJogador(TabelaReservas.getSelectedRow()));

				atualizarTabelas(TabelaTitulares, TabelaReservas, futirio, scrollPane, scrollPane_1);
			}
		});
		btnSubstituir.setBounds(327, 433, 120, 23);
		contentPane.add(btnSubstituir);
		btnStatus.setBounds(60, 433, 120, 23);
		contentPane.add(btnStatus);

		JButton btnNegociarJogador = new JButton("Negociar Jogador");
		btnNegociarJogador.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNegociarJogador.setBounds(508, 59, 110, 23);
		contentPane.add(btnNegociarJogador);

		JLabel lblNewLabel = new JLabel("Posição: ");// +
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(152, 94, 123, 27);
		contentPane.add(lblNewLabel);

		JLabel lblAno = new JLabel("Ano: " + futirio.getCarioca().getAno());
		lblAno.setForeground(Color.WHITE);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAno.setBounds(378, 94, 110, 27);
		contentPane.add(lblAno);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(GerenciaTime.class.getResource("/Imagens/fundoGrande.png")));
		bg.setBounds(0, 0, 628, 467);
		contentPane.add(bg);

		// TODO: Criar um botão que quando clicado, chama o método abaixo
		// salvarJogo(campeonato);
	}

	public void atualizarTabelas(JTable TabelaTitulares, JTable TabelaReservas, OJogo futirio, JScrollPane scrollPane,
			JScrollPane scrollPane_1) {
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 133, 207, 294);
		contentPane.add(scrollPane);
		
		String[] colunas = { "Posição", "Nome", "Habilidade" };

		String[][] playersTitulares = futirio.getCarioca().getTimes().get(futirio.getIndexTime())
				.getAtributosJogadoresTitulares();
		String[][] playersReservas = futirio.getCarioca().getTimes().get(futirio.getIndexTime())
				.getAtributosJogadoresReservas();

		TabelaTitulares = new JTable(playersTitulares, colunas);
		scrollPane.setViewportView(TabelaTitulares);
		contentPane.add(scrollPane);

		TabelaReservas = new JTable(playersReservas, colunas);
		scrollPane_1.setViewportView(TabelaReservas);
		contentPane.add(scrollPane_1);
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
