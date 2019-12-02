package br.ufrpe.animal_clinic.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.Servico;
import br.ufrpe.animal_clinic.negocio.beans.Alimentacao;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.negocio.beans.Especie;
import br.ufrpe.animal_clinic.negocio.beans.Genero;
import br.ufrpe.animal_clinic.negocio.beans.Prontuario;
import br.ufrpe.animal_clinic.negocio.beans.TempoDeVida;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    
    @FXML
    private Button btAtualizar;
    
    @FXML
    private TableView<Prontuario> tabelaProntuario;

    @FXML
    private TableColumn<Prontuario, String> colunaRelatoMedico;


    @FXML
    private TableColumn<Prontuario, Consulta> colunaNomeAnimal;

    
    public void voltar() {
    	Main.trocaCena(0);
    }
    
    private List<Animal> listaDeAnimais = new ArrayList();
    private List<Prontuario> listaDeProntuarios = new ArrayList();
    private List<Usuario> listaDeUsuario = new ArrayList();
    
    private ObservableListBase<Prontuario> listaObP;
    private ObservableListBase<Animal> listaOb;
    private ObservableListBase<Usuario> listaObs;
    
    public void atualizarT() throws NullException, ElementoNaoExisteException {
    	String login = i.getLogin();
		Usuario dono = s.procurarUsuarioPorLogin(login);
    	
    	for(Prontuario p: i.getProntuarios()) {
			if(p.getConsulta().getAnimal().getDono().getId().equals(dono.getId())) {
				if(listaDeProntuarios.contains(p)==false) {
					listaDeProntuarios.add(p);
				}
			}
		}
		
		listaObP = (ObservableListBase<Prontuario>) FXCollections.observableArrayList(listaDeProntuarios);
    	tabelaProntuario.setItems(listaObP);
    	
    }
    
    public void preencherTabela() throws NullException, ElementoNaoExisteException {
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaTempo.setCellValueFactory(new PropertyValueFactory<>("TempoDeVida"));
    	colunaEspecie.setCellValueFactory(new PropertyValueFactory<>("Especie"));
    	colunaGenero.setCellValueFactory(new PropertyValueFactory<>("Genero"));
    	colunaAlimento.setCellValueFactory(new PropertyValueFactory<>("Alimentacao"));
    	
    	colunaNomeUsuario.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
    	colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
    	
    	colunaRelatoMedico.setCellValueFactory(new PropertyValueFactory<>("relatorio"));
    	colunaNomeAnimal.setCellValueFactory(new PropertyValueFactory<>("consulta"));

    	String login = i.getLogin();
		Usuario dono = s.procurarUsuarioPorLogin(login);
		
		for(Animal a: i.getDadosAnimais()) {
			if(a.getIdDono().equals(dono.getId())) {
				if (listaDeAnimais.contains(a) == false) {
	        		listaDeAnimais.add(a);
	    		}
			}
		}
		
		
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
    void remove(ActionEvent event) throws  ElementoNaoExisteException, NullException {
    	Animal animal = tabela.getSelectionModel().getSelectedItem();
    	listaDeAnimais.remove(animal);
    	listaOb.remove(animal);
    	
    	try{
    		i.removerAn(animal);
    	}catch (ElementoNaoExisteException e) {
    		Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro na Remocao");
            alert.setHeaderText("Informacoes nao existem.");
            alert.setContentText("Tente um novo animal.");
            alert.showAndWait();
		}
    }

    @FXML
    void solicitarMarcar(ActionEvent event) {
    	Animal animal = tabela.getSelectionModel().getSelectedItem();
    	try{
    		i.setNomeAnimal(animal.getNome());
    		Main.trocaCena(6);
    	}catch (NullPointerException e) {
    		Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro na Marcacao");
            alert.setHeaderText("Informacoes nao existem.");
            alert.setContentText("Tente um novo animal.");
            alert.showAndWait();
		}
    	
    	
    }
    
    @FXML
    void atualizar(ActionEvent event) throws NullException, ElementoNaoExisteException {
    	preencherTabela();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
