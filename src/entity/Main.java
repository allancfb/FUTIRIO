package entity;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {

	// TODO: comentar
	public static void criarTime() {
		Time time = new Time();
	}

	// TODO: comentar
	public static void criarTime(String nome) {
		Time time = new Time(nome);
	}

	public static void main(String args[]) {
		Jogador j = new Jogador(Posicao.ATAQUE);
		
		System.out.println(j.isEstrela());
	}

}
