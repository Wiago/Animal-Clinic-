package br.ufrpe.animal_clinic.negocio;

import java.time.LocalDate;
import java.util.List;

import br.ufrpe.animal_clinic.dados.IRepositorioGenerico;
import br.ufrpe.animal_clinic.dados.RepositorioGenerico;
import br.ufrpe.animal_clinic.exception.ElementoJaExisteException;
import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;

public class ControladorSolicitarConsulta {
	private IRepositorioGenerico<Consulta> repositorioConsultas;
    private static ControladorSolicitarConsulta instance;
    
    private ControladorSolicitarConsulta() {
        this.repositorioConsultas = new RepositorioGenerico<>("consultasSolicitadas.txt");
    }

    public static ControladorSolicitarConsulta getInstance() {
        if (instance == null) {
            instance = new ControladorSolicitarConsulta();
        }
        return instance;
    }

    public void inserir(Consulta obj) throws ElementoJaExisteException {
        repositorioConsultas.inserir(obj);
    }

    public List<Consulta> listar() {
        return repositorioConsultas.listar();
    }

    public void remover(Consulta obj) throws ElementoNaoExisteException {
        repositorioConsultas.remover(obj);
    }

    public void atualizar(Consulta newObj) throws ElementoNaoExisteException {
        repositorioConsultas.atualizar(newObj);
    }
    
    public Consulta procurarPorId(String id) throws ElementoNaoExisteException {
    	Consulta con = null;
    	List<Consulta> consultas = listar();
    	for(Consulta u : consultas) {
    		con = u;
    		if(u.getId().equals(id)) {
    			return con;
    		}
    	}
		throw new ElementoNaoExisteException(id);
    }
    
    public Consulta procurarPorDataHora(LocalDate data, String hora) throws ElementoNaoExisteException {
    	Consulta con = null;
    	List<Consulta> consultas = listar();
    	for(Consulta u : consultas) {
    		con = u;
    		if(u.getData().isEqual(data) && u.getHora().equals(hora)) {
    			return con;
    		}
    		con = null;
    	}
    	throw new ElementoNaoExisteException(hora);
    }
}
