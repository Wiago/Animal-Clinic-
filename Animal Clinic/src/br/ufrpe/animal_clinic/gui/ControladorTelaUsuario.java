package br.ufrpe.animal_clinic.gui;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.ufrpe.animal_clinic.negocio.beans.Alimentacao;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Especie;
import br.ufrpe.animal_clinic.negocio.beans.Genero;
import br.ufrpe.animal_clinic.negocio.beans.TempoDeVida;
import javafx.collections.FXCollections;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorTelaUsuario implements Initializable {
	
	@FXML
    private TableView<Animal> tabela;

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
    
    private List<Animal> listaDeAnimais = new ArrayList();
    
    private ObservableListBase<Animal> listaOb;
    
    public void preencherTabela() {
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaTempo.setCellValueFactory(new PropertyValueFactory<>("TempoDeVida"));
    	colunaEspecie.setCellValueFactory(new PropertyValueFactory<>("Especie"));
    	colunaGenero.setCellValueFactory(new PropertyValueFactory<>("Genero"));
    	colunaAlimento.setCellValueFactory(new PropertyValueFactory<>("Alimentacao"));
    	
    	Animal a = new Animal("Ze", null, Alimentacao.CARNIVORO, Especie.CANINO, Genero.MACHO, TempoDeVida.ADULTO);
    	Animal b = new Animal("Zezinho", null, Alimentacao.HERBIVORO, Especie.ROEDOR, Genero.MACHO, TempoDeVida.ADULTO);
    	
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
