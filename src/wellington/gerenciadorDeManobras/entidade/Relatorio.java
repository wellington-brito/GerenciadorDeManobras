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
public class Relatorio {
    private String login;
    private String manobra;
    private int dias;
    private int status;
    private int totalManobras;
    private int totalTreinos;

    public int getTotalTreinos() {
        return totalTreinos;
    }

    public void setTotalTreinos(int totalTreinos) {
        this.totalTreinos = totalTreinos;
    }
     
    
    
    public int getTotalManobras() {
        return totalManobras;
    }

    public void setTotalManobras(int totalManobras) {
        this.totalManobras = totalManobras;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getManobra() {
        return manobra;
    }

    public void setManobra(String manobra) {
        this.manobra = manobra;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
}
