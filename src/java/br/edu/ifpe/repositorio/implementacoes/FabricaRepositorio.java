/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.repositorio.implementacoes;

import br.edu.ifpe.repositorio.interfaces.RepositorioGenerico;

/**
 *
 * @author 1860915
 */
public class FabricaRepositorio {
    
    public static final int MEMO = 1;
    public static final int DB = 2;
    public static final int MATERIAL = 1;
    public static final int FORNECEDOR = 2;
    public static final int FUNCIONARIO = 3;
    
    public static RepositorioGenerico criarRepositorio(int tipoNegocio,int tipoPersistencia){
        
        if(tipoPersistencia==MEMO){
            if(tipoNegocio==MATERIAL){
                return new RepositorioMaterialImplMemo();
            }else if(tipoNegocio==FORNECEDOR){
                return new RepositorioFornecedorImplMemo();
            }
        }else if(tipoPersistencia==DB){
            if(tipoNegocio==FORNECEDOR){
                return new RepositorioFornecedorImplDB();
            }else if(tipoNegocio==MATERIAL){
                return new RepositorioMaterialImplDB();
            }
        }
        return null;
    }
    
}
