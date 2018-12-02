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
	private String escudo;
	private TimeTabela timeTabela;
	private ArrayList<Time> adversarios;
	private ArrayList<Jogador> jogadores;
	private ArrayList<Jogador> jogadoresTitulares;
	private ArrayList<Jogador> jogadoresReservas;
	private double habilidadeGeral;
	private double fundos = 2000000;
	private double salarioTotal;

	// Construtores

	// TODO: comentar
	public Time() {
		adversarios = new ArrayList<Time>();
		jogadores = new ArrayList<Jogador>();
		jogadoresTitulares = new ArrayList<Jogador>();
		jogadoresReservas = new ArrayList<Jogador>();

		gerarNomeTime();
	}

	// TODO: comentar
	public Time(String nome) {
		jogadores = new ArrayList<Jogador>();
		jogadoresTitulares = new ArrayList<Jogador>();
		jogadoresReservas = new ArrayList<Jogador>();
		adversarios = new ArrayList<Time>();

		this.nome = nome;
	}

	// Getters and Setters

	// TODO: comentar
	public String getNome() {
		return nome;
	}

	public String getEscudo() {
		return escudo;
	}

	public TimeTabela getTimeTabela() {
		return timeTabela;
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
	public double getHabilidadeGeral() {
		atualizarHabilidadeGeral();

		return habilidadeGeral;
	}

	public ArrayList<Jogador> getJogadoresTitulares() {
		return jogadoresTitulares;
	}

	public ArrayList<Jogador> getJogadoresReservas() {
		return jogadoresReservas;
	}

	// TODO: comentar
	public Jogador getJogador(int i) {
		return getJogadores().get(i);
	}

	public Jogador getJogadorTitular(int i) {
		return getJogadoresTitulares().get(i);
	}

	public Jogador getJogadorReserva(int i) {
		return getJogadoresReservas().get(i);
	}

	public void addAdversario(Time adversario) {
		adversarios.add(adversario);
	}

	public ArrayList<Time> getAdversarios() {
		return adversarios;
	}

	public Time getAdversario(int i) {
		return adversarios.get(i);
	}

	public String[][] getAllAtributosJogador() {

		String[][] retorno = new String[jogadores.size()][8];

		for (int i = 0; i < jogadores.size(); i++) {
			String[] aux = { this.jogadores.get(i).getPosicaoRecomendada().getNome(), jogadores.get(i).getNome(),
					Double.toString(jogadores.get(i).getHabilidade()), Integer.toString(jogadores.get(i).getChute()),
					Integer.toString(jogadores.get(i).getPasse()), Integer.toString(jogadores.get(i).getDrible()),
					Integer.toString(jogadores.get(i).getDesarme()), Integer.toString(jogadores.get(i).getDefesa()) };
			retorno[i] = aux;
		}
		return retorno;
	}

	public String[][] getAtributosJogadoresTitulares() {

		String[][] retorno = new String[jogadoresTitulares.size()][3];

		for (int i = 0; i < jogadoresTitulares.size(); i++) {
			String[] aux = { this.jogadoresTitulares.get(i).getPosicao().getNome(), jogadoresTitulares.get(i).getNome(),
					Double.toString(jogadoresTitulares.get(i).getHabilidade()) };
			retorno[i] = aux;
		}
		return retorno;
	}

	public String[][] getAtributosJogadoresReservas() {

		String[][] retorno = new String[jogadoresReservas.size()][3];

		for (int i = 0; i < jogadoresReservas.size(); i++) {
			String[] aux = { this.jogadoresReservas.get(i).getPosicaoRecomendada().getNome(),
					jogadoresReservas.get(i).getNome(), Double.toString(jogadoresReservas.get(i).getHabilidade()) };
			retorno[i] = aux;
		}
		return retorno;
	}

	public void setEscudo(String escudo) {
		this.escudo = escudo;
	}

	// TODO: comentar
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTimeTabela(TimeTabela timeTabela) {
		this.timeTabela = timeTabela;
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

	// TODO: comentar AND FAZER A INTERAÇAO COM A LISTA DE TRANFERENCIA JV - "n
	// sei
	// fazer isso" ESSA PORRA AKI N TA PRONTA N!!! FALTA FAZER ELE GASTAR O
	// DINHEIRO
	// DO CONTRATO

	public void comprarJogador(Jogador jogador) {
		jogador.setPosicao(Posicao.DEFAULT);
		jogadores.add(jogador);
		this.subtrairFundos(jogador.getTxContrato());

		bancarExcesso();
		atualizarHabilidadeGeral();
		atualizarSalarioTotal();
		atualizarTitulares();
	}

	// TODO: COMENTAR AND FAZER A INTERAÇAO COM A LISTA DE TRANFERENCIA JV - "n
	// sei
	// fazer isso"
	public Jogador venderJogador(Jogador jogador) {
		jogadores.remove(jogador);
		addFundos(jogador.getTxContrato());

		bancarExcesso();
		atualizarHabilidadeGeral();
		atualizarSalarioTotal();
		atualizarTitulares();
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
	private double calcularHabilidadeGeral() {
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
		Posicao posicao = jogadorTroca2.getPosicao();
		jogadorTroca2.setPosicao(jogadorTroca1.getPosicao());
		jogadorTroca1.setPosicao(posicao);

		atualizarTitulares();
	}

	// TODO: comentar
	public void atualizarTitulares() { // seta os titulares e os reservas
		jogadoresTitulares.clear();
		jogadoresReservas.clear();
		int contadorDeJogadores = 1;
		for (int i = 0; i < jogadores.size(); i++) {
			if (jogadores.get(i).getPosicao() == Posicao.GOL) {
				jogadoresTitulares.add(jogadores.get(i));
				break;
			}
		}

		for (int i = 0; i < jogadores.size(); i++) {
			if (jogadores.get(i).getPosicao() == Posicao.DEFESA) {
				jogadoresTitulares.add(jogadores.get(i));
				contadorDeJogadores++;
			}
			if (contadorDeJogadores == 5)
				break;

		}

		for (int i = 0; i < jogadores.size(); i++) {
			if (jogadores.get(i).getPosicao() == Posicao.MEIA) {
				jogadoresTitulares.add(jogadores.get(i));
				contadorDeJogadores++;
			}
			if (contadorDeJogadores == 9)
				break;
		}

		for (int i = 0; i < jogadores.size(); i++) {
			if (jogadores.get(i).getPosicao() == Posicao.ATAQUE) {
				jogadoresTitulares.add(jogadores.get(i));
				contadorDeJogadores++;
			}
			if (contadorDeJogadores == 11)
				break;
		}

		for (int i = 0; i < jogadores.size(); i++) {
			if (jogadores.get(i).getPosicao() == Posicao.DEFAULT
					&& jogadores.get(i).getPosicaoRecomendada() == Posicao.GOL) {
				jogadoresReservas.add(jogadores.get(i));
				contadorDeJogadores++;
			}
		}
		
		for (int i = 0; i < jogadores.size(); i++) {
			if (jogadores.get(i).getPosicao() == Posicao.DEFAULT
					&& jogadores.get(i).getPosicaoRecomendada() == Posicao.DEFESA) {
				jogadoresReservas.add(jogadores.get(i));
				contadorDeJogadores++;
			}
		}
		
		for (int i = 0; i < jogadores.size(); i++) {
			if (jogadores.get(i).getPosicao() == Posicao.DEFAULT
					&& jogadores.get(i).getPosicaoRecomendada() == Posicao.MEIA) {
				jogadoresReservas.add(jogadores.get(i));
				contadorDeJogadores++;
			}
		}
		
		for (int i = 0; i < jogadores.size(); i++) {
			if (jogadores.get(i).getPosicao() == Posicao.DEFAULT
					&& jogadores.get(i).getPosicaoRecomendada() == Posicao.ATAQUE) {
				jogadoresReservas.add(jogadores.get(i));
				contadorDeJogadores++;
			}
		}
		
		for (int i = 0; i < jogadores.size(); i++) {
			if (jogadores.get(i).getPosicao() == Posicao.TODAS) {
				jogadoresReservas.add(jogadores.get(i));
				contadorDeJogadores++;
			}
		}

		atualizarHabilidadeGeral();
	}

}