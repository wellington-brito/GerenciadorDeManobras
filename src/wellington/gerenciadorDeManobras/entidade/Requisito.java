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
public class Requisito {

    
    private int id;
    private int idManobra;
    private int idManobraRequisito;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdManobra() {
        return idManobra;
    }

    public void setIdManobra(int idManobraRecente) {
        this.idManobra = idManobraRecente;
    }

    public int getIdManobraRequisito() {
        return idManobraRequisito;
    }

    public void setIdManobraRequisito(int idManobraRequisito) {
        this.idManobraRequisito = idManobraRequisito;
    }
}
