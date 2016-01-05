/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import wellington.gerenciadorDeManobras.entidade.Treino;

/**
 *
 * @author Wellington
 */
public class TreinoDAO {

    private static final String SQL_INSERT = "INSERT INTO TREINO (IDMANOBRA, PROGRESSO, QNTDDIAS) VALUES (?, ?,?)";

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

}
