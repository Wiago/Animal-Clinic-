package br.ufrpe.animal_clinic.negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import br.ufrpe.animal_clinic.dados.RepositorioUsuarios;
import br.ufrpe.animal_clinic.exception.UsuarioExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

public class ControladorUsuarios {
	private RepositorioUsuarios repositorio;
	
	public void cadastrar(Usuario u) throws UsuarioExisteException, NullException {
		
		if(u != null) {
			repositorio.cadastrar(u);
		}else {
			NullException e = new NullException();
            throw e;
		}
		
	}
	
	public void alterarLogin(Usuario u, String login) throws NullException {
		if(u != null) {
			Usuario u1 = procurar(u.getId());
			u1.setLogin(login);
		}else {
			NullException e = new NullException();
            throw e;
		}
	} 
	
	public void remover(Usuario u) throws NullException{
		repositorio.remover(u.getId());
	}
	
	public Usuario procurar(String id) throws NullException {
        return this.repositorio.procurar(id);
    }
	
	public void salvarDados(String file) throws IOException {
        File arquivo = new File(file);
        FileOutputStream fos = new FileOutputStream(arquivo);
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(this.repositorio.getDados());
        ous.close();
    }
	
	public void carregarDados(String file) {
        
        File arquivo = new File(file);
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(arquivo);

            try {
                ois = new ObjectInputStream(fis);
                this.repositorio = new RepositorioUsuarios((ArrayList<Usuario>) ois.readObject());
                ois.close();
            } catch (IOException ex) {
                this.repositorio = new RepositorioUsuarios(15);
            } catch (ClassNotFoundException ex) {
                this.repositorio = new RepositorioUsuarios(15);
            }
        } catch (FileNotFoundException ex) {
            this.repositorio = new RepositorioUsuarios(15);
        }
    }
	
	public ArrayList<Usuario> getDados() {
        return this.repositorio.getDados();
    }
}
