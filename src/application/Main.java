package application;

import java.awt.Label;
import java.awt.TextField;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	// Main
	@FXML
	private Button jogar;

	@FXML
	private Button creditos;

	@FXML
	private Button sair;

	// Créditos
	@FXML
	private Button voltar;

	// selecionaOpcoes
	@FXML
	private Label nomeLabel;

	@FXML
	private TextField nomeTecnico;

	@FXML
	private ComboBox<?> selectTime;

	@FXML
	private Label timeLabel;

	@FXML
	private Button btnAvancar;

	@FXML
	private Label erro;

	Stage stage = new Stage();

	public static void main(String[] args) {
		launch(args);
	}

	// Cena de início
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			stage = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

			Scene inicio = new Scene(root);

			primaryStage.setTitle("FUTIRIO");
			primaryStage.setScene(inicio);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// go to selecionaOpcoes
	@FXML
	public void jogar(ActionEvent event) throws IOException {
		Parent jogarParent = FXMLLoader.load(getClass().getResource("selecionaOpcoes.fxml"));
		Scene jogar = new Scene(jogarParent);

		stage.setTitle("Selecione seu time");
		stage.setScene(jogar);
		stage.show();
	}

	// go to Creditos
	@FXML
	public void creditos(ActionEvent event) throws IOException {
		Parent creditosParent = FXMLLoader.load(getClass().getResource("Creditos.fxml"));
		Scene creditos = new Scene(creditosParent);

		stage.setTitle("Créditos");
		stage.setScene(creditos);
		stage.show();
	}

	// sair
	@FXML
	public void sair(ActionEvent event) {
		Platform.exit();
	}

	// Cena de Créditos
	@FXML
	public void voltar(ActionEvent event) throws IOException {
		Parent inicioParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene inicio = new Scene(inicioParent);

		// Setando a cena a ser mostrada
		stage.setTitle("FUTIRIO");
		stage.setScene(inicio);
		stage.show();
	}

	// Cena selecionaOpcoes
	public void avancar(ActionEvent event) throws IOException {
		if (nomeTecnico.getText().equals("")) {
			// TODO seta mensagem de erro na label ("Insira o nome do técnico")
			erro.setVisible(true);
		} /*
			 * else if(){ //se o conteúdo do combobox estiver vazio }else { //carrega página
			 * de jogo erro.setVisible(false); }
			 */
	}

}
