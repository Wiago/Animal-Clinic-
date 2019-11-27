package br.ufrpe.animal_clinic.negocio.negocioN;

import java.util.List;

import br.ufrpe.animal_clinic.dados.dadosN.IRepositorioGenerico;
import br.ufrpe.animal_clinic.dados.dadosN.RepositorioGenerico;
import br.ufrpe.animal_clinic.exception.ElementoJaExisteException;
import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
import br.ufrpe.animal_clinic.negocio.beans.Animal;

public class ControladorAnimal {
	private IRepositorioGenerico<Animal> repositorioAnimals;
    private static ControladorAnimal instance;
    
    private ControladorAnimal() {
        this.repositorioAnimals = new RepositorioGenerico<>("usuarios.dat");
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
}
