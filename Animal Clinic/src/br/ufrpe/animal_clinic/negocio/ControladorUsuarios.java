package br.ufrpe.animal_clinic.negocio;

import br.ufrpe.animal_clinic.dados.RepositorioUsuarios;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class ControladorUsuarios {
	private RepositorioUsuarios repositorio;
	
	public boolean Cadastrar(Usuario u) {
		if(u != null) {
			return repositorio.cadastrar(u);
		}
		else {
			return false;
		}
	}
}
