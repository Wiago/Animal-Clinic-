package br.ufrpe.animal_clinic.dados;

import java.util.Date;
import java.util.ArrayList;

import br.ufrpe.animal_clinic.negocio.beans.Cirurgia;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.exception.*;

public class RepositorioCirurgia {

	 ArrayList<Cirurgia> cirurgias;

	 public RepositorioCirurgia(int tamanho) {
		 this.cirurgias = new ArrayList<Cirurgia>(tamanho);
	 }

	 public RepositorioCirurgia(ArrayList<Cirurgia> cirurgias) {
		 this.cirurgias = cirurgias;
	 }
	    
	 public void cadastrar(Cirurgia c) {
		 try {
	         this.procurar(c);
	     } catch (NullException ex) {
	    	 cirurgias.add(c);
	     }
	 }
	     
	 public Cirurgia procurar(Cirurgia c) throws NullException {
		 Cirurgia get = null;
	     boolean continuar = true;
	     for (int i = 0; i < cirurgias.size() && continuar == true; i++) {
	    	 get = cirurgias.get(i);
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
	     return get;
	  }
	 public Cirurgia procurar(String id) throws NullException {
		 Cirurgia get = null;
	     boolean continuar = true;
	     for (int i = 0; i < cirurgias.size() && continuar == true; i++) {
	    	 get = cirurgias.get(i);
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
}
