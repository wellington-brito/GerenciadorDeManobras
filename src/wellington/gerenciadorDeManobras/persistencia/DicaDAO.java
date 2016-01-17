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
import wellington.gerenciadorDeManobras.entidade.Dica;
import wellington.gerenciadorDeManobras.entidade.Requisito;

/**
 *
 * @author Wellington
 */
public class DicaDAO {

    private static final String SQL_INSERT = "INSERT INTO DICA (IDMANOBRA,IDUSUARIO, DESCRICAO) VALUES (?, ?, ?)";
    private static final String SQl_BUSCAR_DICAS = "SELECT  ID, IDMANOBRA, DESCRICAO FROM DICA WHERE IDUSUARIO = ?";
    private static final String SQL_DELETE = "DELETE FROM DICA WHERE ID = ?";
    private static final String SQL_DICAS_ALEATORIAS = "SELECT DESCRICAO FROM DICA  ORDER BY RAND() LIMIT 9";
    private static final String SQL_UPDATE = "UPDATE DICA SET DESCRICAO = ?  WHERE ID = ?";

    public void incluirDica(Dica dicaEmEdicao) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setInt(1, dicaEmEdicao.getIdManobra());
            comando.setInt(2, dicaEmEdicao.getIdUsuario());
            comando.setString(3, dicaEmEdicao.getDescricao());

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

    public List<Dica> buscarTodasDicas(int idUsuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Dica> listaDicas = new ArrayList<>();
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQl_BUSCAR_DICAS);
            //Executa o comando e obtém o resultado da consulta
            comando.setInt(1,idUsuario);
            resultado = comando.executeQuery();
            //O método next retornar boolean informando se existe um próximo
            //elemento para iterar
            while (resultado.next()) {
                Dica dica = this.buscarTodasDicas(resultado);
                //Adiciona um item à lista que será retornada
                listaDicas.add(dica);
            }
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return listaDicas;
    }

    private Dica buscarTodasDicas(ResultSet resultado) throws SQLException {
        //Instancia um novo objeto e atribui os valores vindo do BD
        //(Note que no BD o index inicia por 1)
        Dica dica = new Dica();
        dica.setId(resultado.getInt(1));
        dica.setIdManobra(resultado.getInt(2));
        dica.setDescricao(resultado.getString(3));
        return dica;
    }

    public void removerDica(int id) throws SQLException {
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

    public List<Dica> buscarDicasAleatorias() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Dica> listaDicas = new ArrayList<>();
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_DICAS_ALEATORIAS);
            //Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
            //O método next retornar boolean informando se existe um próximo
            //elemento para iterar
            while (resultado.next()) {
                Dica dica = (Dica) this.buscarTodasDicasAleatoriamente(resultado);
                //Adiciona um item à lista que será retornada

               
                listaDicas.add(dica);
            }
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return listaDicas;
    }

    private Dica buscarTodasDicasAleatoriamente(ResultSet resultado) throws SQLException {
          Dica dica = new Dica();
            dica.setDescricao(resultado.getString(1));
            return dica;
    }

    public void atualizar(Dica dica) throws SQLException {
       Connection conexao = null;
        PreparedStatement comando = null;
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)     
            comando.setString(1, dica.getDescricao());
           // comando.setInt(2, dica.getIdUsuario());;
            comando.setInt(2, dica.getId());
           
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
