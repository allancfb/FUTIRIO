package entity;

import java.util.*;

public class ListaDeTransferencia {

	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

	// CONSTRUTOR

	// TODO: COMENTAR
	public ListaDeTransferencia() {

		Random random = new Random();

		for (int i = 0; i < 25; i++) {
			int aux = random.nextInt(3);
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

	// TODO : COMENTAR
	public ArrayList<Jogador> getJogadores() {
		return jogadores;

	}

	// METODOS

	public void AtualizaLista() {

		if (jogadores.size() < 25) {

			Random random = new Random();

			for (int i = 0; i < (25 - jogadores.size()); i++) {
				int aux = random.nextInt(3);
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
		AtualizaLista();
		return jogador;

	}

	// TODO: COMENTAR
	public ArrayList<String[]> getAllAtributosJogador() {

		ArrayList<String[]> retorno = new ArrayList<String[]>();

		for (int i = 0; i < jogadores.size(); i++) {
			String[] aux = { this.jogadores.get(i).getPosicao().getNome(), jogadores.get(i).getNome(),
					Double.toString(jogadores.get(i).getHabilidade()), Double.toString(jogadores.get(i).getSalario()),
					Double.toString(jogadores.get(i).getTxContrato()) };
			retorno.add(aux);

		}
		return retorno;

	}

}
