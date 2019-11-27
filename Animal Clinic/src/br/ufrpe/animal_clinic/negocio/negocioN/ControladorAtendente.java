package br.ufrpe.animal_clinic.negocio.negocioN;

import java.util.List;

import br.ufrpe.animal_clinic.dados.dadosN.IRepositorioGenerico;
import br.ufrpe.animal_clinic.dados.dadosN.RepositorioGenerico;
import br.ufrpe.animal_clinic.exception.ElementoJaExisteException;
import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
import br.ufrpe.animal_clinic.negocio.beans.Atendente;

public class ControladorAtendente {
	private IRepositorioGenerico<Atendente> repositorioAtendentes;
    private static ControladorAtendente instance;
    
    private ControladorAtendente() {
        this.repositorioAtendentes = new RepositorioGenerico<>("usuarios.dat");
    }

    public static ControladorAtendente getInstance() {
        if (instance == null) {
            instance = new ControladorAtendente();
        }
        return instance;
    }

    public void inserir(Atendente obj) throws ElementoJaExisteException {
    	repositorioAtendentes.inserir(obj);
    }

    public List<Atendente> listar() {
        return repositorioAtendentes.listar();
    }

    public void remover(Atendente obj) throws ElementoNaoExisteException {
    	repositorioAtendentes.remover(obj);
    }

    public void atualizar(Atendente newObj) throws ElementoNaoExisteException {
    	repositorioAtendentes.atualizar(newObj);
    }
}
