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
	
	// Construtores
	
	/**
	 * <p>Construtor sem par�metros.</p>
	 * 
	 * <p>Instancia um novo <code>Jogador<code> e gera o novo {@link Nome} aleat�rio para ele.</p>
	 */
	Jogador() {
		Random random = new Random();
		
		random.nextInt(4);
		
		nome = new Nome();
	}
	
	/**
	 * <p>Construtor recebendo um {@link Nome} como par�metro.</p>
	 * 
	 * <p>Instancia um novo <code>Jogador</code> e o <code>nome</code> � atribu�bo ao atributo <code>nome</code>.</p>
	 * 
	 * @param nome o nome do jogador
	 */
	Jogador(Nome nome) {
		this.nome = nome;
	}
	
	// Getters and Setters
	
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
	 * <p>Essa recomenda��o � feita atrav�s de m�dias ponderadas das habilidades e a <code>posicao</code> do jogador.<p>
	 * 
	 * @return a posi��o recomendada
	 */
	public Posicao getPosicaoRecomendada() {
		return posicaoRecomendada;
	}
	
	/**
	 * Retorna um <code>boolean</code> contendo se o jogador � capit�o ou n�o.
	 * 
	 * @return <code>true</code> se for capit�o, <code>false</code> se n�o for
	 */
	public boolean isCapitao() {
		return isCapitao;
	}
	
	/**
	 * Atribui um {@link Nome} ao <code>nome</code> do jogador.
	 * 
	 * @param nome o nome do jogador
	 */
	public void setNome(Nome nome) {
		this.nome = nome;
	}
	
	/**
	 * Atribui um {@link Time} ao <code>time</code> do jogador.
	 * 
	 * @param time o time do jogador
	 */
	public void setTime(Time time) {
		this.time = time;
	}

	/**
	 * Atribui um <code>double</code> sal�rio ao <code>salario</code> do jogador.
	 * 
	 * @param salario o sal�rio do jogador
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * <p>Atribui um Enum {@link Posicao} � <code>posicao<code> do jogador.</p>
	 * 
	 * <p>Depois de atribuir, atualiza a <code>habilidade</code> e a <code>posicaoRecomendada</code> do jogador.</p>
	 * 
	 * @param posicao a posi��o do jogador
	 */
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	/**
	 * <p>Atribui um <code>int</code> chute � habilidade <code>chute</code> do jogador.</p>
	 * 
	 * <p>Depois de atribuir, atualiza a <code>habilidade</code> e a <code>posicaoRecomendada</code> do jogador.</p>
	 * 
	 * @param chute a habilidade chute do jogador
	 */
	public void setChute(int chute) {
		this.chute = chute;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	/**
	 * <p>Atribui um <code>int</code> drible � habilidade <code>drible</code> do jogador.</p>
	 * 
	 * <p>Depois de atribuir, atualiza a <code>habilidade</code> e a <code>posicaoRecomendada</code> do jogador.</p>
	 * 
	 * @param drible a habilidade drible do jogador
	 */
	public void setDrible(int drible) {
		this.drible = drible;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	/**
	 * <p>Atribui um <code>int</code> passe � habilidade <code>passe</code> do jogador.</p>
	 * 
	 * <p>Depois de atribuir, atualiza a <code>habilidade</code> e a <code>posicaoRecomendada</code> do jogador.</p>
	 * 
	 * @param passe a habilidade passe do jogador
	 */
	public void setPasse(int passe) {
		this.passe = passe;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	/**
	 * <p>Atribui um <code>int</code> desarme � habilidade <code>desarme</code> do jogador.</p>
	 * 
	 * <p>Depois de atribuir, atualiza a <code>habilidade</code> e a <code>posicaoRecomendada</code> do jogador.</p>
	 * 
	 * @param desarme a habilidade desarme do jogador
	 */
	public void setDesarme(int desarme) {
		this.desarme = desarme;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	/**
	 * <p>Atribui um <code>int</code> defesa � habilidade <code>defesa</code> do jogador.</p>
	 * 
	 * <p>Depois de atribuir, atualiza a <code>habilidade</code> e a <code>posicaoRecomendada</code> do jogador.</p>
	 * 
	 * @param defesa a habilidade defesa do jogador
	 */
	public void setDefesa(int defesa) {
		this.defesa = defesa;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	/**
	 * Atribui um <code>boolean<code> em que <code>true</code> � capit�o e <code>false</code> n�o �.
	 * 
	 * @param isCapitao <code>boolean</code> contendo a informa��o se o jogador � capit�o ou n�o
	 */
	public void setIsCapitao(boolean isCapitao) {
		this.isCapitao = isCapitao;
	}

	// M�todos
	
	/**
	 * <p>Atualiza a <code>habilidade</code> do jogador.</p>
	 * 
	 * <p>Essa atualiza��o � feita atrav�s da fun��o privada <code>calcularHabilidade()</code>.</p>
	 */
	protected void atualizarHabilidade() {
		habilidade = calcularHabilidade(posicao);
	}
	
	/**
	 * <p>Atualiza a <code>posicaoRecomendada</code> do jogador.</p>
	 * 
	 * <p>Essa atualiza��o � feita atrav�s da fun��o privada <code>calcularPosicaoRecomendada()</code>.</p>
	 */
	protected void atualizarPosicaoRecomendada() {
		posicaoRecomendada = calcularPosicaoRecomendada();
	}
	
	/**
	 * <p>Calcula a habilidade do jogador.</p>
	 * 
	 * <p>Esse c�lculo � feito com uma m�dia ponderada das habilidades que varia de acordo com a <code>posicao</code> do jogador.</p>
	 * 
	 * @param posicao a posi��o do jogador
	 * @return a habilidade do jogador
	 */
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
	
	/**
	 * <p>Retorna a posi��o recomendada do jogador.</p>
	 * 
	 * <p>Essa recomenda��o � feita atrav�s de m�dias ponderadas das habilidades e a <code>posicao</code> do jogador.</p>
	 * 
	 * @return a posi��o recomendada do jogador
	 */
	private Posicao calcularPosicaoRecomendada() {
		// TODO: estabelecer m�dia ponderada
		double mediaGOL = 0;
		double mediaDEFESA = 0;
		double mediaMEIA = 0;
		double mediaATAQUE = 0;
		
		mediaGOL = (1 * defesa) + (1 * desarme) + (1 * passe) + (1 * drible) + (1 * chute);
		mediaDEFESA = (1 * defesa) + (1 * desarme) + (1 * passe) + (1 * drible) + (1 * chute);
		mediaMEIA = (1 * defesa) + (1 * desarme) + (1 * passe) + (1 * drible) + (1 * chute);
		mediaATAQUE = (1 * defesa) + (1 * desarme) + (1 * passe) + (1 * drible) + (1 * chute);
		
		if (mediaGOL >= mediaDEFESA && mediaGOL >= mediaMEIA && mediaGOL >= mediaATAQUE)
			return Posicao.GOL;
		else if (mediaDEFESA >= mediaGOL && mediaDEFESA >= mediaMEIA && mediaDEFESA >= mediaATAQUE)
			return Posicao.DEFESA;
		else if (mediaMEIA >= mediaGOL && mediaMEIA >= mediaDEFESA && mediaMEIA >= mediaATAQUE)
			return Posicao.MEIA;
		else
			return Posicao.ATAQUE;
	}
	
}
