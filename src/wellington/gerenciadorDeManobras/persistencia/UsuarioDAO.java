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
import wellington.gerenciadorDeManobras.entidade.Usuario;

/**
 *
 * @author Wellington
 */
public class UsuarioDAO {

    private static final String SQL_INSERT = "INSERT INTO USUARIO (LOGIN, SENHA) VALUES (?, ?)";
    private static final String SQL_SELECT_USUARIOS = "SELECT LOGIN, SENHA FROM USUARIO";
    
            
    public void incluirUsuario(Usuario usuarioEmEdicao) throws SQLException{
         Connection conexao = null;
        PreparedStatement comando = null;

        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, usuarioEmEdicao.getLogin());
            comando.setString(2, usuarioEmEdicao.getSenha());

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
    
    public List<Usuario> buscarUsuarios() throws SQLException{    
    
     Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Usuario> listaUsuarios = new ArrayList<>();
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_SELECT_USUARIOS);
            //Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
            //O método next retornar boolean informando se existe um próximo
            //elemento para iterar
            while (resultado.next()) {
                Usuario usuarios = this.extrairLinhaResultadoBuscarTodosUsuarios(resultado);
                //Adiciona um item à lista que será retornada
                listaUsuarios.add(usuarios);
            }
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return listaUsuarios;
    }

    private Usuario extrairLinhaResultadoBuscarTodosUsuarios(ResultSet resultado) throws SQLException {
        //Instancia um novo objeto e atribui os valores vindo do BD
        //(Note que no BD o index inicia por 1)
        Usuario usuario = new Usuario();
        usuario.setLogin(resultado.getString(1));
        usuario.setSenha(resultado.getString(2));
        return usuario;
    }

    
    
}
