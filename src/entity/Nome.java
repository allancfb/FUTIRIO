package entity;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

/**
 * <p>Classe que gera objetos que representam um nome.</p>
 */
public class Nome {

	private String primeiroNome = "";
	private String sobrenome = "";
	private String nomeTodo = "";

	// Construtores
	
	/**
	 * <p>Construtor sem parâmetros.</p>
	 * 
	 * <p>Instancia um novo <code>Nome</code> e gera um <code>primeiroNome</code> e <code>sobrenome</code> aleatórios.</p>
	 * 
	 * <p>Esse nome e sobrenome são pegos de linhas aleatórias de arquivos que os contém.</p>
	 */
	Nome() {
		Random random = new Random();
		String vogal, consoante;
		String silaba;
		String primeirosNomes[] = new String [1000];
		String sobrenomes[] = new String[1000];
		
		// Tenta ler o arquivo
		// Se conseguir, sorteia dentre os dispon�veis
		try {
			File nomesFile = new File("src/entity/primeirosNomes.txt");
			Scanner nomesScanner = new Scanner(nomesFile);
			File sobrenomesFile = new File("src/entity/sobrenomes.txt");
			Scanner sobrenomesScanner = new Scanner(sobrenomesFile);
			
			// Coloca os nomes do arquivo no array
			for (int i = 0; i < primeirosNomes.length; i++) {
				primeirosNomes[i] = nomesScanner.nextLine();
			}
			
			// Coloca os sobrenomes do arquivo no array
			for (int i = 0; i < sobrenomes.length; i++) {
				sobrenomes[i] = sobrenomesScanner.nextLine();
			}
			
			// Sorteia um nome e sobrenome e coloca no atributo do objeto
			primeiroNome = primeirosNomes[random.nextInt(primeirosNomes.length)];
			sobrenome = sobrenomes[random.nextInt(sobrenomes.length)];
			
			nomesScanner.close();
			sobrenomesScanner.close();
		}
		// Caso n�o consiga ler o arquivo, gera um nome e sobrenome aleat�rio
		catch(Exception e) {
			e.printStackTrace();
			
			// Cria um array das vogais e das consoantes
			String vogais[] = { "a", "e", "i", "o", "u" };
			String consoantes[] = { "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "w", "x","y", "z" };
			
			// Gera o primeiro nome juntado 3 silabas formadas por consoante + vogal
			for (int i = 0; i < 3; i++) {
				vogal = vogais[random.nextInt(5)];
				consoante = consoantes[random.nextInt(20)];
				silaba = consoante + vogal;
				primeiroNome += silaba;
			}

			// Gera o sobrenome juntando 3 silabas formadas por consoante + vogal
			for (int i = 0; i < 3; i++) {
				vogal = vogais[random.nextInt(5)];
				consoante = consoantes[random.nextInt(20)];
				silaba = consoante + vogal;
				sobrenome += silaba;
			}
			
			// Deixa a primeira letra maiuscula e as restantes minusculas
			primeiroNome = primeiroNome.substring(0, 1).toUpperCase() + primeiroNome.substring(1).toLowerCase();
			sobrenome = sobrenome.substring(0, 1).toUpperCase() + sobrenome.substring(1).toLowerCase();
		}
		
		nomeTodo = primeiroNome + " " + sobrenome;
	}

	/**
	 * <p>Construtor recebendo um {@link String} nome e um <code>String</code> sobrenome como parâmetro.</p>
	 * 
	 * <p>Instancia um novo <code>Nome</code>, o <code>primeiroNome</code> é atribuído ao <code>primeiroNome</code> e <code>sobrenome</code> é atribuído ao <code>sobrenome</code></p>
	 * 
	 * @param primeiroNome o nome do jogador
	 * @param sobrenome o sobrenome do jogador
	 */
	Nome(String primeiroNome, String sobrenome) {
		// Deixa a primeira letra maiuscula e as restantes minusculas
		primeiroNome = primeiroNome.substring(0, 1).toUpperCase() + primeiroNome.substring(1).toLowerCase();
		sobrenome = sobrenome.substring(0, 1).toUpperCase() + sobrenome.substring(1).toLowerCase();

		primeiroNome = primeiroNome.trim();
		sobrenome = sobrenome.trim();

		this.primeiroNome = primeiroNome;
		this.sobrenome = sobrenome;
		nomeTodo = primeiroNome + " " + sobrenome;
	}

	// Getters and Setters
	
	/**
	 * <p>Retorna um {@link String} que contém o <code>primeiroNome</code> do jogador.</p>
	 * 
	 * @return o primeiro nome do jogador
	 */
	public String getPrimeiroNome() {
		return primeiroNome;
	} 
	
	/**
	 * <p>Retorna um {@link String} que contém o <code>sobrenome</code> do jogador.</p>
	 * 
	 * @return o sobrenome do jogador
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	
	/**
	 * <p>Retorna um {@link String} que contém o <code>nomeTodo</code> do jogador.</p>
	 * 
	 * <p>O nome todo é composto por <code>primeiroNome</code> e <code>sobrenome</code>.</p>
	 * 
	 * @return o nome todo do jogador
	 */
	public String getNomeTodo() {
		return nomeTodo;
	}

	/**
	 * <p>Atribui um {@link String} primeiro nome ao <code>primeiroNome</code> do jogador.</p>
	 * 
	 * <p>Antes da atribuição, o <code>primeiroNome</code> é tratado.</p>
	 * 
	 * <p>Depois da atribuição, o <code>nomeTodo</code> é atualizado através do método privado <code>atualizarNomeTodo()</code>.</p>
	 * 
	 * @param primeiroNome o primeiro nome do jogador
	 */
	public void setPrimeiroNome(String primeiroNome) {
		primeiroNome = primeiroNome.trim();
		
		this.primeiroNome = primeiroNome.substring(0, 1).toUpperCase() + primeiroNome.substring(1).toLowerCase();
		
		atualizarNomeTodo();
	}

	/**
	 * <p>Atribui um {@link String} sobrenome ao <code>sobrenome</code> do jogador.</p>
	 * 
	 * <p>Antes da atribuição, o <code>sobrenome</code> é tratado.</p>
	 * 
	 * <p>Depois da atribuição, o <code>nomeTodo</code> é atualizado através do método privado <code>atualizarNomeTodo()</code>.</p>
	 * 
	 * @param sobrenome o sobrenome do jogador
	 */
	public void setSobrenome(String sobrenome) {
		sobrenome = sobrenome.trim();
		
		this.sobrenome = sobrenome.substring(0, 1).toUpperCase() + sobrenome.substring(1).toLowerCase();
		
		atualizarNomeTodo();
	}

	/**
	 * <p>Atribui um {@link String} primeiro nome ao <code>primeiroNome</code> e um <code>String</code> sobrenome ao <code>sobrenome</code> do jogador.</p>
	 * 
	 * <p>Antes da atribuição, o <code>primeiroNome</code> e o <code>sobrenome</code> são tratados.</p>
	 * 
	 * <p>Depois da atribuição, o <code>nomeTodo</code> é atualizado através do método privado <code>atualizarNomeTodo()</code>.</p>
	 * 
	 * @param primeiroNome o primeiro nome do jogador
	 * @param sobrenome o sobrenome do jogador
	 */
	public void setNomeTodo(String primeiroNome, String sobrenome) {
		primeiroNome = primeiroNome.trim();
		sobrenome = sobrenome.trim();
		
		this.primeiroNome = primeiroNome.substring(0, 1).toUpperCase() + primeiroNome.substring(0).toLowerCase();
		this.sobrenome = sobrenome.substring(0, 1).toUpperCase() + sobrenome.substring(0).toLowerCase();
		
		atualizarNomeTodo();
	}

	// Métodos
	
	/**
	 * <p>Atualiza o <code>nomeTodo</code>.</p>
	 * 
	 * <p>A atualização é feita concatenando <code>primeiroNome</code> e <code>sobrenome</code> separados por um espaço e atribuindo ao <code>nomeTodo</code>.</p>
	 */
	private void atualizarNomeTodo() {
		nomeTodo = primeiroNome + " " + sobrenome;
	}
	
}
