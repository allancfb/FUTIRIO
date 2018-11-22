package swing;
import entity.*;

public class NewGame {

	private Campeonato carioca;
	
	NewGame(int ano){
		
		carioca = new Campeonato(ano);
	}

	public Campeonato getCarioca() {
		return carioca;
	}
	
	
}
