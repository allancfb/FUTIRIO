package entity;

import java.util.ArrayList;

public class Rodada {

	private ArrayList<Time> timesJogos;
	private ArrayList<Partida> partidas;
	
	// Construtor
	
	public Rodada(ArrayList<Time> timesJogos) {
		this.timesJogos = timesJogos;
		partidas = new ArrayList<Partida>();
		
		for (int i = 0; i < timesJogos.size(); i += 2) {
			partidas.add(new Partida(timesJogos.get(i), timesJogos.get(i + 1)));
		}
	}
	
	// Getters and Setters
	
	public ArrayList<Time> gettimesJogos() {
		return timesJogos;
	}
	
	public ArrayList<Partida> getPartidas() {
		return partidas;
	}
	
	// Métodos

	public void rodar() {
		for (Partida partida : partidas) {
			partida.run();
		}
	}
	
}
