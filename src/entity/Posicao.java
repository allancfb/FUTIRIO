package entity;

import java.io.Serializable;

public enum Posicao implements Serializable {

	GOL("Gol", 7, 1, 1, 1, 90), DEFESA("Defesa", 10, 5, 35, 45, 5), MEIA("Meia", 25, 20, 25, 25, 5),
	ATAQUE("Ataque", 50, 30, 10, 5, 5);

	private String nome;
	private int chutePeso, driblePeso, passePeso, desarmePeso, defesaPeso, somaPesos;

	Posicao(String nome, int chutePeso, int driblePeso, int passePeso, int desarmePeso, int defesaPeso) {
		this.nome = nome;
		this.chutePeso = chutePeso;
		this.driblePeso = driblePeso;
		this.passePeso = passePeso;
		this.desarmePeso = desarmePeso;
		this.defesaPeso = defesaPeso;
	}

	public String getNome() {
		return nome;
	}

	public int getChutePeso() {
		return chutePeso;
	}

	public int getDriblePeso() {
		return driblePeso;
	}

	public int getPassePeso() {
		return passePeso;
	}

	public int getDesarmePeso() {
		return desarmePeso;
	}

	public int getDefesaPeso() {
		return defesaPeso;
	}

	public int getSomaPesos() {
		return somaPesos;
	}

}
