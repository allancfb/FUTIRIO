package entity;

public class TimeTabela {

	private Time time;
	private int pontos;
	private int vitorias;
	private int saldoGols;
	private int qtGols;
	private int empates;
	private int derrotas;
	private int golsSofridos;

	// TODO:  comentar
	public Time getTime() {
		return time;
	}
	// TODO:  comentar
	public int getQtGols() {
		return qtGols;
	}
	// TODO:  comentar
	public int getPontos() {
		return pontos;
	}
	// TODO:  comentar
	public int getVitorias() {
		return vitorias;
	}
	// TODO:  comentar
	public int getDerrotas() {
		return derrotas;
	}
	// TODO:  comentar
	public int getEmpates() {
		return empates;
	}
	// TODO:  comentar
	public int getGolsSofridos() {
		return golsSofridos;
	}
	// TODO:  comentar
	public int getSaldoGols() {
		return saldoGols;
	}
	
	TimeTabela(Time time, int pontos, int vitorias, int saldoGols, int qtdGols, int empates, int derrotas, int golSofrido){
		
		this.time = time;
		this.pontos = pontos;
		this.vitorias = vitorias;
		this.saldoGols = saldoGols;
		this.qtGols = qtdGols;
		this.empates = empates;
		this.derrotas = derrotas;
		this.golsSofridos = golSofrido;
	
	}
	
	
}