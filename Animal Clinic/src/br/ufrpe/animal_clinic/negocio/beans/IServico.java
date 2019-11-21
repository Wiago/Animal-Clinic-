package br.ufrpe.animal_clinic.negocio.beans;

import java.io.IOException;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NotFoundException;
import br.ufrpe.animal_clinic.exception.NullException;


public interface IServico {
	
	void cadastrarUsuario(Usuario u) throws ExisteException, NullException;
	void cadastrarConsulta(Consulta c) throws NullException, ExisteException;
	void cadastrarCirurgia(Cirurgia c) throws NullException, ExisteException;
	void removerUsuario(String id) throws NullException;
	void desmarcarConsulta(String id) throws NullException;
	void desmarcarCirurgia(String id) throws NullException;
    void carregarDados()throws IOException, NotFoundException, ClassNotFoundException;
    
    Atendente efetuarLoginRecepcionista(Login l) throws NullException ;
	Medico efetuarLoginMedico(Login l) throws NullException ;
	Usuario efetuarLoginUsuario(Login l) throws NullException ;
	
	Medico procurarMedico(String id) throws NullException ;
	Usuario procurarUsuario(String id) throws NullException ;
	Atendente procurarAtendente(String id) throws NullException ;
    
	
	void salvarDados() throws IOException;
	void marcarExame(Exame e) throws NullException, ExisteException;

}
