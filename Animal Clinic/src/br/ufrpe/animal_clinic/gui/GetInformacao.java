package br.ufrpe.animal_clinic.gui;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

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
import br.ufrpe.animal_clinic.negocio.beans.Genero;
import br.ufrpe.animal_clinic.negocio.beans.Login;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
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
	public void cadastrarU(String nome, String cpf, String senha, String login, Date data) throws ExisteException, NullException, ElementoJaExisteException {
		Usuario u = new Usuario(nome, cpf, senha, login, data);
		System.out.println(u.getId());
		s.cadastrarUsuario(u);
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
				if(u.getId().charAt(0) == '2') {
					return u.getId();
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
	
	public void salvar() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		s.salvarDados();
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
	
	public void CadastrarUsuario(String nomeS, String cpfS, String senhaS, String loginS, Date dataD) throws NullException, ElementoNaoExisteException, ElementoJaExisteException {
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
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate = formatter.format(data); 
	    c.setDataS(strDate);
	    c.setIdDonoAnimal(animal.getIdDono());
	    c.setIdMedico(medico.getId());
	    c.setNomeAnimal(animal.getNome());
		System.out.println(c);
		s.cadastrarCirurgia(c);
	}
	public void cadastrarCon(Animal animal, Medico medico, Date data) throws NullException, ExisteException {
		Consulta c = new Consulta(animal,medico,data);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate = formatter.format(data); 
	    c.setDataS(strDate);
	    c.setIdDonoAnimal(animal.getIdDono());
	    c.setIdMedico(medico.getId());
	    c.setNomeAnimal(animal.getNome());
		System.out.println(c);
		s.cadastrarConsulta(c);
		
	}
	
	public ArrayList<Cirurgia> getCirurgias(){
		//return s.getCirurgias();
		return null;
	}
	
	public void removerAn(Animal a) throws NullException, ElementoNaoExisteException {
		s.removerAnimal(a);
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
