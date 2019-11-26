package br.ufrpe.animal_clinic.negocio.beans;

import java.io.Serializable;

public enum Alimentacao implements Serializable{
	CARNIVORO("Carnivoro"), HERBIVORO("Herbivoro"), ONIVORO("Onivoro"); 
	
	private String categoria;
	
	Alimentacao (String categoria) {
        this.setCategoria(categoria);
    }

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
