package entity;

import java.io.Serializable;

public enum Tempo implements Serializable {

	PRIMEIRO("Primeiro tempo"), INTERVALO("Intevalo"), SEGUNDO("Segundo Tempo"),
	PRORROGACAO("Primeiro Tempo da Prorrogação"), INTERVALOPRORROGACAO("Intevalo da Prorroga��o"),
	PRORROGACAO2("Segundo Tempo da Prorrogação"), DEFAULT("N�o iniciado"), FIM("Fim de jogo");

	private String nome;

	Tempo(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
