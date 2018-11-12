package entity;

import java.util.Random;

public class Partida {
	
	private Time time1;
	private Time time2;
	private String placar;
	private Tempo tempo;
	private int numJogadas;
	private int time1Gols;
	private int time2Gols;
	
	// Construtor
	
	// TODO: comentar
	Partida (Time time1, Time time2) {
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
	public int getNumJogadas() {
		return numJogadas;
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
		Random r = new Random();
		
		int geral1 = time1.getHabilidadeGeral();
		int geral2 = time2.getHabilidadeGeral();
		
		// Gera o geral dos times para a partida
		int geral1Partida = (int) (geral1 + (100 - geral1 - geral2) / 2);
		int geral2Partida = (int) (geral2 + (100 - geral1 - geral2) / 2);
		System.out.println("Geral de " + time1.getNome() + " durante a partida: " + geral1Partida);
		System.out.println("Geral de " + time2.getNome() + " durante a partida: " + geral2Partida);
		
		// Roda a partida
		int vf = 0;
		int vbf = 0;
		int emp = 0;
		for (int j = 0; j < 100000; j++) {
			time1Gols = 0;
			time2Gols = 0;
			atualizarPlacar();
			
			for (int i = 0; i < 90; i++) {
				numJogadas = i;
				
				// Sorteia quem vai jogar a jogada, de acordo com a porcentagem de cada time
				int sorteioPosse = r.nextInt(100) + 1;
				
				// Se o número sorteado estiver dentro da chance do time 1 de jogar, ele joga
				// Senão, time 2 joga
				if (sorteioPosse <= geral1Partida / 18) {
					time1Gols++;
					
					atualizarPlacar();
				}
				else if (sorteioPosse <= (geral2Partida / 18) + (geral1Partida / 18)) {
					time2Gols++;
					
					atualizarPlacar();
				}
			}
			
			if (time1Gols > time2Gols) {
				vf++;
			}
			else if (time2Gols > time1Gols) {
				vbf++;
			}
			else {
				emp++;
			}
		}
		System.out.println("Vitórias Flamengo: " + vf);
		System.out.println("Vitórias Botafogo: " + vbf);
		System.out.println("Empates: " + emp);
	}
	
}
