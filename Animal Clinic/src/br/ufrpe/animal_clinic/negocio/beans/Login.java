package br.ufrpe.animal_clinic.negocio.beans;

import java.io.Serializable;

public class Login implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String senha;
	private String login;
	private String id;
	
	public Login() {
		
	}
	
	public Login(String login, String senha, String id) {
		this.login = login;
		this.senha = senha;
		this.id = id;
	}
	
	public Login(String id, String senha) {
		this.id = id;
		this.senha = senha;
	}

	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenhaHash() {
		return senha;
	}

	public void setSenhaHash(String senha) {
		this.senha = senha;
	}	
}
