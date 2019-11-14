package br.ufrpe.animal_clinic.negocio.beans;
import java.util.Date;
import br.ufrpe.animal_clinic.negocio.ControladorExames;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.ControladorCirurgia;
import br.ufrpe.animal_clinic.negocio.ControladorProntuarios;

public class Atendente extends Usuario {
	private ControladorExames conExame;
	private ControladorCirurgia conCirurg;
	private ControladorProntuarios conPront;
	
	public Atendente(String nome, String cpf, String senha, String login, Date dataNas) {
		super(nome, cpf, senha, login, dataNas);
		
		// TODO - OS CONTROLADORES SÃO SINGLETON!!!
		
		conExame = new ControladorExames();
		conCirurg = new ControladorCirurgia();
		conPront = new ControladorProntuarios();
	}

	
	
	public ControladorExames getControladorExames() {
		return conExame;
	}

	public ControladorCirurgia getControladorCirurgia() {
		return conCirurg;
	}

	public ControladorProntuarios getControladorProntuarios() {
		return conPront;
	}

	public void marcarConsulta(Date data, Animal animal, Medico medico) {
		//TODO
	}
	
	public void remarcarConsulta(Consulta consulta, Date novaData) {
		//TODO
	}
	
	public void marcarExame(Date data, Animal animal, Medico medico) throws ExisteException, NullException{
		Exame ex = new Exame(animal,medico,data);
		conExame.criarExame(ex);
	}
	
	public void remarcarExame(Exame exame, Date novaData) {
		
	}
	
	public void marcarCastracao(Animal animal, Medico medico, Date data) {
		
	}
	
	public void remarcarCastracao(Cirurgia cirurgia, Date novaData) {
		
	}
	
}
