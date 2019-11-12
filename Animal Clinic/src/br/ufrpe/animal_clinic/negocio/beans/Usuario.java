package br.ufrpe.animal_clinic.negocio.beans;

import java.util.Date;

public class Usuario {
	private String nome;
	private String cpf;
	private String senha;
	private Date dataNas;
	private Id id;
	
	
	public Usuario(String nome, String cpf, String senha, Date dataNas) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.dataNas = dataNas;
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
	public Date getDataNas() {
		return dataNas;
	}
	public void setDataNas(Date dataNas) {
		this.dataNas = dataNas;
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuario [getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getSenha()=" + getSenha()
				+ ", getDataNas()=" + getDataNas() + "]";
	}
	
	
	
}
