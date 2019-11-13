package br.ufrpe.animal_clinic.exception;

public class UsuarioExisteException  extends Exception{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public UsuarioExisteException() {
    }
    
    public String getMessage() {
        return "Erro!!\nO usuario já existe.";
    }
}
