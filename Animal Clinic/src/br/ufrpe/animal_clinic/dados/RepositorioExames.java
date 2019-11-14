package br.ufrpe.animal_clinic.dados;

import java.util.ArrayList;

import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Exame;


public class RepositorioExames {
	
	ArrayList<Exame> exames = new ArrayList<Exame>(10);

	public RepositorioExames(int tamanho) {
	    this.exames = new ArrayList<Exame>(tamanho);
	}
	
	public RepositorioExames(ArrayList<Exame> usuarios) {
	    this.exames = usuarios;
	}
	
	
	public ArrayList<Exame> getExames() {
		return exames;
	}

	public void cadastrar(Exame e) throws ExisteException, NullException{
			//Exame exame = procurar(e.getId());
			if(e != null) {
				exames.add(e);
			}
			else {
				throw new NullException();
			}
	}
	
	
	public Exame procurar(String id) throws NullException{
		Exame e = null;
		boolean continuar = true;
	
		for (int j = 0; j < exames.size() && continuar; j++) {
			if (exames.get(j).getId().equals(id)) {
				e = exames.get(j);
	            continuar = false;
			}
	    }
	
		if (e == null) {
	        NullException c = new NullException();
	        throw c;
	    }
	    
	    return e;
	}
	
	
	public void remover(String id) throws NullException {
		try {
			Exame e = procurar(id);
			exames.remove(e);
		}catch(NullException ex){
			NullException c = new NullException();
	        throw c;
		}
	    
	}
	
	 
	public ArrayList<Exame> getDados() {
	        return exames;
	}
		
	

}
