package br.ufrpe.animal_clinic.negocio.beans;

import java.util.Date;

public class Atendente extends Usuario {

	public Atendente(String nome, String cpf, String senha, String login, Date dataNas) {
		super(nome, cpf, senha, login, dataNas);
		// TODO Auto-generated constructor stub
	}

	public void marcarConsulta(Date data, Animal animal, Medico medico) {
		
	}
	
	public void remarcarConsulta(Consulta consulta, Date novaData) {
		
	}
	
	public void marcarExame(Date data, Animal animal, Medico medico) {
		
	}
	
	public void remarcarExame(Exame exame, Date novaData) {
		
	}
	
	public void marcarCastracao(Animal animal, Medico medico, Date data) {
		
	}
	
	public void remarcarCastracao(Cirurgia cirurgia, Date novaData) {
		
	}
	
}
