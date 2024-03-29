package br.ufrpe.animal_clinic.gui;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;


import br.ufrpe.animal_clinic.exception.ElementoJaExisteException;
import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.TipoUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControladorTelaCadastro implements Initializable{
	private static GetInformacao i = GetInformacao.getInstancia();
	DateFormat f = DateFormat.getDateInstance();
	
	@FXML
    private PasswordField senha;
	
	@FXML
    private TextField especialidade;

    @FXML
    private TextField data;

    @FXML
    private Button voltarID;

    @FXML
    private Button cadastrarID;

    @FXML
    private TextField cpf;

    @FXML
    private TextField nome;

    @FXML
    private Label label;

    @FXML
    private TextField login;
    
    @FXML
    private ComboBox<TipoUsuario> usuarios;
    ObservableList<TipoUsuario> itens = FXCollections.observableArrayList(TipoUsuario.values());

    
    @FXML
    void voltar(ActionEvent event) {
    	Main.trocaCena(0);
    	login.clear();
    	senha.clear();
    	nome.clear();
    	cpf.clear();
    	data.clear();
    	usuarios.setValue(null);
    }
    
    @FXML
    void login(ActionEvent event) {
    	Main.trocaCena(0);
    }

    @FXML
    void cadastrar(ActionEvent event) throws ParseException, ExisteException, NullException, IOException, ElementoJaExisteException, ElementoNaoExisteException {
    	String loginS = null;
    	String senhaS = null;
    	String nomeS = null;
    	String cpfS = null;
    	String dataS = data.getText();
    	Date dataD = null;
    	boolean loginB = false;
    	boolean loginB1 = false;
    	String idTeste = null;
    	try {
    		dataD = f.parse(dataS);
    	}catch (ParseException e) {
    		Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro no Cadastro");
            alert.setHeaderText("Informacoes vazias na data de Nascimento.");
            alert.setContentText("Coloque uma data valida.");
            alert.showAndWait();
		}
    	
    	if(!"".equals(login.getText()) || !"".equals(senha.getText()) 
    								   || !"".equals(nome.getText()) 
    								   || !"".equals(cpf.getText())) {
    		loginS = login.getText();
    		senhaS = senha.getText();
    		nomeS = nome.getText();
    		cpfS = cpf.getText();
    		
    		idTeste = i.loginUser(loginS, senhaS);
    		if(idTeste != null) {
    			loginB = true;
    			Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erro no Cadastro");
                alert.setHeaderText("Ja existe um usuario cadastrado com o login passado");
                alert.setContentText("Tente outro login.");
                alert.showAndWait();
    		}
    		
    		TipoUsuario usuario = usuarios.getValue();
    		System.out.println(usuario.getCategoria());
        	
        	String esp = null;
        	if(usuarios.getValue() == TipoUsuario.MEDICO) {
        		esp = especialidade.getText();
        		System.out.println(esp);
        	}
        	
        	if(loginB == false) {
	        	switch (usuario.getCategoria()) {
	    		case 1:
	    			System.out.println();
	    			try {
	    				i.cadastrarAtendente(nomeS, cpfS, senhaS, loginS, dataD);
	    			}catch (ElementoJaExisteException e) {
	    				loginB1 = true;
	    				Alert alert = new Alert(AlertType.ERROR);
	    	            alert.setTitle("Erro no Cadastro");
	    	            alert.setHeaderText("Informacoes ja existem.");
	    	            alert.setContentText("Tente um novo login.");
	    	            alert.showAndWait();
					}
	    			if(loginB1 == false) {
	    				Alert alert = new Alert(AlertType.INFORMATION);
	    	            alert.setTitle("Atendente cadastrado(a)");
	    	            alert.setContentText("Pode-se fazer o login com o(a) novo(a) Atendente.");
	    	            alert.showAndWait();
	    			}
	    			i.salvar();
	    			break;
	    		case 2:
	    			try{
	    				i.cadastrarMedico(nomeS, cpfS, senhaS, loginS, dataD, esp);
	    			}catch(ElementoJaExisteException e){
	    				loginB1 = true;
	    				Alert alert = new Alert(AlertType.ERROR);
	    	            alert.setTitle("Erro no Cadastro");
	    	            alert.setHeaderText("Informacoes ja existem.");
	    	            alert.setContentText("Tente um novo login.");
	    	            alert.showAndWait();
	    			}
	    			if(loginB1 == false) {
	    				Alert alert = new Alert(AlertType.INFORMATION);
	    	            alert.setTitle("Medico(a) cadastrado(a)");
	    	            alert.setContentText("Pode-se fazer o login com o(a) novo(a) Medico.");
	    	            alert.showAndWait();
	    			}
	    			i.salvar();
	    			break;
	    		case 3:
	    			try{
	    				i.cadastrarUsuario(nomeS, cpfS, senhaS, loginS, dataD);
	    			}catch(ElementoJaExisteException e) {
	    				loginB1 = true;
	    				Alert alert = new Alert(AlertType.ERROR);
	    	            alert.setTitle("Erro no Cadastro");
	    	            alert.setHeaderText("Informacoes ja existem.");
	    	            alert.setContentText("Tente um novo login.");
	    	            alert.showAndWait();
	    			}
	    			if(loginB1 == false) {
	    				Alert alert = new Alert(AlertType.INFORMATION);
	    	            alert.setTitle("Cliente cadastrado(a)");
	    	            alert.setContentText("Pode-se fazer o login com o(a) novo(a) Cliente.");
	    	            alert.showAndWait();
	    			}
	    			i.salvar();
	    			break;
	
	    		default:
	    			break;
	    		}
        	}
    	}
    	
    	if(!login.getText().trim().isEmpty() || !senha.getText().trim().isEmpty()) {
    		if(!nome.getText().trim().isEmpty() || !cpf.getText().trim().isEmpty())
    			loginS = login.getText();
    			senhaS = senha.getText();
    			nomeS = nome.getText();
    			cpfS = cpf.getText();
    	}
    	
    	
    	
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			i.salvar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usuarios.setItems(itens);
		
	}

}
