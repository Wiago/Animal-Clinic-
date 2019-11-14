package br.ufrpe.animal_clinic.negocio.beans;

public enum Alimentacao {
	CARNIVORO(1), HERBIVORO(2), ONIVORO(3); 
	
	public int idAlimentacao;
	
	Alimentacao(int idAlimentacao){
		this.idAlimentacao = idAlimentacao;
	}
	/*public String nome; 
	Alimentacao(String nome){ 
		this.nome = nome; 
	} 
	 
	public static void main(String[] args) { 
		System.out.println(Alimentacao.CARNIVORO.name()); 
		System.out.println(CARNIVORO.name().equals("CARNIVORO")); 
	}*/ 
}
