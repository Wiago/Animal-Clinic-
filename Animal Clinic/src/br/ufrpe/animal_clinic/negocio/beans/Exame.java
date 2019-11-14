package br.ufrpe.animal_clinic.negocio.beans;

import java.util.Date;

public class Exame {
	private Animal animal;
	private Medico medico;
	private Date data;
	private String id;
	static Id a = new Id();
	
	public Exame(Animal animal, Medico medico, Date data) {
		this.animal = animal;
		this.medico = medico;
		this.data = data;
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
	public Animal getAnimal() {
		return animal;
	}

	public String getId() {
		return id;
	}

	public void setId() {
		this.id = Id.gerarId(5);
	}

	@Override
	public String toString() {
		return "Exame [getMedico()=" + getMedico() + ", getData()=" + getData() + ", getAnimal()=" + getAnimal() + "]";
	}
	
	
	
}
