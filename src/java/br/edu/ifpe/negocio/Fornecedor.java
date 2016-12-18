/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 1860915
 */

@Table(name = "Forn")
@Entity
public class Fornecedor {
    
    @Id
    @GeneratedValue
    private int codigo;
    @Column(name = "cpf_cnpj",length = 15,unique = true, nullable = false)
    private String cpf_cnpj;
    @Column(length = 50)
    private String nome;
    @Column(length = 50)
    private String razao;
    @Column(length=100)
    private String endereco;
    @Column(length=14)
    private String telefone;

    public Fornecedor(int codigo, String cpf_cnpj, String nome, String razao, String endereco, String telefone) {
        this.codigo = codigo;
        this.cpf_cnpj = cpf_cnpj;
        this.nome = nome;
        this.razao = razao;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    
    @Deprecated
    public Fornecedor(){}
    
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
    
    
    
    
}
