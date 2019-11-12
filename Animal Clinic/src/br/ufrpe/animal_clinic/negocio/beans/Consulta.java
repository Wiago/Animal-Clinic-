package br.ufrpe.animal_clinic.negocio.beans;

import java.util.Date;

public class Consulta {
	private Animal animal;
	private Medico medico;
	private Date data;
	
	public Consulta(Animal animal, Medico medico, Date data) {
		this.animal = animal;
		this.medico = medico;
		this.data = data;
	}	
	
	public Animal getAnimal() {
		return animal;
	}
	
	public void setMedico(Medico medico){
		this.medico = medico;
	}
	
	public Medico getMedico() {
		return medico;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Consulta [getAnimal()=" + getAnimal() + ", getMedico()=" + getMedico() + ", getData()=" + getData()
				+ "]";
	}
	
	
}
