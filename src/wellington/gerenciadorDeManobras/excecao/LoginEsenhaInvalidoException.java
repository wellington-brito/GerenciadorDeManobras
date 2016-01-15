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
public class LoginEsenhaInvalidoException extends GerenciadorException{
    
    public LoginEsenhaInvalidoException( ) {
        super("Loguin ou senha incorretos");
    }
    
}
