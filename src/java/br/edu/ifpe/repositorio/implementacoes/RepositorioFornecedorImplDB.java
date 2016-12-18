/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.repositorio.implementacoes;

import br.edu.ifpe.dao.DaoManagerHiber;
import br.edu.ifpe.negocio.Fornecedor;
import br.edu.ifpe.repositorio.interfaces.RepositorioGenerico;
import java.util.List;

/**
 *
 * @author 1860915
 */
public class RepositorioFornecedorImplDB implements RepositorioGenerico<Fornecedor, Integer>{

    @Override
    public void inserir(Fornecedor t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Fornecedor t) throws Exception {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Fornecedor recuperar(Integer chave) {
        try{
            return (Fornecedor)DaoManagerHiber.getInstance().recover("from Fornecedor where codigo = "+chave).get(0);
        }catch(IndexOutOfBoundsException ex){
            return null;
        }
    }

    @Override
    public void deletar(Fornecedor t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Fornecedor> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Fornecedor");
    }
    
}
