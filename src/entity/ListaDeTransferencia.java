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
	
	//METODOS
	
	public void AtualizaLista() {
		if(jogadores.size()<25) {
			
		}
		
		
	}
	
	
}
