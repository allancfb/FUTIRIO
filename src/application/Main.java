package application;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	@FXML
	private Button jogar;

	@FXML
	private Button creditos;

	@FXML
	private Button sair;

	@FXML
	private Button voltar;

	Stage stage = new Stage();

	public static void main(String[] args) {
		launch(args);
	}

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

	// CENA DE INICIO
	@FXML
	public void jogar(ActionEvent event) throws IOException {
		Parent jogarParent = FXMLLoader.load(getClass().getResource("selecionaOpcoes.fxml"));
		Scene jogar = new Scene(jogarParent);

		stage.setTitle("FUTIRIO");
		stage.setScene(jogar);
		stage.show();
	}

	@FXML
	public void creditos(ActionEvent event) throws IOException {
		Parent creditosParent = FXMLLoader.load(getClass().getResource("Creditos.fxml"));
		Scene creditos = new Scene(creditosParent);

		stage.setTitle("FUTIRIO");
		stage.setScene(creditos);
		stage.show();
	}

	@FXML
	public void sair(ActionEvent event) {
		Platform.exit();
	}

	//////////////////////////////////////////////////////////////////
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

}
