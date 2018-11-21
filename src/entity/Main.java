package entity;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	// TODO: comentar
	public static void salvarTimeDeTXT(String nome, String urlTXT) {
		try {
			Time time = new Time(nome);
			File file = new File(urlTXT);
			Scanner input = new Scanner(file);

			// Adiciona jogadores
			while (input.hasNextLine()) {
				Jogador jogador = new Jogador(Posicao.ATAQUE);
				String atributos[] = input.nextLine().split(",");

				jogador.setNome(atributos[0]); // Nome
				jogador.setChute(Integer.parseInt(atributos[1])); // Chute
				jogador.setPasse(Integer.parseInt(atributos[2])); // Passe
				jogador.setDrible(Integer.parseInt(atributos[3])); // Drible
				jogador.setDesarme(Integer.parseInt(atributos[4])); // Desarme
				jogador.setDefesa(Integer.parseInt(atributos[5])); // Defesa

				// Estrela
				if (Boolean.parseBoolean(atributos[9]) == true) {
					jogador.setIsEstrela(true);
				} else {
					jogador.setIsEstrela(false);
				}

				// Posi��o
				if (atributos[10].equals("GOL")) {
					jogador.setPosicao(Posicao.GOL);
				} else if (atributos[10].equals("DEFESA")) {
					jogador.setPosicao(Posicao.DEFESA);
				} else if (atributos[10].equals("MEIA")) {
					jogador.setPosicao(Posicao.MEIA);
				} else if (atributos[10].equals("ATAQUE")) {
					jogador.setPosicao(Posicao.ATAQUE);
				}

				jogador.atualizarHabilidade();
				jogador.atualizarPosicaoRecomendada();

				time.addJogador(jogador);
			}

			time.bancarExcesso();
			time.atualizarTitulares();
			

			input.close();

			ObjectOutputStream objectOut = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("src/times/" + time.getNome())));
			objectOut.writeObject(time);
			objectOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TODO: comentar
	public static void salvarTime(Time time) {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("src/times/" + time.getNome())));
			objectOut.writeObject(time);
			objectOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TODO: comentar
	public static void gerarTimes() {
		String[] nomes = { "America", "Bangu", "Boavista-RJ", "Bonsucesso", "Cabofriense", "Goytacaz", "Maca�",
				"Madureira", "Nova Igua�u", "Portuguesa-RJ", "Resende", "Volta Redonda" };

		for (String nome : nomes) {
			Time t = new Time(nome); //gfvbgfbvgtfegfwe
			t.gerarJogadores();
			t.bancarExcesso();
			t.atualizarTitulares();
			salvarTime(t);
		}
	}

	// TODO: comentar
	public static void gerarTimesPrincipais() {
		salvarTimeDeTXT("Botafogo", "src/times/Botafogo.txt");
		salvarTimeDeTXT("Flamengo", "src/times/Flamengo.txt");
		salvarTimeDeTXT("Fluminense", "src/times/Fluminense.txt");
		salvarTimeDeTXT("Vasco", "src/times/Vasco.txt");
	}

	// TODO: comentar
	public static Time carregarTime(String nome) {
		try {
			ObjectInputStream objectIn = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("src/times/" + nome)));
			Time time = (Time) objectIn.readObject();
			objectIn.close();

			return time;
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}

	public static void main(String args[]) {
		/*
		Campeonato c = new Campeonato(2018);
		int nRodada = 0;
		for (Rodada rodada : c.getRodadas()) {
			int nPartida = 0;
			nRodada++;
			System.out.println("-----Rodada " + nRodada + "-----");
			
			for (Partida partida : rodada.getPartidas()) {
				nPartida++;
				System.out.println("-----Partida " + nPartida + " da rodada " + nRodada + "-----");
				System.out.println(partida.getPlacar());
			}
		}
		*/
		/*
		Time a = carregarTime("America");
		Time b = carregarTime("Botafogo");
		Time c = carregarTime("Cabofriense");
		Time f = carregarTime("Flamengo");
		Time g = carregarTime("Goytacaz");
		Time m = carregarTime("Maca�");
		
		ArrayList<Time> timesJogos = new ArrayList<Time>();
		timesJogos.add(a);
		timesJogos.add(b);
		timesJogos.add(c);
		timesJogos.add(f);
		timesJogos.add(g);
		timesJogos.add(m);
		Rodada r = new Rodada(timesJogos);
		r.start();
		r.start();
		*/
	}

}
