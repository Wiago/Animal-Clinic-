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
import br.ufrpe.animal_clinic.exception.NotFoundException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Cirurgia;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class RepositorioUsuarios {
	
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>(10);
	
	public RepositorioUsuarios(int tamanho) {
        this.usuarios = new ArrayList<Usuario>(tamanho);
    }

    public RepositorioUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


	public void cadastrar(Usuario u) throws ExisteException{
		usuarios.add(u);
		
		try {
            procurar(u.getId());
        } catch (NullException ex) {
            usuarios.add(u);
            System.out.println(usuarios);
        }

	}

	
	public Usuario procurar(String id) throws NullException{
		Usuario u = null;
		boolean continuar = true;

		for (int j = 0; j < usuarios.size() && continuar; j++) {
			if (usuarios.get(j).getId().equals(id)) {
				u = usuarios.get(j);
	            continuar = false;
			}
	    }

		if (u == null) {
            NullException e = new NullException();
            throw e;
        }
	    
	    return u;
	}


	public void remover(String id) throws NullException {
		try {
			Usuario u = procurar(id);
			usuarios.remove(u);
		}catch(NullException ex){
			NullException e = new NullException();
            throw e;
		}
        
    }
	
	 
	public ArrayList<Usuario> getDados() {
	        return usuarios;
	}
	
	public ArrayList<Usuario> listarPorData(Date d) throws NullException{
		  ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	      for (Usuario usuario : usuarios) {
	    	  if(usuario.getData().equals(d)) {
	    		  listaUsuarios.add(usuario);
	    	  }
	      }
	      if(listaUsuarios.size() == 0) {
	    	  throw new NullException();
	      }
	      return listaUsuarios;
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
		    RepositorioUsuarios a = new RepositorioUsuarios((ArrayList<Usuario>) ois.readObject());
		    ois.close();
   
		}	catch (IOException ex) {
			RepositorioUsuarios a = new RepositorioUsuarios(20);
		}
	}
}
