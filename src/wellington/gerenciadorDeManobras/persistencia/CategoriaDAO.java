/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import wellington.gerenciadorDeManobras.entidade.Categoria;

/**
 *
 * @author were
 */
public class CategoriaDAO {

    private static final String SQL_SELECT_TODAS = "SELECT ID, NOME, DESCRICAO FROM CATEGORIA";
    private static final String SQL_INSERT = "INSERT INTO CATEGORIA (NOME, DESCRICAO) VALUES (?, ?)";
    private static final String SQL_DELETE = "DELETE FROM CATEGORIA WHERE ID = ?";
    private static final String SQL_UPDATE = "UPDATE CATEGORIA SET  NOME = ?, DESCRICAO = ? WHERE ID = ?";

    public void incluirCategoria(Categoria categoria) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, categoria.getNome());
            comando.setString(2, categoria.getDescricao());

            //Executa o comando
            comando.execute();
            //Persiste o comando no banco de dados
            conexao.commit();
            //System.out.println("Manobra cadastrada com sucesso!");
        } catch (Exception e) {
            //Caso aconteça alguma exeção é feito um rollback para o banco de
            //dados retornar ao seu estado anterior.
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }

    public List<Categoria> buscarTodasCategorias() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Categoria> listaCategorias = new ArrayList<>();
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_SELECT_TODAS);
            //Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
            //O método next retornar boolean informando se existe um próximo
            //elemento para iterar
            while (resultado.next()) {
                Categoria categoria = this.extrairLinhaResultado(resultado);
                //Adiciona um item à lista que será retornada
                listaCategorias.add(categoria);
            }
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return listaCategorias;
    }

    private Categoria extrairLinhaResultado(ResultSet resultado) throws SQLException {
//        //Instancia um novo objeto e atribui os valores vindo do BD
//        //(Note que no BD o index inicia por 1)
        Categoria categoria = new Categoria();
        categoria.setId(resultado.getInt(1));
        categoria.setNome(resultado.getString(2));
        categoria.setDescricao(resultado.getString(3));

        return categoria;
    }

    public void removerManobra(int id) throws SQLException {

        Connection conexao = null;
        PreparedStatement comando = null;
        ///id = 4;
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_DELETE);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setInt(1, id);
            //Executa o comando
            comando.execute();
            //Persiste o comando no banco de dados
            conexao.commit();
        } catch (Exception e) {
            //Caso aconteça alguma exeção é feito um rollback para o banco de
            //dados retornar ao seu estado anterior.
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }

    public void atualizar(Categoria categoria) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)               
                  
            comando.setString(1, categoria.getNome());
            comando.setString(2, categoria.getDescricao());
            comando.setInt(3, categoria.getId());    
            //Executa o comando
            comando.execute();
            //Persiste o comando no banco de dados
            conexao.commit();
        } catch (Exception e) {
            //Caso aconteça alguma exeção é feito um rollback para o banco de
            //dados retornar ao seu estado anterior.
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        } 
    }
}
