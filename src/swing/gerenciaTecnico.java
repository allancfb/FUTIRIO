package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Choice;

public class gerenciaTecnico {

	private JFrame frame;
	private JTextField nomeTecnico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gerenciaTecnico window = new gerenciaTecnico();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gerenciaTecnico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox times = new JComboBox();
		times.addItem("Botafogo");
		times.addItem("Flamengo");
		times.addItem("Fluminense");
		times.addItem("Vasco");
		times.setSelectedItem(null);
		times.setBounds(119, 199, 146, 23);
		frame.getContentPane().add(times);

		JButton btnAvanar = new JButton("Avan\u00E7ar");
		btnAvanar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO se os elementos não tiverem sido selecionados, mostra mensagem:
				// Selecione todas as opções para continuar
				/* if(elementos não selecionados) */
				if (nomeTecnico.getText() == null || nomeTecnico.getText().trim().equals("")
						|| times.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(frame, "Selecione todas as opções para continuar", "Erro",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Inicio inicio = new Inicio();
					inicio.setVisible(true);
					frame.setVisible(false);
				}
			}
		});

		btnAvanar.setBounds(247, 270, 89, 23);
		frame.getContentPane().add(btnAvanar);

		JLabel lblTimes = new JLabel("Selecione o time que deseja comandar:");
		lblTimes.setForeground(Color.WHITE);
		lblTimes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTimes.setBounds(120, 165, 370, 27);
		frame.getContentPane().add(lblTimes);

		nomeTecnico = new JTextField();
		nomeTecnico.setToolTipText("");
		nomeTecnico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeTecnico.setForeground(Color.BLACK);
		nomeTecnico.setBounds(120, 108, 259, 27);
		frame.getContentPane().add(nomeTecnico);
		nomeTecnico.setColumns(10);

		JLabel lblNome = new JLabel("Insira o nome do t\u00E9cnico:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(120, 63, 259, 47);
		frame.getContentPane().add(lblNome);

		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon(gerenciaTecnico.class.getResource("/Imagens/campo.jpg")));
		background.setBounds(0, 0, 594, 370);
		frame.getContentPane().add(background);
	}
}
