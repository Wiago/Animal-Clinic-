package br.ufrpe.animal_clinic.exception;

public class UsuarioNullException extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = -3086101875968507237L;

	public UsuarioNullException() {
    }
    
    public String getMessage() {
        return "Erro!!\nA informa��o recebida est� vazia!";
    }
}