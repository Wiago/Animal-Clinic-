package br.ufrpe.animal_clinic.negocio;

import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.animal_clinic.dados.RepositorioAnimais;
import br.ufrpe.animal_clinic.dados.RepositorioUsuarios;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class ControladorUsuarios implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RepositorioUsuarios repositorio;
	private RepositorioAnimais repositorioAnimais;
	private static ControladorUsuarios instancia;
	
	private ControladorUsuarios() {
		repositorio = RepositorioUsuarios.getInstancia();
		repositorioAnimais = RepositorioAnimais.getInstancia();
	}
	
	public static ControladorUsuarios getInstancia() {
		if(instancia == null) {
			instancia = new ControladorUsuarios();
		}
		return instancia;
	}
	
	public RepositorioUsuarios getRepositorio() {
		return repositorio;
	}
	
	public RepositorioAnimais getRepositorioAnimais() {
		return repositorioAnimais;
	}
	
	public void cadastrar(Usuario u) throws ExisteException, NullException {
		if(u != null) {
			repositorio.cadastrar(u);
		}else {
			NullException e = new NullException();
            throw e;
		}
		
	}
	
	public void alterarLogin(Usuario u, String login) throws NullException {
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
	
	public Usuario procurarPorLogin(String login) throws NullException {
        return this.repositorio.procurarPorLogin(login);
    }
	
	public String procurarIdPorLogin(String login) throws NullException{
		return this.repositorio.procurarIdPorLogin(login);
	}
	public ArrayList<Usuario> getDados() {
        return this.repositorio.getDados();
    }
}
