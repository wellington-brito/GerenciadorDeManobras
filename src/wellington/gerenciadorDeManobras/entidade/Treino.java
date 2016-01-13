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
public class Treino {

    private int id;
    private int idUsuario;
    private int idManobra;
    private int progresso;
    private int qntddias;

     public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
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

    public int getProgresso() {
        return progresso;
    }

    public void setProgresso(int progresso) {
        this.progresso = progresso;
    }

    public int getQntddias() {
        return qntddias;
    }

    public void setQntddias(int qntddias) {
        this.qntddias = qntddias;
    }

}
