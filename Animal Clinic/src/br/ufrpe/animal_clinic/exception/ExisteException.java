package br.ufrpe.animal_clinic.exception;

public class ExisteException  extends Exception{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ExisteException() {
    }
    
    public String getMessage() {
        return "Erro!!\nO usuario já existe.";
    }
}
