package br.ufrpe.animal_clinic.negocio.beans;

public enum Alimentacao {
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
