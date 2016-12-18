/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.repositorio.implementacoes;

import br.edu.ifpe.dao.DaoManagerHiber;
import br.edu.ifpe.negocio.Material;
import br.edu.ifpe.repositorio.interfaces.RepositorioGenerico;
import java.util.List;

/**
 *
 * @author 1860915
 */
public class RepositorioMaterialImplDB implements RepositorioGenerico<Material, Integer>{

    @Override
    public void inserir(Material t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Material t) throws Exception {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Material recuperar(Integer chave) {
        return (Material)DaoManagerHiber.getInstance().recover("from Material where codigo = "+chave).get(0);
    }

    @Override
    public void deletar(Material t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Material> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Material");
    }
    
}
