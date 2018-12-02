package entity;

import java.util.*;

public class TimeTabela implements Comparable<TimeTabela> {

	private Time time;
	private int pontos;
	private int vitorias;
	private int saldoGols;
	private int qtGols;
	private int empates;
	private int derrotas;
	private int golsSofridos;
	private int posicao;
	private String nome;

	// Contrutores

	// Construtor Definitivo
	public TimeTabela(Time time) {

		this.time = time;
		this.pontos = 0;
		this.vitorias = 0;
		this.saldoGols = 0;
		this.qtGols = 0;
		this.empates = 0;
		this.derrotas = 0;
		this.golsSofridos = 0;
		this.nome = time.getNome();

	}

	// Construtor Teste (DEPOIS DE TESTAR PODE APAGAR)
	TimeTabela(Time time, int pontos, int vitorias, int saldoGols, int qtdGols, int empates, int derrotas,
			int golSofrido) {

		this.time = time;
		this.pontos = pontos;
		this.vitorias = vitorias;
		this.saldoGols = saldoGols;
		this.qtGols = qtdGols;
		this.empates = empates;
		this.derrotas = derrotas;
		this.golsSofridos = golSofrido;

	}

	// Getters and Setters

	// TODO: comentar
	public Time getTime() {
		return time;
	}

//	public void setPontos(int pontos) {
//		this.pontos = pontos;
//	}

	// TODO: comentar
	public int getQtGols() {
		return qtGols;
	}

	// TODO: comentar
	public int getPontos() {
		return pontos;
	}

	// TODO: comentar
	public int getVitorias() {
		return vitorias;
	}

	// TODO: comentar
	public int getDerrotas() {
		return derrotas;
	}

	// TODO: comentar
	public int getEmpates() {
		return empates;
	}

	// TODO: comentar
	public int getGolsSofridos() {
		return golsSofridos;
	}

	// TODO: comentar
	public int getSaldoGols() {
		return saldoGols;
	}

	// TODO: comentar
	public String getNome() {
		return nome;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public String[] getInformacoes() {
		String[] informacoes = { nome, Integer.toString(pontos), Integer.toString(vitorias),
				Integer.toString(saldoGols), Integer.toString(empates), Integer.toString(derrotas) };
		
		return informacoes;
	}

	// Métodos

	public int compareTo(TimeTabela outroTimeTabela) {
		if (this.getPontos() < outroTimeTabela.getPontos()) {
			return 1;
		} else if (this.getPontos() > outroTimeTabela.getPontos()) {
			return -1;
		} else {
			if (this.getVitorias() < outroTimeTabela.getVitorias()) {
				return 1;
			} else if (this.getVitorias() > outroTimeTabela.getVitorias()) {
				return -1;
			} else {
				if (this.getSaldoGols() < outroTimeTabela.getSaldoGols()) {
					return 1;
				} else if (this.getSaldoGols() > outroTimeTabela.getSaldoGols()) {
					return -1;
				} else {
					if (this.getQtGols() < outroTimeTabela.getQtGols()) {
						return 1;
					} else if (this.getQtGols() > outroTimeTabela.getQtGols()) {
						return -1;
					} else {
						if (this.getEmpates() > outroTimeTabela.getEmpates()) {
							return 1;
						} else if (this.getEmpates() < outroTimeTabela.getEmpates()) {
							return -1;
						} else {
							if (this.getDerrotas() > outroTimeTabela.getDerrotas()) {
								return 1;
							} else if (this.getDerrotas() < outroTimeTabela.getDerrotas()) {
								return -1;
							} else {
								if (this.getGolsSofridos() > outroTimeTabela.getGolsSofridos()) {
									return 1;
								} else if (this.getGolsSofridos() < outroTimeTabela.getGolsSofridos()) {
									return -1;
								} else {
									if (Campeonato.retornaPosicao(this.getTime()) > Campeonato
											.retornaPosicao(outroTimeTabela.getTime())) {
										return -1;
									} else if (Campeonato.retornaPosicao(this.getTime()) < Campeonato
											.retornaPosicao(outroTimeTabela.getTime())) {
										return 1;
									}
								}

							}
						}
					}
				}
			}
		}

		return 0;
	}

	// Atualiza o saldo de gols
	private void atualizarSaldoGols() {
		this.saldoGols = this.qtGols - this.golsSofridos;
	}

	// Adiciona qtdGols
	public void addQtGols(int Gols) {
		this.qtGols += Gols;
		
		atualizarSaldoGols();
	}

	// Adiciona Vitoria
	public void addVitoria() {
		this.vitorias += 1;
		this.pontos += 3;
	}

	// Adiciona empate
	public void addEmpate() {
		this.empates += 1;
		this.pontos += 1;
	}

	// Adiciona derrota
	public void addDerrota() {
		this.derrotas += 1;
	}

	// Adicionar os gols sofridos no ultimo jogo
	public void addGolsSofridos(int golsSofridos) {
		this.golsSofridos += golsSofridos;
		
		atualizarSaldoGols();
	}

}