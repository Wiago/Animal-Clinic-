package br.ufrpe.animal_clinic.negocio;

import br.ufrpe.animal_clinic.dados.RepositorioCirurgia;
import br.ufrpe.animal_clinic.dados.RepositorioProntuarios;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.negocio.beans.Prontuario;

public class ControladorProntuarios {
	private RepositorioProntuarios repositorio;
	private static ControladorProntuarios instancia;
	
	private ControladorProntuarios() {
		repositorio = new RepositorioProntuarios(10);
	}
	
	public static ControladorProntuarios getInstancia() {
		if(instancia == null) {
			instancia = new ControladorProntuarios();
		}
		return instancia;
	}
	
	public RepositorioProntuarios getRepositorio() {
		return repositorio;
	}
	
	public void criarProntuario(Prontuario p) throws NullException, ExisteException {
		
		if(p != null) {
			repositorio.cadastrar(p);
		}else {
			NullException e = new NullException();
            throw e;
		}
		
	}
	
	public void alterarProntuar(Prontuario p) throws NullException {
		if(p != null) {
			Prontuario p1 = procurar(p.getId());
			
		}else {
			NullException e = new NullException();
            throw e;
		}
	} 
	
	public void remover(Prontuario p) throws NullException{
		repositorio.remover(p.getId());
	}
	
	public Prontuario procurar(String id) throws NullException {
        return this.repositorio.procurar(id);
    }
	
}
