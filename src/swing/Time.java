package swing;

public enum Time {
	Botafogo(0, "Botafogo de Futebol e Regatas"), Flamengo(1, "Clube de Regatas do Flamengo"), Fluminense(
			2, "Fluminense Football Club"), Vasco(3, "Clube de Regatas Vasco da Gama");

	private int index;
	private String nomeCompleto;
	Time(int index, String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
		this.index = index;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}
