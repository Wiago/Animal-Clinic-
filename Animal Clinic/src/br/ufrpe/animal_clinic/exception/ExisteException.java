package br.ufrpe.animal_clinic.exception;

import java.io.Serializable;

public class ExisteException  extends Exception implements Serializable{
	
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
