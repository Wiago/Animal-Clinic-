package br.ufrpe.animal_clinic.negocio.negocioN;

import java.time.LocalDate;
import java.util.List;

import br.ufrpe.animal_clinic.dados.IRepositorioGenerico;
import br.ufrpe.animal_clinic.dados.RepositorioGenerico;
import br.ufrpe.animal_clinic.exception.ElementoJaExisteException;
import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
import br.ufrpe.animal_clinic.negocio.ControladorProntuario;
import br.ufrpe.animal_clinic.negocio.beans.Exame;
import br.ufrpe.animal_clinic.negocio.beans.Prontuario;

public class ControladorExame {
	private IRepositorioGenerico<Exame> repositorioExames;
    private static ControladorExame instance;
    
    private ControladorExame() {
        this.repositorioExames = new RepositorioGenerico<>("exames.txt");
    }

    public static ControladorExame getInstance() {
        if (instance == null) {
            instance = new ControladorExame();
        }
        return instance;
    }

    public void inserir(Exame obj) throws ElementoJaExisteException {
        repositorioExames.inserir(obj);
    }

    public List<Exame> listar() {
        return repositorioExames.listar();
    }

    public void remover(Exame obj) throws ElementoNaoExisteException {
        repositorioExames.remover(obj);
    }

    public void atualizar(Exame newObj) throws ElementoNaoExisteException {
        repositorioExames.atualizar(newObj);
    }
    
    public Exame procurarPorId(String id) throws ElementoNaoExisteException {
    	Exame con = null;
    	List<Exame> exames = listar();
    	for(Exame u : exames) {
    		con = u;
    		if(u.getId().equals(id)) {
    			return con;
    		}
    	}
		throw new ElementoNaoExisteException(id);
    }
    
    public Exame procurarPorDataHora(LocalDate data, String hora) throws ElementoNaoExisteException {
    	Exame con = null;
    	List<Exame> exames = listar();
    	for(Exame u : exames) {
    		con = u;
    		if(u.getData().isEqual(data) && u.getHora().equals(hora)) {
    			return con;
    		}
    		con = null;
    	}
    	throw new ElementoNaoExisteException(hora);
    }
}
