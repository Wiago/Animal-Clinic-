package br.ufrpe.animal_clinic.gui;

import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

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

public class ControladorTelaMedico implements Initializable{
	
	private GetInformacao gI = GetInformacao.getInstancia();
	
	@FXML
    private Button voltar;

    @FXML
    private TableView<Animal> tabela;

    @FXML
    private TableColumn<Animal, String> colunaNome;

    @FXML
    private TableColumn<Animal, Especie> colunaEspecie;

    @FXML
    private TableColumn<Animal, Alimentacao> colunaAlimentacao;

    @FXML
    private TableColumn<Usuario, String> colunaDono;

    @FXML
    void voltar(ActionEvent event) {
    	Main.trocaCena(0);
    }
    private List<Animal> listaDeAnimais = new ArrayList();
    
    private ObservableListBase<Animal> listaOb;
    
    public void preencherTabela() {
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
    	colunaAlimentacao.setCellValueFactory(new PropertyValueFactory<>("alimentacao"));
    	colunaDono.setCellValueFactory(new PropertyValueFactory<>("dono"));
    	
    	Animal a = new Animal("Ze",new Usuario("Fulano", "111", "123", "fulo123", new Date().from(Instant.now())), Alimentacao.CARNIVORO, Especie.CANINO, Genero.MACHO, TempoDeVida.ADULTO);
    	Animal b = new Animal("Zezinho", new Usuario("Beltrano", "222", "123", "belt123", new Date().from(Instant.now())), Alimentacao.HERBIVORO, Especie.ROEDOR, Genero.MACHO, TempoDeVida.ADULTO);
    	
    	listaDeAnimais.add(a);
    	listaDeAnimais.add(b);
    	
    	listaOb = (ObservableListBase<Animal>) FXCollections.observableArrayList(listaDeAnimais);
    	tabela.setItems(listaOb);
    }
    
    public void animalSelecionado(Animal animal) {
    	System.out.println(animal.getNome());
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
		
		tabela.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> animalSelecionado(newValue));
	}

}
