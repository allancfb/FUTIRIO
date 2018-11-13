package swing;

public enum Time {
	Botafogo("Botafogo de Futebol e Regatas"), Flamengo("Clube de Regatas do Flamengo"), Fluminense(
			"Fluminense Football Club"), Vasco("Clube de Regatas Vasco da Gama");

	private String nomeCompleto;
	Time(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
}
