package entity;

import java.io.Serializable;

/**
 * <p>
 * Classe que gera objetos que representam jogadores estrela.
 * </p>
 */
public class JogadorEstrela extends Jogador implements Serializable {

	private static final long serialVersionUID = 1L;
	private double habMinDoTimePCompra;

	// Construtores

	// TODO: comentar
	JogadorEstrela(Posicao posicao) {
		super(posicao);
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	// TODO: comentar
	JogadorEstrela(String nome, Posicao posicao) {
		super(nome, posicao);
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
