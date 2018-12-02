package swing;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import entity.Rodada;

public class RodaJogos implements Runnable {
	private Rodada rodada;
	private JLabel intTempo;
	private JProgressBar progressBar;
	private ArrayList<JLabel> golsA;
	private ArrayList<JLabel> golsB;
	private RodadaSwing rodadaSwing;
	private JButton continuar;
	private OJogo futirio;

	public RodaJogos( RodadaSwing rodadaSwing, Rodada rodada, JLabel intTempo, JProgressBar progressBar, ArrayList<JLabel> golsA,ArrayList<JLabel> golsB, OJogo futirio, JButton continuar) {
		this.rodada = rodada;
		this.intTempo = intTempo;
		this.progressBar = progressBar;
		this.golsA = golsA;
		this.golsB = golsB;
		this.rodadaSwing = rodadaSwing;
		this.continuar = continuar;
		this.futirio = futirio;
	}

	public void run() {
		for (int i = 1; i <= 90; i++) {

			rodada.run();
			intTempo.setText(Integer.toString(rodada.getMinuto()));
			progressBar.setValue(rodada.getMinuto());

			for (int j = 0; j < 8; j++) {
				golsA.get(j).setText(" " + Integer.toString(rodada.getPartidas().get(j).getTime1Gols()));
				golsB.get(j).setText(" " + Integer.toString(rodada.getPartidas().get(j).getTime2Gols()));
			}
			if (i == 90) {
				rodadaSwing.terminarRodada(futirio);
				continuar.setVisible(true);
				futirio.getCarioca().passarRodada();
			}

			
		}
	}

}