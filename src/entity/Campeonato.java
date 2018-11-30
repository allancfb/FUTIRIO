package entity;

import java.util.*;

public class Campeonato {

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

	// TODO: comentar
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
		return getRodadas()[getIndexRodadaAtual()-1];
	}
	
	// TODO: comentar
	public static int getRodadasTotais() {
		return rodadasTotais;
	}

	// TODO: comentar
	public static int getNumPartidasTotal() {
		return numPartidasTotal;
	}

	// TODO: comentar
	public int getIndexRodadaAtual() {
		return rodadaAtual;
	}

	// TODO: comentar
	public int getNumPartidasJogadas() {
		return numPartidasJogadas;
	}

	// TODO: comentar
	public Time getCampeao() {
		return Campeao;
	}

	// TODO: comentar POR ENQUANTO O TIME GANHA UM MILHAO QD GANHA O CAMPEONATO
	public void setCampeao(Time campeao) {
		Campeao = campeao;
		campeao.addFundos(1000000000);
	}

	// TODO: comentar
	public ArrayList<TimeTabela> getTabela() {
		return tabela;
	}

	// TODO: comentar
	public int getAno() {
		return ano;
	}

	// Métodos
	
	 
	// ////////////////////////////////////////////////////////////////////////

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

	public void PassarRodada() {
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

	// TODO: comentar
	public void organizaTabela() {

		ArrayList<TimeTabela> tabela = new ArrayList<TimeTabela>();
		tabela = this.tabela;

		for (int i = tabela.size() - 1; i >= 0; i--)
			organizador(tabela, tabela.get(i));

	}

	// TODO: comentar
	private void adicionarTimes() {

		String[] nomes = { "America", "Bangu", "Boavista-RJ", "Bonsucesso", "Botafogo", "Cabofriense", "Flamengo",
				"Fluminense", "Goytacaz", "Macaé", "Madureira", "Nova Iguaçu", "Portuguesa-RJ", "Resende", "Vasco",
				"Volta Redonda" };

		for (int i = 0; i < nomes.length; i++) {
			tabela.add(new TimeTabela(Main.carregarTime(nomes[i])));
			timesJogos.add(Main.carregarTime(nomes[i]));
		}
	}

	// TODO: comentar
	private void organizador(ArrayList<TimeTabela> tabela, TimeTabela timeTabela) {
		 TabelaComparator tabelaComparator = new TabelaComparator();
          Collections.sort(tabela, tabelaComparator);
		
		
//		for (int i = 0; i <= tabela.size(); i++) {
//			if (timeTabela.getPontos() > tabela.get(i).getPontos()) {
//				tabela.set(i, timeTabela);
//				break;
//			} else if (timeTabela.getPontos() == tabela.get(i).getPontos()) {
//				if (timeTabela.getVitorias() > tabela.get(i).getVitorias()) {
//					tabela.set(i, timeTabela);
//					break;
//				} else if (timeTabela.getVitorias() == tabela.get(i).getVitorias()) {
//					if (timeTabela.getSaldoGols() > tabela.get(i).getSaldoGols()) {
//						tabela.set(i, timeTabela);
//						break;
//					} else if (timeTabela.getSaldoGols() == tabela.get(i).getSaldoGols()) {
//						if (timeTabela.getQtGols() > tabela.get(i).getQtGols()) {
//							tabela.set(i, timeTabela);
//							break;
//						} else if (timeTabela.getQtGols() == tabela.get(i).getQtGols()) {
//							if (timeTabela.getEmpates() < tabela.get(i).getEmpates()) {
//								tabela.set(i, timeTabela);
//								break;
//							} else if (timeTabela.getEmpates() == tabela.get(i).getEmpates()) {
//								if (timeTabela.getDerrotas() < tabela.get(i).getDerrotas()) {
//									tabela.set(i, timeTabela);
//									break;
//								} else if (timeTabela.getDerrotas() == tabela.get(i).getDerrotas()) {
//									if (timeTabela.getGolsSofridos() < tabela.get(i).getGolsSofridos()) {
//										tabela.set(i, timeTabela);
//										break;
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//		}
	}

}
