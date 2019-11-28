package br.ufrpe.animal_clinic.negocio.negocioN;

import java.util.List;

import br.ufrpe.animal_clinic.dados.dadosN.IRepositorioGenerico;
import br.ufrpe.animal_clinic.dados.dadosN.RepositorioGenerico;
import br.ufrpe.animal_clinic.exception.*;
import br.ufrpe.animal_clinic.negocio.beans.*;

public class ControladorUsuario {
    
    private IRepositorioGenerico<Usuario> repositorioUsuarios;
    private static ControladorUsuario instance;
    
    private ControladorUsuario() {
        this.repositorioUsuarios = new RepositorioGenerico<>("usuarios.dat");
    }

    public static ControladorUsuario getInstance() {
        if (instance == null) {
            instance = new ControladorUsuario();
        }
        return instance;
    }

    public void inserir(Usuario obj) throws ElementoJaExisteException {
        repositorioUsuarios.inserir(obj);
    }

    public List<Usuario> listar() {
        return repositorioUsuarios.listar();
    }

    public void remover(Usuario obj) throws ElementoNaoExisteException {
        repositorioUsuarios.remover(obj);
    }

    public void atualizar(Usuario newObj) throws ElementoNaoExisteException {
        repositorioUsuarios.atualizar(newObj);
    }
    
    public Usuario procurarPorLogin(String login) throws ElementoNaoExisteException {
    	List<Usuario> usuarios = repositorioUsuarios.listar();
    	for(Usuario u : usuarios) {
    		if(u.getLogin().equals(login)) {
    			return u;
    		}
    	}
		return null;
    }
    
}
