package br.ufrpe.animal_clinic.gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.ufrpe.animal_clinic.exception.ElementoJaExisteException;
import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.Servico;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.negocio.beans.Exame;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
import br.ufrpe.animal_clinic.negocio.beans.Prontuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ControladorTelaExame implements Initializable{
	
	static GetInformacao i = GetInformacao.getInstancia();
	private Servico s = Servico.getInstancia();
	
	private GetInformacao gI = GetInformacao.getInstancia();
	
	private List<String> listaProntuarios = new ArrayList();
	private ObservableListBase<String> listaOb;
	
	@FXML
    private TextField horaExame;

    @FXML
    private Button btVoltar;

    @FXML
    private TextArea txtRelatorio;
    
    @FXML
    private Text relatorioProntuario;

    @FXML
    private Button btExame;

    @FXML
    private TableColumn<Prontuario, String> prontuarios;

    @FXML
    private DatePicker dataExame;

    @FXML
    private TableView<String> tabelaprontuario;
    
    @FXML
    private Button btAtualizar;

    @FXML
    void marcarExame(ActionEvent event) throws ElementoNaoExisteException, NullException, ExisteException, ElementoJaExisteException {
    	Animal a = null;
    	Medico medico = null;
    	LocalDate data = null;
    	String hora = null;
    	String descricao = null;
    	try {
    		a = s.procurarAnimalPorNome(i.getNomeAnimal());
        	medico = s.procurarMedicoPorLogin(i.getLogin());
        	hora = horaExame.getText();
        	descricao = txtRelatorio.getText();
    	}catch(ElementoNaoExisteException e) {
    		Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro na Marcacao");
            alert.setHeaderText("Informacoes nao existem.");
            alert.setContentText("Tente outro animal, medico, hora ou relatorio.");
            alert.showAndWait();
    	}
    	data = dataExame.getValue();
    	Exame e = new Exame(a, medico, data, hora);
    	s.cadastrarExame(e);
    }

    @FXML
    void voltar(ActionEvent event) {
    	Main.trocaCena(3);
    }
    
    public void preencherTabela(){
    	prontuarios.setCellValueFactory(new PropertyValueFactory<>("relatorio"));
    	
    	for(Prontuario m: s.getArrayProntuarios()) {
			if (listaProntuarios.contains(m.getRelatorio()) == false) {
	        	if(m.getConsulta().getAnimal().getNome().equals(gI.getNomeAnimal())){
	        		listaProntuarios.add(m.getRelatorio());
	        		relatorioProntuario.setText(m.getConsulta().getAnimal().getNome());
	        	}
	    	}
		}
    	
    	System.out.println(s.getArrayProntuarios());
    	
    	listaOb = (ObservableListBase<String>) FXCollections.observableArrayList(listaProntuarios);
    	tabelaprontuario.setItems(listaOb);
    }
    
    @FXML
    void atualizar(ActionEvent event) {
    	preencherTabela();
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
