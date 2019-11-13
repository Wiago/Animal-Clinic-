package br.ufrpe.animal_clinic.negocio.beans;

import java.util.ArrayList;
import java.util.Date;

public class Medico extends Usuario {

	private String especialidade;
	private ArrayList <Animal> pacientesDoDia = new ArrayList();

<<<<<<< Updated upstream
	public Medico(String nome, String cpf, String senha,String login, Date dataNas) {
		super(nome, cpf, senha, login, dataNas);
=======
	public Medico(String nome, String cpf, String senha, Date dataNas) {
		super(nome, cpf, senha, senha, dataNas);
>>>>>>> Stashed changes
		// TODO Auto-generated constructor stub
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
