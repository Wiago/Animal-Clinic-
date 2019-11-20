package br.ufrpe.animal_clinic.negocio;

import java.util.Date;

import br.ufrpe.animal_clinic.dados.RepositorioConsultas;
import br.ufrpe.animal_clinic.dados.RepositorioExames;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.negocio.beans.Exame;
public class ControladorConsultas {
	private static ControladorConsultas instancia;
	private RepositorioConsultas repositorio;
	
	private ControladorConsultas() {
		repositorio = new RepositorioConsultas(10);
	}
	
	public static ControladorConsultas getInstancia() {
		if(instancia == null) {
			instancia = new ControladorConsultas();
		}
		return instancia;
	}
	
	public RepositorioConsultas getRepositorio() {
		return repositorio;
	}


	public void criarConsulta(Consulta c) throws NullException, ExisteException {
		if(c != null) {
			repositorio.cadastrarConsulta(c);
		}else {
			NullException exc = new NullException();
            throw exc;
		}
		
	}
	
	public void remarcarConsulta(Consulta c, Date dataNova) throws NullException {
		if(this.procurar(c) != null) {
			Consulta cons = new Consulta(c.getAnimal(), c.getMedico(), dataNova);
			repositorio.remover(c);
			repositorio.cadastrarConsulta(cons);
		}
		else {
			throw new NullException();
		}
	}
	/*public void alterarConsulta(Consulta c) throws NullException {
		if(c != null) {
			Consulta c1 = procurar(c);
			//TO-DO
		}else {
			NullException exc = new NullException();
            throw exc;
		}
	} */
	
	public void remover(Consulta c) throws NullException{
		repositorio.remover(c);
	}
	
	public Consulta procurar(Consulta c) throws NullException {
        return this.repositorio.procurar(c);
    }
}
