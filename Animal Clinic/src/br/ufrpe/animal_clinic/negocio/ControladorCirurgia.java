package br.ufrpe.animal_clinic.negocio;

import br.ufrpe.animal_clinic.dados.RepositorioCirurgia;
import br.ufrpe.animal_clinic.dados.RepositorioExames;
import br.ufrpe.animal_clinic.negocio.beans.Cirurgia;
public class ControladorCirurgia {
	private RepositorioCirurgia repo = new RepositorioCirurgia(10);
	private static ControladorCirurgia instancia;
	
	private ControladorCirurgia() {
		repo = new RepositorioCirurgia(10);
	}
	
	public static ControladorCirurgia getInstancia() {
		if(instancia == null) {
			instancia = new ControladorCirurgia();
		}
		return instancia;
	}
}
