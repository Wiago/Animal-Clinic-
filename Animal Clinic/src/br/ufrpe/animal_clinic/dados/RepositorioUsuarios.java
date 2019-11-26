package br.ufrpe.animal_clinic.dados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NotFoundException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class RepositorioUsuarios implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static RepositorioUsuarios instancia;

	private ArrayList<Usuario> usuarios;
	
	private Map<String,String> loginId;
	
	private RepositorioUsuarios() {
        this.usuarios = new ArrayList<Usuario>();
        this.loginId = new HashMap<String,String>();
    }

    /*public RepositorioUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }*/
	
	public static RepositorioUsuarios getInstancia() {
		if(instancia == null) {
			instancia = new RepositorioUsuarios();
		}
		return instancia;
	}

	public Map<String, String> getLoginId() {
		return loginId;
	}

	public void setLoginId(Map<String, String> loginId) {
		this.loginId = loginId;
	}

	public ArrayList<Usuario> getUsuarios(){
		return usuarios;
	}
	
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void cadastrar(Usuario u) throws ExisteException{
		try {
            procurar(u.getId());
        } catch (NullException ex) {
            usuarios.add(u);
            loginId.put(u.getLogin(), u.getId());
        }

	}

	
	public Usuario procurar(String id) throws NullException{
		Usuario u = null;
		boolean continuar = true;

		for (int j = 0; j < usuarios.size() && continuar; j++) {
			if (usuarios.get(j).getId().equals(id)) {
				u = usuarios.get(j);
	            continuar = false;
			}
	    }

		if (u == null) {
            NullException e = new NullException();
            throw e;
        }
	    
	    return u;
	}
	
	public Usuario procurarPorLogin(String login) throws NullException{
		Usuario u = null;
		boolean continuar = true;

		for (int j = 0; j < usuarios.size() && continuar; j++) {
			if (usuarios.get(j).getLogin().equals(login)) {
				u = usuarios.get(j);
	            continuar = false;
			}
	    }

		if (u == null) {
            NullException e = new NullException();
            throw e;
        }
	    
	    return u;
	}
	
	public String procurarIdPorLogin(String login) throws NullException{
		String id = loginId.get(login);
		if(id != null) {
			return id;
		}
		else {
			throw new NullException();
		}
	}


	public void remover(String id) throws NullException {
		try {
			Usuario u = procurar(id);
			usuarios.remove(u);
			loginId.remove(u.getLogin());
		}catch(NullException ex){
			NullException e = new NullException();
            throw e;
		}
        
    }
	
	 
	public ArrayList<Usuario> getDados() {
	        return usuarios;
	}
	
	public Map<String,String> getDadosLoginId() {
        return loginId;
	}
	
	public ArrayList<Usuario> listarPorData(Date d) throws NullException{
		  ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	      for (Usuario usuario : usuarios) {
	    	  if(usuario.getData().equals(d)) {
	    		  listaUsuarios.add(usuario);
	    	  }
	      }
	      if(listaUsuarios.size() == 0) {
	    	  throw new NullException();
	      }
	      return listaUsuarios;
	}
	
	
	public Usuario getUsuario() {
		Usuario b = null;
		for (int a = 0; a<this.usuarios.size();a++) {
			b = this.usuarios.get(a);
		}
		return b;
	}
	
	public void salvarDados(String file) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		System.out.println(usuarios);

        Writer writer = Files.newBufferedWriter(Paths.get(file));
        StatefulBeanToCsv<Usuario> beanToCsv = new StatefulBeanToCsvBuilder<Usuario>(writer).build();
        
        
        beanToCsv.write(usuarios);
        System.out.println(usuarios);
        writer.flush();
        writer.close();
	}
	
	public void carregarDados(String file) throws ClassNotFoundException, FileNotFoundException {
	    
		ArrayList<Usuario> users = new ArrayList<Usuario>();
		BufferedReader csvReader = null;
		String csvLine = null;
		
		try {
			csvReader = new BufferedReader(new FileReader(file));
			csvReader.readLine(); // ignore header!
			System.out.println("Linhas no arquivo (Usuários):");
			while ((csvLine = csvReader.readLine()) != null) {
				System.out.println(csvLine);
				users.add(Usuario.of(csvLine)); // create usuario object and add to repository
			}

		} catch (Exception e) {
			System.out.println("Erro ao ler arquivo!! | Linha lida: " + csvLine);
			e.printStackTrace();

		} finally {
			closeFile(csvReader);
		}
		
		usuarios.addAll(users);
		System.out.println("Usuários no Arquivo (toString):");
		System.out.println(usuarios);
		System.out.println("Usuários no Arquivo (Key,Login):");
		for(Usuario us: usuarios) {
			loginId.put(us.getLogin(), us.getId());
			System.out.println(us.getLogin()+","+loginId.get(us.getLogin()));
		}		
	}
	
	private static void closeFile(BufferedReader csvReader) {
		try {
			csvReader.close();
		} catch (IOException e) {
			System.out.println("Erro ao fechar arquivo!!");
			e.printStackTrace();
		}
	}
}
