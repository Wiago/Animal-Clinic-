package br.ufrpe.animal_clinic.negocio.negocioN;

import java.util.List;

import br.ufrpe.animal_clinic.dados.dadosN.IRepositorioGenerico;
import br.ufrpe.animal_clinic.dados.dadosN.RepositorioGenerico;
import br.ufrpe.animal_clinic.exception.ElementoJaExisteException;
import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
import br.ufrpe.animal_clinic.negocio.beans.Medico;

public class ControladorMedico {
	private IRepositorioGenerico<Medico> repositorioMedicos;
    private static ControladorMedico instance;
    
    private ControladorMedico() {
        this.repositorioMedicos = new RepositorioGenerico<>("usuarios.dat");
    }

    public static ControladorMedico getInstance() {
        if (instance == null) {
            instance = new ControladorMedico();
        }
        return instance;
    }

    public void inserir(Medico obj) throws ElementoJaExisteException {
    	repositorioMedicos.inserir(obj);
    }

    public List<Medico> listar() {
        return repositorioMedicos.listar();
    }

    public void remover(Medico obj) throws ElementoNaoExisteException {
    	repositorioMedicos.remover(obj);
    }

    public void atualizar(Medico newObj) throws ElementoNaoExisteException {
    	repositorioMedicos.atualizar(newObj);
    }
}
