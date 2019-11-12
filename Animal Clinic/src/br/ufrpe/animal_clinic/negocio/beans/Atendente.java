package br.ufrpe.animal_clinic.negocio.beans;

import java.util.Date;

public class Atendente extends Usuario {

	public Atendente(String nome, String cpf, String senha, Date dataNas) {
		super(nome, cpf, senha, dataNas);
		// TODO Auto-generated constructor stub
	}
	
	public boolean marcarConsulta(Date data, Animal animal, Medico medico) {
		return false;
	}
	
	public boolean alterarConsulta(Consulta consulta, Date novaData) {
		return false;
	}
	
	public boolean marcarExame(Date data, Animal animal, Medico medico) {
		return false;
	}
	
	public boolean alterarExame(Exame exame, Date novaData) {
		return false;
	}
	
	
}
