package br.ufrpe.animal_clinic.negocio.beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



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
	private String dataNasS;
	private String id;
	//static Id a = new Id();
	
	public Usuario() {
	}
	public Usuario(String nome, String cpf, String senha, String login, Date dataNas) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.dataNas = dataNas;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate = formatter.format(dataNas); 
		this.dataNasS = strDate;
		this.login = login;
		this.setId(3);
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
	
	public void setDataPorS(String dataNas) {
		this.dataNas = Date.from(Instant.parse(dataNas));
	}
	
	public String getDataNasS() {
		return dataNasS;
	}

	public void setDataNasS(String dataNasS) {
		this.dataNasS = dataNasS;
	}

	public String getId() {
		return id;
	}
	
	public void setId(int opcao) {
		this.id = Id.gerarId(opcao);
	}
	
	public void setIdCSV(String id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	

	@Override
	public String toString() {
		return "Usuário [Nome = " + getNome() + "/"+"Login = " + getLogin() + "/CPF = " + getCpf() + "/Senha = " + getSenha()
				+ "/ Data de Nascimento = " + getDataNasS() + "]";
	}
	
	public static Usuario of(String csvLine) throws ParseException {

		// 0 1 2 3 4 5 6 7
		// "cpf","dataNas","dataNasS","id","login","nome","senha","serialVersionUID"
		String[] dados = csvLine.split(",");
		String oldString = String.valueOf('"');
		SimpleDateFormat formatter = new SimpleDateFormat("dd/M/yyyy"); 
		Date data1 = formatter.parse(dados[2].replaceAll(oldString,""));
		Usuario u = new Usuario(null,null,null,null,data1);
		try {
			System.out.println("Chegou");
			u.setCpf(dados[0].replaceAll(oldString,""));
			u.setIdCSV(dados[3].replaceAll(oldString,""));
			u.setLogin(dados[4].replaceAll(oldString,""));
			u.setNome(dados[5].replaceAll(oldString,""));
			u.setSenha(dados[6].replaceAll(oldString,""));

		} catch (Exception e) {
//			System.err.println("Erro ao converter linha do CSV em um usuário! | Linha lida: " + linha);
//			e.printStackTrace();
			
			return null;
		}
		return u;
	}
	
}
