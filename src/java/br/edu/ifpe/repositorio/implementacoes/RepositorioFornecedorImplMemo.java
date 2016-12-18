/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.repositorio.implementacoes;

import br.edu.ifpe.negocio.Fornecedor;
import br.edu.ifpe.repositorio.interfaces.RepositorioGenerico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1860915
 */
public class RepositorioFornecedorImplMemo implements RepositorioGenerico<Fornecedor, Integer>{

    private List<Fornecedor> listaFornecedor = new ArrayList<>();
    
    @Override
    public void inserir(Fornecedor t) {
        this.listaFornecedor.add(t);
    }

    @Override
    public void alterar(Fornecedor t) throws Exception {
        Fornecedor f = null;
        for(int i = 0;i<this.listaFornecedor.size();i++){
            f = this.listaFornecedor.get(i);
            if(f.getCodigo()==t.getCodigo()){
                f.setCpf_cnpj(t.getCpf_cnpj());
                f.setNome(t.getNome());
                f.setRazao(t.getRazao());
                f.setEndereco(t.getEndereco());
                f.setTelefone(t.getTelefone());
                return;
            }
        }
    }

    @Override
    public Fornecedor recuperar(Integer chave) {
        Fornecedor f = null;
        for(int i = 0;i<this.listaFornecedor.size();i++){
            f = this.listaFornecedor.get(i);
            if(f.getCodigo()==chave){
                return f;
            }
        }
        return null;
    }

    @Override
    public void deletar(Fornecedor t) {
        this.listaFornecedor.remove(t);
    }

    @Override
    public List<Fornecedor> recuperarTodos() {
        return this.listaFornecedor;
    }
    
}
