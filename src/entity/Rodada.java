package entity;

import java.util.ArrayList;

public class Rodada {

	private ArrayList<Time> timesJogos;
	private ArrayList<Partida> partidas;
	private int minuto = 0;
	private Tempo tempo;

	// Construtor

	public Rodada(ArrayList<Time> timesJogos) {
		this.timesJogos = timesJogos;
		partidas = new ArrayList<Partida>();
		tempo = Tempo.DEFAULT;

		for (int i = 0; i < timesJogos.size() / 2; i++) {
			partidas.add(new Partida(timesJogos.get(i), timesJogos.get(i + 8)));
		}
	}

	// Getters and Setters

	public ArrayList<Time> getTimesJogos() {
		return timesJogos;
	}

	public int getMinuto() {
		return minuto;
	}

	public Tempo getTempo() {
		return tempo;
	}

	public ArrayList<Partida> getPartidas() {
		return partidas;
	}

	// Métodos
	
	// Roda 1 minuto de todas as partidas da rodada
	public void run() {

		minuto += 1;
		for (Partida partida : partidas) {
			partida.run();
		}

		Thread.currentThread();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Atualiza em que tempo o jogo está
	private void atualizarTempo() {
		switch (minuto) {
		case 1:
			tempo = Tempo.PRIMEIRO;
			break;

		// case 45:
		// tempo = Tempo.INTERVALO;
		// break;

		case 46:
			tempo = Tempo.SEGUNDO;
			break;

		case 90:
			tempo = Tempo.FIM;
			break;

		// case 91:
		// tempo = Tempo.PRORROGAÇÃO1;
		// break;
		//
		// case 105:
		// tempo = Tempo.INTERVALOPRORROGAÇÃO;
		// break;
		//
		// case 106:
		// tempo = Tempo.PRORROGAÇÃO2;
		// break;
		//
		// case 120:
		// tempo = Tempo.DEFAULT;
		// break;

		default:
			break;
		}
	}

}
