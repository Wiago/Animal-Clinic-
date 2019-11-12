package br.ufrpe.animal_clinic.dados;

import java.util.ArrayList;

import br.ufrpe.animal_clinic.exception.UsuarioNullException;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class RepositorioUsuarios {
	
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>(10);

	public void cadastrar(Usuario u) {
		
		try {
            procurar(u.getId());
        } catch (UsuarioNullException ex) {
            usuarios.add(u);
        }

	}

	
	public Usuario procurar(String id) {
		Usuario u = null;
		boolean continuar = true;

		for (int j = 0; j < usuarios.size() && continuar; j++) {
			if (usuarios.get(j).getId().equals(id)) {
				u = usuarios.get(j);
	            continuar = false;
			}
	    }

	    if (u == null) {
	        	
	    }
	    
	    return u;
	}


	public void remover(String id) {
        Usuario u = procurar(id);
        usuarios.remove(u);
    }
	
	 
	public ArrayList<Usuario> getDados() {
	        return usuarios;
	}
}
