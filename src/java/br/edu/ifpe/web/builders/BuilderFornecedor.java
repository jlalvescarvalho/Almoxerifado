/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.web.builders;

import br.edu.ifpe.negocio.Fornecedor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author 1860915
 */

@ManagedBean(name = "bFornecedor")
@RequestScoped
public class BuilderFornecedor {
    
    private int codigo;
    private String cpf_cnpj;
    private String nome;
    private String razao;
    private String endereco;
    private String telefone;
    
    @Deprecated
    public BuilderFornecedor(){}

    public BuilderFornecedor(int codigo, String cpf_cnpj){
        this.codigo = codigo;
        this.cpf_cnpj = cpf_cnpj;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
        
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
        
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
        
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
        
    }
    
    public Fornecedor buildFornecedor(){
        return new Fornecedor(this.codigo, this.cpf_cnpj, this.nome, this.razao, this.endereco, this.telefone);
    }
    
}
