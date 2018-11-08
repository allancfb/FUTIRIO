package entity;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
	// TODO: comentar
	public static void criarTimes() {
		try {
			// Instancia o arquivo de times
			File fileTimes = new File("src/entity/backupTimes.txt");
			// Instancia o FileWriter para escrever por cima do arquivo de backup dos times
			FileWriter fw = new FileWriter(fileTimes);
			
			// Gera os 12 times
			for (int i = 0; i < 12; i++) {
				int qtdGOL = 0, qtdDEFESA = 0, qtdMEIA = 0, qtdATAQUE = 0;
				Time t = new Time();
				// Instancia o arquivo do time
				File fileTime = new File("src/entity/backupTime.txt");
				// Cria um Scanner para ler o arquivo que contém os jogadores do time
				Scanner input = new Scanner(fileTime);
				
				// Lê todo o arquivo do time e adiciona ao arquivo de backup dos times
				while (input.hasNextLine()) {
					fw.append(input.nextLine());
					fw.append("\n");
				}
				
				// Coloca os jogadores em excesso na reserva
				for (Jogador jogador : t.getJogadores()) {
					if (jogador.getPosicao() == Posicao.GOL) {
						qtdGOL++;
						
						if (qtdGOL > 1)
							jogador.setPosicao(Posicao.DEFAULT);
					}
					else if (jogador.getPosicao() == Posicao.DEFESA) {
						qtdDEFESA++;
						
						if (qtdDEFESA > 4)
							jogador.setPosicao(Posicao.DEFAULT);
					}
					else if (jogador.getPosicao() == Posicao.MEIA) {
						qtdMEIA++;
						
						if (qtdMEIA > 4)
							jogador.setPosicao(Posicao.DEFAULT);
					}
					else if (jogador.getPosicao() == Posicao.ATAQUE) {
						qtdATAQUE++;
						
						if (qtdATAQUE > 2)
							jogador.setPosicao(Posicao.DEFAULT);
					}
				}
				
				input.close();
			}
			
			fw.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		
	}

}
