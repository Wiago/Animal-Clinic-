package br.ufrpe.animal_clinic.negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import br.ufrpe.animal_clinic.dados.RepositorioCirurgias;
import br.ufrpe.animal_clinic.dados.RepositorioUsuarios;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class ControladorUsuarios {
	private RepositorioUsuarios repositorio;
	private static ControladorUsuarios instancia;
	
	private ControladorUsuarios() {
		repositorio = new RepositorioUsuarios(10);
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
	
	public ArrayList<Usuario> getDados() {
        return this.repositorio.getDados();
    }
}
