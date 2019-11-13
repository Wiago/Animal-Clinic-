package br.ufrpe.animal_clinic.dados;

import java.util.ArrayList;

import br.ufrpe.animal_clinic.exception.UsuarioExisteException;
import br.ufrpe.animal_clinic.exception.UsuarioNullException;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class RepositorioUsuarios {
	
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>(10);
	
	public RepositorioUsuarios(int tamanho) {
        this.usuarios = new ArrayList<Usuario>(tamanho);
    }

    public RepositorioUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


	public void cadastrar(Usuario u) throws UsuarioExisteException{
		
		try {
            procurar(u.getId());
        } catch (UsuarioNullException ex) {
            usuarios.add(u);
        }

	}

	
	public Usuario procurar(String id) throws UsuarioNullException{
		Usuario u = null;
		boolean continuar = true;

		for (int j = 0; j < usuarios.size() && continuar; j++) {
			if (usuarios.get(j).getId().equals(id)) {
				u = usuarios.get(j);
	            continuar = false;
			}
	    }

		if (u == null) {
            UsuarioNullException e = new UsuarioNullException();
            throw e;
        }
	    
	    return u;
	}


	public void remover(String id) throws UsuarioNullException {
		try {
			Usuario u = procurar(id);
			usuarios.remove(u);
		}catch(UsuarioNullException ex){
			UsuarioNullException e = new UsuarioNullException();
            throw e;
		}
        
    }
	
	 
	public ArrayList<Usuario> getDados() {
	        return usuarios;
	}
}
