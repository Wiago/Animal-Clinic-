package br.ufrpe.animal_clinic.dados;

import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.animal_clinic.negocio.beans.Cirurgia;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.exception.*;

public class RepositorioCirurgias implements Serializable{

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<Cirurgia> cirurgias;

	 public RepositorioCirurgias(int tamanho) {
		 this.cirurgias = new ArrayList<Cirurgia>(tamanho);
	 }

	 public RepositorioCirurgias(ArrayList<Cirurgia> cirurgias) {
		 this.cirurgias = cirurgias;
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
            throw new NullException();
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
	  
	  public void salvarDados(String file) throws IOException {
		    File arquivo = new File(file);
		    FileOutputStream fos = new FileOutputStream(arquivo);
		    ObjectOutputStream ous = new ObjectOutputStream(fos);
		    ous.writeObject(this.getDados());
		    ous.close();
		}
		
	  public void carregarDados(String file) throws ClassNotFoundException, FileNotFoundException {
		    
		    File arquivo = new File(file);
		    FileInputStream fis;
		    ObjectInputStream ois;
		    fis = new FileInputStream(arquivo);

			try {
			    ois = new ObjectInputStream(fis);
			    RepositorioCirurgias a = new RepositorioCirurgias((ArrayList<Cirurgia>) ois.readObject());
			    ois.close();
	   
			}	catch (IOException ex) {
				RepositorioCirurgias a = new RepositorioCirurgias(20);
			}
	  }
}
