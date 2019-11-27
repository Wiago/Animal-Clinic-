package br.ufrpe.animal_clinic.dados;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Cirurgia;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.negocio.beans.Exame;
import br.ufrpe.animal_clinic.negocio.beans.Medico;

import java.util.Map;

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
import java.util.Date;
import java.util.HashMap;

public class RepositorioConsultas implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static RepositorioConsultas instancia;
	private static RepositorioUsuarios repoUsuarios;
	private static RepositorioAnimais repoAnimais;
	private ArrayList<Consulta> consultas;
	
	/*public RepositorioConsultas(int tam) {
		consultas = new ArrayList(tam);
	}*/
	
	private RepositorioConsultas() {
		 this.consultas = new ArrayList<Consulta>();
		 repoUsuarios = RepositorioUsuarios.getInstancia();
		 repoAnimais = RepositorioAnimais.getInstancia();
	 }
	 
	 public static RepositorioConsultas getInstancia() {
		 if(instancia == null) {
			 instancia = new RepositorioConsultas();
		 }
		 return instancia;
	 }
	 public static RepositorioUsuarios getRepoUsuarios() {
			return repoUsuarios;
	}

	public static RepositorioAnimais getRepoAnimais() {
		return repoAnimais;
	}
		
	public ArrayList<Consulta> getCirurgias(){
		return consultas;
	}

	public void cadastrarConsulta(Consulta c) {
		 try {
	         this.procurar(c);
	     } catch (NullException ex) {
	    	 consultas.add(c);
	     }
	 }
	     
	 public Consulta procurar(Consulta c) throws NullException {
		 Consulta get = null;
	     boolean continuar = true;
	     for (int i = 0; i < consultas.size() && continuar == true; i++) {
	    	 get = consultas.get(i);
	    	 if(get.getId().equals(c.getId())) { 
	    		 continuar = false;
	    	 }
	    	 else {
	    		 get = null;
	    	 }
	     }
	     if (get == null) {
           throw new NullException();
	     }
	     return c;
	  }

	 public Consulta procurar(String id) throws NullException {
		 Consulta get = null;
	     boolean continuar = true;
	     for (int i = 0; i < consultas.size() && continuar == true; i++) {
	    	 get = consultas.get(i);
	    	 if(get.getId().equals(id)) { 
	    		 continuar = false;
	    	 }
	    	 else {
	    		 get = null;
	    	 }
	     }
	     if (get == null) {
           throw new NullException();
	     }
	     return get;
	  }
	 
	  public ArrayList<Consulta> listarPorData(Date d) throws NullException{
		  ArrayList<Consulta> listaConsultas = new ArrayList<Consulta>();
	      for (Consulta con : consultas) {
	    	  if(con.getData().equals(d)) {
	    		  listaConsultas.add(con);
	    	  }
	      }
	      if(listaConsultas.size() == 0) {
	    	  throw new NullException();
	      }
	      return listaConsultas;
	  }
	       
	  public void remover(Consulta c) throws NullException{
		  try {
			  Consulta con = this.procurar(c);
			  consultas.remove(con);
		  }
		  catch(NullException ne) {
			  throw ne;
		  }
		  
	  }
	        
	  public ArrayList<Consulta> getDados() {
		  return this.consultas;
	  }
	  
	  
	  public void salvarDados(String file) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
	        Writer writer = Files.newBufferedWriter(Paths.get(file));
	        StatefulBeanToCsv<Consulta> beanToCsv = new StatefulBeanToCsvBuilder<Consulta>(writer).build();
	        beanToCsv.write(consultas);
	        System.out.println(consultas);
	        writer.flush();
	        writer.close();
		}
		
	  public void carregarDados(String file) throws ClassNotFoundException, FileNotFoundException {
		  	ArrayList<Consulta> cons = new ArrayList<Consulta>();
			BufferedReader csvReader = null;
			String csvLine = null;
			System.out.println("ok");
			try {
				csvReader = new BufferedReader(new FileReader(file));
				csvReader.readLine(); // ignore header!

				while ((csvLine = csvReader.readLine()) != null) {
					System.out.println(csvLine);
					cons.add(RepositorioConsultas.of(csvLine)); // create usuario object and add to repository
				}

			} catch (Exception e) {
				System.out.println("Erro ao ler arquivo!! | Linha lida: " + csvLine);
				e.printStackTrace();

			} finally {
				closeFile(csvReader);
			}
			
			consultas.addAll(cons);
			System.out.println(consultas);
	  }
	  
	  private static void closeFile(BufferedReader csvReader) {
			try {
				csvReader.close();
			} catch (IOException e) {
				System.out.println("Erro ao fechar arquivo!!");
				e.printStackTrace();
			}
	  }
	  
	  public static Consulta of(String csvLine) throws ParseException, NullException {

			// 0 1 2 3 4 5 6 7 8
			// "animal","data","dataS","id","idDonoAnimal","idMedico","medico","nomeAnimal","serialVersionUID"
			//Animal animal, Medico medico, Date data
			String[] dados = csvLine.split(",");
			String oldString = String.valueOf('"');
			SimpleDateFormat formatter = new SimpleDateFormat("dd/M/yyyy"); 
			Consulta c = new Consulta(null, null, null);
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
