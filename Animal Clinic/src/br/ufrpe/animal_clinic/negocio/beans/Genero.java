package br.ufrpe.animal_clinic.negocio.beans;

public enum Genero {
	MACHO("Macho"), FEMEA("Femea");
	
	private String categoria;
	
	Genero (String categoria) {
        this.setCategoria(categoria);
    }

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
