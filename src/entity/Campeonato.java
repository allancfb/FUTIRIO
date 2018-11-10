package entity;

import java.util.ArrayList;

public class Campeonato {
	
	private int ano;
	private Time Campeao;
	private static int rodadasTotais = 30;
	private static int numPartidasTotal = 240;
	private int rodadaAtual;
	private int numPartidasJogadas;
	private ArrayList<TimeTabela> tabela = new ArrayList <TimeTabela>();

	public static int getRodadasTotais() {
		return rodadasTotais;
	}

	public static int getNumPartidasTotal() {
		return numPartidasTotal;
	}

	public int getRodadaAtual() {
		return rodadaAtual;
	}

	public int getNumPartidasJogadas() {
		return numPartidasJogadas;
	}

	public Time getCampeao() {
		return Campeao;
	}

	public void setCampeao(Time campeao) {
		Campeao = campeao;
	}

	public ArrayList<TimeTabela> getTabela() {
		return tabela;
	}

	public int getAno() {
		return ano;
	}
	
}
