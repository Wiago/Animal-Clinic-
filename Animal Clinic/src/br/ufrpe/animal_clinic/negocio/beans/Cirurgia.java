package br.ufrpe.animal_clinic.negocio.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Cirurgia implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8679480174319325837L;
	private Animal animal;
	private Medico medico;
	private Date data;
	private String dataS;
	private String id;
	static Id a = new Id();
	
	public Cirurgia(Animal animal, Medico medico, Date data) {
		this.animal = animal;
		this.medico = medico;
		this.data = data;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate = formatter.format(data); 
	    this.dataS = strDate;
		this.setId();
	}
	
	public Animal getAnimal() {
		return animal;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDataS() {
		return dataS;
	}

	public void setDataS(String dataS) {
		this.dataS = dataS;
	}

	public String getId() {
		return id;
	}
	
	public void setId() {
		this.id = Id.gerarId(7);
	}

	@Override
	public String toString() {
		return "Cirurgia [Médico =(" + getMedico().getNome()+ ";" + getMedico().getEspecialidade() 
				+ ")/ Data=(" + getData() + ")/"
				+ "Animal=" + getAnimal().getNome() + "/" + getAnimal().getTempoDeVida() + "/" +getAnimal().getEspecie() + "/" +getAnimal().getGenero() + "/" +getAnimal().getAlimentacao() + "/ Dono =(" +getAnimal().getDono().getNome() + ";" +getAnimal().getDono().getCpf() + ") ]\n\n";
	}
	
	public static Cirurgia of(String csvLine) throws ParseException {

		// 0 1 2 3 4 5 6 7
		// "cpf","dataNas","dataNasS","id","login","nome","senha","serialVersionUID"
		//Animal animal, Medico medico, Date data
		String[] dados = csvLine.split(",");
		String oldString = String.valueOf('"');
		SimpleDateFormat formatter = new SimpleDateFormat("dd/M/yyyy"); 
		Date data1 = formatter.parse(dados[2].replaceAll(oldString,""));
		Cirurgia c = new Cirurgia(null,null,null);
		try {
			System.out.println("Chegou");
			/*u.setCpf(dados[0].replaceAll(oldString,""));
			u.setIdCSV(dados[3].replaceAll(oldString,""));
			u.setLogin(dados[4].replaceAll(oldString,""));
			u.setNome(dados[5].replaceAll(oldString,""));
			u.setSenha(dados[6].replaceAll(oldString,""));*/

		} catch (Exception e) {
//			System.err.println("Erro ao converter linha do CSV em um usuário! | Linha lida: " + linha);
//			e.printStackTrace();
			
			return null;
		}
		return c;
	}
	
}
