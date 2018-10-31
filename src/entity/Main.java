package entity;

public class Main {

	public static void main(String args[]) {

		Time t = new Time("Bangu");
		
		System.out.println("Time: " + t.getNome());
		System.out.println("----------Jogadores----------");
		
		for (int i = 0; i < 20; i++) {
			System.out.println(t.getJogadores().get(i).getNome().getNomeTodo());
		}

	}

}
