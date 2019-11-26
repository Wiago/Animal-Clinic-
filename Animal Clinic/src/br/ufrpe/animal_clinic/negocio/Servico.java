package br.ufrpe.animal_clinic.negocio;

import java.io.IOException;

import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NotFoundException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Atendente;
import br.ufrpe.animal_clinic.negocio.beans.Cirurgia;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.negocio.beans.Exame;
import br.ufrpe.animal_clinic.negocio.beans.IServico;
import br.ufrpe.animal_clinic.negocio.beans.Login;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;


public class Servico implements IServico{
	
	private static Servico instancia;
	
	private ControladorUsuarios usuarios;
	private ControladorConsultas consultas;
	private ControladorExames exames;
	private ControladorCirurgias cirurgias;
	private ControladorProntuarios prontuarios;
	
	private Servico() {
		usuarios = ControladorUsuarios.getInstancia();
		consultas = ControladorConsultas.getInstancia();
		exames = ControladorExames.getInstancia();
		cirurgias = ControladorCirurgias.getInstancia();
		prontuarios = ControladorProntuarios.getInstancia();
	}
	public static Servico getInstancia() {
		if(instancia == null) {
			instancia = new Servico();
		}
		return instancia;
	}

	@Override
	public void cadastrarUsuario(Usuario u) throws ExisteException, NullException {
		this.usuarios.cadastrar(u);	
	}

	@Override
	public void cadastrarConsulta(Consulta c) throws NullException, ExisteException {
		this.consultas.criarConsulta(c);
	}

	@Override
	public void cadastrarCirurgia(Cirurgia c) throws NullException, ExisteException {
		this.cirurgias.criarCirurgia(c);
		
	}

	@Override
	public void removerUsuario(String id) throws NullException {
		this.usuarios.remover(this.usuarios.procurar(id));
		
	}

	@Override
	public void desmarcarConsulta(String id) throws NullException {
		this.consultas.getRepositorio().remover(this.consultas.procurar(id));;
		
	}

	@Override
	public void desmarcarCirurgia(String id) throws NullException {
		this.cirurgias.getRepositorio().remover(this.cirurgias.procurar(id));
		
	}

	@Override
	public void carregarDados() throws IOException, NotFoundException, ClassNotFoundException {
		//this.cirurgias.getRepositorio().carregarDados("HistoricoDeCirurgia.txt");
		//this.consultas.getRepositorio().carregarDados("HistoricoDeConsultas.txt");
		//this.exames.getRepositorio().carregarDados("HistoricoDeExames.txt");
		//this.prontuarios.getRepositorio().carregarDados("HistoricoDeProntuarios.txt");
		this.usuarios.getRepositorio().carregarDados("HistoricoDeUsuarios.csv");
	}


	@Override
	public Usuario efetuarLogin(String login) throws NullException {
		System.out.println("ok");
		Usuario u = usuarios.procurarPorLogin(login);
		if(u != null) {
			System.out.println("Ok - achou o usu�rio por login!");
		}
		return u;
	}
	
	public String procurarIdPorLogin(String login) throws NullException {
		return usuarios.procurarIdPorLogin(login);
	}

	@Override
	public Medico procurarMedico(String id) throws NullException {
		return (Medico) usuarios.procurar(id);
	}
	
	public Medico procurarMedicoPorLogin(String login) throws NullException {
		return (Medico) usuarios.procurarPorLogin(login);
	}

	@Override
	public Usuario procurarUsuario(String id) throws NullException {
		return usuarios.procurar(id);
	}
	
	public Usuario procurarUsuarioPorLogin(String login) throws NullException {
		return usuarios.procurarPorLogin(login);
	}

	@Override
	public Atendente procurarAtendente(String id) throws NullException {
		return (Atendente) usuarios.procurar(id);
	}
	
	public Atendente procurarAtendentePorLogin(String login) throws NullException {
		return (Atendente) usuarios.procurarPorLogin(login);
	}

	@Override
	public void salvarDados() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		try {	
		/*this.cirurgias.getRepositorio().salvarDados("HistoricoDeCirurgia.txt");
		this.consultas.getRepositorio().salvarDados("HistoricoDeConsultas.txt");
		this.exames.getRepositorio().salvarDados("HistoricoDeExames.txt");
		this.prontuarios.getRepositorio().salvarDados("HistoricoDeProntuarios.txt");*/
		this.usuarios.getRepositorio().salvarDados("HistoricoDeUsuarios.csv");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void marcarExame(Exame e) throws NullException, ExisteException {
		this.exames.criarExame(e);
		
	}
	
	public ArrayList<Usuario> getDadosUsuarios(){
		return usuarios.getDados();
	}

}
