package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.Button;
import java.net.URL;
import java.util.*;

public class mainController implements Initializable{
	
	@FXML
	private Button jogar;
	
	@FXML
	private Button creditos;
	
	@FXML
	private Button sair;
	
	public void jogar(ActionEvent event) {
		//TODO vai pra cena para escolher caracter�sticas do jogo futuro
	}

	public void creditos(ActionEvent event) {
		//TODO vai pra cena cr�ditos
	}

	public void sair(ActionEvent event) {
		Platform.exit();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}