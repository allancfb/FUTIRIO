package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	public Stage window;
	public Scene creditos, jogar;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			window = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));

			//Criando cenas
			Scene inicio = new Scene(root);
			// configurando os estilos das aplicações
			inicio.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setTitle("FUTIRIO");
			primaryStage.setScene(inicio);

			// mostrando a cena
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
