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
			// L� o arquivo
			File nomesTimesFile = new File("src/unifoot/nomesTimes.txt");
			Scanner nomesTimesScanner = new Scanner(nomesTimesFile);
			jogadores = new ArrayList<Jogador>();
			
			// Coloca os nomes dos times do arquivo no vetor
			for (int i = 0; i < nomesTimes.length; i++) {
				nomesTimes[i] = nomesTimesScanner.nextLine();
			}
			
			nome = nomesTimes[random.nextInt(nomesTimes.length)];
			
			// cria jogadores
			for (int i = 0; i < 20; i++) {
				jogadores.add(new Jogador());
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	Time(String nome) {
		jogadores = new ArrayList<Jogador>();
		
		this.nome = nome;
		
		// cria jogadores
		for (int i = 0; i < 20; i++) {
			jogadores.add(new Jogador());
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