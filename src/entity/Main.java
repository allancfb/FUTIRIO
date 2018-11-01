package entity;

public class Main {

	public static void main(String args[]) {

		Time t = new Time("Bangu");
		
		for (int i = 0; i < t.getJogadores().size(); i++) {
			System.out.println(t.getJogadores().get(i).getNome());
			System.out.println(t.getJogadores().get(i).getChute());
		}
		
	}

}
