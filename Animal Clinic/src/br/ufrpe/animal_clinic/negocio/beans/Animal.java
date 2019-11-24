package br.ufrpe.animal_clinic.negocio.beans;

import java.io.Serializable;
import java.util.Date;

public class Animal implements Serializable{ 
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -4247798444000409255L;
	private String nome; 
	private Usuario dono; 
	private boolean oAnimalEMae; 
	private boolean estaVivo; 
	private Alimentacao alimentacao; 
	private Especie especie; 
	private Genero genero; 
	private TempoDeVida tempoDeVida; 
	 
	public Animal(String nome, Usuario dono, Alimentacao alimentacao, Especie especie, Genero genero, TempoDeVida tempoDeVida) { 
		this.nome = nome; 
		this.dono = dono; 
		this.oAnimalEMae = false; 
		this.estaVivo = true; 
		this.alimentacao = alimentacao; 
		this.especie = especie; 
		this.genero = genero; 
		this.tempoDeVida = tempoDeVida; 
	} 
	 
	public String getNome() { 
		return nome; 
	} 
 
 
	public void setNome(String nome) { 
		this.nome = nome; 
	} 
	 
	public Usuario getDono() { 
		return dono; 
	} 
 
 
	public void setDono(Usuario dono) { 
		this.dono = dono; 
	} 
 
 
	public boolean isoAnimalEMae() { 
		return oAnimalEMae; 
	} 
 
 
	public void setoAnimalEMae(boolean oAnimalEMae) { 
		this.oAnimalEMae = oAnimalEMae; 
	} 
 
 
 
	public boolean isEstaVivo() { 
		return estaVivo; 
	} 
 
 
 
	public void setEstaVivo(boolean estaVivo) { 
		this.estaVivo = estaVivo; 
	} 
 
 
 
	public Alimentacao getAlimentacao() { 
		return alimentacao; 
	} 
 
 
 
	public void setAlimentacao(Alimentacao alimentacao) { 
		this.alimentacao = alimentacao; 
	} 
 
 
 
	public Especie getEspecie() { 
		return especie; 
	} 
 
 
 
	public void setEspecie(Especie especie) { 
		this.especie = especie; 
	} 
 
 
 
	public Genero getGenero() { 
		return genero; 
	} 
 
 
 
	public void setGenero(Genero genero) { 
		this.genero = genero; 
	} 
 
 
 
	public TempoDeVida getTempoDeVida() { 
		return tempoDeVida; 
	} 
 
 
 
	public void setTempoDeVida(TempoDeVida tempoDeVida) { 
		this.tempoDeVida = tempoDeVida; 
	} 
 
	
	@Override
	public String toString() {
		return "Animal [Nome = " + nome + ", Dono = " + dono + "; " + alimentacao + "; " + especie
				+ "; " + genero + "; " + tempoDeVida + "]";
	}

	@Override 
	public boolean equals(Object obj) { 
		if (this == obj) 
			return true; 
		if (obj == null) 
			return false; 
		if (getClass() != obj.getClass()) 
			return false; 
		Animal other = (Animal) obj; 
		if (!other.getDono().getId().equals(this.getDono().getId())) { //se os id's(dono) forem diferentes 
			return false; 
		}  
		else if (!other.getNome().equals(this.getNome())) { //se o nome dos animais for diferente 
			return false; 
		} 
		return true; 
	} 
 
	 
} 

