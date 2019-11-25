package br.ufrpe.animal_clinic.gui;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NotFoundException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.Servico;
import br.ufrpe.animal_clinic.negocio.beans.Atendente;
import br.ufrpe.animal_clinic.negocio.beans.Login;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class GetInformacao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Servico s = Servico.getInstancia();
	private Login l;
	
	public void cadastrarU(String nome, String cpf, String senha, String login, Date data) throws ExisteException, NullException {
		Usuario u = new Usuario(nome, cpf, senha, login, data);
		//u.setId(3);
		System.out.println(u.getId());
		s.cadastrarUsuario(u);
	}
	
	public void loginUser(String login, String senha) throws NullException {
		String id = s.procurarIdPorLogin(login);
		if(id != null) {
			switch(id.charAt(0)) {
				case '1':
					s.efetuarLoginAtendente(login);
					break;
				case '2':
					s.efetuarLoginMedico(login);
					break;
				case '3':
					s.efetuarLoginUsuario(login);
					break;
			}
		}
	}
	
	public void salvar() throws IOException {
		s.salvarDados();
	}
	
	public void carregar() throws ClassNotFoundException, IOException, NotFoundException {
		s.carregarDados();
	}

	public void cadastrarA(String nomeS, String cpfS, String senhaS, String loginS, Date dataD) throws ExisteException, NullException {
		Atendente a = new Atendente(nomeS, cpfS, senhaS, loginS, dataD);
		a.setId(1);
		System.out.println(a.getId());
		s.cadastrarUsuario(a);
	}

	public void cadastrarM(String nomeS, String cpfS, String senhaS, String loginS, Date dataD) throws ExisteException, NullException {
		Medico m = new Medico(nomeS, cpfS, senhaS, loginS, dataD);
		m.setId(2);
		System.out.println(m.getId());
		s.cadastrarUsuario(m);
	}
}
