package entity;

import java.util.Random;

public class Partida {

	private Time time1;
	private Time time2;
	private String placar;
	private Tempo tempo;
	private int minuto;
	private int time1Gols;
	private int time2Gols;

	// Construtor

	// TODO: comentar
	public Partida(Time time1, Time time2) {
		setTime1(time1);
		setTime2(time2);
		tempo = Tempo.DEFAULT;
		atualizarPlacar();
	}

	// Getters and Setters

	// TODO: comentar
	public Time getTime1() {
		return time1;
	}

	// TODO: comentar
	public Time getTime2() {
		return time2;
	}

	// TODO: comentar
	public String getPlacar() {
		return placar;
	}
	
	public int getTime1Gols() {
		return time1Gols;
	}

	public int getTime2Gols() {
		return time2Gols;
	}

	// TODO: comentar
	public int getMinuto() {
		return minuto;
	}

	// TODO: comentar
	public Tempo getTempo() {
		return tempo;
	}

	// TODO: comentar
	private void setTime1(Time time1) {
		this.time1 = time1;
	}

	// TODO: comentar
	private void setTime2(Time time2) {
		this.time2 = time2;
	}

	// TODO: comentar
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
		if (sorteioPosse <= geral1Partida / 18) {
			time1Gols++;

			atualizarPlacar();
		} else if (sorteioPosse <= (geral2Partida / 18) + (geral1Partida / 18)) {
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

//		case 45:
//			tempo = Tempo.INTERVALO;
//			break;

		case 46:
			tempo = Tempo.SEGUNDO;
			break;

		case 90:
			tempo = Tempo.FIM;
			break;

		case 91:
//			tempo = Tempo.PRORROGAÇÃO1;
//			break;
//
//		case 105:
//			tempo = Tempo.INTERVALOPRORROGAÇÃO;
//			break;
//
//		case 106:
//			tempo = Tempo.PRORROGAÇÃO2;
//			break;
//
//		case 120:
//			tempo = Tempo.DEFAULT;
//			break;

		default:
			break;
		}
	}
	
}
