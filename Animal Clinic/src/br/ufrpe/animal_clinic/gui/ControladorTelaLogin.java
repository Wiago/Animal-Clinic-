package br.ufrpe.animal_clinic.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.animal_clinic.exception.NotFoundException;
import br.ufrpe.animal_clinic.exception.NullException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class ControladorTelaLogin implements Initializable{
	
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
    void login(ActionEvent event) throws NullException, ClassNotFoundException, IOException, NotFoundException {
    	String loginS = id.getText();
    	String senhaS = senha.getText();
    	i.loginUser(loginS, senhaS);
    	Main.trocaCena(2);
    }

    @FXML
    void sair(ActionEvent event) {
    	Main.getStage().close();
    }

    @FXML
    void cadastrar(ActionEvent event) {
    	Main.trocaCena(1);

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			i.carregar();
		} catch (ClassNotFoundException | IOException | NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
