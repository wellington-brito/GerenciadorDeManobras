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
import wellington.gerenciadorDeManobras.entidade.Requisito;

/**
 *
 * @author Wellington
 */
public class RequisitoDAO {

    private static final String SQL_INSERT = "INSERT INTO REQUISITO (IDMANOBRARECENTE, IDMANOBRAREQUISITO) VALUES (?, ?)";
    private static final String SQl_BUSCAR_REQUISITOS = "SELECT IDMANOBRARECENTE FROM REQUISITO WHERE IDMANOBRAREQUISITO = ? ";

    public void incluirRequisito(Requisito requisitoEmEdicao) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setInt(1, requisitoEmEdicao.getIdManobraRecente());
            comando.setInt(2, requisitoEmEdicao.getIdManobraRequisito());

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

    public List<Requisito> buscarTodosRequisitosEspecificos(int idManobra) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Requisito> listaRequisitos = new ArrayList<>();
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQl_BUSCAR_REQUISITOS);
            //Executa o comando e obtém o resultado da consulta
            comando.setInt(1, idManobra);
            resultado = comando.executeQuery();
            //O método next retornar boolean informando se existe um próximo
            //elemento para iterar
            while (resultado.next()) {
                 Requisito requisito = this.buscarTodosRequisitosEspecificos(resultado);
                //Adiciona um item à lista que será retornada
                listaRequisitos.add(requisito);
            }
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return listaRequisitos;
    }

    private Requisito buscarTodosRequisitosEspecificos(ResultSet resultado) throws SQLException {
        //Instancia um novo objeto e atribui os valores vindo do BD
        //(Note que no BD o index inicia por 1)
        Requisito requisito = new Requisito();
        requisito.setIdManobraRecente(resultado.getInt(1));
        //requisito.setIdManobraRequisito(resultado.getInt(2));
        return requisito;
    }
}


