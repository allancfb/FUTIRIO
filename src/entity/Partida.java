package entity;

import java.io.Serializable;
import java.util.Random;

public class Partida implements Serializable {

	private static final long serialVersionUID = 1L;
	private Time time1;
	private Time time2;
	private String placar;
	private Tempo tempo;
	private int minuto;
	private int time1Gols;
	private int time2Gols;

	// Construtor
	public Partida(Time time1, Time time2) {
		setTime1(time1);
		setTime2(time2);
		tempo = Tempo.DEFAULT;
		atualizarPlacar();
	}

	// Getters and Setters

	public Time getTime1() {
		return time1;
	}

	public Time getTime2() {
		return time2;
	}

	public String getPlacar() {
		return placar;
	}

	public int getTime1Gols() {
		return time1Gols;
	}

	public int getTime2Gols() {
		return time2Gols;
	}

	public int getMinuto() {
		return minuto;
	}

	public Tempo getTempo() {
		return tempo;
	}

	private void setTime1(Time time1) {
		this.time1 = time1;
	}

	private void setTime2(Time time2) {
		this.time2 = time2;
	}

	private void atualizarPlacar() {
		placar = time1.getNome() + " " + time1Gols + " x " + time2Gols + " " + time2.getNome();
	}

	// Métodos

	// Roda 1 minuto da partida
	public void run() {
		minuto++;
		Random r = new Random();

		double geral1 = time1.getHabilidadeGeral();
		double geral2 = time2.getHabilidadeGeral();

		// Gera o geral dos times para a partida
		double geral1Partida = geral1 + (100 - geral1 - geral2) / 2;
		double geral2Partida = geral2 + (100 - geral1 - geral2) / 2;

		// Roda a partida
		atualizarPlacar();

		// Sorteia um número de 1 a 100
		double sorteioPosse = r.nextDouble() * 100;

		// Confere se algum time fez gol
		if (sorteioPosse <= geral1Partida / 25) {
			time1Gols++;

			atualizarPlacar();
		} else if (sorteioPosse <= (geral2Partida / 25) + (geral1Partida / 25)) {
			time2Gols++;

			atualizarPlacar();
		}

		atualizarTempo();
	}

	// Atualiza em que tempo o jogo está
	private void atualizarTempo() {
		switch (minuto) {
		case 1:
			tempo = Tempo.PRIMEIRO;
			break;

		case 46:
			tempo = Tempo.SEGUNDO;
			break;

		case 90:
			tempo = Tempo.FIM;
			break;

		default:
			break;
		}
	}

}
