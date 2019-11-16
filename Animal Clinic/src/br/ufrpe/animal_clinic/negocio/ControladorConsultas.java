package br.ufrpe.animal_clinic.negocio;

import br.ufrpe.animal_clinic.dados.RepositorioConsultas;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
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
}
