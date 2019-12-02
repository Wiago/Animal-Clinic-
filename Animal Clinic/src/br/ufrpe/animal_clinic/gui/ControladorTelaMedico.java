package br.ufrpe.animal_clinic.gui;

import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.ufrpe.animal_clinic.exception.ElementoJaExisteException;
import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.Servico;
import br.ufrpe.animal_clinic.negocio.beans.Alimentacao;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.negocio.beans.Especie;
import br.ufrpe.animal_clinic.negocio.beans.Genero;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
import br.ufrpe.animal_clinic.negocio.beans.Prontuario;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorTelaMedico implements Initializable{
	
	private static GetInformacao gI = GetInformacao.getInstancia();
	private Servico s = Servico.getInstancia();
	private List<Animal> listaDeAnimais = new ArrayList();
    private List<Consulta> listaDeConsultas = new ArrayList();
    private List<Medico> listaDoMedico = new ArrayList();
    private List<Consulta> listaDeProntuario = new ArrayList();
    private ObservableListBase<Consulta> listaObsss;
    private ObservableListBase<Animal> listaOb;
    private ObservableListBase<Consulta> listaObs;
    private ObservableListBase<Medico> listaObss;
	
	@FXML
    private Button voltar;

    @FXML
    private TableView<Animal> tabela;
    
    @FXML
    private TableView<Medico> tabelaMedico;
    
    @FXML
    private TableColumn<Medico, String> loginMedico;

    @FXML
    private TableColumn<Medico, String> especialidadeMedico;
    
    @FXML
    private TableColumn<Medico, String> nomeMedico;
    
    @FXML
    private TableColumn<Animal, String> colunaNome;

    @FXML
    private TableColumn<Animal, Especie> colunaEspecie;

    @FXML
    private TableColumn<Animal, Alimentacao> colunaAlimentacao;

    @FXML
    private TableColumn<Usuario, String> colunaDono;
    
    @FXML
    private TableColumn<Consulta, String> colinaHorario;

    @FXML
    private TableView<Consulta> tabelaConsultas;

    @FXML
    private TableColumn<Consulta, Animal> colunaNomeAnimal;

    @FXML
    private Button btConsultar;
    
    @FXML
    private Button btMarcarExame;

    
    @FXML
    private TextArea textRelatoConsulta;
    
    @FXML
    private TableView<Consulta> tabelaProntuario;
    
    @FXML
    private Button btProntuario;
    
    @FXML
    private TableColumn<Consulta, Animal> colunaConsultas;
    
    @FXML
    private Button btAtualizar;
    
    @FXML
    private Button btAtualizarPacientes;

    @FXML
    void gerarProntuario(ActionEvent event) {
    	String relatorio = textRelatoConsulta.getText();
    	Consulta consulta = tabelaProntuario.getSelectionModel().getSelectedItem();
    	
    	try {
			gI.novoProntuario(consulta, relatorio);
			Main.trocaCena(7);
			listaDeProntuario.remove(consulta);
			tabelaProntuario.setItems(listaObsss);
			
		} catch (ElementoJaExisteException e) {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro na geracao do Prontuario");
            alert.setHeaderText("Informacoes ja existem.");
            alert.setContentText("Tente novamente com um novo elemento.");
            alert.showAndWait();
		}
    }
    
    @FXML
    void voltar(ActionEvent event) {
    	Main.trocaCena(0);
    }
    
    @FXML
    void consultar(ActionEvent event) throws NullException, ElementoNaoExisteException {
    	Consulta consulta = tabelaConsultas.getSelectionModel().getSelectedItem();
    	listaDeConsultas.remove(consulta);
    	listaObs.remove(consulta);
    	listaObsss.add(consulta);
    	tabelaProntuario.setItems(listaObsss);
    	
    	try{
    		gI.removerConsulta(consulta);
    	}catch (NullException e) {
    		Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro na Remocao");
            alert.setHeaderText("Informacoes nao existem.");
            alert.setContentText("Tente uma nova consulta.");
            alert.showAndWait();
		}
    }
    
    @FXML
    void atualizar(ActionEvent event) throws NullException, ElementoNaoExisteException {
    	preencherTabela();
    }
    
    @FXML
    void marcarExame(ActionEvent event) {
    	Animal animal = tabela.getSelectionModel().getSelectedItem();
    	gI.setNomeAnimal(animal.getNome());
    	Main.trocaCena(7);
    	
    }
    @FXML
    public void preencherTabela() throws NullException, ElementoNaoExisteException {
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaEspecie.setCellValueFactory(new PropertyValueFactory<>("Especie"));
    	colunaAlimentacao.setCellValueFactory(new PropertyValueFactory<>("Alimentacao"));
    	colunaDono.setCellValueFactory(new PropertyValueFactory<>("Dono"));
    
    	loginMedico.setCellValueFactory(new PropertyValueFactory<>("login"));
    	especialidadeMedico.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
    	nomeMedico.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
    	colinaHorario.setCellValueFactory(new PropertyValueFactory<>("data"));
    	colunaNomeAnimal.setCellValueFactory(new PropertyValueFactory<>("Animal"));
    	
    	colunaConsultas.setCellValueFactory(new PropertyValueFactory<>("Animal"));
    	
    	
    	String login = gI.getLogin();
		Medico medico = s.procurarMedicoPorLogin(login);
		
		if(listaDoMedico.contains(medico) == false) {
			listaDoMedico.add(medico);
		}
		

		for(Consulta c: gI.getConsultas()) {
			if(c.getMedico().getId().equals(medico.getId())) {
				if (listaDeConsultas.contains(c) == false) {
					listaDeConsultas.add(c);
	    		}
			}
		}
    	
		for(Consulta a: gI.getConsultas()) {
			if(a.getMedico().getLogin().equals(gI.getLogin())) {
				listaDeAnimais.add(a.getAnimal());
			}
		}
    	
  
    	System.out.println(s.getArrayConsultas());
    	
    	listaObs = (ObservableListBase<Consulta>) FXCollections.observableArrayList(listaDeConsultas);
    	listaOb = (ObservableListBase<Animal>) FXCollections.observableArrayList(listaDeAnimais);
    	listaObss = (ObservableListBase<Medico>) FXCollections.observableArrayList(listaDoMedico);
    	listaObsss = (ObservableListBase<Consulta>) FXCollections.observableArrayList(listaDeProntuario);
    	
    	tabela.setItems(listaOb);
    	tabelaConsultas.setItems(listaObs);
    	tabelaMedico.setItems(listaObss);
    }
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
