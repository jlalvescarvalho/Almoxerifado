/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.repositorio.implementacoes;

import br.edu.ifpe.repositorio.interfaces.RepositorioGenerico;
import br.edu.ifpe.execoes.MaterialNaoEncontradoException;
import br.edu.ifpe.negocio.Material;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1860915
 */
public class RepositorioMaterialImplMemo implements RepositorioGenerico<Material, Integer>{

    private List<Material> listaMaterial = null;
    
    protected RepositorioMaterialImplMemo(){
        this.listaMaterial = new ArrayList<>();
    }
    
    @Override
    public void inserir(Material material) {
        this.listaMaterial.add(material);
    }

    @Override
    public void alterar(Material material) throws MaterialNaoEncontradoException{
        Material m = null;
        for(int i = 0;i<this.listaMaterial.size();i++){
            m = this.listaMaterial.get(i);
            if(m.getCodigo()==material.getCodigo()){
                m.setNome(material.getNome());
                m.setMarca(material.getMarca());
                return;
            }
        }
        throw new MaterialNaoEncontradoException("o material não foi encontrado");
    }

    @Override
    public Material recuperar(Integer chave) {
        for(Material m:this.listaMaterial){
            if(m.getCodigo()==chave){
                return m;
            }
        }
        return null;
    }

    @Override
    public void deletar(Material material) {
        this.listaMaterial.remove(material);
    }

    @Override
    public List<Material> recuperarTodos() {
        return this.listaMaterial;
    }
    
}
