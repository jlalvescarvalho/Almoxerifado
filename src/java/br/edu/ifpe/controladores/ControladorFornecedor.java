/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controladores;

import br.edu.ifpe.negocio.Fornecedor;
import br.edu.ifpe.repositorio.implementacoes.FabricaRepositorio;
import br.edu.ifpe.repositorio.interfaces.RepositorioGenerico;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author 1860915
 */
@ManagedBean
@SessionScoped
public class ControladorFornecedor {
    
    private RepositorioGenerico<Fornecedor,Integer> repositorioFornecedor = null;
    private Fornecedor selectedFornecedor;
    
    public ControladorFornecedor(){
        this.repositorioFornecedor = FabricaRepositorio.criarRepositorio(FabricaRepositorio.FORNECEDOR,
                FabricaRepositorio.DB);
    }
    
    public String inserir(Fornecedor fornecedor){
        
        try{
            Long.parseLong(fornecedor.getCpf_cnpj());
        }catch(NumberFormatException ne){
            FacesContext.getCurrentInstance().addMessage("formulario:inCPF", new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "Digite apenas números no CPF!"));
            return null;
        }
        try{
        
        this.repositorioFornecedor.inserir(fornecedor);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Parabéns, Fornecedor Cadastrado com sucesso"));
        
        return "apresentafornecedores.xhtml";
        }catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um problema ao adicionar um novo fornecedor."));
            return null;
        }
    }
    
    public String alterar(Fornecedor fornecedor){
        try {
            this.repositorioFornecedor.alterar(fornecedor);
            
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("O Fornecedor "+fornecedor.getNome()+" foi "
                            + "Alterado com sucesso!"));
            
            return "apresentarfornecedores.xhtml";
            
        } catch (Exception ex) {
            Logger.getLogger(ControladorFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Fornecedor recuperarFornecedor(int codigo){
        return this.repositorioFornecedor.recuperar(codigo);
    }
    
    public void deletar(Fornecedor fornecedor){
        this.repositorioFornecedor.deletar(fornecedor);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
        "O fornecedor "+fornecedor.getNome()+" foi excluído com sucesso!!!"));
        
    }
    
    public List<Fornecedor> recuperarTodosFornecedores(){
        return this.repositorioFornecedor.recuperarTodos();
    }

    public Fornecedor getSelectedFornecedor() {
        return selectedFornecedor;
    }

    public void setSelectedFornecedor(Fornecedor selectedFornecedor) {
        this.selectedFornecedor = selectedFornecedor;
    }
    
    
    
}
