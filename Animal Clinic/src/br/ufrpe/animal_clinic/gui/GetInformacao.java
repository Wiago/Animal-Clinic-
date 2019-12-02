package br.ufrpe.animal_clinic.gui;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import br.ufrpe.animal_clinic.exception.ElementoJaExisteException;
import br.ufrpe.animal_clinic.exception.ElementoNaoExisteException;
import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NotFoundException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.Servico;
import br.ufrpe.animal_clinic.negocio.beans.Alimentacao;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Atendente;
import br.ufrpe.animal_clinic.negocio.beans.Cirurgia;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.negocio.beans.Especie;
import br.ufrpe.animal_clinic.negocio.beans.Exame;
import br.ufrpe.animal_clinic.negocio.beans.Genero;
import br.ufrpe.animal_clinic.negocio.beans.Login;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
import br.ufrpe.animal_clinic.negocio.beans.Prontuario;
import br.ufrpe.animal_clinic.negocio.beans.TempoDeVida;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class GetInformacao {
	
	private static GetInformacao instancia;
	private String login;
	private String nomeAnimal;
	private Servico s;

	private GetInformacao() {
		s = Servico.getInstancia();
	}
	public static GetInformacao getInstancia() {
		if(instancia == null) {
			instancia = new GetInformacao();
		}
		return instancia;
	}

	
	public String loginUser(String login, String senha) throws NullException, ElementoNaoExisteException {
		Usuario u = null;
		Medico m = null;
		Atendente a = null;
		
		if(login != null && senha != null) {
			if(s.procurarUsuarioPorLogin(login) != null) {
				u = s.procurarUsuarioPorLogin(login);
				if(u.getId().charAt(0) == '3') {
					return u.getId();
				}
			}
			if(s.procurarMedicoPorLogin(login) != null) {
				m = s.procurarMedicoPorLogin(login);
				if(m.getId().charAt(0) == '2') {
					return m.getId();
				}
			}
			if(s.procurarAtendentePorLogin(login) != null) {
				a = s.procurarAtendentePorLogin(login);
				if(a.getId().charAt(0) == '1') {
					return a.getId();
				}
			
			}
		}
		return null;
	}
	
	public void salvar() throws IOException{
		s.salvarDados();
	}
	
	public void novoProntuario(Consulta c, String s) throws ElementoJaExisteException {
		Prontuario p = new Prontuario(c,s);
		this.s.gerarProntuario(p);
	}
	
	public List<Consulta> getListaDeSConsultas(){
		return s.listar();
	}
	
	public void cadastrarAtendente(String nomeS, String cpfS, String senhaS, String loginS, Date dataD) throws ExisteException, NullException, ElementoJaExisteException, ElementoNaoExisteException {
		Atendente a = new Atendente(nomeS, cpfS, senhaS, loginS, dataD);
		List<Atendente> b = s.getArrayAtendente();
		if(s.procurarAtendentePorLogin(loginS) == null) {
			s.cadastrarAtendente(a);
		}else {
			throw new ElementoJaExisteException(a); 
		}
	}
	
	public void cadastrarUsuario(String nomeS, String cpfS, String senhaS, String loginS, Date dataD) throws NullException, ElementoNaoExisteException, ElementoJaExisteException {
		Usuario u = new Usuario(nomeS, cpfS, senhaS, loginS, dataD);
		if(s.procurarUsuarioPorLogin(loginS) == null) {
			s.cadastrarUsuario(u);
		}else {
			throw new ElementoJaExisteException(u);
		}
	}

	public void cadastrarMedico(String nomeS, String cpfS, String senhaS, String loginS, Date dataD, String especialidade) throws ExisteException, NullException, ElementoJaExisteException, ElementoNaoExisteException {
		Medico m = new Medico(nomeS, cpfS, senhaS, loginS, especialidade,dataD);
		if(s.procurarMedicoPorLogin(loginS) == null) {
			s.cadastrarMedico(m);
		}else {
			throw new ElementoJaExisteException(m); 
		}
	}
	
	public void cadastrarAnimal(String nome, Usuario dono, Alimentacao alimentacao, Especie especie, Genero genero, TempoDeVida tempoDeVida) throws ExisteException, ElementoJaExisteException, ElementoNaoExisteException {
		Animal a = new Animal(nome, dono, alimentacao, especie, genero, tempoDeVida);
		if(s.procurarAnimalPorNome(nome) == null) {
			s.cadastrarAnimal(a);
		}else {
			throw new ElementoJaExisteException(a);
		}
	}
	
	public void cadastrarCir(Animal animal, Medico medico, Date data) throws NullException, ExisteException {
		Cirurgia c = new Cirurgia(animal,medico,data);
		s.cadastrarCirurgia(c);
	}
	public void cadastrarCon(Animal animal, Medico medico, LocalDate data, String hora, String descricao) throws NullException, ExisteException, ElementoJaExisteException, ElementoNaoExisteException {
		Consulta c = new Consulta(animal, medico, data, hora, descricao);
		Consulta p = s.procurarConsultaPorDataHora(data, hora);
		s.cadastrarConsulta(c);
	}
	
	public void cadastrarConsulta(Consulta c) throws NullException, ExisteException, ElementoJaExisteException {
		s.cadastrarConsulta(c);
	}
	
	public void cadastrarExame(Animal animal, Medico medico, LocalDate data, String hora, String relatorio) throws NullException, ExisteException, ElementoJaExisteException, ElementoNaoExisteException {
		Exame c = new Exame(animal, medico, data, hora);
		Exame p = s.procurarExamePorDataHora(data, hora);
		s.cadastrarExame(c);
	}
	
	public List<Consulta> getConsultas(){
		return s.getArrayConsultas();
	}
	
	public void removerAn(Animal a) throws NullException, ElementoNaoExisteException {
		s.removerAnimal(a);
	}
	
	public void removerConsulta(Consulta c) throws NullException, ElementoNaoExisteException {
		s.desmarcarConsulta(c.getId());
	}
	
	public void carregarDados() throws ClassNotFoundException, IOException, NotFoundException, ExisteException {
		s.getInstancia();
	}
	public List<Usuario> getDadosUsuarios(){
		return s.getArrayUsuario();
	}
	
	public List<Animal> getDadosAnimais(){
		return s.getArrayAnimal();
	}
	
	public List<Medico> getDadosMedicos(){
		return s.getArrayMedico();
	}
	
	public List<Atendente> getDadosAtendetes(){
		return s.getArrayAtendente();
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNomeAnimal() {
		return nomeAnimal;
	}
	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}
}
