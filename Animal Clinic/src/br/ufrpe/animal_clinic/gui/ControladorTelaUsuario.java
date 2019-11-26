package br.ufrpe.animal_clinic.gui;

import java.io.Serializable;
import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.ufrpe.animal_clinic.dados.RepositorioUsuarios;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.Servico;
import br.ufrpe.animal_clinic.negocio.beans.Alimentacao;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Especie;
import br.ufrpe.animal_clinic.negocio.beans.Genero;
import br.ufrpe.animal_clinic.negocio.beans.TempoDeVida;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorTelaUsuario implements Initializable {
	static GetInformacao i = GetInformacao.getInstancia();
	private Servico s = Servico.getInstancia();
	
	private GetInformacao gI = GetInformacao.getInstancia();

	@FXML
	private Button btRemovePets;

    @FXML
    private Button btAddPets;

    @FXML
    private TableView<Usuario> tabelaUsuario;

    @FXML
    private Button btMarcar;
	
	@FXML
    private TableView<Animal> tabela;
	
	@FXML
	private TableColumn<Usuario, String> colunaNomeUsuario;

	@FXML
	private TableColumn<Usuario, Date> colunaData;
	
	@FXML
    private TableColumn<Usuario, String> colunaLogin;
	
    @FXML
    private TableColumn<Animal, TempoDeVida> colunaTempo;

    @FXML
    private TableColumn<Animal, Especie> colunaEspecie;

    @FXML
    private TableColumn<Animal, String> colunaNome;

    @FXML
    private TableColumn<Animal, Genero> colunaGenero;
    
    @FXML
    private TableColumn<Animal, Alimentacao> colunaAlimento;
    
    @FXML
    private Button voltar;
    
    @FXML
    private Button btAtulaizar;
    
    @FXML
    private Button btAtualizaU;
    
    
    public void voltar() {
    	Main.trocaCena(0);
    }
    
    private List<Animal> listaDeAnimais = new ArrayList();

    private List<Usuario> listaDeUsuario = new ArrayList();
    
    private ObservableListBase<Animal> listaOb;
    private ObservableListBase<Usuario> listaObs;
    
    public void preencherTabela() throws NullException {
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaTempo.setCellValueFactory(new PropertyValueFactory<>("TempoDeVida"));
    	colunaEspecie.setCellValueFactory(new PropertyValueFactory<>("Especie"));
    	colunaGenero.setCellValueFactory(new PropertyValueFactory<>("Genero"));
    	colunaAlimento.setCellValueFactory(new PropertyValueFactory<>("Alimentacao"));
    	
    	colunaNomeUsuario.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
    	colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
    	
    	if (i.getA() != null){
    		if (listaDeAnimais.contains(i.getA()) == false) {
        		listaDeAnimais.add(i.getA());
    		}
    	}
    	String login = i.getLogin();
		Usuario dono = s.procurarUsuarioPorLogin(login);
    	
		if(listaDeUsuario.contains(dono) == false) {
	    	listaDeUsuario.add(dono);
		}
    	
    	listaOb = (ObservableListBase<Animal>) FXCollections.observableArrayList(listaDeAnimais);
    	tabela.setItems(listaOb);
    	
    	listaObs = (ObservableListBase<Usuario>) FXCollections.observableArrayList(listaDeUsuario);
    	tabelaUsuario.setItems(listaObs);
    }
    
    public void animalSelecionado(Animal animal) {
    	System.out.println(animal.getNome());
    }
    
    @FXML
    void adicionar(ActionEvent event) {
    	Main.trocaCena(5);
    }

    @FXML
    void remove(ActionEvent event) {
    	Animal animal = tabela.getSelectionModel().getSelectedItem();
    	listaDeAnimais.remove(animal);
    	listaOb.remove(animal);
    }

    @FXML
    void solicitarMarcar(ActionEvent event) {
    	Animal animal = tabela.getSelectionModel().getSelectedItem();
    	
    }
    
    @FXML
    void atualizar(ActionEvent event) throws NullException {
    	preencherTabela();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//tabela.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> animalSelecionado(newValue));
	}
}
