package br.ufrpe.animal_clinic.gui.TELA;

import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.gui.GetInformacao;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class Controlador implements Initializable{
	
	private static GetInformacao i = new GetInformacao();
	
	@FXML
    private PasswordField senha;

    @FXML
    private Button sair;

    @FXML
    private TextField id;

    @FXML
    private Button login;

    @FXML
    private Button cadastrar;

    @FXML
    void login(ActionEvent event) throws NullException {
    	String idS = id.getText();
    	String senhaS = senha.getText();
    	
    	i.loginU(idS, senhaS);
    }

    @FXML
    void sair(ActionEvent event) {

    }

    @FXML
    void cadastrar(ActionEvent event) {
    	Main.trocaCena(1);

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
