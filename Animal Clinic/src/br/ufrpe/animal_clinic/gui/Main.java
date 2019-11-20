package br.ufrpe.animal_clinic.gui;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Alimentacao;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Atendente;
import br.ufrpe.animal_clinic.negocio.beans.Especie;
import br.ufrpe.animal_clinic.negocio.beans.Genero;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
import br.ufrpe.animal_clinic.negocio.beans.TempoDeVida;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;
import br.ufrpe.animal_clinic.negocio.beans.Alimentacao;
import br.ufrpe.animal_clinic.negocio.beans.Especie;
import br.ufrpe.animal_clinic.negocio.beans.Genero;
import br.ufrpe.animal_clinic.negocio.beans.TempoDeVida;
import br.ufrpe.animal_clinic.dados.RepositorioExames;

public class Main {

	public static void main(String[] args) throws ParseException, ExisteException, NullException {
		
		//Teste
		
		DateFormat f = DateFormat.getDateInstance();
		Date data1 = f.parse("12/01/1995");
		Date data2 = f.parse("01/09/1980");
		Date data3 = f.parse("18/07/1999");
		
		Date data4 = f.parse("01/12/2019");
		Date data5 = f.parse("02/12/2019");
		
		Medico a = new Medico("Pedro","111.111.111-11","pedrinho123","1111",data1);
		Usuario dono = new Usuario("Claudio","222.222.222-22","clau895","2222",data3);
		Atendente b = new Atendente("Fernanda","333.333.333-33","fer555","5555",data2);
		Animal c = new Animal("Scooby",dono,Alimentacao.CARNIVORO,Especie.CANINO,Genero.MACHO,TempoDeVida.ADULTO);
		
		
		//1.
		
		a.setEspecialidade("Cachorros");
		b.marcarExame(data4, c, a);
		//System.out.println(b.getControladorExames().getRepositorio().getExames());
		
		b.remarcarExame(b.getControladorExames().getRepositorio().getExames().get(0), data5);
		//System.out.println(b.getControladorExames().getRepositorio().getExames());
		
		//2.
		
		b.marcarCastracao(data4, c, a);
		//System.out.println(b.getControladorCirurgias().getRepositorio().getDados());
		
		b.remarcarCastracao(b.getControladorCirurgias().getRepositorio().getDados().get(0), data5);
		//System.out.println(b.getControladorCirurgias().getRepositorio().getDados());
		
		//3. 
		b.marcarConsulta(data4, c, a);
		//System.out.println(b.getControladorConsultas().getRepositorio().getDados());
		
		b.remarcarConsulta(b.getControladorConsultas().getRepositorio().getDados().get(0), data5);
		//System.out.println(b.getControladorConsultas().getRepositorio().getDados());
		
		
	}

}
