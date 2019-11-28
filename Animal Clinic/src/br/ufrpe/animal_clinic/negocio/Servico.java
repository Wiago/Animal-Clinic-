package br.ufrpe.animal_clinic.negocio;

import java.io.IOException;
import java.time.LocalDate;

import br.ufrpe.animal_clinic.exception.ElementoJaExisteException;
import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
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
import br.ufrpe.animal_clinic.negocio.negocioN.ControladorAnimal;
import br.ufrpe.animal_clinic.negocio.negocioN.ControladorAtendente;
import br.ufrpe.animal_clinic.negocio.negocioN.ControladorConsulta;
import br.ufrpe.animal_clinic.negocio.negocioN.ControladorMedico;
import br.ufrpe.animal_clinic.negocio.negocioN.ControladorUsuario;

import java.util.ArrayList;
import java.util.List;




public class Servico implements IServico{
	
	private static Servico instancia;
	

	private ControladorUsuario usuario;
	private ControladorMedico medico;
	private ControladorAtendente atendente;
	private ControladorAnimal animal;
	private ControladorConsulta consulta;
	//private ControladorExame exame;
	//private ControladorProntuario prontuario;
	
	
	private Servico() {
		usuario = ControladorUsuario.getInstance();
		medico = ControladorMedico.getInstance();
		atendente = ControladorAtendente.getInstance();
		animal = ControladorAnimal.getInstance();
		consulta = ControladorConsulta.getInstance();
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
	
	public void cadastrarMedico(Medico m) throws ElementoJaExisteException {
		this.medico.inserir(m);
	}
	
	public void cadastrarAtendente(Atendente a) throws ElementoJaExisteException {
		this.atendente.inserir(a);
	}
	
	public void cadastrarAnimal(Animal a) throws ElementoJaExisteException {
		this.animal.inserir(a);
	}

	@Override
	public void cadastrarConsulta(Consulta c) throws NullException, ExisteException, ElementoJaExisteException {
		this.consulta.inserir(c);
	}

	@Override
	public void cadastrarCirurgia(Cirurgia c) throws NullException, ExisteException {
		//this.cirurgias.criarCirurgia(c);
	}
	

	@Override
	public void removerUsuario(Usuario u) throws NullException, ElementoNaoExisteException {
		this.usuario.remover(u);
	}
	
	public void removerAtendente(Atendente a) throws NullException, ElementoNaoExisteException {
		this.atendente.remover(a);
	}
	
	public void removerAnimal(Animal a) throws NullException, ElementoNaoExisteException {
		this.animal.remover(a);
	}
	
	public void removerMedico(Medico m) throws NullException, ElementoNaoExisteException {
		this.medico.remover(m);
	}

	@Override
	public void desmarcarConsulta(String id) throws NullException, ElementoNaoExisteException {
		Consulta c = this.consulta.procurarPorId(id);
		this.consulta.remover(c);
	}

	@Override
	public void desmarcarCirurgia(String id) throws NullException {
		//this.cirurgias.getRepositorio().remover(this.cirurgias.procurar(id));
		
	}



	@Override
	public Usuario efetuarLoginUsuario(String login, String senha) throws NullException {
		System.out.println("ok");
		Usuario a = null;
		List <Usuario> u = usuario.listar();
		for(Usuario b:u) {
			if (b.getLogin().equals(login)) {
				if(b.getSenha().equals(senha)) {
					a = b;
				}
			}
		}
		if(a==null) {
			throw new NullException();
		}
		else {
			return a;
		}
	}
	public Atendente efetuarLoginAtendente(String login, String senha) throws NullException {
		System.out.println("ok");
		Atendente a = null;
		List <Atendente> u = atendente.listar();
		for(Atendente b:u) {
			if (b.getLogin().equals(login)) {
				if(b.getSenha().equals(senha)) {
					a = b;
				}
			}
		}
		if(a==null) {
			throw new NullException();
		}
		else {
			return a;
		}
	}
	public Medico efetuarLoginMedico(String login, String senha) throws NullException {
		System.out.println("ok");
		Medico a = null;
		List <Medico> u = medico.listar();
		for(Medico b:u) {
			if (b.getLogin().equals(login)) {
				if(b.getSenha().equals(senha)) {
					a = b;
				}
			}
		}
		if(a==null) {
			throw new NullException();
		}
		else {
			return a;
		}
	}
	/*
	public String procurarIdPorLogin(String login) throws NullException {
		return usuarios.procurarIdPorLogin(login);
	}

	
	
	public Medico procurarMedicoPorLogin(String login) throws NullException {
		return usuarios.procurarMedicoPorLogin(login);
	}

	
	
	public Usuario procurarUsuarioPorLogin(String login) throws NullException {
		return usuarios.procurarPorLogin(login);
	}

	
	
	public Atendente procurarAtendentePorLogin(String login) throws NullException {
		return usuarios.procurarAtendentePorLogin(login);
	}
	*/
	
	public List<Medico> getArrayMedico(){
		return medico.listar();
	}
	
	public List<Usuario> getArrayUsuario(){
		return usuario.listar();
	}
	
	public List<Atendente> getArrayAtendente(){
		return atendente.listar();
	}
	
	public List<Animal> getArrayAnimal(){
		return animal.listar();
	}
	
	@Override
	public void salvarDados() throws IOException{
		try {	
		//this.exames.getRepositorio().salvarDados("HistoricoDeExames.txt");
		//this.prontuarios.getRepositorio().salvarDados("HistoricoDeProntuarios.txt");*/
			this.animal = ControladorAnimal.getInstance();
			this.atendente = ControladorAtendente.getInstance();
			this.medico = ControladorMedico.getInstance();
			this.usuario = ControladorUsuario.getInstance();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void marcarExame(Exame e) throws NullException, ExisteException {
		//this.exames.criarExame(e);	
	}
	
	@Override
	public void removerAnimal(String nomeAnimal, String loginDono) throws NullException {
		//usuarios.getRepositorioAnimais().removerPorLoginDoDono(nomeAnimal, loginDono);
	}

	@Override
	public void removerUsuario(String id) throws NullException {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public Medico procurarMedicoPorLogin(String login) throws NullException, ElementoNaoExisteException {
		return medico.procurarPorLogin(login);
	}

	

	@Override
	public Usuario procurarUsuarioPorLogin(String login) throws NullException, ElementoNaoExisteException {
		return usuario.procurarPorLogin(login);
	}

	

	@Override
	public Atendente procurarAtendentePorLogin(String login) throws NullException, ElementoNaoExisteException {
		return atendente.procurarPorLogin(login);
	}

	@Override
	public Animal procurarAnimalPorNome(String nome) throws ElementoNaoExisteException {
		return animal.procurarPorNome(nome);
	}

	@Override
	public Usuario procurarDonoAnimal(String login) throws ElementoNaoExisteException {
		return animal.procurarDono(login);
	}
	
	public Consulta procurarConsultaPorId(String id) throws ElementoNaoExisteException {
		return this.consulta.procurarPorId(id);
	}
	
	public Consulta procurarConsultaPorDataHora(LocalDate data, String hora) throws ElementoNaoExisteException {
		return this.consulta.procurarPorDataHora(data, hora);
	}
	

}
