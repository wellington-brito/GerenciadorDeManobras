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
    private int idManobraRecente;
    private int idManobraRequisito;

    public int getIdManobraRecente() {
        return idManobraRecente;
    }

    public void setIdManobraRecente(int idManobraRecente) {
        this.idManobraRecente = idManobraRecente;
    }

    public int getIdManobraRequisito() {
        return idManobraRequisito;
    }

    public void setIdManobraRequisito(int idManobraRequisito) {
        this.idManobraRequisito = idManobraRequisito;
    }
}
