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
import java.util.HashMap;
import java.util.Map;

import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class RepositorioUsuarios {
	
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>(10);
	
	Map<String,String> loginId = new HashMap<String,String>();
	
	public RepositorioUsuarios(int tamanho) {
        this.usuarios = new ArrayList<Usuario>(tamanho);
    }

    public RepositorioUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


	public void cadastrar(Usuario u) throws ExisteException{
		try {
            procurar(u.getId());
        } catch (NullException ex) {
            usuarios.add(u);
            loginId.put(u.getLogin(), u.getId()); //Key = login; Content = id
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
	
	public Usuario procurarPorLogin(String login) throws NullException{
		Usuario u = null;
		boolean continuar = true;

		for (int j = 0; j < usuarios.size() && continuar; j++) {
			if (usuarios.get(j).getLogin().equals(login)) {
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
	
	public String procurarIdPorLogin(String login) throws NullException{
		String id = loginId.get(login);
		if(id != null) {
			return id;
		}
		else {
			throw new NullException();
		}
	}


	public void remover(String id) throws NullException {
		try {
			Usuario u = procurar(id);
			usuarios.remove(u);
			loginId.remove(u.getLogin());
		}catch(NullException ex){
			NullException e = new NullException();
            throw e;
		}
        
    }
	
	 
	public ArrayList<Usuario> getDados() {
	        return usuarios;
	}
	
	public Map<String,String> getDadosLoginId() {
        return loginId;
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
	
	public Usuario getUsuario() {
		Usuario b = null;
		for (int a = 0; a<this.usuarios.size();a++) {
			b = this.usuarios.get(a);
		}
		return b;
	}
	
	public void salvarDados(String file) throws IOException {
		System.out.println("oi");
	    File arquivo = new File(file);
	    FileOutputStream fos = new FileOutputStream(arquivo);
	    ObjectOutputStream ous = new ObjectOutputStream(fos);
	    ous.writeObject(getUsuario());
	    ous.close();
	}
	
	public void carregarDados(String file) throws ClassNotFoundException, FileNotFoundException {
	    
	    File arquivo = new File(file);
	    FileInputStream fis;
	    ObjectInputStream ois;
	    fis = new FileInputStream(arquivo);

		try {
		    ois = new ObjectInputStream(fis);
		    ois.close();
   
		}	catch (IOException ex) {
		}
	}
}
