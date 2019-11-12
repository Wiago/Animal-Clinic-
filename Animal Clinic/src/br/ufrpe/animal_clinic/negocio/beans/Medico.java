package br.ufrpe.animal_clinic.negocio.beans;

import java.util.ArrayList;
import java.util.Date;

public class Medico extends Usuario {

	private String especialidade;
	private ArrayList <Animal> pacientesDoDia = new ArrayList();

	public Medico(String nome, String cpf, String senha, Date dataNas) {
		super(nome, cpf, senha, dataNas);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
