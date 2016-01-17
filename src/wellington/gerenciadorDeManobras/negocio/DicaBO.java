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

    public List<Dica> buscarTodasDicas(int idUsuario) throws SQLException {
        DicaDAO dicaDAO = new DicaDAO();
        return dicaDAO.buscarTodasDicas(idUsuario);
    }

    public void removerDica(int id) throws SQLException {
        DicaDAO dicaDAO = new DicaDAO();
        dicaDAO.removerDica(id);
    }

    public List<Dica> buscarDicasAleatorias() throws SQLException {
        DicaDAO dicaDAO = new DicaDAO();
        return dicaDAO.buscarDicasAleatorias();
    }

    public void atualizarDica(Dica dicaEmEdicao) throws SQLException {
         this.verificaIdUsuario(dicaEmEdicao);
    
    }
    
     private void verificaIdUsuario(Dica dica) throws SQLException {
       if(dica.getIdUsuario()>0){
        DicaDAO dicaDAO = new DicaDAO();
        dicaDAO.atualizar(dica);
       }
    }

}
