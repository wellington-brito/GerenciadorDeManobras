/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.excecao;

/**
 *
 * @author Wellington
 */
public class ManobraDuplicadaException extends GerenciadorException{
    
    public ManobraDuplicadaException( ) {
        super("Manobra já existe!");
    }
    
}
