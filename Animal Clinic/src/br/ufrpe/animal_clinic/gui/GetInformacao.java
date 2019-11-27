package br.ufrpe.animal_clinic.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NotFoundException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.Servico;
import br.ufrpe.animal_clinic.negocio.beans.Alimentacao;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Atendente;
import br.ufrpe.animal_clinic.negocio.beans.Especie;
import br.ufrpe.animal_clinic.negocio.beans.Genero;
import br.ufrpe.animal_clinic.negocio.beans.Login;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
import br.ufrpe.animal_clinic.negocio.beans.TempoDeVida;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class GetInformacao {
	
	private static GetInformacao instancia;
	private Servico s;
	private Login l;
	private Usuario u;
	private String login;
	private Animal a;

	private GetInformacao() {
		s = Servico.getInstancia();
	}
	public static GetInformacao getInstancia() {
		if(instancia == null) {
			instancia = new GetInformacao();
		}
		return instancia;
	}
	public void cadastrarU(String nome, String cpf, String senha, String login, Date data) throws ExisteException, NullException {
		Usuario u = new Usuario(nome, cpf, senha, login, data);
		//u.setId(3); 
		System.out.println(u.getId());
		s.cadastrarUsuario(u);
	}
	
	public String loginUser(String login, String senha) throws NullException {
		String id = s.procurarIdPorLogin(login);
		if(id != null) {
			switch(id.charAt(0)) {
				case '1':
					Usuario a = s.efetuarLogin(login);
					if(a != null && a.getSenha().equals(senha)) {
						return a.getId();
					}
					break;
				case '2':
					Usuario m = s.efetuarLogin(login);
					if(m != null && m.getSenha().equals(senha)) {
						return m.getId();
					}
					break;
				case '3':
					Usuario u = s.efetuarLogin(login);
					if(u != null && u.getSenha().equals(senha)) {
						return u.getId();
					}
					break;
			}
		}
		return null;
		
	}
	
	public void salvar() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		s.salvarDados();
	}
	
	public void carregar() throws ClassNotFoundException, IOException, NotFoundException {
		s.carregarDados();
	}

	public void cadastrarA(String nomeS, String cpfS, String senhaS, String loginS, Date dataD) throws ExisteException, NullException {
		Usuario a = new Atendente(nomeS, cpfS, senhaS, loginS, dataD);
		//a.setId(1);
		System.out.println(a.getId());
		s.cadastrarUsuario(a);
	}

	public void cadastrarM(String nomeS, String cpfS, String senhaS, String loginS, Date dataD) throws ExisteException, NullException {
		Usuario m = new Medico(nomeS, cpfS, senhaS, loginS, dataD);
		//m.setId(2);
		System.out.println(m.getId());
		s.cadastrarUsuario(m);
	}
	
	public void cadastrarAn(String nome, Usuario dono, Alimentacao alimentacao, Especie especie, Genero genero, TempoDeVida tempoDeVida) throws ExisteException {
		Animal a = new Animal(nome, dono, alimentacao, especie, genero, tempoDeVida);
		s.cadastrarAnimal(a);
	}
	
	public void removerAn(Animal a) throws NullException {
		s.removerAnimal(a.getNome(), a.getDono().getLogin());
	}
	
	public void carregarDados() throws ClassNotFoundException, IOException, NotFoundException {
		s.carregarDados();
	}
	public ArrayList<Usuario> getDadosUsuarios(){
		return s.getDadosUsuarios();
	}
	
	public ArrayList<Animal> getDadosAnimais(){
		return s.getDadosAnimais();
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Animal getA() {
		return a;
	}
	public void setA(Animal a) {
		this.a = a;
	}
	public Usuario getU() {
		return u;
	}
	public void setU(Usuario u) {
		this.u = u;
	}
}
