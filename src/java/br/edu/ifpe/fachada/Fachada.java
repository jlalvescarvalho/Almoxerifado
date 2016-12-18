/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.fachada;

import br.edu.ifpe.repositorio.interfaces.RepositorioGenerico;
import br.edu.ifpe.negocio.Fornecedor;
import br.edu.ifpe.negocio.Material;
import br.edu.ifpe.repositorio.implementacoes.FabricaRepositorio;
import br.edu.ifpe.repositorio.implementacoes.RepositorioMaterialImplMemo;
import java.util.List;

/**
 *
 * @author 1860915
 */
public class Fachada {
    private static Fachada myself = null;
    
    private RepositorioGenerico<Material,Integer> repositorioMaterial= null;
    private RepositorioGenerico<Fornecedor, Integer> repositorioFornecedor = null;
    
    private Fachada(){
        this.repositorioMaterial = FabricaRepositorio.criarRepositorio(FabricaRepositorio.MATERIAL,
                FabricaRepositorio.DB);
        this.repositorioFornecedor = FabricaRepositorio.criarRepositorio(FabricaRepositorio.FORNECEDOR,
                FabricaRepositorio.DB);
    }
    
    public static Fachada getInstance(){
        if(myself==null)
            myself = new Fachada();
        
        return myself;
    }
    
    
    public void inserir(Material material){
        this.repositorioMaterial.inserir(material);
    }
    
    public void alterar(Material material)throws Exception{
        this.repositorioMaterial.alterar(material);
    }
    
    public Material recuperarMaterial(int codigo){
        return this.repositorioMaterial.recuperar(codigo);
    }
    
    public void deletar(Material material){
        this.repositorioMaterial.deletar(material);
    }
    
    public List<Material> recuperarTodosMateriais(){
        return this.repositorioMaterial.recuperarTodos();
    }
    
    public void inserir(Fornecedor fornecedor){
        this.repositorioFornecedor.inserir(fornecedor);
    }
    
    public List<Fornecedor> recuperarTodosFornecedores(){
        return this.repositorioFornecedor.recuperarTodos();
    }
    
    public Fornecedor recuperarFornecedor(int codigo){
        return this.repositorioFornecedor.recuperar(codigo);
    }
    
    public void alterar(Fornecedor fornecedor) throws Exception{
        this.repositorioFornecedor.alterar(fornecedor);
    }
    
    public void excluir(Fornecedor fornecedor){
        this.repositorioFornecedor.deletar(fornecedor);
    }
}
