package br.ufrpe.animal_clinic.gui;

import java.io.Serializable;
import java.net.URL;
import java.time.Instant;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorTelaUsuario implements Initializable {
	static GetInformacao i;
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
    	
    	Animal a = new Animal("Ze", new Usuario("Fulano", "111", "123", "fulo123", new Date().from(Instant.now())), Alimentacao.CARNIVORO, Especie.CANINO, Genero.MACHO, TempoDeVida.ADULTO);
    	Animal b = new Animal("Zezinho", new Usuario("Beltrano", "222", "123", "belo123", new Date().from(Instant.now())), Alimentacao.HERBIVORO, Especie.ROEDOR, Genero.MACHO, TempoDeVida.ADULTO);
    	
    	Date d = new Date(); 
    	Usuario c = new Usuario("Henrique", "123.123.123-33", "123", "henr123",d);
    	
    	Animal g = new Animal("Ze", c, Alimentacao.CARNIVORO, Especie.CANINO, Genero.MACHO, TempoDeVida.ADULTO);
    	Animal h = new Animal("Zezinho", c, Alimentacao.HERBIVORO, Especie.ROEDOR, Genero.MACHO, TempoDeVida.ADULTO);
    	
    	listaDeAnimais.add(a);
    	listaDeAnimais.add(b);
    	listaDeAnimais.add(g);
    	listaDeAnimais.add(h);
    	
    	
    	listaDeUsuario.add(c);
    	
    	listaOb = (ObservableListBase<Animal>) FXCollections.observableArrayList(listaDeAnimais);
    	tabela.setItems(listaOb);
    	
    	listaObs = (ObservableListBase<Usuario>) FXCollections.observableArrayList(listaDeUsuario);
    	//tabelaUsuario.setItems(listaObs);
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
