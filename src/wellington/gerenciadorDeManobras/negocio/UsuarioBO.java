/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.negocio;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import wellington.gerenciadorDeManobras.entidade.Usuario;
import wellington.gerenciadorDeManobras.excecao.UsuarioDuplicadoException;
import wellington.gerenciadorDeManobras.persistencia.UsuarioDAO;

/**
 *
 * @author Wellington
 */
public class UsuarioBO {

    private UsuarioBO usuarioBO;
    private List<Usuario> usuarios;

    public void incluirUsuario(Usuario usuarioEmEdicao) throws NoSuchAlgorithmException, UnsupportedEncodingException, SQLException {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioEmEdicao.setSenha(this.exemploMD5(usuarioEmEdicao.getSenha()));
        usuarioDAO.incluirUsuario(usuarioEmEdicao);
    }

    public String converterHexadecimalParaString(byte[] valorHexadecimal) {
        StringBuilder valorConvertido = new StringBuilder();
        for (byte caracter : valorHexadecimal) {
            valorConvertido.append(String.format("%02X", 0xFF & caracter));
        }
        return valorConvertido.toString();
    }

    public String exemploMD5(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
      
            String texto = senha;

            MessageDigest algoritmo = MessageDigest.getInstance("MD5");
            byte[] codigoHashHexaDecimal = algoritmo.digest(texto.getBytes("UTF-8"));

            String codigoHashFinal = converterHexadecimalParaString(codigoHashHexaDecimal);
            return codigoHashFinal;
        
    }

    public boolean verificauUsuarioDuplicado(Usuario usuarioEmEdicao) throws SQLException {
        this.usuarioBO = new UsuarioBO();
        this.usuarios = usuarioBO.buscarUsuarios();
        String nomeUsuario = usuarioEmEdicao.getLogin();
        for (Usuario user : usuarios) {
            if (user.getLogin().equals(nomeUsuario) || user.getLogin() == null) {
                return true;
            }
        }
        return false;
    }

    public List<Usuario> buscarUsuarios() throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.buscarUsuarios();
    }
}
