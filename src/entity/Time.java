package entity;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Time {
	
	private String nome;
	private ArrayList<Jogador> jogadores;
	
	// Construtores
	
	Time() {
		Random random = new Random();
		String nomesTimes[] = new String[1000];
		
		try {
			// Lê o arquivo
			File nomesTimesFile = new File("src/entity/nomesTimes.txt");
			Scanner nomesTimesScanner = new Scanner(nomesTimesFile);
			jogadores = new ArrayList<Jogador>();
			
			// Coloca os nomes dos times do arquivo no vetor
			for (int i = 0; i < nomesTimes.length; i++) {
				nomesTimes[i] = nomesTimesScanner.nextLine();
			}
			
			nome = nomesTimes[random.nextInt(nomesTimes.length)];
			
			// cria jogadores
			for (int i = 0; i < 2; i++) {
				jogadores.add(new Jogador(Posicao.GOL));
			}
			for (int i = 0; i < 8; i++) {
				jogadores.add(new Jogador(Posicao.DEFESA));
			}
			for (int i = 0; i < 8; i++) {
				jogadores.add(new Jogador(Posicao.MEIA));
			}
			for (int i = 0; i < 4; i++) {
				jogadores.add(new Jogador(Posicao.ATAQUE));
			}
			
			nomesTimesScanner.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	Time(String nome) {
		jogadores = new ArrayList<Jogador>();
		
		this.nome = nome;
		
		// cria jogadores
		for (int i = 0; i < 2; i++) {
			jogadores.add(new Jogador(Posicao.GOL));
		}
		for (int i = 0; i < 8; i++) {
			jogadores.add(new Jogador(Posicao.DEFESA));
		}
		for (int i = 0; i < 8; i++) {
			jogadores.add(new Jogador(Posicao.MEIA));
		}
		for (int i = 0; i < 4; i++) {
			jogadores.add(new Jogador(Posicao.ATAQUE));
		}
	}

	// Getters and Setters
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogador(Jogador jogador) {
		jogadores.add(jogador);
	}
	
}
