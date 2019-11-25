package br.ufrpe.animal_clinic.gui;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorTelaUsuario implements Initializable {
	static GetInformacao i;
	private Servico s;
	
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
    private TableColumn<Usuario, String> colunaCPF;

    @FXML
    private Button btSair;

    @FXML
    private Button updateDados;

    @FXML
    private Button btAdd;

    @FXML
    private TableView<Usuario> tabelaUsuario;

    @FXML
    void addPet(ActionEvent event) {

    }

    @FXML
    void atualizarDados(ActionEvent event) {

    }

    @FXML
    void sair(ActionEvent event) {

    }
    private List<Usuario> listaDoUsuario = new ArrayList();
    private List<Animal> listaDeAnimais = new ArrayList();
    
    private ObservableListBase<Animal> listaOb;
    private ObservableListBase<Usuario> listaObs;
    
    public void preencherTabela() throws NullException {
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaTempo.setCellValueFactory(new PropertyValueFactory<>("TempoDeVida"));
    	colunaEspecie.setCellValueFactory(new PropertyValueFactory<>("Especie"));
    	colunaGenero.setCellValueFactory(new PropertyValueFactory<>("Genero"));
    	colunaAlimento.setCellValueFactory(new PropertyValueFactory<>("Alimentacao"));
    	
    	colunaNomeUsuario.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    	colunaTempo.setCellValueFactory(new PropertyValueFactory<>("data"));
    	colunaLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
    	
    	Date d = new Date(); 
    	Usuario c = new Usuario("Henrique", "123.123.123-33", "123", "henr123",d);
    	
    	Animal a = new Animal("Ze", c, Alimentacao.CARNIVORO, Especie.CANINO, Genero.MACHO, TempoDeVida.ADULTO);
    	Animal b = new Animal("Zezinho", c, Alimentacao.HERBIVORO, Especie.ROEDOR, Genero.MACHO, TempoDeVida.ADULTO);
    	
    	listaDeAnimais.add(a);
    	listaDeAnimais.add(b);
 
    	
    	listaOb = (ObservableListBase<Animal>) FXCollections.observableArrayList(listaDeAnimais);
    	tabela.setItems(listaOb);
    	
    	listaObs = (ObservableListBase<Usuario>) FXCollections.observableArrayList(listaDoUsuario);
    	tabelaUsuario.setItems(listaObs);
    }
    
    public void animalSelecionado(Animal animal) {
    	System.out.println(animal.getNome());
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			preencherTabela();
		} catch (NullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//tabela.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> animalSelecionado(newValue));
	}
}
