package br.ufrpe.animal_clinic.dados.dadosN;

import java.util.List;

import br.ufrpe.animal_clinic.exception.*;

public interface IRepositorioGenerico<T> {
    
    void inserir(T obj) throws ElementoJaExisteException;
    
    List<T> listar();
    
    T procurar(T objeto);
    
    void remover(T obj) throws ElementoNaoExisteException;

    void atualizar(T newObj) throws ElementoNaoExisteException;

}
