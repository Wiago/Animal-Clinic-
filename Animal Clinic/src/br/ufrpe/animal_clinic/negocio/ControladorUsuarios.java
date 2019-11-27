package br.ufrpe.animal_clinic.negocio;

import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.animal_clinic.dados.RepositorioAnimais;
import br.ufrpe.animal_clinic.dados.RepositorioUsuarios;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Atendente;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
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
		int d = 0;
		if(u != null || u.getNome() != null || u.getSenha() != null || u.getCpf() != null || u.getLogin() != null) {
			for(int a = 0; a<repositorio.getDados().size(); a++) {
				Usuario f = repositorio.getDados().get(a);
				if(f.getLogin() != u.getLogin() && f.getCpf() != u.getCpf()) {
					d++;
					System.out.println(d);
				}
			}
			if(d == repositorio.getDados().size()) {
				repositorio.cadastrar(u);
			}
			else {
				ExisteException e = new ExisteException();
				throw e;
			}
			
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
	public Medico procurarMedico(String id) throws NullException{
		return repositorio.procurarMedico(id);
	}
	
	public Medico procurarMedicoPorLogin(String login) throws NullException{
		return repositorio.procurarMedicoPorLogin(login);
	}
	public Atendente procurarAtendente(String id) throws NullException{
		return repositorio.procurarAtendente(id);
	}
	
	public Atendente procurarAtendentePorLogin(String login) throws NullException{
		return repositorio.procurarAtendentePorLogin(login);
	}
	
	public ArrayList<Usuario> getDados() {
        return this.repositorio.getDados();
    }
	public ArrayList<Animal> getDadosAnimais() {
        return this.repositorioAnimais.getAnimais();
    }
	public ArrayList<Medico> getDadosMedico(){
		return this.repositorio.getMedicos();
	}
}
