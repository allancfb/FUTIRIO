package entity;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Time implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private ArrayList<Jogador> jogadores;
	private int habilidadeGeral;

	// Construtores

	// TODO: comentar
	Time() {
		jogadores = new ArrayList<Jogador>();

		gerarNomeTime();
	}

	// TODO: comentar
	Time(String nome) {
		jogadores = new ArrayList<Jogador>();

		this.nome = nome;
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
	public int getHabilidadeGeral() {
		atualizarHabilidadeGeral();

		return habilidadeGeral;
	}

	// TODO: comentar
	public Jogador getJogador(int i) {
		return getJogadores().get(i);
	}

	// TODO: comentar
	public void setNome(String nome) {
		this.nome = nome;
	}

	// Métodos

	// TODO: comentar
	public void addJogador(Jogador jogador) {
		jogadores.add(jogador);

		bancarExcesso();
		atualizarHabilidadeGeral();
	}

	// TODO: comentar
	public void gerarJogadores() {
		// Gera jogadores para as posições
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

	// TODO: comentar
	public void bancarExcesso() {
		int qtdGOL = 0, qtdDEFESA = 0, qtdMEIA = 0, qtdATAQUE = 0;

		for (int j = 0; j < getJogadores().size(); j++) {
			if (getJogador(j).getPosicao() == Posicao.GOL) {
				qtdGOL++;
				
				if (qtdGOL > 1)
					getJogador(j).setPosicao(Posicao.DEFAULT);
			} else if (getJogador(j).getPosicao() == Posicao.DEFESA) {
				qtdDEFESA++;
				
				if (qtdDEFESA > 4) {
					getJogador(j).setPosicao(Posicao.DEFAULT);
				}
			} else if (getJogador(j).getPosicao() == Posicao.MEIA) {
				qtdMEIA++;
				
				if (qtdMEIA > 4)
					getJogador(j).setPosicao(Posicao.DEFAULT);
			} else if (getJogador(j).getPosicao() == Posicao.ATAQUE) {
				qtdATAQUE++;
				
				if (qtdATAQUE > 2)
					getJogador(j).setPosicao(Posicao.DEFAULT);
			}
		}
	}

	// TODO: comentar
	public void criarBackup() {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("src/times/" + nome)));
			objectOut.writeObject(this);
			objectOut.close();
		} catch (Exception e) {
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// TODO: comentar
	public void atualizarHabilidadeGeral() {
		habilidadeGeral = calcularHabilidadeGeral();
	}

	// TODO: comentar
	private int calcularHabilidadeGeral() {
		int somaMedia = 0;
		
		for (Jogador jogador : jogadores) {
			if (jogador.getPosicao() != Posicao.DEFAULT) {
				somaMedia += jogador.getHabilidade();
			}
		}

		return somaMedia / 11;
	}

}
