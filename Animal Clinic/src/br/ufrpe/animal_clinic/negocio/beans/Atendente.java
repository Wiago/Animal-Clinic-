package br.ufrpe.animal_clinic.negocio.beans;
import java.io.Serializable;
import java.util.Date;


public class Atendente extends Usuario implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Atendente(String nome, String cpf, String senha, String login, Date dataNas) {
		super(nome, cpf, senha, login, dataNas);
		this.setId(1);
	}
	
	
}
