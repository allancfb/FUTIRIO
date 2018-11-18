package entity;

import java.util.ArrayList;

public class Rodada {

	private ArrayList<Time> jogosTimes;
	private ArrayList<Partida> partidas;
	
	// Construtor
	
	Rodada(ArrayList<Time> jogosTimes) {
		this.jogosTimes = jogosTimes;
		
	}
	
	// Getters and Setters
	
	public ArrayList<Time> getJogosTimes() {
		return jogosTimes;
	}
	
	// Métodos
	
	public void rodar() {
		for (Partida partida : partidas) {
			partida.run();
		}
	}
	
}
