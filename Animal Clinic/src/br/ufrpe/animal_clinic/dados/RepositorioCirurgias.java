package br.ufrpe.animal_clinic.dados;

import java.util.Date;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Cirurgia;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;
import br.ufrpe.animal_clinic.exception.*;

public class RepositorioCirurgias implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static RepositorioCirurgias instancia; 
	private static RepositorioUsuarios repoUsuarios;
	private static RepositorioAnimais repoAnimais;
	
	private ArrayList<Cirurgia> cirurgias;

	 /*public RepositorioCirurgias(int tamanho) {
		 this.cirurgias = new ArrayList<Cirurgia>(tamanho);
	 }*/

	 private RepositorioCirurgias() {
		 this.cirurgias = new ArrayList<Cirurgia>();
		 repoUsuarios = RepositorioUsuarios.getInstancia();
		 repoAnimais = RepositorioAnimais.getInstancia();
	 }
	 
	 public static RepositorioCirurgias getInstancia() {
		 if(instancia == null) {
			 instancia = new RepositorioCirurgias();
		 }
		 return instancia;
	 }

	 public static RepositorioUsuarios getRepoUsuarios() {
		return repoUsuarios;
	}

	public static RepositorioAnimais getRepoAnimais() {
		return repoAnimais;
	}
	
	public ArrayList<Cirurgia> getCirurgias(){
		return cirurgias;
	}
	public void cadastrar(Cirurgia c) throws ExisteException, NullException{
			 if(cirurgias.size() == 0) {
				 cirurgias.add(c);
			 }
			 else {
				 Cirurgia c1 = this.procurar(c);
				 if(c1 == null) {
					 cirurgias.add(c);
				 }
				 else {
					 throw new ExisteException();
				 }
			 }
	 }
	     
	 public Cirurgia procurar(Cirurgia c) throws NullException {
		 Cirurgia get = null;
	     boolean continuar = true;
	     for (int i = 0; i < cirurgias.size() && continuar == true; i++) {
	    	 if(cirurgias.get(i).getId().equals(c.getId())) { 
	    		 get = cirurgias.get(i);
	    		 continuar = false;
	    	 }
	     }
	     if (get == null) {
            return null;
	     }
	     return get;
	  }
	 
	 public Cirurgia procurar(String id) throws NullException {
		 Cirurgia get = null;
	     boolean continuar = true;
	     for (int i = 0; i < cirurgias.size() && continuar == true; i++) {
	    	 if(cirurgias.get(i).getId().equals(id)) { 
	    		 get = cirurgias.get(i);
	    		 continuar = false;
	    	 }
	     }
	     if (get == null) {
           throw new NullException();
	     }
	     return get;
	  } 
	       
	  public void remover(Cirurgia c) throws NullException{
		  try {
			  this.procurar(c);
			  cirurgias.remove(c);
		  }
		  catch(NullException ne) {
			  throw ne;
		  }
		  
      }
	        
	  public ArrayList<Cirurgia> getDados() {
	        return this.cirurgias;
	  }
	  
	  public ArrayList<Cirurgia> listarPorData(Date d) throws NullException{
		  ArrayList<Cirurgia> listaCirurgias = new ArrayList<Cirurgia>();
	      for (Cirurgia cirurgia : cirurgias) {
	    	  if(cirurgia.getData().equals(d)) {
	    		  listaCirurgias.add(cirurgia);
	    	  }
	      }
	      if(listaCirurgias.size() == 0) {
	    	  throw new NullException();
	      }
	      return listaCirurgias;
	  }
	  
	  public void salvarDados(String file) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
	        Writer writer = Files.newBufferedWriter(Paths.get(file));
	        StatefulBeanToCsv<Cirurgia> beanToCsv = new StatefulBeanToCsvBuilder<Cirurgia>(writer).build();
	        beanToCsv.write(cirurgias);
	        System.out.println(cirurgias);
	        writer.flush();
	        writer.close();
		}
		
	  public void carregarDados(String file) throws ClassNotFoundException, FileNotFoundException {
		  	ArrayList<Cirurgia> cirur = new ArrayList<Cirurgia>();
			BufferedReader csvReader = null;
			String csvLine = null;
			System.out.println("ok");
			try {
				csvReader = new BufferedReader(new FileReader(file));
				csvReader.readLine(); // ignore header!

				while ((csvLine = csvReader.readLine()) != null) {
					System.out.println(csvLine);
					cirur.add(RepositorioCirurgias.of(csvLine)); // create cirurgia object and add to repository
				}

			} catch (Exception e) {
				System.out.println("Erro ao ler arquivo!! | Linha lida: " + csvLine);
				e.printStackTrace();

			} finally {
				closeFile(csvReader);
			}
			
			cirurgias.addAll(cirur);
			System.out.println(cirurgias);
	  }
	  
	  private static void closeFile(BufferedReader csvReader) {
			try {
				csvReader.close();
			} catch (IOException e) {
				System.out.println("Erro ao fechar arquivo!!");
				e.printStackTrace();
			}
	  }
	  
	  public static Cirurgia of(String csvLine) throws ParseException, NullException {

			// 0 1 2 3 4 5 6 7 8
			// "animal","data","dataS","id","idDonoAnimal","idMedico","medico","nomeAnimal","serialVersionUID"
			//Animal animal, Medico medico, Date data
			String[] dados = csvLine.split(",");
			String oldString = String.valueOf('"');
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
			Cirurgia c = new Cirurgia(null, null, null);
			Animal a;
			Medico m;
			Date data1 = formatter.parse(dados[2].replaceAll(oldString,""));
			a = repoAnimais.procurarPorIdDoDono(dados[7].replaceAll(oldString,""), dados[4].replaceAll(oldString,""));
			m = repoUsuarios.procurarMedico(dados[5].replaceAll(oldString,""));
			c.setAnimal(a);
			c.setMedico(m);
			c.setData(data1);
			c.setNomeAnimal(dados[7].replaceAll(oldString,""));
			c.setIdDonoAnimal(dados[4].replaceAll(oldString,""));
			c.setIdMedico(dados[5].replaceAll(oldString,""));
			c.setDataS(dados[2].replaceAll(oldString,""));
			c.setIdCSV(dados[3].replaceAll(oldString,""));
			return c;
		}
}
