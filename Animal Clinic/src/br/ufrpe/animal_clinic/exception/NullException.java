package br.ufrpe.animal_clinic.exception;

import java.io.Serializable;

public class NullException extends Exception implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -3086101875968507237L;

	public NullException() {
    }
    
    public String getMessage() {
        return "Erro!!\nA informação recebida está vazia!";
    }
}