package br.ufrpe.animal_clinic.negocio;

import java.time.LocalDate;
import java.util.List;

import br.ufrpe.animal_clinic.dados.IRepositorioGenerico;
import br.ufrpe.animal_clinic.dados.RepositorioGenerico;
import br.ufrpe.animal_clinic.exception.ElementoJaExisteException;
import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
import br.ufrpe.animal_clinic.negocio.beans.Prontuario;

public class ControladorProntuario {
	private IRepositorioGenerico<Prontuario> repositorioProntuarios;
    private static ControladorProntuario instance;
    
    private ControladorProntuario() {
        this.repositorioProntuarios = new RepositorioGenerico<>("prontuarios.txt");
    }

    public static ControladorProntuario getInstance() {
        if (instance == null) {
            instance = new ControladorProntuario();
        }
        return instance;
    }

    public void inserir(Prontuario obj) throws ElementoJaExisteException {
        repositorioProntuarios.inserir(obj);
    }

    public List<Prontuario> listar() {
        return repositorioProntuarios.listar();
    }

    public void remover(Prontuario obj) throws ElementoNaoExisteException {
        repositorioProntuarios.remover(obj);
    }

    public void atualizar(Prontuario newObj) throws ElementoNaoExisteException {
        repositorioProntuarios.atualizar(newObj);
    }
    
    public Prontuario procurarPorId(String id) throws ElementoNaoExisteException {
    	Prontuario con = null;
    	List<Prontuario> prontuario = listar();
    	for(Prontuario u : prontuario) {
    		con = u;
    		if(u.getId().equals(id)) {
    			return con;
    		}
    	}
		throw new ElementoNaoExisteException(id);
    }
    
    public Prontuario procurarPorDataHora(LocalDate data, String hora) throws ElementoNaoExisteException {
    	Prontuario con = null;
    	List<Prontuario> prontuario = listar();
    	for(Prontuario u : prontuario) {
    		con = u;
    		if(u.getConsulta().getData().isEqual(data) && u.getConsulta().getData().equals(hora)) {
    			return con;
    		}
    		con = null;
    	}
    	throw new ElementoNaoExisteException(hora);
    }
}
