package entity;

import java.io.Serializable;

public enum Posicao implements Serializable {
	
	GOL("Gol"), DEFESA("Defesa"), MEIA("Meia"), ATAQUE("Ataque"), DEFAULT("Default");
	
	private String nome;
	
	Posicao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
