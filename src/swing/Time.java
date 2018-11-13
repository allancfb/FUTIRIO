package swing;

public enum Time {
	BOTAFOGO("Botafogo","Botafogo de Futebol e Regatas"), FLAMENGO("Flamengo","Clube de Regatas do Flamengo"), FLUMINENSE(
			"Fluminense","Fluminense Football Club"), VASCO("Vasco", "Clube de Regatas Vasco da Gama");

	private String nome;
	private String apelido;

	Time(String apelido, String nome) {
		this.apelido = apelido;
		this.nome = nome;
	}

	public String getNomeCompleto() {
		return nome;
	}

	public String getApelido() {
		return apelido;
	}
}
