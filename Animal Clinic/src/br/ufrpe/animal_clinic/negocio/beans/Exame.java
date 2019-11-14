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
		this.setId();
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

	public boolean equals(String id) {
		if (this.id == null) {
			if (id != null)
				return false;
		} else if (!id.equals(this.id))
			return false;
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exame other = (Exame) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Exame [Médico =" + getMedico().getNome()+ "," + getMedico().getEspecialidade() 
				+ "; Data=" + getData() + "; "
				+ "Animal=" + getAnimal().getNome() + "," + getAnimal().getTempoDeVida() + "," +getAnimal().getEspecie() + "," +getAnimal().getGenero() + "," +getAnimal().getAlimentacao() + "; Dono = " +getAnimal().getDono().getNome() + "," +getAnimal().getDono().getCpf() + "." + "]\n\n";
	}
	
	
	
}
