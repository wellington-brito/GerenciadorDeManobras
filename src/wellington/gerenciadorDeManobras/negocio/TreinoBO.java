/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.negocio;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import wellington.gerenciadorDeManobras.entidade.Manobra;
import wellington.gerenciadorDeManobras.entidade.Requisito;
import wellington.gerenciadorDeManobras.entidade.Treino;
import wellington.gerenciadorDeManobras.excecao.CampoObrigatorioException;
import wellington.gerenciadorDeManobras.persistencia.RequisitoDAO;
import wellington.gerenciadorDeManobras.persistencia.TreinoDAO;

/**
 *
 * @author Wellington
 */
public class TreinoBO {

    private List<String> idManobrasSugeridas;
    private List<Requisito> listaRquisitos;

    public void inserir(Treino treino) throws SQLException {
        TreinoDAO treinoDAO = new TreinoDAO();
        treinoDAO.inserir(treino);
    }

    public void validarCamposObrigatoriosIdManobra(Treino t) throws CampoObrigatorioException {
        if (t.getIdManobra() == 0 ) {
            throw new CampoObrigatorioException();
        }
    }

//    public void validarCamposObrigatoriosAtualizar(Treino t) throws CampoObrigatorioException {
//       
//    }

    public void atualizar(Treino treinoEmEdicao) throws SQLException {
        TreinoDAO treinoDAO = new TreinoDAO();
        treinoDAO.atualizar(treinoEmEdicao);

    }

    public void removerTreino(int id) throws Exception {
        TreinoDAO treinoDAO = new TreinoDAO();
        treinoDAO.removerTreino(id);
    }

    public List<Treino> buscarTodosTreinos() throws SQLException {
        TreinoDAO treinoDAO = new TreinoDAO();
        return treinoDAO.buscarTodosTrienos();
    }

    public List<Requisito> verificaProgresso(Treino treinoEmEdicao) throws SQLException {
        if (treinoEmEdicao.getProgresso() == 100) {
            RequisitoDAO requisitoDAO = new RequisitoDAO();
            listaRquisitos = requisitoDAO.buscarTodosRequisitosEspecificos(); // where idmanobrarequisito == treino em treinoEmEdicao.getIdManobra(

//            for(Requisito requisito : listaRquisitos){                                
//                idManobrasSugeridas.add(Integer.toString(requisito.getIdManobraRecente()));                        
//            }
//            return idManobrasSugeridas;
        }
        return listaRquisitos;
    }
}
