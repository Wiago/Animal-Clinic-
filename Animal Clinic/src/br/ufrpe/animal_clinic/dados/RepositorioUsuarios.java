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
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class RepositorioUsuarios {
	
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>(10);
	
	Map<String,String> loginId = new HashMap<String,String>();
	
	public RepositorioUsuarios(int tamanho) {
        this.usuarios = new ArrayList<Usuario>(tamanho);
    }

    public RepositorioUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


	public void cadastrar(Usuario u) throws ExisteException{
		try {
            procurar(u.getId());
        } catch (NullException ex) {
            usuarios.add(u);
            loginId.put(u.getLogin(), u.getId()); //Key = login; Content = id
            System.out.println(usuarios);
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
	
	public ArrayList<Usuario> getUsuarios(){
		return usuarios;
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
		System.out.println("ok");
		try {
			csvReader = new BufferedReader(new FileReader(file));
			csvReader.readLine(); // ignore header!

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
		System.out.println(usuarios);
		for(Usuario us: usuarios) {
			loginId.put(us.getLogin(), us.getId());
			System.out.println("Key:"+us.getLogin()+","+loginId.get(us.getLogin()));
		}
		System.out.println(loginId.get("ccc123"));
		
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
