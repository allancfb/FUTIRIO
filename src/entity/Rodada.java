package entity;

import java.util.ArrayList;

public class Rodada {

	private ArrayList<Time> timesJogos;
	private ArrayList<Partida> partidas;
	private int minuto;
	private Tempo tempo;

	// Construtor

	public Rodada(ArrayList<Time> timesJogos) {
		this.timesJogos = timesJogos;
		partidas = new ArrayList<Partida>();
		tempo = Tempo.DEFAULT;

		for (int i = 0; i < timesJogos.size(); i += 2) {
			partidas.add(new Partida(timesJogos.get(i), timesJogos.get(i + 1)));
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

	// Roda 45 minutos de todas as partidas da rodada
	public void start() {
		// Delay pra não bugar o timer
		Thread.currentThread();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 1; i <= 45; i++) {
			// Esse for é só enquanto não tem a interação com a interface
			for (int j = 0; j < 1000; j++) {
				System.out.println();
			}
			
			minuto++;
			
			// TODO: mostrar minuto na tela
			System.out.println(minuto);
			
			atualizarTempo();
			// TODO: mostra tempo na tela
			System.out.println(tempo.getNome());
			
			run();
			
			// TODO: atualizar placares na tela
			
			// Esse for é só enquanto não tem a interação com a interface, para visualizar
			for (Partida partida : partidas) {
				System.out.println(partida.getPlacar());
			}
			
			// Sleep meio segundo
			Thread.currentThread();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Roda 1 minuto de todas as partidas da rodada
	private void run() {
		for (Partida partida : partidas) {
			partida.run();
		}
	}

	// Atualiza em que tempo o jogo está
	private void atualizarTempo() {
		switch (minuto) {
		case 1:
			tempo = Tempo.PRIMEIRO;
			break;

		case 45:
			tempo = Tempo.INTERVALO;
			break;

		case 46:
			tempo = Tempo.SEGUNDO;
			break;

		case 90:
			tempo = Tempo.FIM;
			break;

		case 91:
			tempo = Tempo.PRORROGAÇÃO1;
			break;

		case 105:
			tempo = Tempo.INTERVALOPRORROGAÇÃO;
			break;

		case 106:
			tempo = Tempo.PRORROGAÇÃO2;
			break;

		case 120:
			tempo = Tempo.DEFAULT;
			break;

		default:
			break;
		}
	}
	
}
