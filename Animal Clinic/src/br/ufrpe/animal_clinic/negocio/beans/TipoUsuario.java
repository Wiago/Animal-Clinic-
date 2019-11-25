package br.ufrpe.animal_clinic.negocio.beans;

import java.io.Serializable;

public enum TipoUsuario implements Serializable{
	USUARIO(3), MEDICO(2), ATENDENTE(1);
	
	private int categoria;
	
	TipoUsuario (int categoria) {
        this.setCategoria(categoria);
    }

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
}
