/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.negocio;

import java.sql.SQLException;
import java.util.List;
import wellington.gerenciadorDeManobras.entidade.Categoria;
import wellington.gerenciadorDeManobras.excecao.CampoObrigatorioException;
import wellington.gerenciadorDeManobras.persistencia.CategoriaDAO;

/**
 *
 * @author were
 */
public class CategoriaBO {
    
    public List<Categoria> buscarTodasCategorias() throws SQLException {
        CategoriaDAO categoriaDAO = new CategoriaDAO();        
        return categoriaDAO.buscarTodasCategorias();
    }

    public void inserir(Categoria categoriaEmEdicao) throws SQLException {      
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaDAO.inserir(categoriaEmEdicao);
    }
   
    
    public void removerManobra(int id) throws SQLException {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaDAO.removerManobra(id);
    }
    
     public void atualizar(Categoria categoria) throws SQLException{
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaDAO.atualizar(categoria);
    }

     public void validarCamposObrigatorios(Categoria c) throws CampoObrigatorioException {
        if (c.getDescricao().trim().isEmpty() && c.getNome().trim().isEmpty()) {
            throw new CampoObrigatorioException();
        }
    }
}
