package br.ufrpe.animal_clinic.negocio;

import java.util.Date;

import br.ufrpe.animal_clinic.dados.RepositorioCirurgia;
import br.ufrpe.animal_clinic.dados.RepositorioExames;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Cirurgia;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
public class ControladorCirurgia {
	private RepositorioCirurgia repositorio;
	private static ControladorCirurgia instancia;
	
	private ControladorCirurgia() {
		repositorio = new RepositorioCirurgia(10);
	}
	
	public static ControladorCirurgia getInstancia() {
		if(instancia == null) {
			instancia = new ControladorCirurgia();
		}
		return instancia;
	}
	
	public RepositorioCirurgia getRepositorio() {
		return repositorio;
	}
	
	public void criarCirurgia(Cirurgia c) throws NullException, ExisteException {
		if(c != null) {
			repositorio.cadastrar(c);
		}else {
			NullException exc = new NullException();
            throw exc;
		}
		
	}
	
	/*public void alterarCirurgia(Cirurgia c) throws NullException {
		if(c != null) {
			Cirurgia c1 = this.procurar(c);
			//TO-DO
		}else {
			NullException exc = new NullException();
            throw exc;
		}
	} */
	
	public void remarcarCirurgia(Cirurgia c, Date dataNova) throws NullException {
		if(this.procurar(c) != null) {
			Cirurgia cir = new Cirurgia(c.getAnimal(), c.getMedico(), dataNova);
			repositorio.remover(c);
			repositorio.cadastrar(cir);
		}
		else {
			throw new NullException();
		}
	}
	
	public void remover(Cirurgia c) throws NullException{
		repositorio.remover(c);
	}
	
	public Cirurgia procurar(Cirurgia c) throws NullException {
        return this.repositorio.procurar(c);
    }
}
