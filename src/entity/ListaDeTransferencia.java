package entity;

import java.io.Serializable;
import java.util.*;

public class ListaDeTransferencia implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

	// CONSTRUTOR

	public ListaDeTransferencia() {

		Random random = new Random();

		for (int i = 0; i < 25; i++) {
			int aux = random.nextInt(4);
			Posicao posicao;
			switch (aux) {

			case 0:
				posicao = Posicao.GOL;
				break;

			case 1:
				posicao = Posicao.DEFESA;
				break;

			case 2:
				posicao = Posicao.MEIA;
				break;

			case 3:
				posicao = Posicao.ATAQUE;
				break;

			default:
				posicao = Posicao.DEFAULT;
				break;

			}
			this.jogadores.add(new Jogador(posicao));
		}
	}

	// GETTERS AND SETTERS

	public ArrayList<Jogador> getJogadores() {
		return jogadores;

	}

	// METODOS
	public void atualizaLista() {

		if (jogadores.size() < 25) {

			Random random = new Random();

			for (int i = 0; i < (25 - jogadores.size()); i++) {
				int aux = random.nextInt(4);
				Posicao posicao;
				switch (aux) {

				case 0:
					posicao = Posicao.GOL;
					break;

				case 1:
					posicao = Posicao.DEFESA;
					break;

				case 2:
					posicao = Posicao.MEIA;
					break;

				case 3:
					posicao = Posicao.ATAQUE;
					break;

				default:
					posicao = Posicao.DEFAULT;
					break;

				}
				this.jogadores.add(new Jogador(posicao));
			}

		}

	}

	// Recebe o jogador e retorna pro time o valor da venda do jogador
	public double receberJogadorVendido(Jogador jogador) {

		jogadores.add(jogador);

		return jogador.getTxContrato();
	}

	// Envia o jogador comprado;
	public Jogador enviarJogadorComprado(Jogador jogador) {

		jogadores.remove(jogador);
		atualizaLista();
		return jogador;

	}

	public String[][] getAllAtributosJogador() {

		String[][] retorno = new String[jogadores.size()][5];

		for (int i = 0; i < jogadores.size(); i++) {
			String[] aux = { this.jogadores.get(i).getPosicao().getNome(), jogadores.get(i).getNome(),
					Double.toString(jogadores.get(i).getHabilidade()),
					Double.toString(jogadores.get(i).getTxContrato()) };
			retorno[i] = aux;
		}
		return retorno;
	}

}
