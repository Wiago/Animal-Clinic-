package br.ufrpe.animal_clinic.exception;

import java.io.Serializable;

public class NotFoundException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4594781340898286520L;
	
	public NotFoundException() {
		
	}
	
	public String getMenssage() {
		return "Não foi possivel encontrar este arquivo, ARQUIVO NAO EXISTE";
	}
}
