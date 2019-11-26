package br.ufrpe.animal_clinic.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.animal_clinic.exception.NotFoundException;
import br.ufrpe.animal_clinic.exception.NullException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class ControladorTelaLogin implements Initializable{
	
	private static GetInformacao i = GetInformacao.getInstancia();
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
    	String idLogin = i.loginUser(loginS, senhaS);
    	System.out.println(idLogin);
    	if(idLogin != null) {
    		switch(idLogin.charAt(0)) {
    			case '1':
    				Main.trocaCena(2);
    				id.clear();
    				senha.clear();
    				break;
    			case '2':
    				Main.trocaCena(3);
    				id.clear();
    				senha.clear();
    				break;
    			case '3':
    				i.setLogin(loginS);
    				Main.trocaCena(4);
    				id.clear();
    				senha.clear();
    				break;
    		}
    	}
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
			i.carregarDados();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
