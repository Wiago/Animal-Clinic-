package br.ufrpe.animal_clinic.negocio;

import java.util.List;

import br.ufrpe.animal_clinic.dados.IRepositorioGenerico;
import br.ufrpe.animal_clinic.dados.RepositorioGenerico;
import br.ufrpe.animal_clinic.exception.ElementoJaExisteException;
import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class ControladorAnimal {
	private IRepositorioGenerico<Animal> repositorioAnimals;
    private static ControladorAnimal instance;
    private static ControladorUsuario repositorioUsuarios;
    
    private ControladorAnimal() {
        this.repositorioAnimals = new RepositorioGenerico<>("animais.txt");
    }

    public static ControladorAnimal getInstance() {
        if (instance == null) {
            instance = new ControladorAnimal();
        }
        return instance;
    }

    public void inserir(Animal obj) throws ElementoJaExisteException {
    	repositorioAnimals.inserir(obj);
    }

    public List<Animal> listar() {
        return repositorioAnimals.listar();
    }

    public void remover(Animal obj) throws ElementoNaoExisteException {
    	repositorioAnimals.remover(obj);
    }

    public void atualizar(Animal newObj) throws ElementoNaoExisteException {
    	repositorioAnimals.atualizar(newObj);
    }
    
    public Animal procurarPorNome(String nome) throws ElementoNaoExisteException {
		List<Animal> animais = repositorioAnimals.listar();
    	for(Animal a : animais) {
    		if(a.getNome().equals(nome)) {
    			return a;
    		}
    	}
		return null;
    }
    
    public Usuario procurarDono(String login) throws ElementoNaoExisteException {
		List<Usuario> usuarios = repositorioUsuarios.listar();
    	for(Usuario u : usuarios) {
    		if(u.getLogin().equals(login)) {
    			return u;
    		}
    	}
		return null;
    }
}
