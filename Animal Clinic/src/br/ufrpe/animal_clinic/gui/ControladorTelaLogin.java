package br.ufrpe.animal_clinic.gui;

import java.awt.List;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NotFoundException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.Servico;
import br.ufrpe.animal_clinic.negocio.beans.Atendente;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


public class ControladorTelaLogin implements Initializable{
	private static GetInformacao i = GetInformacao.getInstancia();
	private static Servico s = Servico.getInstancia();
	java.util.List<Atendente> a = null;
	java.util.List<Usuario> u = null;
	java.util.List<Medico> m = null;
	
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
    void login(ActionEvent event) throws NullException, ClassNotFoundException, IOException, NotFoundException, ElementoNaoExisteException {
    	String loginS = id.getText();
    	String senhaS = senha.getText();
    	String id;
		System.out.println(id = i.loginUser(loginS, senhaS));
    	
		try{
			id = i.loginUser(loginS, senhaS);
		
			switch (id.charAt(0)) {
			case '1':
				try{
					Atendente a = s.procurarAtendentePorLogin(loginS);
					Main.trocaCena(2);
				}catch (ElementoNaoExisteException e) {
					Alert alert = new Alert(AlertType.ERROR);
		            alert.setTitle("Erro no Login");
		            alert.setHeaderText("Informacoes nao existem.");
		            alert.setContentText("Nao existe este usuario cadastrado.");
		            alert.showAndWait();
				}
				break;
			case '2':
				try{
					Medico m = s.procurarMedicoPorLogin(loginS);
					i.setLogin(loginS);
					Main.trocaCena(3);
				}catch (ElementoNaoExisteException e){
					Alert alert = new Alert(AlertType.ERROR);
		            alert.setTitle("Erro no Login");
		            alert.setHeaderText("Informacoes nao existem.");
		            alert.setContentText("Nao existe este usuario cadastrado.");
		            alert.showAndWait();
				}
				break;
			case '3':
				try{
					Usuario u = s.procurarUsuarioPorLogin(loginS);
					i.setLogin(loginS);
					Main.trocaCena(4);
				}catch (ElementoNaoExisteException e){
					Alert alert = new Alert(AlertType.ERROR);
		            alert.setTitle("Erro no Login");
		            alert.setHeaderText("Informacoes nao existem.");
		            alert.setContentText("Nao existe este usuario cadastrado.");
		            alert.showAndWait();
				}
				break;
			default:
				Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Erro no Login");
	            alert.setHeaderText("Informacoes nao existem.");
	            alert.setContentText("Nao existe este usuario cadastrado.");
	            alert.showAndWait();
				break;
			}
		}catch (NullPointerException e) {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro no Login");
            alert.setHeaderText("Informacoes estao vazias.");
            alert.setContentText("Nao existe este usuario cadastrado.");
            alert.showAndWait();
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
			i.salvar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
