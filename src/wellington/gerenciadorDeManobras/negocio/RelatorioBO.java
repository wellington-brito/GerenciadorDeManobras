/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.negocio;

import java.sql.SQLException;
import java.util.List;
import wellington.gerenciadorDeManobras.entidade.Relatorio;
import wellington.gerenciadorDeManobras.persistencia.RelatorioDAO;

/**
 *
 * @author Wellington
 */
public class RelatorioBO {

    public List<Relatorio> recuperaManobraLoginDia(int idUsuario) throws SQLException {
        RelatorioDAO manobraLoginDiaDAO = new RelatorioDAO();
        return manobraLoginDiaDAO.recuperaManobraLoginDia(idUsuario);
    }

    public List<Relatorio> recuperaTotalManobra() throws SQLException {
        RelatorioDAO manobraLoginDiaDAO = new RelatorioDAO();
        return manobraLoginDiaDAO.recuperaTotalManobraPorLogin();
    }

}
