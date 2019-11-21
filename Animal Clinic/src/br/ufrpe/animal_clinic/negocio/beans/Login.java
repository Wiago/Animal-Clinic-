package br.ufrpe.animal_clinic.negocio.beans;

public class Login {
	private String id;
	private int senhaHash;
	
	public Login() {
		
	}
	
	public Login(String id, int senhaHash) {
		this.id = id;
		this.senhaHash = senhaHash;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSenhaHash() {
		return senhaHash;
	}

	public void setSenhaHash(int senhaHash) {
		this.senhaHash = senhaHash;
	}	
}
