package entity;

public enum Tempo {

	PRIMEIRO("Primeiro tempo"), INTERVALO("Intevalo"), SEGUNDO("Segundo Tempo"),
	PRORROGAÇÃO1("Primeiro Tempo da Prorrogação"), INTERVALOPRORROGAÇÃO("Intevalo da Prorrogação"),
	PRORROGAÇÃO2("Segundo Tempo da Prorrogação"), DEFAULT("Não iniciado");

	private String nome;

	Tempo(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
