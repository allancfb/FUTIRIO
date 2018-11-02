package entity;

public enum Posicao {
	
	GOL("Gol"), DEFESA("Defesa"), MEIA("Meia"), ATAQUE("Ataque");
	
	private String nome;
	
	Posicao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
