package br.ufrpe.animal_clinic.negocio.beans;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2775735858339834846L;
	private String nome;
	private String cpf;
	private String login;
	private String senha;
	private Date dataNas;
	private String id;
	static Id a = new Id();
	
	public Usuario(String nome, String cpf, String senha, String login, Date dataNas) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.dataNas = dataNas;
		this.login = login;
		this.setId(3);
	}

	public Usuario(String nome2, String cpf2, String senha2) {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getData() {
		return dataNas;
	}
	public void setData(Date dataNas) {
		this.dataNas = dataNas;
	}

	public String getId() {
		return id;
	}
	
	public void setId(int opcao) {
		this.id = Id.gerarId(opcao);
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	

	@Override
	public String toString() {
		return "Usuário [Nome = " + getNome() + ","+"Login = " + getLogin() + " CPF = " + getCpf() + ", Senha = " + getSenha()
				+ ", Data de Nascimento = " + getData() + "]";
	}
	
}
