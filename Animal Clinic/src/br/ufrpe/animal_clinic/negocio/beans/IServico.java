package br.ufrpe.animal_clinic.negocio.beans;

import java.io.IOException;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NotFoundException;
import br.ufrpe.animal_clinic.exception.NullException;


public interface IServico {
	
	void cadastrarUsuario(Usuario u) throws ExisteException, NullException;
	void cadastrarConsulta(Consulta c) throws NullException, ExisteException;
	void cadastrarCirurgia(Cirurgia c) throws NullException, ExisteException;
	void cadastrarAnimal(Animal a);
	
	void removerUsuario(String id) throws NullException;
	void removerAnimal(String nome);
	
	void desmarcarConsulta(String id) throws NullException;
	void desmarcarCirurgia(String id) throws NullException;
    void carregarDados()throws IOException, NotFoundException, ClassNotFoundException;
    
    
    Usuario efetuarLogin(String login) throws NullException ;
	
	Medico procurarMedico(String id) throws NullException ;
	Medico procurarMedicoPorLogin(String login) throws NullException;
	Usuario procurarUsuario(String id) throws NullException ;
	Usuario procurarUsuarioPorLogin(String login) throws NullException;
	Atendente procurarAtendente(String id) throws NullException ;
	Atendente procurarAtendentePorLogin(String login) throws NullException;
    
	
	void salvarDados() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException;
	void marcarExame(Exame e) throws NullException, ExisteException;
	
}
