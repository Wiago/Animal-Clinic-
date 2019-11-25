package br.ufrpe.animal_clinic.negocio.beans;

import java.io.Serializable;

public enum TempoDeVida implements Serializable{
	FILHOTE("Filhote"), ADULTO("Adulto"), IDOSO("Idoso");
	
	private String categoria;
	
	TempoDeVida (String categoria) {
        this.setCategoria(categoria);
    }

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
