package br.ufrpe.animal_clinic.negocio.beans;

import java.io.Serializable;

public enum Especie implements Serializable{
	CANINO("Canino"), FELINO("Felino"), ROEDOR("Roedor"), REPTIL("Reptil"), AVE("Ave");
	
	private String categoria;
	
	Especie (String categoria) {
        this.setCategoria(categoria);
    }

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
