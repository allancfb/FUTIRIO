package entity;

public enum Tempo {

	PRIMEIRO("Primeiro tempo"), INTERVALO("Intevalo"), SEGUNDO("Segundo Tempo"),
	PRORROGA��O1("Primeiro Tempo da Prorroga��o"), INTERVALOPRORROGA��O("Intevalo da Prorroga��o"),
	PRORROGA��O2("Segundo Tempo da Prorroga��o"), DEFAULT("N�o iniciado");

	private String nome;

	Tempo(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
