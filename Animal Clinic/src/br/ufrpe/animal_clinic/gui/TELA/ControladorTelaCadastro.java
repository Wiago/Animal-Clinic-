package br.ufrpe.animal_clinic.gui.TELA;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;

import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.gui.GetInformacao;
import br.ufrpe.animal_clinic.negocio.beans.TipoUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControladorTelaCadastro implements Initializable{
	private static GetInformacao i = new GetInformacao();
	DateFormat f = DateFormat.getDateInstance();
	
	@FXML
    private PasswordField senha;

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
    void cadastrar(ActionEvent event) throws ParseException, ExisteException, NullException, IOException {
    	
    	String loginS = login.getText();
    	String senhaS = senha.getText();
    	String nomeS = nome.getText();
    	String cpfS = cpf.getText();
    	String dataS = data.getText();
    	Date dataD = f.parse(dataS);
    	TipoUsuario usuario = usuarios.getValue();
    	
    	switch (usuario.getCategoria()) {
		case 1:
			i.cadastrarA(nomeS, cpfS, senhaS, loginS, dataD);
			i.salvar();
			break;
		case 2:
			i.cadastrarM(nomeS, cpfS, senhaS, loginS, dataD);
			i.salvar();
			break;
		case 3:
			i.cadastrarU(nomeS, cpfS, senhaS, loginS, dataD);
			i.salvar();
			break;

		default:
			break;
		}
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		usuarios.setItems(itens);
		
	}

}
