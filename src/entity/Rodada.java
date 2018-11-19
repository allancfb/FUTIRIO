package entity;

import java.util.ArrayList;

public class Rodada {

	private ArrayList<Time> timesJogos;
	private ArrayList<Partida> partidas;
	
	// Construtor
	
	Rodada(ArrayList<Time> timesJogos) {
		this.timesJogos = timesJogos;
		
	}
	
	// Getters and Setters
	
	public ArrayList<Time> gettimesJogos() {
		return timesJogos;
	}
	
	// Métodos
	
	public void rodar() {
		for (Partida partida : partidas) {
			partida.run();
		}
	}
	
}
