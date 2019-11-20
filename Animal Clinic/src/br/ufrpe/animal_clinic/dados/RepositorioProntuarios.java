package br.ufrpe.animal_clinic.dados;

import java.util.ArrayList;
import java.util.Date;

import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Cirurgia;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.negocio.beans.Prontuario;


public class RepositorioProntuarios {
	ArrayList<Prontuario> prontuarios = new ArrayList<Prontuario>(10);
	
	public RepositorioProntuarios(int tamanho) {
        this.prontuarios = new ArrayList<Prontuario>(tamanho);
    }

    public void RepositorioUsuarios(ArrayList<Prontuario> prontuario) {
        this.prontuarios = prontuario;
    }


	public void cadastrar(Prontuario p) throws ExisteException{
		
		try {
            procurar(p.getId());
        } catch (NullException ex) {
            prontuarios.add(p);
        }

	}

	
	public Prontuario procurar(String id) throws NullException{
		Prontuario u = null;
		boolean continuar = true;

		for (int j = 0; j < prontuarios.size() && continuar; j++) {
			if (prontuarios.get(j).getId().equals(id)) {
				u = prontuarios.get(j);
	            continuar = false;
			}
	    }

		if (u == null) {
            NullException e = new NullException();
            throw e;
        }
	    
	    return u;
	}
	public Prontuario procurar(Prontuario p) throws NullException {
		 Prontuario get = null;
	     boolean continuar = true;
	     for (int i = 0; i < prontuarios.size() && continuar == true; i++) {
	    	 get = prontuarios.get(i);
	    	 if(get.getId().equals(p.getId())) { 
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

	public void remover(String id) throws NullException {
		try {
			Prontuario u = procurar(id);
			prontuarios.remove(u);
		}catch(NullException ex){
			NullException e = new NullException();
            throw e;
		}   
    }
	
	public ArrayList<Prontuario> listarPorData(Date d) throws NullException{
		  ArrayList<Prontuario> listaProntuarios = new ArrayList<Prontuario>();
	      for (Prontuario prontuario : prontuarios) {
	    	  if(prontuario.getData().equals(d)) {
	    		  listaProntuarios.add(prontuario);
	    	  }
	      }
	      if(listaProntuarios.size() == 0) {
	    	  throw new NullException();
	      }
	      return listaProntuarios;
	  }
}
