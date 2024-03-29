package br.ufrpe.animal_clinic.negocio.beans;

import java.io.Serializable;
import java.util.Date;

public class Prontuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Consulta consulta;
	private String relatorio;
	private String nomeAnimal;
	private String id;
	//static Id a = new Id();
	
	public Prontuario(Consulta consulta, String relatorio, String nomeAnimal) {
		this.consulta = consulta;
		this.relatorio = relatorio;
		this.nomeAnimal = nomeAnimal;
		this.setId();
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}



	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}



	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public String getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}

	public String getId() {
		return id;
	}

	public void setId() {
		this.id = Id.gerarId(6);
	}

	@Override
	public String toString() {
		return "Prontuário [Consulta =(" + getConsulta().getAnimal()+ ";" 
										+ getConsulta().getMedico() + ";" 
										+ getConsulta().getData() + ";" 
										+ getConsulta().getHora()+")" 
										+ ";" + getRelatorio(); 
	}
}