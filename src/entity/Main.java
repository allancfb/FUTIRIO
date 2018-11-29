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
			Time t = new Time(nome); // gfvbgfbvgtfegfwe
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

	public static void carregarEscudos() {
		Time america = carregarTime("America");
		america.setEscudo("src/iconTimes/iconAmerica.png");
		Time bangu = carregarTime("Bangu");
		bangu.setEscudo("src/iconTimes/iconBangu.png");
		Time boavista = carregarTime("Boavista-RJ");
		boavista.setEscudo("src/iconTimes/iconBoavista.png");
		Time bonsucesso = carregarTime("Bonsucesso");
		bonsucesso.setEscudo("src/iconTimes/iconBonsucesso.png");
		Time botafogo = carregarTime("Botafogo");
		botafogo.setEscudo("src/iconTimes/iconBotafogo.png");
		Time cabofriense = carregarTime("Cabofriense");
		cabofriense.setEscudo("src/iconTimes/iconCabofriense.png");
		Time flamengo = carregarTime("Flamengo");
		flamengo.setEscudo("src/iconTimes/iconFlamengo.png");
		Time fluminense = carregarTime("Fluminense");
		fluminense.setEscudo("src/iconTimes/iconFluminense.png");
		Time goytacaz = carregarTime("Goytacaz");
		goytacaz.setEscudo("src/iconTimes/iconGoytacaz.png");
		Time macae = carregarTime("Maca�");
		macae.setEscudo("src/iconTimes/iconMacae.png");
		Time madureira = carregarTime("Madureira");
		madureira.setEscudo("src/iconTimes/iconMadureira.png");
		Time novaIguacu = carregarTime("Nova Igua�u");
		novaIguacu.setEscudo("src/iconTimes/iconNovaIguacu.png");
		Time portuguesa = carregarTime("Portuguesa-RJ");
		portuguesa.setEscudo("src/iconTimes/iconPortuguesa.png");
		Time resende = carregarTime("Resende");
		resende.setEscudo("src/iconTimes/iconResende.png");
		Time vasco = carregarTime("Vasco");
		vasco.setEscudo("src/iconTimes/iconVasco.png");
		Time voltaRedonda = carregarTime("Volta Redonda");
		voltaRedonda.setEscudo("src/iconTimes/iconVoltaRedonda.png");
	}

	public static String escudow(Time time) {
		System.out.println("pelo menos to entrando aqui");
		if(time.getNome().equals("Botafogo")) {
			time.setEscudo("src/iconTimes/iconBotafogo.png");
			return time.getEscudo();
		}else if(time.getNome().equals("Portuguesa-RJ")) {
			return "src/iconTimes/iconPortuguesa.png";
		}else {
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

	public static void main(String args[]) {
		/*
		 * SUGEST�O: Colocar isso no NewGame
		 */

		Time flamengo = carregarTime("Flamengo");
		for (Jogador jogador : flamengo.getJogadoresReservas()) {
			System.out.println(jogador.getNome());
		}
		flamengo.substituicao(flamengo.getJogadoresTitulares().get(0), flamengo.getJogador(20));
		for (Jogador jogador : flamengo.getJogadoresReservas()) {
			System.out.println(jogador.getNome());
		}

		// carregando escudos
		// carregarEscudos();

		// Time america = carregarTime("America");
		// america.setEscudo("/iconTimes/iconAmerica.png");
		// Time bangu = carregarTime("Bangu");
		// bangu.setEscudo("/iconTimes/iconBangu.png");
		// Time boavista = carregarTime("Boavista-RJ");
		// boavista.setEscudo("/iconTimes/iconBoavista.png");
		// Time bonsucesso = carregarTime("Bonsucesso");
		// bonsucesso.setEscudo("/iconTimes/iconBonsucesso.png");
		// Time botafogo = carregarTime("Botafogo");
		// botafogo.setEscudo("/iconTimes/iconBotafogo.png");
		// Time cabofriense = carregarTime("Cabofriense");
		// cabofriense.setEscudo("/iconTimes/iconCabofriense.png");
		// Time flamengo = carregarTime("Flamengo");
		// flamengo.setEscudo("/iconTimes/iconFlamengo.png");
		// Time fluminense = carregarTime("Fluminense");
		// fluminense.setEscudo("/iconTimes/iconFluminense.png");
		// Time goytacaz = carregarTime("Goytacaz");
		// goytacaz.setEscudo("/iconTimes/iconGoytacaz.png");
		// Time macae = carregarTime("Maca�");
		// macae.setEscudo("/iconTimes/iconMacae.png");
		// Time madureira = carregarTime("Madureira");
		// madureira.setEscudo("/iconTimes/iconMadureira.png");
		// Time novaIguacu = carregarTime("Nova Igua�u");
		// novaIguacu.setEscudo("/iconTimes/iconNovaIguacu.png");
		// Time portuguesa = carregarTime("Portuguesa-RJ");
		// portuguesa.setEscudo("/iconTimes/iconPortuguesa.png");
		// Time resende = carregarTime("Resende");
		// resende.setEscudo("/iconTimes/iconResende.png");
		// Time vasco = carregarTime("Vasco");
		// vasco.setEscudo("/iconTimes/iconVasco.png");
		// Time voltaRedonda = carregarTime("Volta Redonda");
		// voltaRedonda.setEscudo("/iconTimes/iconVoltaRedonda.png");
	}

}
