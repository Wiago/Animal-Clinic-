package br.ufrpe.animal_clinic.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.ufrpe.animal_clinic.exception.*;

public class RepositorioGenerico<T> implements IRepositorioGenerico<T> {
    
    protected List<T> elementos;
    private String filename;
    
    @SuppressWarnings("unchecked")
    public RepositorioGenerico(String filename) {
        this.filename = filename;
        this.elementos = new ArrayList<>();
        
        Object listaElementos = RepositorioFileUtil.lerDoArquivo(this.filename); 
        if (listaElementos != null && listaElementos instanceof List<?>){
            this.elementos = (List<T>) listaElementos;
        }
    }
   
    @Override
    public void inserir(T novoObj) throws ElementoJaExisteException  {
        if (!this.elementos.contains(novoObj)) {
            this.elementos.add(novoObj);
        } else {
            throw new ElementoJaExisteException(novoObj);
        }
        
        RepositorioFileUtil.salvarArquivo(elementos, this.filename);
    }

    @Override
    public List<T> listar() {
        return Collections.unmodifiableList(this.elementos);
    }

    /**
     * M�todo deve remover um elemento previamente cadastrado no reposit�rio.
     * 
     * A implementa��o deste m�todo deve OBRIGATORIAMENTE usar o m�todo indexOf
     * da classe java.util.List para encontrar o �ndice de um determinado objeto
     * do reposit�rio e remov�-lo.
     * 
     * @throws ElementoNaoExisteException
     *             Exce��o dever� ser levantada se, ao tentar remover um
     *             elemento da lista, o mesmo n�o exista no reposit�rio
     */
    @Override
    public void remover(T obj) throws ElementoNaoExisteException {
        if (this.elementos.contains(obj)) {
            this.elementos.remove(this.elementos.indexOf(obj));
        } else {
            throw new ElementoNaoExisteException(obj);
        }
        
        RepositorioFileUtil.salvarArquivo(elementos, this.filename);
    }

    /**
     * M�todo deve atualizar um elemento previamente cadastrado no reposit�rio.
     * 
     * A implementa��o deste m�todo deve OBRIGATORIAMENTE usar o m�todo indexOf
     * da classe java.util.List para encontrar o �ndice de um determinado voo e
     * atualiz�-lo.
     * 
     * @throws ElementoNaoExisteException
     *             Exce��o dever� ser levantada se, ao tentar procurar um
     *             elemento para ser atualizado, o mesmo n�o exista no
     *             reposit�rio
     */
    @Override
    public void atualizar(T newObj) throws ElementoNaoExisteException {
        if (this.elementos.contains(newObj)) {
            int indice = this.elementos.indexOf(newObj);
            this.elementos.set(indice, newObj);
        } else {
            throw new ElementoNaoExisteException(newObj);
        }
        
        RepositorioFileUtil.salvarArquivo(elementos, this.filename);
    }

	@Override
	public T procurar(T objeto) {
		for(T obj:elementos) {
			if(obj.equals(objeto)) {
				return obj;
			}
		}
		return null;
	}
    
}
