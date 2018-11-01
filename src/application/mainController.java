package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.awt.Button;
import java.net.URL;
import java.util.*;

import org.omg.CORBA.portable.IndirectionException;

public class mainController implements Initializable{
	
	public void jogar(ActionEvent event) {
		//TODO vai pra cena para escolher características do jogo futuro
	}

	public void creditos(ActionEvent event) {
		//TODO vai pra cena créditos
	}

	public void sair(ActionEvent event) {
		Platform.exit();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
