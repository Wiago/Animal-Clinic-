package br.ufrpe.animal_clinic.negocio;

import java.io.IOException;

import br.ufrpe.animal_clinic.exception.ElementoJaExisteException;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NotFoundException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Atendente;
import br.ufrpe.animal_clinic.negocio.beans.Cirurgia;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.negocio.beans.Exame;
import br.ufrpe.animal_clinic.negocio.beans.IServico;
import br.ufrpe.animal_clinic.negocio.beans.Login;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;
import br.ufrpe.animal_clinic.negocio.negocioN.ControladorMedico;
import br.ufrpe.animal_clinic.negocio.negocioN.ControladorUsuario;

import java.util.ArrayList;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;


public class Servico implements IServico{
	
	private static Servico instancia;
	
	private ControladorUsuarios usuarios;
	private ControladorUsuario usuario;
	private ControladorMedico medico;
	private ControladorConsultas consultas;
	private ControladorExames exames;
	private ControladorCirurgias cirurgias;
	private ControladorProntuarios prontuarios;
	
	private Servico() {
		usuario = ControladorUsuario.getInstance();
		medico = ControladorMedico.getInstance();
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
	public void cadastrarUsuario(Usuario u) throws ElementoJaExisteException {
		this.usuario.inserir(u);
		//this.usuarios.cadastrar(u);	
	}

	@Override
	public void cadastrarConsulta(Consulta c) throws NullException, ExisteException {
		this.consultas.criarConsulta(c);
	}

	@Override
	public void cadastrarCirurgia(Cirurgia c) throws NullException, ExisteException {
		this.cirurgias.criarCirurgia(c);
		
	}
	
	public ArrayList<Cirurgia> getCirurgias(){
		return cirurgias.getRepositorio().getCirurgias();
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
	public void carregarDados() throws IOException, NotFoundException, ClassNotFoundException, ExisteException {
		
		//this.exames.getRepositorio().carregarDados("HistoricoDeExames.txt");
		//this.prontuarios.getRepositorio().carregarDados("HistoricoDeProntuarios.txt");
		this.usuarios.getRepositorio().carregarDados("HistoricoDeUsuarios.csv");
		this.usuarios.getRepositorioAnimais().carregarDados("HistoricoDeAnimais.csv");
		this.cirurgias.getRepositorio().carregarDados("HistoricoDeCirurgias.csv");
		this.consultas.getRepositorio().carregarDados("HistoricoDeConsultas.csv");
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
		return usuarios.procurarMedico(id);
	}
	
	public Medico procurarMedicoPorLogin(String login) throws NullException {
		return usuarios.procurarMedicoPorLogin(login);
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
		return usuarios.procurarAtendente(id);
	}
	
	public Atendente procurarAtendentePorLogin(String login) throws NullException {
		return usuarios.procurarAtendentePorLogin(login);
	}
	
	public ArrayList<Medico> getArrayMedico(){
		return usuarios.getDadosMedico();
	}

	@Override
	public void salvarDados() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		try {	
		//this.exames.getRepositorio().salvarDados("HistoricoDeExames.txt");
		//this.prontuarios.getRepositorio().salvarDados("HistoricoDeProntuarios.txt");*/
		this.usuarios.getRepositorio().salvarDados("HistoricoDeUsuarios.csv");
		this.usuarios.getRepositorioAnimais().salvarDados("HistoricoDeAnimais.csv");
		this.cirurgias.getRepositorio().salvarDados("HistoricoDeCirurgias.csv");
		this.consultas.getRepositorio().salvarDados("HistoricoDeConsultas.csv");
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
	public ArrayList<Animal> getDadosAnimais(){
		return usuarios.getDadosAnimais();
	}
	
	@Override
	public void cadastrarAnimal(Animal a) throws ExisteException {
		usuarios.getRepositorioAnimais().cadastrar(a);
	}
	@Override
	public void removerAnimal(String nomeAnimal, String loginDono) throws NullException {
		usuarios.getRepositorioAnimais().removerPorLoginDoDono(nomeAnimal, loginDono);
	}

}
