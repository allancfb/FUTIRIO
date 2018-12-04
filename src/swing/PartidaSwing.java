package swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import entity.*;

public class PartidaSwing {

	private JPanel TimeA = new JPanel();
	private JLabel lblTimeA = new JLabel("Time A");
	private JPanel TimeB = new JPanel();
	private JLabel lblTimeB = new JLabel("Time B");
	private JPanel placar = new JPanel();
	private JLabel PartidaGolsA = new JLabel(" 0");
	private JLabel X = new JLabel(" X");
	private JLabel PartidaGolsB = new JLabel(" 0");

	public PartidaSwing(int y, String timeA, String timeB) {

		setTimeA(timeA);
		setTimeB(timeB);

		TimeA.setBackground(Color.WHITE);
		TimeA.setBounds(98, y, 160, 25);
		TimeA.add(lblTimeA);

		TimeB.setBackground(Color.WHITE);
		TimeB.setBounds(325, y, 160, 25);
		TimeB.add(lblTimeB);

		placar.setBackground(new Color(28, 104, 30));
		placar.setBounds(262, y, 60, 25);
		placar.setLayout(null);

		PartidaGolsA.setBounds(0, 0, 20, 25);
		placar.add(PartidaGolsA);
		PartidaGolsA.setForeground(Color.WHITE);
		PartidaGolsA.setFont(new Font("Tahoma", Font.PLAIN, 17));

		X.setBounds(19, 0, 20, 25);
		placar.add(X);
		X.setForeground(Color.WHITE);
		X.setFont(new Font("Tahoma", Font.PLAIN, 17));

		PartidaGolsB.setBounds(40, 0, 20, 25);
		placar.add(PartidaGolsB);
		PartidaGolsB.setForeground(Color.WHITE);
		PartidaGolsB.setFont(new Font("Tahoma", Font.PLAIN, 17));
	}

	public JPanel getTimeA() {
		return TimeA;
	}

	public JLabel getLblTimeA() {
		return lblTimeA;
	}

	public JPanel getTimeB() {
		return TimeB;
	}

	public JLabel getLblTimeB() {
		return lblTimeB;
	}

	public JPanel getPlacar() {
		return placar;
	}

	public JLabel getPartidaGolsA() {
		return PartidaGolsA;
	}

	public JLabel getX() {
		return X;
	}

	public JLabel getPartidaGolsB() {
		return PartidaGolsB;
	}

	public void setTimeA(String timeA) {
		this.lblTimeA.setText(timeA);
	}

	public void setTimeB(String timeB) {
		this.lblTimeB.setText(timeB);
	}

	public void setPartidaGolsA(int gols) {
		PartidaGolsA.setText(Integer.toString(gols));
	}

	public void setPartidaGolsB(int gols) {
		PartidaGolsB.setText(Integer.toString(gols));
	}

}
