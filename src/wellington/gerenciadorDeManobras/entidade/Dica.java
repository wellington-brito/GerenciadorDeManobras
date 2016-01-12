/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.entidade;

/**
 *
 * @author Wellington
 */
public class Dica {
    private int id;
    private int idManobra;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdManobra() {
        return idManobra;
    }

    public void setIdManobra(int idManobra) {
        this.idManobra = idManobra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
