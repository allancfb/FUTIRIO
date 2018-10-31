package entity;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Nome {

	private String primeiroNome = "";
	private String sobrenome = "";
	private String nomeTodo = "";

	// Construtores
	// Caso n�o tenha nenhum par�metro, pega um nome e sobrenome aleat�rio
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

	// Caso receba nome e sobrenome, armazena no objeto
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
	public String getPrimeiroNome() {
		return primeiroNome;
	} 

	public void setPrimeiroNome(String primeiroNome) {
		primeiroNome = primeiroNome.trim();
		
		this.primeiroNome = primeiroNome.substring(0, 1).toUpperCase() + primeiroNome.substring(1).toLowerCase();
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		sobrenome = sobrenome.trim();
		
		this.sobrenome = sobrenome.substring(0, 1).toUpperCase() + sobrenome.substring(1).toLowerCase();
	}

	public String getNomeTodo() {
		return nomeTodo;
	}

	public void setNomeTodo(String primeiroNome, String sobrenome) {
		primeiroNome = primeiroNome.trim();
		sobrenome = sobrenome.trim();
		
		this.primeiroNome = primeiroNome.substring(0, 1).toUpperCase() + primeiroNome.substring(0).toLowerCase();
		this.sobrenome = sobrenome.substring(0, 1).toUpperCase() + sobrenome.substring(0).toLowerCase();
	}

}
