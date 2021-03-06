package entity;

import java.io.Serializable;
import java.util.*;

public class TimeTabela implements Comparable<TimeTabela>, Serializable {

	private static final long serialVersionUID = 1L;
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

	// Getters and Setters

	public Time getTime() {
		return time;
	}

	public int getQtGols() {
		return qtGols;
	}

	public int getPontos() {
		return pontos;
	}

	public int getVitorias() {
		return vitorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public int getEmpates() {
		return empates;
	}

	public int getGolsSofridos() {
		return golsSofridos;
	}

	public int getSaldoGols() {
		return saldoGols;
	}

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
		String[] informacoes = { Integer.toString(posicao), nome, Integer.toString(pontos), Integer.toString(vitorias),
				Integer.toString(saldoGols), Integer.toString(empates), Integer.toString(derrotas) };
		
		return informacoes;
	}

	// M�todos

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