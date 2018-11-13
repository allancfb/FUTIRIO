package swing;

public enum Time {
	Botafogo("Botafogo de Futebol e Regatas"), Flamengo("Clube de Regatas do Flamengo"), Fluminense(
			"Fluminense Football Club"), Vasco("Clube de Regatas Vasco da Gama");

	private String nome;

	Time(String nome) {
		this.nome = nome;
	}

	public String getNomeCompleto() {
		return nome;
	}
}
