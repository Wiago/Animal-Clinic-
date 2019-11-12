package br.ufrpe.animal_clinic.exception;

public class UsuarioNullException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNullException() {
    }
    
    public String getMessage() {
        return "Erro!\nA informação recebida está vazia!\nCaso este erro persistir, acione o suporte!";
    }

}
