package br.ufrpe.animal_clinic.negocio;

import br.ufrpe.animal_clinic.dados.RepositorioExames;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Exame;

public class ControladorExames {
	private RepositorioExames repositorio;
	
	public void criarProntuario(Exame e) throws NullException, ExisteException {
		
		if(e != null) {
			repositorio.cadastrar(e);
		}else {
			NullException c = new NullException();
            throw c;
		}
		
	}
	
	public void alterarProntuar(Exame e) throws NullException {
		if(e != null) {
			Exame e1 = procurar(e.getId());
			
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
