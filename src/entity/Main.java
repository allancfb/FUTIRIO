package entity;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import swing.OJogo;

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

				// Posição
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
		String[] nomes = { "America", "Bangu", "Boavista-RJ", "Bonsucesso", "Cabofriense", "Goytacaz", "Macaé",
				"Madureira", "Nova Iguaçu", "Portuguesa-RJ", "Resende", "Volta Redonda" };

		for (String nome : nomes) {
			Time t = new Time(nome);
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

	public static String carregarEscudo(Time time) {
		switch (time.getNome()) {
		case "America":
			time.setEscudo("src/iconTimes/iconAmerica.png");
			return time.getEscudo();
		case "Bangu":
			time.setEscudo("src/iconTimes/iconBangu.png");
			return time.getEscudo();
		case "Boavista-RJ":
			time.setEscudo("src/iconTimes/iconBoavista.png");
			return time.getEscudo();
		case "Bonsucesso":
			time.setEscudo("src/iconTimes/iconBonsucesso.png");
			return time.getEscudo();
		case "Botafogo":
			time.setEscudo("src/iconTimes/iconBotafogo.png");
			return time.getEscudo();
		case "Cabofriense":
			time.setEscudo("src/iconTimes/iconCabofriense.png");
			return time.getEscudo();
		case "Flamengo":
			time.setEscudo("src/iconTimes/iconFlamengo.png");
			return time.getEscudo();
		case "Fluminense":
			time.setEscudo("src/iconTimes/iconFluminense.png");
			return time.getEscudo();
		case "Goytacaz":
			time.setEscudo("src/iconTimes/iconGoytacaz.png");
			return time.getEscudo();
		case "Macaé":
			time.setEscudo("src/iconTimes/iconMacae.png");
			return time.getEscudo();
		case "Madureira":
			time.setEscudo("src/iconTimes/iconMadureira.png");
			return time.getEscudo();
		case "Nova Iguaçu":
			time.setEscudo("src/iconTimes/iconNovaIguacu.png");
			return time.getEscudo();
		case "Portuguesa-RJ":
			time.setEscudo("src/iconTimes/iconPortuguesa.png");
			return time.getEscudo();
		case "Resende":
			time.setEscudo("src/iconTimes/iconResende.png");
			return time.getEscudo();
		case "Vasco":
			time.setEscudo("src/iconTimes/iconVasco.png");
			return time.getEscudo();
		case "Volta Redonda":
			time.setEscudo("src/iconTimes/iconVoltaRedonda.png");
			return time.getEscudo();
		default:
			return "";
		}
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
	
	/**
	 * Usar quando quiser gerar os times novamente
	 */
	public static void atualizarTimes() {
		gerarTimes();
		gerarTimesPrincipais();
	}

	public static void main(String args[]) {
		// atualizarTimes();
		
//		Time a = carregarTime("America");
//		for (String[] jogador : a.getAtributosJogadoresReservas()) {
//			for (String atributo : jogador) {
//				System.out.println(atributo);
//			}
//		}
//
//		System.out.println("----------------");
//
//		for (Jogador jogador : a.getJogadoresReservas()) {
//			System.out.println(jogador.getNome());
//		}
//
//		System.out.println("-------SUBSTITUIÇÃO--------");
//		a.substituicao(a.getJogadoresTitulares().get(0), a.getJogadoresReservas().get(0));
//
//		for (String[] jogador : a.getAtributosJogadoresReservas()) {
//			for (String atributo : jogador) {
//				System.out.println(atributo);
//			}
//		}
//
//		System.out.println("----------------");
//
//		for (Jogador jogador : a.getJogadoresReservas()) {
//			System.out.println(jogador.getNome());
//		}
	}

}
