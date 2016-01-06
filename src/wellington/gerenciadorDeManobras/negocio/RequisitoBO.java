/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.negocio;

import java.sql.SQLException;
import wellington.gerenciadorDeManobras.entidade.Requisito;
import wellington.gerenciadorDeManobras.persistencia.RequisitoDAO;

/**
 *
 * @author Wellington
 */
public class RequisitoBO {

    public void inlcuirRequisito(Requisito requisitoEmEdicao) throws SQLException {
        RequisitoDAO requisitoDAO = new RequisitoDAO();
        requisitoDAO.incluirRequisito(requisitoEmEdicao);
    }

}
