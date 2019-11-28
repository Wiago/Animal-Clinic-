package br.ufrpe.animal_clinic.dados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;


import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Alimentacao;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Especie;
import br.ufrpe.animal_clinic.negocio.beans.Genero;
import br.ufrpe.animal_clinic.negocio.beans.TempoDeVida;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;
import br.ufrpe.animal_clinic.dados.RepositorioUsuarios;

public class RepositorioAnimais implements Serializable{
	private static RepositorioAnimais instancia;
	private static RepositorioUsuarios donos;
	private ArrayList<Animal> animais;
	
	
	private RepositorioAnimais() {
		animais = new ArrayList<Animal>();
		donos = RepositorioUsuarios.getInstancia();
	}
	
	public static RepositorioAnimais getInstancia() {
		if(instancia == null) {
			instancia = new RepositorioAnimais();
		}
		return instancia;
	}

	public ArrayList<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(ArrayList<Animal> animais) {
		this.animais = animais;
	}
	
	public void cadastrar(Animal a) throws ExisteException{
		try {
            procurarPorIdDoDono(a.getNome(), a.getDono().getId());
        } catch (NullException ex) {
            animais.add(a);
        }

	}

	
	public Animal procurarPorIdDoDono(String nomeAnimal, String idDono) throws NullException{
		Animal a = null;
		boolean continuar = true;

		for (int j = 0; j < animais.size() && continuar; j++) {
			if ((animais.get(j).getDono().getId().equals(idDono))&&(animais.get(j).getNome().equals(nomeAnimal))) {
				a = animais.get(j);
	            continuar = false;
			}
	    }

		if (a == null) {
            NullException e = new NullException();
            throw e;
        }
	    
	    return a;
	}
	
	public Animal procurarPorLoginDoDono(String nomeAnimal,String loginDono) throws NullException{
		Animal a = null;
		boolean continuar = true;

		for (int j = 0; j < animais.size() && continuar; j++) {
			if ((animais.get(j).getDono().getLogin().equals(loginDono))&&(animais.get(j).getNome().equals(nomeAnimal))) {
				a = animais.get(j);
	            continuar = false;
			}
	    }

		if (a == null) {
            NullException e = new NullException();
            throw e;
        }
	    
	    return a;
	}
	
	public ArrayList<Animal> listarPorDono(String login) throws NullException{
		  ArrayList<Animal> listaAnimais = new ArrayList<Animal>();
	      for (Animal animal : animais) {
	    	  if(animal.getDono().getLogin().equals(login)) {
	    		  listaAnimais.add(animal);
	    	  }
	      }
	      if(listaAnimais.size() == 0) {
	    	  throw new NullException();
	      }
	      return listaAnimais;
	}

	public void animalMorre(Animal a) throws NullException {
		if(procurarPorIdDoDono(a.getNome(), a.getDono().getId()) != null) {
			a.setEstaVivo(false);
		}
	}
	
	public void animalEMae(Animal a) throws NullException {
		if(procurarPorIdDoDono(a.getNome(), a.getDono().getId()) != null) {
			a.setoAnimalEMae(true);
		}
	}
	public void animalNaoEMae(Animal a) throws NullException {
		if(procurarPorIdDoDono(a.getNome(), a.getDono().getId()) != null) {
			a.setoAnimalEMae(false);
		}
	}
	
	public void alterarNomeAnimal(Animal a, String novoNome) throws NullException {
		if(procurarPorIdDoDono(a.getNome(), a.getDono().getId()) != null) {
			a.setNome(novoNome);;
		}
	}
	public void alterarNomeDono(Animal a, String novoNome) throws NullException {
		if(procurarPorIdDoDono(a.getNome(), a.getDono().getId()) != null) {
			a.getDono().setNome(novoNome);;
		}
	}
	
	public void removerPorIdDoDono(String nomeAnimal, String idDono) throws NullException {
		try {
			Animal a = procurarPorIdDoDono(nomeAnimal, idDono);
			animais.remove(a);
		}catch(NullException ex){
			NullException e = new NullException();
            throw e;
		}
        
    }
	
	public void removerPorLoginDoDono(String nomeAnimal, String loginDono) throws NullException {
		try {
			Animal a = procurarPorLoginDoDono(nomeAnimal, loginDono);
			animais.remove(a);
		}catch(NullException ex){
			NullException e = new NullException();
            throw e;
		}
        
    }
	
}
