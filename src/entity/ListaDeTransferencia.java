package entity;

import java.util.*;

public class ListaDeTransferencia {

	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	
	ListaDeTransferencia(){
		
		Random random = new Random();
		
		for(int i = 0; i < 25;i++) {
			int aux = random.nextInt(3);
			
			switch(aux) {
			case 0 : this.jogadores.add(new Jogador(GOL));
				
			
			
			}
			this.jogadores.add(new Jogador());
		}
	}
	
}
