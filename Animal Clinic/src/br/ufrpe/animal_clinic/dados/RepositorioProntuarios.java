package br.ufrpe.animal_clinic.dados;

import java.util.ArrayList;

import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Prontuario;


public class RepositorioProntuarios {
	ArrayList<Prontuario> prontuario = new ArrayList<Prontuario>(10);
	
	public void repositorioProntuario(int tamanho) {
        this.prontuario = new ArrayList<Prontuario>(tamanho);
    }

    public void RepositorioUsuarios(ArrayList<Prontuario> prontuario) {
        this.prontuario = prontuario;
    }


	public void cadastrar(Prontuario p) throws ExisteException{
		
		try {
            procurar(p.getId());
        } catch (NullException ex) {
            prontuario.add(p);
        }

	}

	
	public Prontuario procurar(String id) throws NullException{
		Prontuario u = null;
		boolean continuar = true;

		for (int j = 0; j < prontuario.size() && continuar; j++) {
			if (prontuario.get(j).getId().equals(id)) {
				u = prontuario.get(j);
	            continuar = false;
			}
	    }

		if (u == null) {
            NullException e = new NullException();
            throw e;
        }
	    
	    return u;
	}


	public void remover(String id) throws NullException {
		try {
			Prontuario u = procurar(id);
			prontuario.remove(u);
		}catch(NullException ex){
			NullException e = new NullException();
            throw e;
		}
        
    }
}
