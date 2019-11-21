package br.ufrpe.animal_clinic.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Cirurgia;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.negocio.beans.Prontuario;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;


public class RepositorioProntuarios {
	ArrayList<Prontuario> prontuarios = new ArrayList<Prontuario>(10);
	
	public RepositorioProntuarios(ArrayList<Prontuario> arrayList) {
        this.prontuarios = new ArrayList<Prontuario>(arrayList);
    }
	
	public RepositorioProntuarios(int a) {
        this.prontuarios = new ArrayList<Prontuario>(a);
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

	
	public ArrayList<Prontuario> getProntuarios() {
		return prontuarios;
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
	
	public void salvarDados(String file) throws IOException {
	    File arquivo = new File(file);
	    FileOutputStream fos = new FileOutputStream(arquivo);
	    ObjectOutputStream ous = new ObjectOutputStream(fos);
	    ous.writeObject(this.getProntuarios());
	    ous.close();
	}
	
	public void carregarDados(String file) throws ClassNotFoundException, FileNotFoundException {
	    
	    File arquivo = new File(file);
	    FileInputStream fis;
	    ObjectInputStream ois;
	    fis = new FileInputStream(arquivo);

		try {
		    ois = new ObjectInputStream(fis);
		    RepositorioProntuarios a = new RepositorioProntuarios((ArrayList<Prontuario>) ois.readObject());
		    ois.close();
   
		}	catch (IOException ex) {
			RepositorioProntuarios a = new RepositorioProntuarios(20);
		}
	}
}
