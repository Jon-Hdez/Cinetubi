/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.model;

/**
 *
 * @author José Vicente López López 2212002118
 */
public class Asiento {
    private int idSala;
    private int numero;

    public Asiento(int idSala, int numero) {
        this.idSala = idSala;
        this.numero = numero;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Asiento{" + "idSala=" + idSala + ", numero=" + numero + '}';
    }
    
}
