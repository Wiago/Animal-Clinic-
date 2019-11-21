package br.ufrpe.animal_clinic.negocio;

import java.io.IOException;

import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NotFoundException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Atendente;
import br.ufrpe.animal_clinic.negocio.beans.Consulta;
import br.ufrpe.animal_clinic.negocio.beans.Exame;
import br.ufrpe.animal_clinic.negocio.beans.IServico;
import br.ufrpe.animal_clinic.negocio.beans.Login;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class Servico implements IServico{

	@Override
	public void cadastrarUsuario(Usuario u) throws ExisteException, NullException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cadastrarConsulta(Consulta c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cadastrarCirurgia() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerUsuario(String id) throws NullException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desmarcarConsulta(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desmarcarCirurgia() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void carregarDados() throws IOException, NotFoundException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Atendente efetuarLoginRecepcionista(Login l) throws NullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medico efetuarLoginMedico(Login l) throws NullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario efetuarLoginPaciente(Login l) throws NullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medico procurarMedico(String id) throws NullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario procurarUsuario(String id) throws NullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Atendente procurarRecepcionista(String id) throws NullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarDados() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void marcarExame(Exame e) {
		// TODO Auto-generated method stub
		
	}
	

}
