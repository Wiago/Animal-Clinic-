package br.ufrpe.animal_clinic.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Cirurgia;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.negocio.beans.Exame;
import br.ufrpe.animal_clinic.negocio.beans.Prontuario;


public class RepositorioExames implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static RepositorioExames instancia;
	ArrayList<Exame> exames = new ArrayList<Exame>();

	private RepositorioExames() {
	    this.exames = new ArrayList<Exame>();
	}
	
	/*public RepositorioExames(ArrayList<Exame> usuarios) {
	    this.exames = usuarios;
	}*/
	 
	 public static RepositorioExames getInstancia() {
		 if(instancia == null) {
			 instancia = new RepositorioExames();
		 }
		 return instancia;
	 }
	
	
	public ArrayList<Exame> getExames() {
		return exames;
	}

	public void cadastrar(Exame e) throws ExisteException, NullException{
			Exame exame = e;
			if(exames.size() > 0 && exame != null) {
				exame = procurar(e.getId());
				if(exame == null) {
					exames.add(exame);
				}
				else {
					throw new ExisteException();
				}
			}
			if(exames.size() == 0 && exame != null) {
				exames.add(exame);
			}
			else {
				throw new NullException();
			}
	}
	
	
	public Exame procurar(String id) throws NullException{
		Exame e = null;
		boolean continuar = true;
		for (int j = 0; j < exames.size() && continuar; j++) {
			if (exames.get(j).getId().equals(id)) {
				e = exames.get(j);
	            continuar = false;
			}
	    }
	
		if (e == null) {
	        NullException c = new NullException();
	        throw c;
	    }
	    
	    return e;
	}
	
	public Exame procurar(Exame e) throws NullException {
		 Exame get = null;
	     boolean continuar = true;
	     for (int i = 0; i < exames.size() && continuar == true; i++) {
	    	 get = exames.get(i);
	    	 if(get.getId().equals(e.getId())) { 
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
			Exame e = procurar(id);
			exames.remove(e);
		}catch(NullException ex){
			NullException c = new NullException();
	        throw c;
		}
	    
	}
	
	 
	public ArrayList<Exame> getDados() {
		return exames;
	}
		
	public ArrayList<Exame> listarPorData(Date d) throws NullException{
		  ArrayList<Exame> listaExames = new ArrayList<Exame>();
	      for (Exame exame : exames) {
	    	  if(exame.getData().equals(d)) {
	    		  listaExames.add(exame);
	    	  }
	      }
	      if(listaExames.size() == 0) {
	    	  throw new NullException();
	      }
	      return listaExames;
	}
	
	public void salvarDados(String file) throws IOException {
	    File arquivo = new File(file);
	    FileOutputStream fos = new FileOutputStream(arquivo);
	    ObjectOutputStream ous = new ObjectOutputStream(fos);
	    ous.writeObject(this.getDados());
	    ous.close();
	}
	
	public void carregarDados(String file) throws ClassNotFoundException, FileNotFoundException {
	    
	    
	}
}
