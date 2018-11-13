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

	//Construtor Definitivo
	TimeTabela(Time time){
		
		this.time = time;
		this.pontos = 0;
		this.vitorias = 0;
		this.saldoGols = 0;
		this.qtGols = 0;
		this.empates = 0;
		this.derrotas = 0;
		this.golsSofridos = 0;
	
	}
	
	//Construtor Teste (DEPOIS DE TESTAR PODE APAGAR)
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

	//Adiciona Vitoria
	public void addVitoria() {
		this.vitorias += 1;
		this.pontos += 3;
	}

	//Atualiza o saldo de gols
	public void attSaldoGols(int gols) {
		this.saldoGols = this.qtGols - this.golsSofridos;
	}

	//Adiciona qtdGols
	public void addQtGols(int Gols) {
		this.qtGols += Gols;
	}

	//Adiciona empate
	public void addEmpate() {
		this.empates += 1;
		this.pontos += 1;
	}

	//Adiciona derrota
	public void addDerrota() {
		this.derrotas += 1;
	}

	//Adicionar os gols sofridos no ultimo jogo
	public void addGolsSofridos(int golsSofridos) {
		this.golsSofridos += golsSofridos;
	}

}