package br.ufrpe.animal_clinic.negocio.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Medico extends Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String especialidade;
	private ArrayList <Animal> pacientesDoDia = new ArrayList();

	public Medico(String nome, String cpf, String senha,String login, Date dataNas) {
		super(nome, cpf, senha, login, dataNas);
		this.setId(2);
	}

	public String getId() {
		return getId();
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public ArrayList<Animal> getPacientesDoDia() {
		return pacientesDoDia;
	}

	public void setPacientesDoDia(ArrayList<Animal> pacientesDoDia) {
		this.pacientesDoDia = pacientesDoDia;
	}
	
	public void removerPaciente(String nome, String cpf) {
		for(Animal animal: pacientesDoDia) {
			if(animal.getDono().getCpf().equals(cpf)) {
				if(animal.getNome().equals(nome)) {
					pacientesDoDia.remove(animal);
				}
			}
		}
	}
	public void removerPaciente(Animal animal) {
		for(Animal ani: pacientesDoDia) {
			if(ani.equals(animal)) {
				pacientesDoDia.remove(animal);
			}
		}
	}

	@Override
	public String toString() {
		return "["+this.getNome()+" , "+especialidade+ "]";
	}
	
}
