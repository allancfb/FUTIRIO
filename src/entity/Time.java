package entity;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Time implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private ArrayList<Jogador> jogadores;
	private ArrayList<Jogador> jogadoresTitulares;
	private int habilidadeGeral;
	private double fundos;
	private double salarioTotal;

	// Construtores

	// TODO: comentar
	public Time() {
		jogadores = new ArrayList<Jogador>();
		jogadoresTitulares = new ArrayList<Jogador>();

		gerarNomeTime();
	}

	// TODO: comentar
	public Time(String nome) {
		jogadores = new ArrayList<Jogador>();
		jogadoresTitulares = new ArrayList<Jogador>();

		this.nome = nome;
	}

	// Getters and Setters

	// TODO: comentar
	public String getNome() {
		return nome;
	}

	// TODO: comentar
	public double getSalarioTotal() {
		return salarioTotal;
	}

	// TODO: comentar
	public double getFundos() {
		return fundos;
	}

	// TODO: comentar
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	// TODO: comentar
	public int getHabilidadeGeral() {
		atualizarHabilidadeGeral();

		return habilidadeGeral;
	}

	// TODO: comentar
	public Jogador getJogador(int i) {
		return getJogadores().get(i);
	}

	// TODO: comentar
	public void setNome(String nome) {
		this.nome = nome;
	}

	// Métodos

	// TODO: comentar
	public void addFundos(double fundos) {
		this.fundos += fundos;
	}

	// TODO: comentar
	public void atualizarSalarioTotal() {

		this.salarioTotal = 0;

		for (int i = 0; i < this.jogadores.size(); i++) {
			this.salarioTotal += jogadores.get(i).getSalario();
		}

	}

	// TODO: comentar
	public void subtrairFundos(double fundos) {
		this.fundos -= fundos;
	}

	// TODO: comentar
	public void addJogador(Jogador jogador) {
		jogadores.add(jogador);
		atualizarSalarioTotal();
	}

	// TODO: comentar AND FAZER A INTERAÇAO COM A LISTA DE TRANFERENCIA JV - "n sei
	// fazer isso" ESSA PORRA AKI N TA PRONTA N!!! FALTA FAZER ELE GASTAR O DINHEIRO
	// DO CONTRATO
	public void comprarJogador(Jogador jogador) {
		jogadores.add(jogador);
		this.subtrairFundos(jogador.getTxContrato());

		bancarExcesso();
		atualizarHabilidadeGeral();
		atualizarSalarioTotal();
	}

	// TODO: COMENTAR AND FAZER A INTERAÇAO COM A LISTA DE TRANFERENCIA JV - "n sei
	// fazer isso"
	public Jogador venderJogador(Jogador jogador) {
		jogadores.remove(jogador);

		bancarExcesso();
		atualizarHabilidadeGeral();
		atualizarSalarioTotal();

		return jogador;
	}

	// TODO: comentar
	public void gerarJogadores() {
		// Gera jogadores para as posições
		for (int i = 0; i < 2; i++) {
			jogadores.add(new Jogador(Posicao.GOL));
		}
		for (int i = 0; i < 8; i++) {
			jogadores.add(new Jogador(Posicao.DEFESA));
		}
		for (int i = 0; i < 8; i++) {
			jogadores.add(new Jogador(Posicao.MEIA));
		}
		for (int i = 0; i < 4; i++) {
			jogadores.add(new Jogador(Posicao.ATAQUE));
		}
	}

	// TODO: comentar
	public void bancarExcesso() {
		int qtdGOL = 0, qtdDEFESA = 0, qtdMEIA = 0, qtdATAQUE = 0;

		for (int j = 0; j < getJogadores().size(); j++) {
			if (getJogador(j).getPosicao() == Posicao.GOL) {
				qtdGOL++;

				if (qtdGOL > 1)
					getJogador(j).setPosicao(Posicao.DEFAULT);
			} else if (getJogador(j).getPosicao() == Posicao.DEFESA) {
				qtdDEFESA++;

				if (qtdDEFESA > 4) {
					getJogador(j).setPosicao(Posicao.DEFAULT);
				}
			} else if (getJogador(j).getPosicao() == Posicao.MEIA) {
				qtdMEIA++;

				if (qtdMEIA > 4)
					getJogador(j).setPosicao(Posicao.DEFAULT);
			} else if (getJogador(j).getPosicao() == Posicao.ATAQUE) {
				qtdATAQUE++;

				if (qtdATAQUE > 2)
					getJogador(j).setPosicao(Posicao.DEFAULT);
			}
		}
	}

	// TODO: comentar
	public void criarBackup() {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("src/times/" + nome)));
			objectOut.writeObject(this);
			objectOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TODO: comentar
	private void gerarNomeTime() {
		try {
			Random random = new Random();
			String nomesTimes[] = new String[1000];
			// Lê o arquivo
			File nomesTimesFile = new File("src/entity/nomesTimes.txt");
			Scanner nomesTimesScanner = new Scanner(nomesTimesFile);
			jogadores = new ArrayList<Jogador>();

			// Coloca os nomes dos times do arquivo no vetor
			for (int i = 0; i < nomesTimes.length; i++) {
				nomesTimes[i] = nomesTimesScanner.nextLine();
			}

			// Sorteia um nome para o time
			nome = nomesTimes[random.nextInt(nomesTimes.length)];

			nomesTimesScanner.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// TODO: comentar
	public void atualizarHabilidadeGeral() { /*----------------------------------------------*/
		habilidadeGeral = calcularHabilidadeGeral();
	}

	// TODO: comentar
	private int calcularHabilidadeGeral() {
		int somaMedia = 0;

		for (Jogador jogador : jogadores) {
			if (jogador.getPosicao() != Posicao.DEFAULT) {
				somaMedia += jogador.getHabilidade();
			}
		}

		return somaMedia / 11;
	}

	// TODO: comentar
	public void substituicao(Jogador jogadorTroca1, Jogador jogadorTroca2) {
		String nomePosicao = jogadorTroca2.getPosicao().getNome();
		jogadorTroca2.setPosicao(jogadorTroca1.getPosicao());
		jogadorTroca1.setPosicao(Posicao.retornaPosicao(nomePosicao));
	}

	// TODO: comentar
	public void atualizarTitulares() {
		jogadoresTitulares.clear();
		    int contadorDeJogadores = 1;
		    for (int i = 0; i < jogadores.size(); i++) {
			    if (jogadores.get(i).getPosicao() == Posicao.retornaPosicao("Gol")) {
				    jogadoresTitulares.set(0,jogadores.get(i));
				    break;
			    }
		    }
			
		    for (int i = 0; i < jogadores.size(); i++) {
			    if (jogadores.get(i).getPosicao() == Posicao.retornaPosicao("Defesa")) {
			     	jogadoresTitulares.set(1,jogadores.get(i));	
			     	contadorDeJogadores++;
			    }
			    if (contadorDeJogadores == 5)
			    	break;
			    
		    }
		    
		    for (int i = 0; i < jogadores.size(); i++) {
		    	if (jogadores.get(i).getPosicao() == Posicao.retornaPosicao("Meia")) {
		    		jogadoresTitulares.set(5,jogadores.get(i));
		    		contadorDeJogadores++;
		    	}
		    	if (contadorDeJogadores == 9)
			    	break;
		    }
		    
		    for (int i = 0; i < jogadores.size(); i++) {
		    	if (jogadores.get(i).getPosicao() == Posicao.retornaPosicao("Ataque")) {
		    		jogadoresTitulares.set(9,jogadores.get(i));
		    		contadorDeJogadores++;
		    	}
		    	if (contadorDeJogadores == 11)
			    	break;
		    }
		    
		    atualizarHabilidadeGeral();
	}

}
/*  pera, não apaga

public void atualizarTitulares() {
	jogadoresTitulares.clear();
	    int contadorDeJogadores = 1;
	    for (int i = 0; i < jogadores.size(); i++) {
		
		if (jogadores.get(i).getPosicao() == Posicao.retornaPosicao("Gol")) {
			jogadoresTitulares.set(0,jogadores.get(i));
			break;
		    }
	    }
		
	    for (int i = 0; i < jogadores.size(); i++) {
		    if (jogadores.get(i).getPosicao() == Posicao.retornaPosicao("Defesa")) {
		     	jogadoresTitulares.set(1,jogadores.get(i));	
		     	contadorDeJogadores++;
		    }
	    }
	    
	    for (int i = 0; i < jogadores.size(); i++) {
	    	if (jogadores.get(i).getPosicao() == Posicao.retornaPosicao("Meia")) {
	    		jogadoresTitulares.set(5,jogadores.get(i));
	    	}
	    }
	    
	    for (int i = 0; i < jogadores.size(); i++) {
	    	if (jogadores.get(i).getPosicao() == Posicao.retornaPosicao("Ataque")) {
	    		jogadoresTitulares.set(9,jogadores.get(i));
	    	}
	    }
	    
	    atualizarHabilidadeGeral();
}
*/