package br.ufrpe.animal_clinic.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.ufrpe.animal_clinic.negocio.Servico;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorTelaConsulta implements Initializable {
	static GetInformacao i = GetInformacao.getInstancia();
	private Servico s = Servico.getInstancia();
	
	private GetInformacao gI = GetInformacao.getInstancia();
	
	private List<Medico> listaMedicos = new ArrayList();
	private ObservableListBase<Medico> listaOb;
	
	@FXML
    private TextField horaConsulta;

    @FXML
    private Button btVoltar;

    @FXML
    private TextArea relatoSintomas;

    @FXML
    private Button btConsulta;

    @FXML
    private TableColumn<Medico, String> colunaEspecialidade;

    @FXML
    private DatePicker dataConsulta;

    @FXML
    private TableView<Medico> tabelaMedico;

    @FXML
    private TableColumn<Medico, String> colunaNome;
    
    @FXML
    private Button btAtualizar;

    @FXML
    void marcarConsulta(ActionEvent event) {
    	
    }

    @FXML
    void voltar(ActionEvent event) {
    	Main.trocaCena(5);
    }
    
    public void preencherTabela(){
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaEspecialidade.setCellValueFactory(new PropertyValueFactory<>("xmedicoEspecialidade"));
    	
    	for(Medico m: s.getArrayMedico()) {
			if (listaMedicos.contains(m) == false) {
	        	listaMedicos.add(m);
	    	}
		}
    	
    	listaOb = (ObservableListBase<Medico>) FXCollections.observableArrayList(listaMedicos);
    	tabelaMedico.setItems(listaOb);
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
