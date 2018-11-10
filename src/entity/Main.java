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
