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
    private static final String SQl_BUSCAR_DICAS = "SELECT ID, IDMANOBRA, IDUSUARIO, DESCRICAO FROM DICA";
    private static final String SQL_DELETE = "DELETE FROM DICA WHERE ID = ?";
   
    
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

    public List<Dica> buscarTodasDicas() throws SQLException {
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
        dica.setIdUsuario(resultado.getInt(3));
        dica.setDescricao(resultado.getString(4));
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
}


  

