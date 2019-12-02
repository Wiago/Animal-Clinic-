package br.ufrpe.animal_clinic.gui;

import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.ufrpe.animal_clinic.exception.ElementoJaExisteException;
import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Alimentacao;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.negocio.beans.Especie;
import br.ufrpe.animal_clinic.negocio.beans.Exame;
import br.ufrpe.animal_clinic.negocio.beans.Genero;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
import br.ufrpe.animal_clinic.negocio.beans.TempoDeVida;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorTelaAtendente implements Initializable{
	
	private GetInformacao gI = GetInformacao.getInstancia();
	
	@FXML
    private Button voltar;
	
	@FXML
	private Button marcarExame;
	
    @FXML
    private TableView<Animal> tabela;

    @FXML
    private TableColumn<Animal,String> colunaNome;

    @FXML
    private TableColumn<Animal,Usuario> colunaCPF;

    @FXML
    private TableColumn<Animal, Especie> colunaEAnimal;

    @FXML
    private TableView<Usuario> tabelaUsuarios;

    @FXML
    private TableColumn<Medico, String> colunaCpfM;

    @FXML
    private TableColumn<Usuario, String> colunaLoginU;

    @FXML
    private TableColumn<Usuario, String> colunaNomeU;

    @FXML
    private TableColumn<Medico, String> colunaEspecialidadeM;

    @FXML
    private TableView<Medico> tabelaMedicos;

    @FXML
    private TableColumn<Medico, String> colunaLoginM;

    @FXML
    private TableColumn<Medico, String> coluaNomeM;

    @FXML
    private TableColumn<Usuario, String> colunaCpU;

    @FXML
    private TableColumn<Consulta, Date> colunaDataC;

    @FXML
    private TableColumn<Exame, Date> colunaDataE;

    @FXML
    private TableColumn<Exame, Consulta> colunaConsultaE;

    @FXML
    private TableView<Exame> tabelaExame;

    @FXML
    private TableColumn<Consulta, Animal> colunaConsultaA;

    @FXML
    private TableColumn<Consulta, Medico> colunaMedicoC;

    @FXML
    private TableView<Consulta> tabelaConsulta;

    @FXML
    private TableColumn<Exame, Consulta> colunaMedicoE;

    @FXML
    void marcarExame(ActionEvent event) throws NullException, ExisteException {
    	Exame exame = null;
		
    	try{
    		exame = tabelaExame.getSelectionModel().getSelectedItem();
    		System.out.println(exame);
    		gI.cadastrarExame(exame);
    	}catch (ElementoJaExisteException e) {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro na Marcacao");
            alert.setHeaderText("Informacoes ja existem.");
            alert.setContentText("Tente outro Exame.");
            alert.showAndWait();
		}
    }
        
    @FXML
    void voltar(ActionEvent event) {
    	Main.trocaCena(0);
    }
    
    private List<Animal> listaDeAnimais = new ArrayList();
    private List<Usuario> listaDeUsuarios = new ArrayList();
    private List<Medico> listaDeMedicos = new ArrayList();
    private List<Consulta> listaDeSConsuta = new ArrayList();
    private List<Exame> listaDeSExame = new ArrayList();
    
    private ObservableListBase<Animal> listaOb;
    private ObservableListBase<Usuario> listaObU;
    private ObservableListBase<Medico> listaObM;
    private ObservableListBase<Consulta> listaObSC;
    private ObservableListBase<Exame> listaObSE;
    
    public void preencherTabela() {
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaCPF.setCellValueFactory(new PropertyValueFactory<>("dono"));
    	colunaEAnimal.setCellValueFactory(new PropertyValueFactory<>("especie"));
    	
    	coluaNomeM.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaCpfM.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    	colunaCpU.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    	colunaEspecialidadeM.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
    	colunaLoginM.setCellValueFactory(new PropertyValueFactory<>("login"));
    	colunaLoginU.setCellValueFactory(new PropertyValueFactory<>("login"));
    	colunaNomeU.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
    	colunaDataC.setCellValueFactory(new PropertyValueFactory<>("data"));
    	colunaMedicoC.setCellValueFactory(new PropertyValueFactory<>("medico"));
    	colunaConsultaA.setCellValueFactory(new PropertyValueFactory<>("animal"));
    	
    	colunaConsultaE.setCellValueFactory(new PropertyValueFactory<>("consuta"));
    	colunaEAnimal.setCellValueFactory(new PropertyValueFactory<>("animal"));
    	colunaDataE.setCellValueFactory(new PropertyValueFactory<>("data"));
    	
    	listaDeSExame.addAll(gI.getListaSExame());
    	listaDeSConsuta.addAll(gI.getListaDeSConsultas());
    	listaDeAnimais.addAll(gI.getDadosAnimais());
    	listaDeMedicos.addAll(gI.getDadosMedicos());
    	listaDeUsuarios.addAll(gI.getDadosUsuarios());
    	
    	listaObSC = (ObservableListBase<Consulta>) FXCollections.observableArrayList(listaDeSConsuta);
    	tabelaConsulta.setItems(listaObSC);
    	
    	listaOb = (ObservableListBase<Animal>) FXCollections.observableArrayList(listaDeAnimais);
    	tabela.setItems(listaOb);
    	
    	listaObU = (ObservableListBase<Usuario>) FXCollections.observableArrayList(listaDeUsuarios);
    	tabelaUsuarios.setItems(listaObU);
    	
    	listaObM = (ObservableListBase<Medico>) FXCollections.observableArrayList(listaDeMedicos);
    	tabelaMedicos.setItems(listaObM);
    	
    	listaDeSExame = (ObservableListBase<Exame>) FXCollections.observableArrayList(listaDeSExame);
    	tabelaExame.setItems(listaObSE);
    	
    }
    
    public void animalSelecionado(Animal animal) {
    	System.out.println(animal.getNome());
    }
    
    @FXML
    void marcar(ActionEvent event) throws NullException, ExisteException, ElementoJaExisteException, ElementoNaoExisteException {
    	Consulta consulta = null;
    			
    	try{
    		consulta = tabelaConsulta.getSelectionModel().getSelectedItem();
    		System.out.println(consulta);
    		gI.cadastrarConsulta(consulta);
    	}catch (ElementoJaExisteException e) {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro na Marcacao");
            alert.setHeaderText("Informacoes ja existem.");
            alert.setContentText("Tente outra consulta.");
            alert.showAndWait();
		}
    	
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
		
	}

}
