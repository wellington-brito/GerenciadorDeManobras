/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.negocio;

import java.sql.SQLException;
import java.util.List;
import wellington.gerenciadorDeManobras.entidade.Manobra;
import wellington.gerenciadorDeManobras.entidade.Treino;
import wellington.gerenciadorDeManobras.excecao.CampoObrigatorioException;
import wellington.gerenciadorDeManobras.persistencia.TreinoDAO;

/**
 *
 * @author Wellington
 */
public class TreinoBO {

    public void inserir(Treino treino) throws SQLException {
        TreinoDAO treinoDAO = new TreinoDAO();
        treinoDAO.inserir(treino);
    }

    public void validarCamposObrigatoriosIdManobra(Treino t) throws CampoObrigatorioException {
        if (t.getIdManobra() == 0) {
            throw new CampoObrigatorioException();
        }
    }
    public void validarCamposObrigatoriosAtualizar(Treino t) throws CampoObrigatorioException {
        if (t.getIdManobra() == 0 || t.getProgresso() == 0 || t.getQntddias() == 0) {
            throw new CampoObrigatorioException();
        }
    }

    public List<Treino> buscarTodosTreinos() throws SQLException {
        TreinoDAO treinoDAO = new TreinoDAO();
        return treinoDAO.buscarTodosTrienos();
    }

    public void atualizar(Treino treinoEmEdicao) throws SQLException {
        TreinoDAO treinoDAO =  new TreinoDAO();
        treinoDAO.atualizar(treinoEmEdicao);
        
    }
}
