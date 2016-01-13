/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.negocio;

import java.sql.SQLException;
import java.util.List;
import wellington.gerenciadorDeManobras.entidade.Dica;
import wellington.gerenciadorDeManobras.persistencia.DicaDAO;

/**
 *
 * @author Wellington
 */
public class DicaBO {

    public void incluirNovaDica(Dica dicaEmEdicao) throws SQLException {
        DicaDAO dicaDAO = new DicaDAO();
        dicaDAO.incluirDica(dicaEmEdicao);      
    }
    
    public List<Dica> buscarTodasDicas() throws SQLException{
        DicaDAO dicaDAO = new DicaDAO();
        return dicaDAO.buscarTodasDicas();
    }
    
}
