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
import wellington.gerenciadorDeManobras.entidade.Manobra;
import wellington.gerenciadorDeManobras.entidade.Treino;

/**
 *
 * @author were
 */
public class ManobraDAO {

    private static final String SQL_INSERT = "INSERT INTO MANOBRA (NOME, IDUSUARIO, DIFICULDADE, STATUS, ID_CATEGORIA) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_MANOBRAS = "SELECT ID, NOME, DIFICULDADE, STATUS, ID_CATEGORIA  FROM MANOBRA WHERE IDUSUARIO = ?";
    private static final String SQL_DELETE = "DELETE FROM MANOBRA WHERE ID = ?";
    private static final String SQL_UPDATE = "UPDATE MANOBRA SET  NOME = ?, DIFICULDADE = ?, ID_CATEGORIA = ?, STATUS = ?, IDUSUARIO = ? WHERE ID = ?";
    private static final String SQL_UPDATE_STATUS = "UPDATE MANOBRA SET STATUS = ? WHERE ID = ?";
    
    
    public void inserir(Manobra manobra) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, manobra.getNome());
            comando.setInt(2,manobra.getIdUsuario());
            comando.setInt(3, manobra.getDificuldade());
            comando.setInt(4, manobra.getStatus());
            comando.setInt(5, manobra.getCategoria());

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

    public List<Manobra> buscarTodasManobras(int idUsuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Manobra> listaManobras = new ArrayList<>();
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_SELECT_MANOBRAS);
            comando.setInt(1, idUsuario);
            //Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
            //O método next retornar boolean informando se existe um próximo
            //elemento para iterar
            while (resultado.next()) {
                Manobra manobra = this.extrairLinhaResultadoBuscarTodasManobras(resultado);
                //Adiciona um item à lista que será retornada
                listaManobras.add(manobra);
            }
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return listaManobras;
    }

    private Manobra extrairLinhaResultadoBuscarTodasManobras(ResultSet resultado) throws SQLException {
        //Instancia um novo objeto e atribui os valores vindo do BD
        //(Note que no BD o index inicia por 1)
        Manobra manobra = new Manobra();
        manobra.setId(resultado.getInt(1));
        manobra.setNome(resultado.getString(2));
        manobra.setDificuldade(resultado.getInt(3));
        manobra.setStatus(resultado.getInt(4));
        manobra.setCategoria(resultado.getInt(5));
        return manobra;
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

    public void atualizar(Manobra manobra) throws SQLException {
       Connection conexao = null;
        PreparedStatement comando = null;
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)     
            comando.setString(1, manobra.getNome());
            comando.setInt(2, manobra.getDificuldade());          
            comando.setInt(3, manobra.getCategoria());
            comando.setInt(4, manobra.getStatus());
            comando.setInt(5, manobra.getIdUsuario());
            comando.setInt(6, manobra.getId());
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

    public void atualizarStatus(Treino treino) throws SQLException {
       Connection conexao = null;
        PreparedStatement comando = null;
        Manobra manobra = new Manobra();
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE_STATUS);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)     
            comando.setInt(1, treino.getProgresso());
            comando.setInt(2, treino.getIdManobra());
           // comando.setInt(3, treino.getIdUsuario());
            
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
