package br.ufrpe.animal_clinic.negocio;

import br.ufrpe.animal_clinic.dados.RepositorioProntuarios;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.exception.ProntuarioNullException;
import br.ufrpe.animal_clinic.exception.UsuarioExisteException;
import br.ufrpe.animal_clinic.negocio.beans.Prontuario;

public class ControladorProntuarios {
	private RepositorioProntuarios repositorio;
	
	public void criarProntuario(Prontuario p) throws NullException {
		
		if(p != null) {
			repositorio.cadastrar(p);
		}else {
			NullException e = new NullException();
            throw e;
		}
		
	}
	
	public void alterarProntuario(Usuario u, String login) throws NullException {
		if(u != null) {
			Usuario u1 = procurar(u.getId());
			u1.setLogin(login);
		}else {
			NullException e = new NullException();
            throw e;
		}
	} 
	
	public void remover(Usuario u) throws NullException{
		repositorio.remover(u.getId());
	}
	
	public Usuario procurar(String id) throws NullException {
        return this.repositorio.procurar(id);
    }
	
}
