package entity;

import java.util.Random;

/**
 * <p>Classe que gera objetos que representam jogadores de futebol.<p>
 * 
 * @author Allan
 */
public class Jogador {

	private Nome nome;
	private Time time;
	private double salario;
	protected int chute;
	protected int drible;
	protected int passe;
	protected int desarme;
	protected int defesa;
	private double habilidade;
	private boolean isCapitao;
	protected Posicao posicao;
	protected Posicao posicaoRecomendada;
	
	/**
	 * <p>Construtor sem par�metros.</p>
	 * 
	 * <p>Instancia um novo jogador e gera o novo {@link Nome} aleat�rio para ele.</p>
	 */
	Jogador() {
		Random random = new Random();
		
		random.nextInt(4);
		
		nome = new Nome();
	}
	
	/**
	 * <p>Construtor recebendo um {@link Nome} como par�metro.</p>
	 * 
	 * <p>Esse nome � atribu�bo ao atributo <code>nome</code>.</p>
	 * 
	 * @param nome o nome do jogador a ser instanciado
	 */
	Jogador(Nome nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna o objeto da classe {@link Nome} do jogador.
	 * 
	 * @return o nome do jogador
	 */
	public Nome getNome() {
		return nome;
	}
	
	/**
	 * Retorna a {@link String} contendo o <code>nome</code> e <code>sobrenome</code> do jogador.
	 * 
	 * @return o nome todo do jogador.
	 */
	public String getNomeTodo() {
		return nome.getNomeTodo();
	}
	
	/**
	 * Retorna o objeto da classe {@link Time} que o jogador pertence.
	 * 
	 * @return o time que o jogador est� est� no momento.
	 */
	public Time getTime() {
		return time;
	}
	
	/**
	 * Retorna um <code>double</code> que cont�m o <code>salario</code> atual do jogador.
	 * 
	 * @return o sal�rio atual do jogador.
	 */
	public double getSalario() {
		return salario;
	}
	
	/**
	 * Retorna um objeto do Enum {@link Posicao} contendo a <code>posicao</code> atual do jogador.
	 * 
	 * @return a posi��o atual do jogador
	 */
	public Posicao getPosicao() {
		return posicao;
	}
	
	/**
	 * Retorna um <code>int</code> que cont�m a habilidade do jogador em <code>chute</code>.
	 * 
	 * @return a habilidade em chute do jogador
	 */
	public int getChute() {
		return chute;
	}
	
	/**
	 * Retorna um <code>int</code> que cont�m a habilidade do jogador em <code>drible</code>.
	 * 
	 * @return a habilidade em drible do jogador
	 */
	public int getDrible() {
		return drible;
	}
	
	/**
	 * Retorna um <code>int</code> que cont�m a habilidade do jogador em <code>passe</code>.
	 * 
	 * @return a habilidade em passe do jogador
	 */
	public int getPasse() {
		return passe;
	}
	
	/**
	 * Retorna um <code>int</code> que cont�m a habilidade do jogador em <code>defesa</code>.
	 * 
	 * @return a habilidade em defesa do jogador
	 */
	public int getDefesa() {
		return defesa;
	}
	
	/**
	 * Retorna um <code>int</code> que cont�m a habilidade do jogador em <code>desarme</code>.
	 * 
	 * @return a habilidade em desarme do jogador
	 */
	public int getDesarme() {
		return desarme;
	}
	
	/**
	 * <p>Retorna um <code>double</code> que cont�m a <code>habilidade</code> geral do jogador.</p>
	 * 
	 * <p>Essa <code>habilidade</code> � obtida atrav�s de m�dias ponderadas de acordo com as habilidades e a <code>posicao</code> do jogador.</p>
	 * 
	 * @return a habilidade geral do jogador
	 */
	public double getHabilidade() {
		return habilidade;
	}
	
	/**
	 * <p>Retorna um objeto do Enum {@link Posicao} de recomenda��o para o jogador.</p>
	 * 
	 * <p>Essa recomenda��o � feita atrav�s de m�dias ponderadas e a posi��o.<p>
	 * 
	 * @return a posi��o recomendada
	 */
	public Posicao getPosicaoRecomendada() {
		return posicaoRecomendada;
	}
	
	public void setNome(Nome nome) {
		this.nome = nome;
	}
	
	public void setTime(Time time) {
		this.time = time;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	public void setChute(int chute) {
		this.chute = chute;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
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
	}

	public void setDesarme(int desarme) {
		this.desarme = desarme;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	public void setIsCapitao(boolean isCapitao) {
		this.isCapitao = isCapitao;
	}

	// M�todos
	public boolean isCapitao() {
		return isCapitao;
	}
	
	protected void atualizarHabilidade() {
		habilidade = calcularHabilidade(posicao);
	}
	
	protected void atualizarPosicaoRecomendada() {
		posicaoRecomendada = calcularPosicaoRecomendada();
	}
	
	private double calcularHabilidade(Posicao posicao) {
		switch (posicao) {
			case GOL:
				//TODO: estabelecer media ponderada
				return 1.0;
				
			case DEFESA:
				//TODO: estabelecer media ponderada
				return 1.0;
			
			case MEIA:
				//TODO: estabelecer media ponderada
				return 1.0;
				
			case ATAQUE:
				//TODO: estabelecer media ponderada
				return 1.0;
				
			default:
				return 1.0;
		}
	}
	
	private Posicao calcularPosicaoRecomendada() {
		// TODO: estabelece m�dia ponderada
		return Posicao.ATAQUE;
	}
	
}
