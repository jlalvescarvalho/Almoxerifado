/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.execoes;

/**
 *
 * @author 1860915
 */
public class MaterialNaoEncontradoException extends Exception{
    public MaterialNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
