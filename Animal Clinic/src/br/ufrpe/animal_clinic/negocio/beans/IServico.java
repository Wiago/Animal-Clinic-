package br.ufrpe.animal_clinic.negocio.beans;

import java.io.IOException;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import br.ufrpe.animal_clinic.exception.ElementoJaExisteException;
import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NotFoundException;
import br.ufrpe.animal_clinic.exception.NullException;


public interface IServico {
	
	void cadastrarUsuario(Usuario u) throws ExisteException, NullException, ElementoJaExisteException;
	void cadastrarConsulta(Consulta c) throws NullException, ExisteException;
	void cadastrarCirurgia(Cirurgia c) throws NullException, ExisteException;
	void cadastrarAnimal(Animal a) throws ExisteException, ElementoJaExisteException;
	
	void removerUsuario(String id) throws NullException;
	
	void desmarcarConsulta(String id) throws NullException;
	void desmarcarCirurgia(String id) throws NullException;
    void carregarDados()throws IOException, NotFoundException, ClassNotFoundException, ExisteException;
    
    
    Usuario efetuarLoginUsuario(String login, String senha) throws NullException ;
    Atendente efetuarLoginAtendente(String login, String senha) throws NullException ;
    Medico efetuarLoginMedico(String login, String senha) throws NullException ;
	
	Medico procurarMedicoPorLogin(String login) throws NullException, ElementoNaoExisteException;
	Usuario procurarUsuarioPorLogin(String login) throws NullException, ElementoNaoExisteException;
	Atendente procurarAtendentePorLogin(String login) throws NullException, ElementoNaoExisteException;
	Animal procurarAnimalPorNome(String nome) throws ElementoNaoExisteException;
	Usuario procurarDonoAnimal(String login) throws ElementoNaoExisteException;
    
	
	void salvarDados() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException;
	void marcarExame(Exame e) throws NullException, ExisteException;
	void removerAnimal(String nomeAnimal, String loginDono) throws NullException;
	void removerUsuario(Usuario u) throws NullException, ElementoNaoExisteException;
	
}
