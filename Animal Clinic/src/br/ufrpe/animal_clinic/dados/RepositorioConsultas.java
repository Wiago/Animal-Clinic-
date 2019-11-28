package br.ufrpe.animal_clinic.dados;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Cirurgia;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.negocio.beans.Exame;
import br.ufrpe.animal_clinic.negocio.beans.Medico;

import java.util.Map;


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
	  
}
