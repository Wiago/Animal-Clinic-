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


public class Servico implements IServico{
	
	private ControladorUsuarios usuarios;
	private ControladorConsultas consultas;
	private ControladorExames exames;
	private ControladorCirurgias cirurgias;
	private ControladorProntuarios prontuarios;

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
		this.cirurgias.getRepositorio().carregarDados("HistoricoDeCirurgia.txt");
		this.consultas.getRepositorio().carregarDados("HistoricoDeConsultas.txt");
		this.exames.getRepositorio().carregarDados("HistoricoDeExames.txt");
		this.prontuarios.getRepositorio().carregarDados("HistoricoDeProntuarios.txt");
		this.usuarios.getRepositorio().carregarDados("HistoricoDeUsuarios.txt");
	}

	@Override
	public Atendente efetuarLoginRecepcionista(Login l) throws NullException {
		Atendente a = (Atendente) usuarios.procurar(l.getId());
		return (Atendente) a;
	}

	@Override
	public Medico efetuarLoginMedico(Login l) throws NullException {
		Medico m = (Medico) usuarios.procurar(l.getId());
		return m;
	}

	@Override
	public Usuario efetuarLoginUsuario(Login l) throws NullException {
		System.out.println("ok");
		Usuario u = usuarios.getRepositorio().procurar(l.getId());
		return u;
	}

	@Override
	public Medico procurarMedico(String id) throws NullException {
		return (Medico) usuarios.getRepositorio().procurar(id);
	}

	@Override
	public Usuario procurarUsuario(String id) throws NullException {
		return usuarios.getRepositorio().procurar(id);
	}

	@Override
	public Atendente procurarAtendente(String id) throws NullException {
		return (Atendente) usuarios.getRepositorio().procurar(id);
	}

	@Override
	public void salvarDados() throws IOException {
		this.cirurgias.getRepositorio().salvarDados("HistoricoDeCirurgia.txt");
		this.consultas.getRepositorio().salvarDados("HistoricoDeConsultas.txt");
		this.exames.getRepositorio().salvarDados("HistoricoDeExames.txt");
		this.prontuarios.getRepositorio().salvarDados("HistoricoDeProntuarios.txt");
		this.usuarios.getRepositorio().salvarDados("HistoricoDeUsuarios.txt");
	}

	@Override
	public void marcarExame(Exame e) throws NullException, ExisteException {
		this.exames.criarExame(e);
		
	}

}
