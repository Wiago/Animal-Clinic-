package br.ufrpe.animal_clinic.gui;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.util.Date;
import java.util.ResourceBundle;



import br.ufrpe.animal_clinic.exception.ElementoJaExisteException;
import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.Servico;
import br.ufrpe.animal_clinic.negocio.beans.Alimentacao;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Cirurgia;
import br.ufrpe.animal_clinic.negocio.beans.Especie;
import br.ufrpe.animal_clinic.negocio.beans.Genero;
import br.ufrpe.animal_clinic.negocio.beans.Login;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
import br.ufrpe.animal_clinic.negocio.beans.TempoDeVida;
import br.ufrpe.animal_clinic.negocio.beans.TipoUsuario;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ControladorTelaCadastroAnimal implements Initializable{
	
	private static GetInformacao i = GetInformacao.getInstancia();
	private Servico s = Servico.getInstancia();
	@FXML
    private TextField nomePet;

    @FXML
    private ComboBox<Especie> especie;
    ObservableList<Especie> especies = FXCollections.observableArrayList(Especie.values());

    @FXML
    private ComboBox<Genero> genero;
    ObservableList<Genero> generos = FXCollections.observableArrayList(Genero.values());
    
    @FXML
    private Button btCadastro;

    @FXML
    private ComboBox<TempoDeVida> tempoDeVida;
    ObservableList<TempoDeVida> idade = FXCollections.observableArrayList(TempoDeVida.values());
    
    @FXML
    private Button btSair;

    @FXML
    private ComboBox<Alimentacao> alimentacao;
    ObservableList<Alimentacao> alimentos = FXCollections.observableArrayList(Alimentacao.values());
    
    @FXML
    void cadastrar(ActionEvent event) throws NullException, ExisteException, IOException, ElementoNaoExisteException, ElementoJaExisteException {
    	Especie e = especie.getValue();
		Genero g = genero.getValue();
		TempoDeVida t = tempoDeVida.getValue();
		Alimentacao a = alimentacao.getValue();
		
		String login = i.getLogin();
		Usuario dono = s.procurarUsuarioPorLogin(login);
		
		i.cadastrarAnimal(nomePet.getText(), dono, a, e, g, t);
		i.salvar();
		
		Main.trocaCena(4);
    }

    @FXML
    void sair(ActionEvent event) {
    	Main.trocaCena(4);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		especie.setItems(especies);
		genero.setItems(generos);
		tempoDeVida.setItems(idade);
		alimentacao.setItems(alimentos);

	}
}
