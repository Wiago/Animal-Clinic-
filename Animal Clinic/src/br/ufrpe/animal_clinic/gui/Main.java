package br.ufrpe.animal_clinic.gui;

import java.text.DateFormat;
import java.util.Date;

import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Atendente;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class Main {

	public static void main(String[] args) {
		
		DateFormat f = DateFormat.getDateInstance();
		Date data1 = f.parse("12/01/1995");
		Date data2 = f.parse("01/09/1980");
		Date data3 = f.parse("18/07/1999");
		
		Medico a = new Medico("Pedro","111.111.111-11","pedrinho123","1111",data1);
		Usuario dono = new Usuario("Claudio","222.222.222-22","clau895","2222",data3);
		Atendente b = new Atendente("Fernanda","333.333.333-33","fer555","5555",data2);
		Animal c = new Animal("Scooby",dono,CARNIVORO,CANINO,MACHO,ADULTO);
		

	}

}
