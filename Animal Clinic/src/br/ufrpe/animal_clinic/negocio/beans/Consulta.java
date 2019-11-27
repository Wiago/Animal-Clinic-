package br.ufrpe.animal_clinic.negocio.beans;

import java.io.Serializable;
import java.util.Date;

public class Consulta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2237191239913280526L;
	private Animal animal;
	private String nomeAnimal;
	private String idDonoAnimal;
	private Medico medico;
	private String idMedico;
	private Date data;
	private String dataS;
	private String id;
	//static Id a = new Id();
	
	public Consulta(Animal animal, Medico medico, Date data) {
		this.animal = animal;
		this.medico = medico;
		this.data = data;
		this.setId();
	}	
	
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public String getIdDonoAnimal() {
		return idDonoAnimal;
	}

	public void setIdDonoAnimal(String idDonoAnimal) {
		this.idDonoAnimal = idDonoAnimal;
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public String getDataS() {
		return dataS;
	}

	public void setDataS(String dataS) {
		this.dataS = dataS;
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
				+ "Animal=" + getAnimal().getNome() + "/" + getAnimal().getTempoDeVida() + "/" +getAnimal().getEspecie() + "/" +getAnimal().getGenero() + "/" +getAnimal().getAlimentacao() + "/ Dono =(" +getAnimal().getDono().getNome() + ";" +getAnimal().getDono().getCpf() + ")" + "]\n\n";
	}
	
	
}
