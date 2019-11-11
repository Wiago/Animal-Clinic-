package br.ufrpe.animal_clinic.negocio.beans;

import java.util.Date;

public class Animal extends Usuario {
	
	public Usuario Dono;
	public boolean oAnimalEMae;
	public boolean estaVivo;
	public Alimentacao alimentacao;
	public Especie especie;
	public Genero genero;
	public TempoDeVida tempoDeVida;
	
	public Animal(String nome, String cpf, String senha, Date dataNas, Usuario Dono) {
		super(nome, cpf, senha, dataNas);
		this.Dono = Dono;
	}

}
