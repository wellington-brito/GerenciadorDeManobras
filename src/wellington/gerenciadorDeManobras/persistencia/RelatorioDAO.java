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
import wellington.gerenciadorDeManobras.entidade.Relatorio;

/**
 *
 * @author Wellington
 */
public class RelatorioDAO {

    public static final String SQL_MANOBRA_LOGIN_DIAS = "SELECT M.NOME, T.QNTDDIAS FROM MANOBRA M JOIN\n"
            + "	TREINO T ON M.ID  = T.IDMANOBRA JOIN\n"
            + "	USUARIO U ON U.ID = T.IDUSUARIO WHERE IDUSUARIO = ?";

    public static final String SQL_TOTAL_MANOBRA_TREINO = "SELECT U.LOGIN, M.NOME, COUNT(M.ID), COUNT(T.ID) FROM USUARIO U JOIN\n"
            + "					MANOBRA M ON M.IDUSUARIO = U.ID JOIN\n"
            + "					TREINO T ON T.IDMANOBRA =  M.ID  JOIN\n"
            + "					USUARIO U ON U.ID = T.IDUSUARIO WHERE  M.STATUS <=100 GROUP BY U.LOGIN, M.NOME";

    public static final String SQL_TOTAL_LOGIN = "SELECT U.LOGIN, COUNT(M.STATUS) FROM MANOBRA M JOIN\n"
            + "USUARIO U ON U.ID = M.IDUSUARIO WHERE  M.STATUS =100 GROUP BY U.ID";

    public List<Relatorio> recuperaManobraLoginDia(int idUsuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Relatorio> listaManobraLoginDia = new ArrayList<>();
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_MANOBRA_LOGIN_DIAS);
            comando.setInt(1, idUsuario);
            //Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
            //O método next retornar boolean informando se existe um próximo
            //elemento para iterar
            while (resultado.next()) {
                Relatorio manobraLoginDia = this.extrairLinhaResultadoBuscarTodosTreinos(resultado);
                //Adiciona um item à lista que será retornada
                listaManobraLoginDia.add(manobraLoginDia);
            }
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return listaManobraLoginDia;
    }

    private Relatorio extrairLinhaResultadoBuscarTodosTreinos(ResultSet resultado) throws SQLException {
        //Instancia um novo objeto e atribui os valores vindo do BD
        //(Note que no BD o index inicia por 1)
        Relatorio manobraLoginDia = new Relatorio();
        manobraLoginDia.setManobra(resultado.getString(1));
        //manobraLoginDia.setLogin(resultado.getString(1));
        manobraLoginDia.setDias(resultado.getInt(2));
        return manobraLoginDia;
    }

    public List<Relatorio> recuperaTotalManobraPorLogin() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Relatorio> listaTotalManobras = new ArrayList<>();
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_TOTAL_LOGIN);

            //Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
            //O método next retornar boolean informando se existe um próximo
            //elemento para iterar
            while (resultado.next()) {
                Relatorio resultadoTotal = this.extrairLinhaResultado(resultado);
                //Adiciona um item à lista que será retornada
                listaTotalManobras.add(resultadoTotal);
            }
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return listaTotalManobras;
    }

    private Relatorio extrairLinhaResultado(ResultSet resultado) throws SQLException {
        Relatorio totalManobra = new Relatorio();
        totalManobra.setLogin(resultado.getString(1));
        totalManobra.setTotalManobras(resultado.getInt(2));
        return totalManobra;
    }

    public List<Relatorio> recuperarTotalManobrasTotalTreinos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Relatorio> listaTotalManobrasTreinos = new ArrayList<>();
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_TOTAL_MANOBRA_TREINO);

            //Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
            //O método next retornar boolean informando se existe um próximo
            //elemento para iterar
            while (resultado.next()) {
                Relatorio resultadoTotal = this.extrairLinhaResultadoTotalManobraTreinos(resultado);
                //Adiciona um item à lista que será retornada
                listaTotalManobrasTreinos.add(resultadoTotal);
            }
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return listaTotalManobrasTreinos;

    }

    private Relatorio extrairLinhaResultadoTotalManobraTreinos(ResultSet resultado) throws SQLException {
        Relatorio totalManobra = new Relatorio();
        totalManobra.setLogin(resultado.getString(1));
        totalManobra.setManobra(resultado.getString(2));
        totalManobra.setTotalManobras(resultado.getInt(3));
        totalManobra.setTotalTreinos(resultado.getInt(4));
        return totalManobra;
    }

}
