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

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

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
	
	public void salvarDados(String file) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		System.out.println(animais);

        Writer writer = Files.newBufferedWriter(Paths.get(file));
        StatefulBeanToCsv<Animal> beanToCsv = new StatefulBeanToCsvBuilder<Animal>(writer).build();
        
        
        beanToCsv.write(animais);
        writer.flush();
        writer.close();
	}
	
	public void carregarDados(String file) throws ClassNotFoundException, FileNotFoundException {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		BufferedReader csvReader = null;
		String csvLine = null;
		try {
			csvReader = new BufferedReader(new FileReader(file));
			csvReader.readLine(); // ignore header!
			System.out.println("Linhas no arquivo(Animais):");
			while ((csvLine = csvReader.readLine()) != null) {
				System.out.println(csvLine);
				animals.add(RepositorioAnimais.of(csvLine)); // create animal object and add to repository
			}

		} catch (Exception e) {
			System.out.println("Erro ao ler arquivo!! | Linha lida: " + csvLine);
			e.printStackTrace();

		} finally {
			closeFile(csvReader);
		}
		animais.addAll(animals);
		System.out.println("Animais no arquivo (toString):");
		System.out.println(animais);
	}
	
	public static Animal of(String csvLine) throws ParseException, NullException {
		// 0 1 2 3 4 5 6 7 8 9 10
		// "alimentacao","dono","especie","estaVivo","genero","idDono","nome","nomeDono","oAnimalEMae","serialVersionUID","tempoDeVida"
		// String nome, Usuario dono, Alimentacao alimentacao, Especie especie, Genero genero, TempoDeVida tempoDeVida
		String[] dados = csvLine.split(",");
		String oldString = String.valueOf('"');
		Usuario user1 = donos.procurar(dados[5].replaceAll(oldString,""));
		Animal a = new Animal(null,user1,null,null,null,null);
		try {
			a.setNome(dados[6].replaceAll(oldString,""));
			a.setAlimentacao(Alimentacao.valueOf(dados[0].replaceAll(oldString,"")));
			a.setEspecie(Especie.valueOf(dados[2].replaceAll(oldString,"")));
			a.setGenero(Genero.valueOf(dados[4].replaceAll(oldString,"")));
			a.setTempoDeVida(TempoDeVida.valueOf(dados[10].replaceAll(oldString,"")));
		} catch (Exception e) {
//			System.err.println("Erro ao converter linha do CSV em um usuário! | Linha lida: " + linha);
//			e.printStackTrace();
			
			return null;
		}
		return a;
	}
	
	private static void closeFile(BufferedReader csvReader) {
		try {
			csvReader.close();
		} catch (IOException e) {
			System.out.println("Erro ao fechar arquivo!!");
			e.printStackTrace();
		}
	}
	
}
