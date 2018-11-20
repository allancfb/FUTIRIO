package entity;

import java.util.ArrayList;

public class Campeonato {

	private String nome;
	private int ano;
	private Time Campeao;
	private static int rodadasTotais = 30;
	private static int numPartidasTotal = 240;
	private int rodadaAtual;
	private int numPartidasJogadas;
	private ArrayList<TimeTabela> tabela = new ArrayList<TimeTabela>();
	private ArrayList<Time> timesJogos = new ArrayList<Time>();
	private ArrayList<Rodada> rodadas = new ArrayList<Rodada>();

	// Construtor

	public Campeonato(int ano) {

		this.ano = ano;
		this.rodadaAtual = 1;
		this.numPartidasJogadas = 0;
		this.nome = "Campeonato Carioca - " + ano;
		
		adicionarTimes();
		gerarRodadas();

	}

	// Getters and Setters

	// TODO: comentar
	public String getNome() {
		return nome;
	}

	public ArrayList<Time> getTimesJogos() {
		return timesJogos;
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
	public int getRodadaAtual() {
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

	public ArrayList<Time> gettimesJogos() {
		return timesJogos;
	}

	// Métodos
	
	public void gerarRodadas() {  /* 0--------------------------------------0 */
		
		for(int i = 0; i < 30; i++) {
		Rodada rodada = new Rodada(getTimesJogos());
		organizaJogos();
		rodadas.add(rodada);
		}
	}
	public void PassarRodada() {
		rodadaAtual++;
		numPartidasJogadas = numPartidasJogadas + 8;
		
	}
	

	public void organizaJogos() {
		timesJogos.set(1, timesJogos.get(8));
		timesJogos.set(15, timesJogos.get(8));
	}

	// TODO: comentar
	public void organizaTabela() {

		ArrayList<TimeTabela> tabela = new ArrayList<TimeTabela>();
		tabela = this.tabela;

		for (int i = tabela.size() - 1; i >= 0; i--)
			organizador(tabela.get(i));

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
	private void organizador(TimeTabela timeTabela) {

		for (int i = 0; i <= tabela.size(); i++) {
			if (timeTabela.getPontos() > tabela.get(i).getPontos()) {
				tabela.set(i, timeTabela);
				break;
			} else if (timeTabela.getPontos() == tabela.get(i).getPontos()) {
				if (timeTabela.getVitorias() > tabela.get(i).getVitorias()) {
					tabela.set(i, timeTabela);
					break;
				} else if (timeTabela.getVitorias() == tabela.get(i).getVitorias()) {
					if (timeTabela.getSaldoGols() > tabela.get(i).getSaldoGols()) {
						tabela.set(i, timeTabela);
						break;
					} else if (timeTabela.getSaldoGols() == tabela.get(i).getSaldoGols()) {
						if (timeTabela.getQtGols() > tabela.get(i).getQtGols()) {
							tabela.set(i, timeTabela);
							break;
						} else if (timeTabela.getQtGols() == tabela.get(i).getQtGols()) {
							if (timeTabela.getEmpates() < tabela.get(i).getEmpates()) {
								tabela.set(i, timeTabela);
								break;
							} else if (timeTabela.getEmpates() == tabela.get(i).getEmpates()) {
								if (timeTabela.getDerrotas() < tabela.get(i).getDerrotas()) {
									tabela.set(i, timeTabela);
									break;
								} else if (timeTabela.getDerrotas() == tabela.get(i).getDerrotas()) {
									if (timeTabela.getGolsSofridos() < tabela.get(i).getGolsSofridos()) {
										tabela.set(i, timeTabela);
										break;
									}
								}
							}
						}
					}
				}
			}
		}
	}

}
