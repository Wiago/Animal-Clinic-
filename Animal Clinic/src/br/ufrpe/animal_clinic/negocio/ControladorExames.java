package br.ufrpe.animal_clinic.negocio;

import br.ufrpe.animal_clinic.dados.RepositorioExames;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Exame;

public class ControladorExames {
	private static ControladorExames instancia;
	private RepositorioExames repositorio;
		
	private ControladorExames() {
		repositorio = new RepositorioExames(10);
	}
	
	public static ControladorExames getInstancia() {
		if(instancia == null) {
			instancia = new ControladorExames();
		}
		return instancia;
	}
	public RepositorioExames getRepositorio() {
		return repositorio;
	}


	public void criarExame(Exame e) throws NullException, ExisteException {
		if(e != null) {
			repositorio.cadastrar(e);
		}else {
			NullException c = new NullException();
            throw c;
		}
		
	}
	
	public void alterarExame(Exame e) throws NullException {
		if(e != null) {
			Exame e1 = procurar(e.getId());
			//TO-DO
		}else {
			NullException c = new NullException();
            throw c;
		}
	} 
	
	public void remover(Exame e) throws NullException{
		repositorio.remover(e.getId());
	}
	
	public Exame procurar(String id) throws NullException {
        return this.repositorio.procurar(id);
    }
}
