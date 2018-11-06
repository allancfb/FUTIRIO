package entity;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

/**
 * <p>Classe que gera objetos que representam jogadores de futebol.<p>
 */
public class Jogador {

	private String nome;
	private Time time;
	protected int chute;
	protected int drible;
	protected int passe;
	protected int desarme;
	protected int defesa;
	private double habilidade;
	private double salario;
	private boolean isCapitao;
	protected Posicao posicao;
	protected Posicao posicaoRecomendada;
	
	// Construtores
	
	
	/**
	 * <p>Construtor recebendo um objeto do Enum {@link Posicao}.</p>
	 * 
	 * <p>Instancia um jogador, atribui a <code>posicao</code> enviada como parâmetro à <code>posicao</code> do jogador e gera um nome aleatório para ele.</p>
	 * 
	 * @param posicao a posição do jogador
	 */
	Jogador(Posicao posicao) {
		this.posicao = posicao;
		
		gerarNome();
		gerarAtributos();
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}
	
	/**
	 * <p>Construtor recebendo um {@link String} nome e uma {@link Posicao} posição como parâmetro.</p>
	 * 
	 * <p>Instancia um novo <code>Jogador</code>, o <code>nome</code> é atribuíbo ao <code>nome</code> e a <code>posicao</code> é atribuída à <code>posicao</code> do jogador.</p>
	 * 
	 * @param nome o nome do jogador
	 * @param posicao a posição do jogador
	 */
	Jogador(String nome, Posicao posicao) {
		this.nome = nome;
		this.posicao = posicao;
		
		gerarAtributos();
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}
	
	// Getters and Setters
	
	/**
	 * <p>Retorna um {@link String} que contém o <code>nome</code> do jogador.</p>
	 * 
	 * @return o nome do jogador
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * <p>Retorna o objeto da classe {@link Time} que o jogador pertence.</p>
	 * 
	 * @return o time que o jogador está está no momento.
	 */
	public Time getTime() {
		return time;
	}
	
	/**
	 * <p>Retorna um <code>double</code> que contém o <code>salario</code> atual do jogador.</p>
	 * 
	 * @return o salário atual do jogador.
	 */
	public double getSalario() {
		return salario;
	}
	
	/**
	 * <p>Retorna um objeto do Enum {@link Posicao} contendo a <code>posicao</code> atual do jogador.</p>
	 * 
	 * @return a posição atual do jogador
	 */
	public Posicao getPosicao() {
		return posicao;
	}
	
	/**
	 * <p>Retorna um <code>int</code> que contém a habilidade do jogador em <code>chute</code>.</p>
	 * 
	 * @return a habilidade em chute do jogador
	 */
	public int getChute() {
		return chute;
	}
	
	/**
	 * <p>Retorna um <code>int</code> que contém a habilidade do jogador em <code>drible</code>.</p>
	 * 
	 * @return a habilidade em drible do jogador
	 */
	public int getDrible() {
		return drible;
	}
	
	/**
	 * <p>Retorna um <code>int</code> que contém a habilidade do jogador em <code>passe</code>.</p>
	 * 
	 * @return a habilidade em passe do jogador
	 */
	public int getPasse() {
		return passe;
	}
	
	/**
	 * <p>Retorna um <code>int</code> que contém a habilidade do jogador em <code>defesa</code>.</p>
	 * 
	 * @return a habilidade em defesa do jogador
	 */
	public int getDefesa() {
		return defesa;
	}
	
	/**
	 * <p>Retorna um <code>int</code> que contém a habilidade do jogador em <code>desarme</code>.</p>
	 * 
	 * @return a habilidade em desarme do jogador
	 */
	public int getDesarme() {
		return desarme;
	}
	
	/**
	 * <p>Retorna um <code>double</code> que contém a <code>habilidade</code> geral do jogador.</p>
	 * 
	 * <p>Essa <code>habilidade</code> é obtida através de médias ponderadas de acordo com as habilidades e a <code>posicao</code> do jogador.</p>
	 * 
	 * @return a habilidade geral do jogador
	 */
	public double getHabilidade() {
		return habilidade;
	}
	
	/**
	 * <p>Retorna um objeto do Enum {@link Posicao} de recomendação para o jogador.</p>
	 * 
	 * <p>Essa recomendação é feita através de médias ponderadas das habilidades e a <code>posicao</code> do jogador.<p>
	 * 
	 * @return a posição recomendada
	 */
	public Posicao getPosicaoRecomendada() {
		return posicaoRecomendada;
	}
	
	/**
	 * <p>Retorna um <code>boolean</code> contendo se o jogador é capitão ou não.</p>
	 * 
	 * @return <code>true</code> se for capitão, <code>false</code> se não for
	 */
	public boolean isCapitao() {
		return isCapitao;
	}
	
	/**
	 * <p>Atribui uma {@link String} nome e atribui ao <code>nome</code> do jogador.</p>
	 * 
	 * @param nome o nome do jogador
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * <p>Atribui um {@link Time} ao <code>time</code> do jogador.</p>
	 * 
	 * @param time o time do jogador
	 */
	public void setTime(Time time) {
		this.time = time;
	}

	/**
	 * <p>Atribui um <code>double</code> salário ao <code>salario</code> do jogador.</p>
	 * 
	 * @param salario o salário do jogador
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * <p>Atribui um Enum {@link Posicao} à <code>posicao<code> do jogador.</p>
	 * 
	 * <p>Depois de atribuir, atualiza a <code>habilidade</code> e a <code>posicaoRecomendada</code> do jogador.</p>
	 * 
	 * @param posicao a posição do jogador
	 */
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
		atualizarHabilidade();
		atualizarPosicaoRecomendada();
	}

	/**
	 * <p>Atribui um <code>int</code> chute à habilidade <code>chute</code> do jogador.</p>
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
	 * <p>Atribui um <code>int</code> drible à habilidade <code>drible</code> do jogador.</p>
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
	 * <p>Atribui um <code>int</code> passe à habilidade <code>passe</code> do jogador.</p>
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
	 * <p>Atribui um <code>int</code> desarme à habilidade <code>desarme</code> do jogador.</p>
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
	 * <p>Atribui um <code>int</code> defesa à habilidade <code>defesa</code> do jogador.</p>
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
	 * <p>Atribui um <code>boolean<code> em que <code>true</code> é capitão e <code>false</code> não é.</p>
	 * 
	 * @param isCapitao <code>boolean</code> contendo a informação se o jogador é capitão ou não
	 */
	public void setIsCapitao(boolean isCapitao) {
		this.isCapitao = isCapitao;
	}

	// Métodos
	
	/**
	 * <p>Atualiza a <code>habilidade</code> do jogador.</p>
	 * 
	 * <p>Essa atualização é feita através da função privada <code>calcularHabilidade()</code>.</p>
	 */
	protected void atualizarHabilidade() {
		habilidade = calcularHabilidade(posicao);
	}
	
	/**
	 * <p>Atualiza a <code>posicaoRecomendada</code> do jogador.</p>
	 * 
	 * <p>Essa atualização é feita através da função privada <code>calcularPosicaoRecomendada()</code>.</p>
	 */
	protected void atualizarPosicaoRecomendada() {
		posicaoRecomendada = calcularPosicaoRecomendada();
	}
	
	/**
	 * <p>Calcula a habilidade do jogador.</p>
	 * 
	 * <p>Esse cálculo é feito com uma média ponderada das habilidades que varia de acordo com a <code>posicao</code> do jogador.</p>
	 * 
	 * @param posicao a posição do jogador
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
				
			case DEFAULT:
				return calcularHabilidade(posicaoRecomendada);
				
			default:
				return 1.0;
		}
	}
	
	/**
	 * <p>Retorna a posição recomendada do jogador.</p>
	 * 
	 * <p>Essa recomendação é feita através de médias ponderadas das habilidades e a <code>posicao</code> do jogador.</p>
	 * 
	 * @return a posição recomendada do jogador
	 */
	private Posicao calcularPosicaoRecomendada() {
		// TODO: estabelecer média ponderada
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
	
	// TODO: comentar
	private String gerarNome() {
		Random random = new Random();
		String nomes[] = new String [468];
		
		// Tenta ler o arquivo
		// Se conseguir, sorteia dentre os disponíveis
		try {
			File nomesFile = new File("src/entity/nomesJogadores.txt");
			Scanner nomesScanner = new Scanner(nomesFile);
			
			// Coloca os nomes do arquivo no array
			for (int i = 0; i < nomes.length; i++) {
				nomes[i] = nomesScanner.nextLine();
			}
			
			// Sorteia um nome e sobrenome e coloca no atributo do objeto
			nome = nomes[random.nextInt(nomes.length)];
			
			nomesScanner.close();
		}
		catch(Exception e) {
			String vogal = "";
			String consoante = "";
			String silaba = "";
			
			e.printStackTrace();
			
			// Cria um array das vogais e das consoantes
			String vogais[] = { "a", "e", "i", "o", "u" };
			String consoantes[] = { "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "w", "x","y", "z" };
			
			// Gera o nome juntado 3 silabas formadas por consoante + vogal
			for (int i = 0; i < 3; i++) {
				vogal = vogais[random.nextInt(5)];
				consoante = consoantes[random.nextInt(20)];
				silaba = consoante + vogal;
				nome += silaba;
			}
			
			// Deixa a primeira letra maiuscula e as restantes minusculas
			nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
		}
		
		return nome;
	}
	
	// TODO: comentar
	private void gerarAtributos() {
		Random random = new Random();
		
		switch (posicao) {
		case GOL:
			chute = random.nextInt(25) + 26;
			drible = random.nextInt(25) + 26;
			passe = random.nextInt(50) + 26;
			desarme = random.nextInt(25) + 26;
			defesa = random.nextInt(50) + 51;
			break;
			
		case DEFESA:
			chute = random.nextInt(50) + 26;
			drible = random.nextInt(50) + 51;
			passe = random.nextInt(50) + 51;
			desarme = random.nextInt(50) + 51;
			defesa = random.nextInt(25) + 26;
			
			break;
			
		case MEIA:
			chute = random.nextInt(50) + 51;
			drible = random.nextInt(50) + 51;
			passe = random.nextInt(50) + 51;
			desarme = random.nextInt(50) + 51;
			defesa = random.nextInt(25) + 26;
			
			break;
			
		case ATAQUE:
			chute = random.nextInt(50) + 51;
			drible = random.nextInt(50) + 51;
			passe = random.nextInt(50) + 51;
			desarme = random.nextInt(50) + 26;
			defesa = random.nextInt(25) + 26;
			
			break;
			
		case DEFAULT:
			break;
		}
	}
	
	// TODO: comentar
	public String criarBackup() {
		return nome + "|" + chute + "|" + drible + "|" + passe + "|" + desarme + "|" + defesa + "|" + habilidade + "|" + salario + "|" + isCapitao + "|" + posicao + "|" + posicaoRecomendada + "\n";
	}
	
}
