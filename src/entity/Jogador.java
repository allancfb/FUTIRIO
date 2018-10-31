package entity;

import java.util.Random;

public class Jogador {

	private Nome nome;
	private Time time;
	private double salario;
	protected int chute;
	protected int drible;
	protected int passe;
	protected int desarme;
	protected int defesa;
	private double habilidade;
	private boolean isCapitao;
	protected Posicao posicao;
	protected Posicao posicaoRecomendada;
	
	// Construtores
	Jogador() {
		Random random = new Random();
		
		random.nextInt(4);
		
		nome = new Nome();
	}
	
	Jogador(Nome nome) {
		this.nome = nome;
	}
	
	// Getters and Setters
	public Nome getNome() {
		return nome;
	}
	
	public String getNomeTodo() {
		return nome.getNomeTodo();
	}
	
	public Time getTime() {
		return time;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public Posicao getPosicao() {
		return posicao;
	}
	
	public int getChute() {
		return chute;
	}
	
	public int getDrible() {
		return drible;
	}
	
	public int getPasse() {
		return passe;
	}
	
	public int getDefesa() {
		return defesa;
	}
	
	public int getDesarme() {
		return desarme;
	}
	
	public double getHabilidade() {
		return habilidade;
	}
	
	public Posicao getPosicaoRecomendada() {
		return posicaoRecomendada;
	}
	
	public void setNome(Nome nome) {
		this.nome = nome;
	}
	
	public void setTime(Time time) {
		this.time = time;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	public void setChute(int chute) {
		this.chute = chute;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	public void setDrible(int drible) {
		this.drible = drible;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	public void setPasse(int passe) {
		this.passe = passe;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	public void setDesarme(int desarme) {
		this.desarme = desarme;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	public void setIsCapitao(boolean isCapitao) {
		this.isCapitao = isCapitao;
	}

	// Métodos
	public boolean isCapitao() {
		return isCapitao;
	}
	
	protected void atualizarHabilidade() {
		habilidade = calcularHabilidade(posicao);
	}
	
	protected void atualizarPosicaoRecomendada() {
		posicaoRecomendada = calcularPosicaoRecomendada();
	}
	
	private double calcularHabilidade(Posicao posicao) {
		switch (posicao) {
			case GOL:
				//TODO: estabelecer media ponderada
				return 1.0;
				
			case DEFESA:
				//TODO: estabelecer media ponderada
				return 1.0;
			
			case MEIA:
				//TODO: estabelecer media ponderada
				return 1.0;
				
			case ATAQUE:
				//TODO: estabelecer media ponderada
				return 1.0;
				
			default:
				return 1.0;
		}
	}
	
	private Posicao calcularPosicaoRecomendada() {
		// TODO: estabelece média ponderada
		return Posicao.ATAQUE;
	}
	
}
