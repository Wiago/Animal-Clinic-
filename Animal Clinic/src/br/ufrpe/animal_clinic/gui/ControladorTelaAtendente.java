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

public class ControladorTelaAtendente implements Initializable{
	
	private GetInformacao gI = GetInformacao.getInstancia();
	
	@FXML
    private Button voltar;

    @FXML
    private TableView<Animal> tabela;

    @FXML
    private TableColumn<Animal,String> colunaNome;

    @FXML
    private TableColumn<Usuario,String> colunaCPF;

    @FXML
    private TableColumn<Animal, Especie> colunaEAnimal;

    @FXML
    void voltar(ActionEvent event) {
    	Main.trocaCena(0);
    }
private List<Animal> listaDeAnimais = new ArrayList();
    
    private ObservableListBase<Animal> listaOb;
    
    public void preencherTabela() {
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cPF"));
    	colunaEAnimal.setCellValueFactory(new PropertyValueFactory<>("especieAnimal"));
    	
    	Animal a = new Animal("Ze", new Usuario("Fulano", "111", "123", "fulo123", new Date().from(Instant.now())), Alimentacao.CARNIVORO, Especie.CANINO, Genero.MACHO, TempoDeVida.ADULTO);
    	
    	listaDeAnimais.add(a);
    	
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
