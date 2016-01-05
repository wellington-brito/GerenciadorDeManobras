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
import wellington.gerenciadorDeManobras.entidade.Treino;

/**
 *
 * @author Wellington
 */
public class TreinoDAO {

    private static final String SQL_INSERT = "INSERT INTO TREINO (IDMANOBRA, PROGRESSO, QNTDDIAS) VALUES (?, ?,?)";
    private static final String SQL_SELECT_TREINO = "SELECT ID, IDMANOBRA, PROGRESSO, QNTDDIAS  FROM TREINO";
    private static final String SQL_UPDATE = "UPDATE TREINO SET  IDMANOBRA = ?, PROGRESSO = ?, QNTDDIAS = ? WHERE ID = ?";

    public void inserir(Treino treino) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setInt(1, treino.getIdManobra());
            comando.setInt(2, treino.getProgresso());
            comando.setInt(3, treino.getQntddias());
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

    public List<Treino> buscarTodosTrienos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Treino> listaTreinos = new ArrayList<>();
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_SELECT_TREINO);
            //Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
            //O método next retornar boolean informando se existe um próximo
            //elemento para iterar
            while (resultado.next()) {
                Treino treino = this.extrairLinhaResultadoBuscarTodosTreinos(resultado);
                //Adiciona um item à lista que será retornada
                listaTreinos.add(treino);
            }
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return listaTreinos;
    }

    private Treino extrairLinhaResultadoBuscarTodosTreinos(ResultSet resultado) throws SQLException {
        //Instancia um novo objeto e atribui os valores vindo do BD
        //(Note que no BD o index inicia por 1)
        Treino treino = new Treino();
        treino.setId(resultado.getInt(1));
        treino.setIdManobra(resultado.getInt(2));
        treino.setProgresso(resultado.getInt(3));
        treino.setQntddias(resultado.getInt(4));

        return treino;
    }

    public void atualizar(Treino treino) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)               

            comando.setInt(1, treino.getIdManobra());
            comando.setInt(2, treino.getProgresso());
            comando.setInt(3, treino.getQntddias());
            comando.setInt(4, treino.getId());
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
