package br.ufrpe.animal_clinic.negocio.beans;
import java.util.Date;
import br.ufrpe.animal_clinic.negocio.ControladorExames;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.ControladorCirurgia;
import br.ufrpe.animal_clinic.negocio.ControladorConsultas;
import br.ufrpe.animal_clinic.negocio.ControladorProntuarios;

public class Atendente extends Usuario {
	private ControladorExames conExame;
	private ControladorCirurgia conCirurg;
	private ControladorProntuarios conPront;
	private ControladorConsultas conCons;
	
	public Atendente(String nome, String cpf, String senha, String login, Date dataNas) {
		super(nome, cpf, senha, login, dataNas);
		this.setId(1);
		conExame = ControladorExames.getInstancia();
		conCirurg = ControladorCirurgia.getInstancia();
		conPront = ControladorProntuarios.getInstancia();
		conCons = ControladorConsultas.getInstancia();
	}
	
	public String getId() {
		return getId();
	}
	
	public ControladorExames getControladorExames() {
		return conExame;
	}

	public ControladorCirurgia getControladorCirurgias() {
		return conCirurg;
	}

	public ControladorProntuarios getControladorProntuarios() {
		return conPront;
	}
	
	public ControladorConsultas getControladorConsultas() {
		return conCons;
	}

	public void marcarConsulta(Date data, Animal animal, Medico medico) throws NullException, ExisteException {
		Consulta co = new Consulta(animal, medico, data);
		conCons.criarConsulta(co);
	}
	public void marcarConsulta(Consulta con) throws NullException, ExisteException {
		conCons.criarConsulta(con);
	}
	
	public void remarcarConsulta(Consulta consulta, Date novaData) throws NullException {
		conCons.remarcarConsulta(consulta, novaData);
	}
	
	public void marcarExame(Date data, Animal animal, Medico medico) throws ExisteException, NullException{
		Exame ex = new Exame(animal,medico,data);
		conExame.criarExame(ex);
	}
	public void marcarExame(Exame ex) throws ExisteException, NullException{
		conExame.criarExame(ex);
	}
	
	public void remarcarExame(Exame exame, Date novaData) throws NullException, ExisteException {
		conExame.remarcarExame(exame, novaData);
	}
	
	public void marcarCastracao(Date data, Animal animal, Medico medico) throws NullException, ExisteException {
		Cirurgia cir = new Cirurgia(animal, medico, data);
		conCirurg.criarCirurgia(cir);
	}
	public void marcarCastracao(Cirurgia cir) throws NullException, ExisteException {
		conCirurg.criarCirurgia(cir);
	}
	
	public void remarcarCastracao(Cirurgia cirurgia, Date novaData) throws NullException, ExisteException {
		conCirurg.remarcarCirurgia(cirurgia, novaData);
	}
	
}
