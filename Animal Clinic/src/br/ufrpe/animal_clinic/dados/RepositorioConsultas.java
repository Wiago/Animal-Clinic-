package br.ufrpe.animal_clinic.dados;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
public class RepositorioConsultas {
	private ArrayList<Consulta> consultas;
	
	public RepositorioConsultas(int tam) {
		consultas = new ArrayList(tam);
	}
}
