package entity;

import java.io.Serializable;
import java.util.*;

public class Campeonato implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private int ano;
	private Time Campeao;
	private static int rodadasTotais = 30;
	private static int numPartidasTotal = 240;
	private int rodadaAtual = 1;
	private int numPartidasJogadas;
	private ArrayList<TimeTabela> tabela;
	private ArrayList<Time> timesJogos;
	private static ArrayList<Time> times;
	private Rodada[] rodadas;
	private ListaDeTransferencia listaDeTransferencia;

	// Construtor

	public Campeonato(int ano) {
		this.ano = ano;
		this.rodadaAtual = 1;
		this.numPartidasJogadas = 0;
		this.nome = "Campeonato Carioca - " + ano;
		rodadas = new Rodada[30];
		tabela = new ArrayList<TimeTabela>();
		timesJogos = new ArrayList<Time>();
		times = new ArrayList<Time>();
		listaDeTransferencia = new ListaDeTransferencia();

		adicionarTimes();

		for (Time time : timesJogos) {
			times.add(time);
		}

		gerarRodadas();
		gerarAdversarios();
	}

	// Getters and Setters

	public String getNome() {
		return nome;
	}

	public Time getTime(int posicao) {
		return times.get(posicao);
	}

	public ArrayList<Time> getTimes() {
		return times;
	}

	public static int retornaPosicao(Time time) {
		return times.indexOf(time);
	}

	public Rodada[] getRodadas() {
		return rodadas;
	}

	public Rodada getRodadaAtual() {
		return getRodadas()[getIndexRodadaAtual() - 1];
	}

	public static int getRodadasTotais() {
		return rodadasTotais;
	}

	public static int getNumPartidasTotal() {
		return numPartidasTotal;
	}

	public int getIndexRodadaAtual() {
		return rodadaAtual;
	}

	public int getNumPartidasJogadas() {
		return numPartidasJogadas;
	}

	public ListaDeTransferencia getListaDeTransferencia() {
		return listaDeTransferencia;
	}

	public Time getCampeao() {
		return Campeao;
	}

	public void setCampeao(Time campeao) {
		Campeao = campeao;
		campeao.addFundos(10000000);
	}

	public ArrayList<TimeTabela> getTabela() {
		return tabela;
	}

	public int getAno() {
		return ano;
	}

	public String[][] getInformacoesTimesTabela() {
		String [][] informacoesTimesTabela = new String[tabela.size()][6];
		
		for (int i = 0; i < tabela.size(); i++) {
			informacoesTimesTabela[i] = tabela.get(i).getInformacoes();
		}
		
		return informacoesTimesTabela;
	}
	
	// M�todos

	public Rodada getProximaRodada() {
		return rodadas[rodadaAtual + 1];
	}

	public void gerarAdversarios() {
		for (Rodada rodada : rodadas) {
			for (Time time : times) {
				for (Partida partida : rodada.getPartidas()) {
					if (partida.getTime1().getNome() == time.getNome()) {
						time.addAdversario(partida.getTime2());
					} else if (partida.getTime2().getNome() == time.getNome()) {
						time.addAdversario(partida.getTime1());
					}
				}
			}
		}
	}

	public void gerarRodadas() {

		for (int i = 0; i < 30; i++) {
			rodadas[i] = new Rodada(timesJogos);
			organizaJogos();

		}
	}

	public void passarRodada() {
		rodadaAtual++;
		numPartidasJogadas = numPartidasJogadas + 8;

	}

	public void organizaJogos() {
		ArrayList<Time> auxiliarJogos = new ArrayList<Time>();
		for (int i = 0; i < timesJogos.size(); i++) {
			auxiliarJogos.add(timesJogos.get(i));
		}
		timesJogos.clear();
		// 0 -- 15 8 ir para 1 ; 9 ir para 15
		// 0 8 1 2 3 4 5 6
		// 9 10 11 12 13 14 15 7

		timesJogos.add(auxiliarJogos.get(0));
		timesJogos.add(auxiliarJogos.get(8));
		timesJogos.add(auxiliarJogos.get(1));
		timesJogos.add(auxiliarJogos.get(2));
		timesJogos.add(auxiliarJogos.get(3));
		timesJogos.add(auxiliarJogos.get(4));
		timesJogos.add(auxiliarJogos.get(5));
		timesJogos.add(auxiliarJogos.get(6));
		timesJogos.add(auxiliarJogos.get(9));
		timesJogos.add(auxiliarJogos.get(10));
		timesJogos.add(auxiliarJogos.get(11));
		timesJogos.add(auxiliarJogos.get(12));
		timesJogos.add(auxiliarJogos.get(13));
		timesJogos.add(auxiliarJogos.get(14));
		timesJogos.add(auxiliarJogos.get(15));
		timesJogos.add(auxiliarJogos.get(7));
	}

	public void organizaTabela() {
		TabelaComparator tabelaComparator = new TabelaComparator();
		Collections.sort(tabela, tabelaComparator);
		
		for (int i = 0; i < tabela.size(); i++) {
			tabela.get(i).setPosicao(i + 1);
		}

	}

	public void criarListaDeTransferencia() {
		listaDeTransferencia = new ListaDeTransferencia();
	}
	
	private void adicionarTimes() {
		String[] nomes = { "America", "Bangu", "Boavista-RJ", "Bonsucesso", "Botafogo", "Cabofriense", "Flamengo",
				"Fluminense", "Goytacaz", "Maca�", "Madureira", "Nova Igua�u", "Portuguesa-RJ", "Resende", "Vasco",
				"Volta Redonda" };

		for (int i = 0; i < nomes.length; i++) {
			TimeTabela timeTabela = new TimeTabela(Main.carregarTime(nomes[i]));
			tabela.add(timeTabela);
			timesJogos.add(Main.carregarTime(nomes[i]));
			timesJogos.get(timesJogos.size() - 1).setTimeTabela(timeTabela);
		}
	}
}
