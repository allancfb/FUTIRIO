package entity;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	// TODO: comentar
	public static void criarTimes() {
		ArrayList<Time> times = new ArrayList<Time>();
		
		try {
			// Instancia o arquivo de times
			File fileTimes = new File("src/entity/backupTimes.txt");
			// Instancia o FileWriter para escrever por cima do arquivo de backup dos times
			FileWriter fw = new FileWriter(fileTimes);
			
			// Gera os 12 times
			for (int i = 0; i < 12; i++) {
				Time t = new Time();
				times.add(t);
				int qtdGOL = 0, qtdDEFESA = 0, qtdMEIA = 0, qtdATAQUE = 0;
				
				// Coloca os jogadores em excesso na reserva
				for (int j = 0; j < times.size(); j++) {
					if (times.get(i).getJogador(j).getPosicao().equals(Posicao.GOL)) {
						qtdGOL++;
						System.out.println(times.get(i).getJogadores().get(j).getNome() + " " + times.get(i).getJogadores().get(j).getPosicao().getNome());
						
						if (qtdGOL > 1)
							times.get(i).getJogador(j).setPosicao(Posicao.DEFAULT);
						
						System.out.println(times.get(i).getJogadores().get(j).getNome() + " " + times.get(i).getJogadores().get(j).getPosicao().getNome());
					}
					else if (times.get(i).getJogador(j).getPosicao().equals(Posicao.DEFESA)) {
						qtdDEFESA++;
						
						if (qtdDEFESA > 4) {
							times.get(i).getJogador(j).setPosicao(Posicao.DEFAULT);
						}
					}
					else if (times.get(i).getJogador(j).getPosicao().equals(Posicao.MEIA)) {
						qtdMEIA++;
						
						if (qtdMEIA > 4)
							times.get(i).getJogador(j).setPosicao(Posicao.DEFAULT);
					}
					else if (times.get(i).getJogador(j).getPosicao().equals(Posicao.ATAQUE)) {
						qtdATAQUE++;
						
						if (qtdATAQUE > 2)
							times.get(i).getJogador(j).setPosicao(Posicao.DEFAULT);
					}
				}
			}
			
			// Coloca os 12 times no arquivo de times
			for (Time time : times) {
				// Instancia o arquivo do time
				File fileTime = new File("src/entity/backupTime.txt");
				// Cria um Scanner para ler o arquivo que contém os jogadores do time
				Scanner input = new Scanner(fileTime);
				
				// Lê todo o arquivo do time e adiciona ao arquivo de backup dos times
				while (input.hasNextLine()) {
					fw.append(input.nextLine());
					fw.append("\n");
				}
			}
			
			fw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		criarTimes();
	}

}
