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
import wellington.gerenciadorDeManobras.excecao.CategoriaDuplicadaException;
import wellington.gerenciadorDeManobras.persistencia.CategoriaDAO;

/**
 *
 * @author were
 */
public class CategoriaBO {
    
    private List<Categoria> categorias;
    
    public List<Categoria> buscarTodasCategorias() throws SQLException {
        CategoriaDAO categoriaDAO = new CategoriaDAO();        
        return categoriaDAO.buscarTodasCategorias();
    }

    public void incluirCategoria(Categoria categoriaEmEdicao) throws SQLException {      
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaDAO.incluirCategoria(categoriaEmEdicao);
    }
   
    
    public void removerManobra(int id) throws SQLException {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaDAO.removerManobra(id);
    }
    
     public void atualizar(Categoria categoria) throws SQLException{
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaDAO.atualizar(categoria);
    }

     public void validarCamposObrigatorios(Categoria categoriaEmEdicao ) throws CampoObrigatorioException {
        if (categoriaEmEdicao.getDescricao().trim().isEmpty()){  
          String msg = "Campo descrição vazio!";
            throw new CampoObrigatorioException(msg);        
        }        
        if(categoriaEmEdicao.getNome().trim().isEmpty()) {
              String msg = "Campo Nome vazio!";
            throw new CampoObrigatorioException(msg);
        }        
    }
     
     public void verificarCategoria(Categoria categoriaEmEdicao) throws SQLException {
        CategoriaBO categoriaBO = new CategoriaBO();
        categorias = categoriaBO.buscarTodasCategorias();
        for (Categoria categoria : categorias) {
            if (categoriaEmEdicao.getNome().equals(categoria.getNome())) {
                throw new CategoriaDuplicadaException();
               
            }
        }
    }
    
}
