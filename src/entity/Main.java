package entity;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
	public static void criarTimes() {
		try {
			File fileTimes = new File("src/entity/backupTimes.txt");
			FileWriter fw = new FileWriter(fileTimes);
			
			for (int i = 0; i < 12; i++) {
				Time t = new Time();
				File fileTime = new File("src/entity/backupTime.txt");
				Scanner input = new Scanner(fileTime);
				
				while (input.hasNextLine()) {
					fw.append(input.nextLine());
					fw.append("\n");
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
