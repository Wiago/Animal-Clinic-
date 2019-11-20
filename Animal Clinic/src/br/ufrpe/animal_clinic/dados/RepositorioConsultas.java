package br.ufrpe.animal_clinic.dados;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Cirurgia;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import java.util.Map;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
public class RepositorioConsultas {
	private ArrayList<Consulta> consultas;
	
	public RepositorioConsultas(int tam) {
		consultas = new ArrayList(tam);
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
