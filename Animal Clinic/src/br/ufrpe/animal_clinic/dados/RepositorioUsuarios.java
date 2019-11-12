package br.ufrpe.animal_clinic.dados;

import java.util.ArrayList;

import br.ufrpe.animal_clinic.negocio.beans.Id;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class RepositorioUsuarios {
	
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>(10);

	public boolean cadastrar(Usuario u) {
		
		try {
            procurar(u.getId());
            return true;
        } catch (UsuarioNullException ex) {
            usuarios.add(u);
            return false;
        }
	}

	private void procurar(Id id) {
		// TODO Auto-generated method stub
		
	}

}
