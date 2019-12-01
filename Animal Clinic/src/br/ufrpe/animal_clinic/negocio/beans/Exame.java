package br.ufrpe.animal_clinic.negocio.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Exame implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2794882594816682264L;
	private Animal animal;
	private Medico medico;
	private LocalDate data;
	private String hora;
	private String relatorio;
	private Prontuario prontuario;
	private String id;
	//static Id a = new Id();
	
	public Exame(Animal animal, Medico medico, LocalDate data, String hora) {
		this.animal = animal;
		this.medico = medico;
		this.data = data;
		this.hora = hora;
		this.setId();
	}
		
	
	public Prontuario getProntuario() {
		return prontuario;
	}
	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}
	public String getRelatorio() {
		return relatorio;
	}
	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
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
		return "Exame [Médico = (" + getMedico().getNome()+ ";" + getMedico().getEspecialidade() 
				+ ") Data=(" + getData() + ")/ "
				+ "Animal=" + getAnimal().getNome() + "/" + getAnimal().getTempoDeVida() + "/" +getAnimal().getEspecie() + "/" +getAnimal().getGenero() + "/" +getAnimal().getAlimentacao() + "/ Dono = (" +getAnimal().getDono().getNome() + ";" +getAnimal().getDono().getCpf() + ")" + "]\n\n";
	}
	
	
	
}
