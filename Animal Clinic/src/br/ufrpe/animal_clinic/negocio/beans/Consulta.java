package br.ufrpe.animal_clinic.negocio.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Consulta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2237191239913280526L;
	private Animal animal;
	private Medico medico;
	private LocalDate data;
	private String hora;
	private String id;
	private String descricaoDoUsuario;
	//static Id a = new Id();
	
	public Consulta(Animal animal, Medico medico, LocalDate data, String hora, String descricao) {
		this.animal = animal;
		this.medico = medico;
		this.data = data;
		this.hora = hora;
		this.descricaoDoUsuario = descricao;
		this.setId();
	}	
	
	
	public String getDescricaoDoUsuario() {
		return descricaoDoUsuario;
	}


	public void setDescricaoDoUsuario(String descricaoDoUsuario) {
		this.descricaoDoUsuario = descricaoDoUsuario;
	}


	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public void setMedico(Medico medico){
		this.medico = medico;
	}
	
	public Medico getMedico() {
		return medico;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public String getId() {
		return id;
	}
	public void setId() {
		this.id = Id.gerarId(4);
	}
	
	public void setIdCSV(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Consulta [Médico =(" + getMedico().getNome()+ ";" + getMedico().getEspecialidade() 
				+ ") Data=(" + getData() + ")/"
				+ "Animal=" + getAnimal().getNome() + "/" + getAnimal().getTempoDeVida() + "/" +getAnimal().getEspecie() + "/" +getAnimal().getGenero() + "/" +getAnimal().getAlimentacao() + "/ Dono =(" +getAnimal().getDono().getNome() + ";" +getAnimal().getDono().getCpf() + ")" + "]";
	}
	
	
}
