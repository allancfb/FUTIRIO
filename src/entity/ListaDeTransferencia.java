package entity;

import java.util.*;

public class ListaDeTransferencia {

	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	
	//CONSTRUTOR
	
	// TODO: COMENTAR
	ListaDeTransferencia(){
		
		Random random = new Random();
		
		for(int i = 0; i < 25;i++) {
			int aux = random.nextInt(3);
			Posicao posicao;
			switch(aux) {
			
			case 0 :  posicao = Posicao.GOL;
			break;
			
			case 1 :  posicao = Posicao.DEFESA;
			break;
			
			case 2 :  posicao = Posicao.MEIA;
			break;
			
			case 3 :  posicao = Posicao.ATAQUE;
			break;
			
			default : posicao = Posicao.DEFAULT;
			break;
			
			}
			this.jogadores.add(new Jogador(posicao));
		}
	}
	
	//GETTERS AND SETTERS
	
	//TODO :  COMENTAR
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
		
	}
	
	//METODOS

	public void AtualizaLista() {
		
		if(jogadores.size()<25) {
			
			Random random = new Random();
			
			for(int i = 0; i < (25-jogadores.size());i++) {
				int aux = random.nextInt(3);
				Posicao posicao;
				switch(aux) {
				
				case 0 :  posicao = Posicao.GOL;
				break;
				
				case 1 :  posicao = Posicao.DEFESA;
				break;
				
				case 2 :  posicao = Posicao.MEIA;
				break;
				
				case 3 :  posicao = Posicao.ATAQUE;
				break;
				
				default : posicao = Posicao.DEFAULT;
				break;
				
				}
				this.jogadores.add(new Jogador(posicao));
			}
		
		}
	
	}

	//Recebe o jogador e retorna pro time o valor da venda do jogador
	public double receberJogadorVendido(Jogador jogador) {
		
		jogadores.add(jogador);
		
		return jogador.getTxContrato();
	}
	
	//Envia o jogador comprado;
	public Jogador enviarJogadorComprado(Jogador jogador) {
		
		jogadores.remove(jogador);
		AtualizaLista();
		return jogador;
		
	}
	
	
}

