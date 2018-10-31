package entity;

public class JogadorEstrela extends Jogador {
	
	private double habMinDoTimePCompra;
	
	// Construtores
	JogadorEstrela() {
		super();
		chute += 50;
		drible += 50;
		passe += 50;
		desarme += 50;
		defesa += 50;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}
	
	JogadorEstrela(Nome nome) {
		super(nome);
		chute += 50;
		drible += 50;
		passe += 50;
		desarme += 50;
		defesa += 50;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	
	// Getters and Setters
	public double getHabMinDoTimePCompra() {
		return habMinDoTimePCompra;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
		atualizarHabMinDoTimePCompra();
	}

	public void setChute(int chute) {
		this.chute = chute;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
		atualizarHabMinDoTimePCompra();
	}

	public void setDrible(int drible) {
		this.drible = drible;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	public void setPasse(int passe) {
		this.passe = passe;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
		atualizarHabMinDoTimePCompra();
	}

	public void setDesarme(int desarme) {
		this.desarme = desarme;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
		atualizarHabMinDoTimePCompra();
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
		atualizarHabMinDoTimePCompra();
	}
	
	// Métodos
	public void atualizarHabMinDoTimePCompra() {
		// TODO: estabelecer critérios para habilidade mínima para o time comprar
	}
	
}
