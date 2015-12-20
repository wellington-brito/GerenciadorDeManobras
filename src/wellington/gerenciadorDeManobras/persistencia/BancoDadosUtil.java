/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDadosUtil {

    private static final String DRIVER = "org.hsqldb.jdbcDriver";
    private static final String URL = "jdbc:hsqldb:file:BD/BD_GERENCIADOR_DE_MANOBRAS;shutdown=true";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            //Ativa o driver na memória
            Class.forName(DRIVER).newInstance();
            //Cria a conexão com o banco de dados
            connection = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void fecharChamadasBancoDados(Connection conexao, Statement comando, ResultSet resultado) throws SQLException {
        //Todo objeto que referencie o banco de dados deve ser fechado
        if (resultado != null && !resultado.isClosed()) {
            resultado.close();
        }
        fecharChamadasBancoDados(conexao, comando);
    }

    public static void fecharChamadasBancoDados(Connection conexao, Statement comando) throws SQLException {
        //Todo objeto que referencie o banco de dados deve ser fechado                
        if (comando != null && !comando.isClosed()) {
            comando.close();
        }
        if (conexao != null && !conexao.isClosed()) {
            conexao.close();
        }
    }

}
