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
	private Rodada[] rodadas;

	// Construtor

	public Campeonato(int ano) {

		this.ano = ano;
		this.rodadaAtual = 1;
		this.numPartidasJogadas = 0;
		this.nome = "Campeonato Carioca - " + ano;
		rodadas = new Rodada[30];

		adicionarTimes();
		gerarRodadas();

	}

	// Getters and Setters

	// TODO: comentar
	public String getNome() {
		return nome;
	}

	public Rodada[] getRodadas() {
		return rodadas;
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

	public void gerarRodadas() { /* 0--------------------------------------0 */

		for (int i = 0; i < 30; i++) {
            if (i != 0) {	
				for(int j = 0; j <= 1; j++) {
				organizaJogos();
				}
			}
			rodadas[i] = new Rodada(timesJogos);
		}
	}

	public void PassarRodada() {
		rodadaAtual++;
		numPartidasJogadas = numPartidasJogadas + 8;

	}

	public void organizaJogos() {
		ArrayList<Time> auxiliarJogos = timesJogos;
		
		//0 -- 15     8 ir para 1 ; 9 ir para 15  
		//0  8 1  2  3  4  5  6 
		//9 10 11 12 13 14 15 7 
	
		timesJogos.set(1, auxiliarJogos.get(8));
		timesJogos.set(2, auxiliarJogos.get(1));
		timesJogos.set(3, auxiliarJogos.get(2));
		timesJogos.set(4, auxiliarJogos.get(3));
		timesJogos.set(5, auxiliarJogos.get(4));
		timesJogos.set(6, auxiliarJogos.get(5));
		timesJogos.set(7, auxiliarJogos.get(6));
		timesJogos.set(8, auxiliarJogos.get(9));
		timesJogos.set(9, auxiliarJogos.get(10));
		timesJogos.set(10, auxiliarJogos.get(11));
		timesJogos.set(11, auxiliarJogos.get(12));
		timesJogos.set(12, auxiliarJogos.get(13));
		timesJogos.set(13, auxiliarJogos.get(14));
		timesJogos.set(14, auxiliarJogos.get(15));
		timesJogos.set(15, auxiliarJogos.get(7));
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
