package entity;

public class Main {

	public static void main(String args[]) {
		Time t = new Time();
		
		for (int i = 0; i < t.getJogadores().size(); i++) {
			System.out.println(t.getJogadores().get(i).getNome());
			System.out.println("Posição: " + t.getJogadores().get(i).getPosicao());
			System.out.println("Chute: " + t.getJogadores().get(i).getChute());
			System.out.println("Drible: " + t.getJogadores().get(i).getDrible());
			System.out.println("Passe: " + t.getJogadores().get(i).getPasse());
			System.out.println("Desarme: " + t.getJogadores().get(i).getDesarme());
			System.out.println("Defesa: " + t.getJogadores().get(i).getDefesa());
		}
	}

}
