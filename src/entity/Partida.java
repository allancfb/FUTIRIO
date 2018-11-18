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
	Partida(Time time1, Time time2) {
		setTime1(time1);
		setTime2(time2);
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

	// TODO: comentar
	public void run() {
		minuto++;
		Random r = new Random();

		int geral1 = time1.getHabilidadeGeral();
		int geral2 = time2.getHabilidadeGeral();

		// Gera o geral dos times para a partida
		int geral1Partida = (int) (geral1 + (100 - geral1 - geral2) / 2);
		int geral2Partida = (int) (geral2 + (100 - geral1 - geral2) / 2);

		// Roda a partida
		atualizarPlacar();

		// Sorteia um número de 1 a 100
		int sorteioPosse = r.nextInt(100) + 1;

		// Se 
		if (sorteioPosse <= geral1Partida / 18) {
			time1Gols++;

			atualizarPlacar();
		} else if (sorteioPosse <= (geral2Partida / 18) + (geral1Partida / 18)) {
			time2Gols++;

			atualizarPlacar();
		}
	}

}
