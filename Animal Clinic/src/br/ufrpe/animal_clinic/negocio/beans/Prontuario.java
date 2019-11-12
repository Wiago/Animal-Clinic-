package br.ufrpe.animal_clinic.negocio.beans;

import java.util.Date;

public class Prontuario {
	private Animal animal;
	private Medico medico;
	private Date data;
	
	public Prontuario(Animal animal, Medico medico, Date data) {
		this.animal = animal;
		this.medico = medico;
		this.data = data;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Animal getAnimal() {
		return animal;
	}

	public Medico getMedico() {
		return medico;
	}
	
	
	
}
