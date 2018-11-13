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
	private ArrayList<TimeTabela> tabela = new ArrayList <TimeTabela>();
	private ArrayList<Time> jogosTimes = new ArrayList<Time>();
	//array de rodada  ===========to do
	
	Campeonato(int ano){
	
		this.ano = ano;
		this.rodadaAtual = 0;
		this.numPartidasJogadas = 0;
		this.nome = "Campeonato Carioca - " + ano;
		adicionarTimes();
		
		
	}
	
	public void organizaJogos() {
		jogosTimes.set(1, jogosTimes.get(8));
		jogosTimes.set(15, jogosTimes.get(8));
	}
	
	// TODO: comentar
	public String getNome() {
		return nome;
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

	// TODO: comentar
	public void setCampeao(Time campeao) {
		Campeao = campeao;
	}

	// TODO: comentar
	public ArrayList<TimeTabela> getTabela() {
		return tabela;
	}

	// TODO: comentar
	public int getAno() {
		return ano;
	}
	
	// TODO: comentar
	public void organizaTabela() {
		
		ArrayList<TimeTabela> tabelinha = new ArrayList <TimeTabela>();
		tabelinha = this.tabela;
		
		for(int i = tabela.size() - 1; i >= 0; i--)
			organizador(tabelinha.get(i));
		
	}
	
	// TODO: comentar
	private void adicionarTimes() {
		
		String[] nomes = {"America","Bangu","Boavista-RJ","Bonsucesso","Botafogo","Cabofriense","Flamengo","Fluminense","Goytacaz","Macaé","Madureira","Nova Iguaçu","Portuguesa-RJ","Resende","Vasco","Volta Redonda"};
		
		for(int i = 0; i < nomes.length;i++){
			tabela.add(new TimeTabela(Main.carregarTime(nomes[i])));
			jogosTimes.add(Main.carregarTime(nomes[i]));
		}
	}
	
	// TODO: comentar
	private void organizador(TimeTabela timeTabela) { 
		
		for(int i = 0; i <= tabela.size(); i++) {
			if(timeTabela.getPontos() > tabela.get(i).getPontos()) {
				tabela.set(i, timeTabela);
				break;
			} else if(timeTabela.getPontos() == tabela.get(i).getPontos()) {
				if(timeTabela.getVitorias() > tabela.get(i).getVitorias()) {
					tabela.set(i, timeTabela);
					break;
				} else if(timeTabela.getVitorias() == tabela.get(i).getVitorias()) {
					if(timeTabela.getSaldoGols() > tabela.get(i).getSaldoGols()) {
						tabela.set(i, timeTabela);
						break;
					}else if(timeTabela.getSaldoGols() == tabela.get(i).getSaldoGols()) {
						if(timeTabela.getQtGols() > tabela.get(i).getQtGols()) {
							tabela.set(i, timeTabela);
							break;
						}else if(timeTabela.getQtGols() == tabela.get(i).getQtGols()) {
							if(timeTabela.getEmpates() < tabela.get(i).getEmpates()) {
								tabela.set(i, timeTabela);
								break;
							}else if(timeTabela.getEmpates() == tabela.get(i).getEmpates()){
								if(timeTabela.getDerrotas() < tabela.get(i).getDerrotas()) {
									tabela.set(i, timeTabela);
									break;
								}else if(timeTabela.getDerrotas() == tabela.get(i).getDerrotas()) {
									if(timeTabela.getGolsSofridos() < tabela.get(i).getGolsSofridos()) {
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
