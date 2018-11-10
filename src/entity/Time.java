package entity;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Time {
	
	private String nome;
	private ArrayList<Jogador> jogadores;
	
	// Construtores
	
	// TODO: comentar
	Time() {
		gerarNomeTime();
		gerarJogadores();
		criarBackup();
	}
	
	// TODO: comentar
	Time(String nome) {
		jogadores = new ArrayList<Jogador>();
		
		this.nome = nome;
		
		gerarJogadores();
		criarBackup();
	}

	// Getters and Setters
	
	// TODO: comentar
	public String getNome() {
		return nome;
	}
	
	// TODO: comentar
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	// TODO: comentar
	public Jogador getJogador(int i) {
		return getJogadores().get(i);
	}
	
	// TODO: comentar
	public void setNome(String nome) {
		this.nome = nome;
	}

	// TODO: comentar
	public void setJogador(Jogador jogador) {
		jogadores.add(jogador);
	}
	
	// Métodos
	
	// TODO: comentar
	private void criarBackup() {
		try {
			File f = new File("src/entity/backupTime.txt");
			FileWriter fw = new FileWriter(f);
			
			String backup = nome + "\n";
			
			for (Jogador jogador : jogadores) {
				backup += jogador.criarBackup();
			}
			
			fw.append(backup);
			fw.append("\n");
			fw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// TODO: comentar
	private void gerarNomeTime() {
		try {
			Random random = new Random();
			String nomesTimes[] = new String[1000];
			// Lê o arquivo
			File nomesTimesFile = new File("src/entity/nomesTimes.txt");
			Scanner nomesTimesScanner = new Scanner(nomesTimesFile);
			jogadores = new ArrayList<Jogador>();
			
			// Coloca os nomes dos times do arquivo no vetor
			for (int i = 0; i < nomesTimes.length; i++) {
				nomesTimes[i] = nomesTimesScanner.nextLine();
			}
			
			// Sorteia um nome para o time
			nome = nomesTimes[random.nextInt(nomesTimes.length)];
			
			nomesTimesScanner.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// TODO: comentar
	private void gerarJogadores() {
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
		
		int qtdGOL = 0, qtdDEFESA = 0, qtdMEIA = 0, qtdATAQUE = 0;
		
		for (int j = 0; j < getJogadores().size(); j++) {
			if (getJogador(j).getPosicao().equals(Posicao.GOL)) {
				qtdGOL++;
				
				if (qtdGOL > 1)
					getJogador(j).setPosicao(Posicao.DEFAULT);
			}
			else if (getJogador(j).getPosicao().equals(Posicao.DEFESA)) {
				qtdDEFESA++;
				
				if (qtdDEFESA > 4) {
					getJogador(j).setPosicao(Posicao.DEFAULT);
				}
			}
			else if (getJogador(j).getPosicao().equals(Posicao.MEIA)) {
				qtdMEIA++;
				
				if (qtdMEIA > 4)
					getJogador(j).setPosicao(Posicao.DEFAULT);
			}
			else if (getJogador(j).getPosicao().equals(Posicao.ATAQUE)) {
				qtdATAQUE++;
				
				if (qtdATAQUE > 2)
					getJogador(j).setPosicao(Posicao.DEFAULT);
			}
		}
	}
	
}
