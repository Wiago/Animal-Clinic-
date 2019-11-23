package br.ufrpe.animal_clinic.negocio.beans;

public enum TipoUsuario {
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
