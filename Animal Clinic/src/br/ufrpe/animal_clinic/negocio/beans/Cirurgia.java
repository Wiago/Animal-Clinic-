package br.ufrpe.animal_clinic.negocio.beans;

import java.util.Date;

public class Cirurgia {
	private Animal animal;
	private Medico medico;
	private Date data;
	private Id id;
	
	public Cirurgia(Animal animal, Medico medico, Date data) {
		this.animal = animal;
		this.medico = medico;
		this.data = data;
	}
	
	public Animal getAnimal() {
		return animal;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public Id getId() {
		return id;
	}
	
	

	@Override
	public String toString() {
		return "Cirurgia [Animal =" + getAnimal() + ", Medico =" + getMedico() + ", Data =" + getData()
				+ "]";
	}
	
	
	
}
