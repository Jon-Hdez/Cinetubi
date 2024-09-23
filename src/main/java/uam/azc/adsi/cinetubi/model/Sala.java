/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.model;

/**
 *
 * @author Jony
 * @author José Vicente López López 2212002118
 */
class Sala {
    
    private int numSala;
    private String tipoSala;
    private int capacidad;
    private String estado;

    public Sala(int numSala, String tipoSala, int capacidad, String estado) {
        this.numSala = numSala;
        this.tipoSala = tipoSala;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Sala{" + "numSala=" + numSala + ", tipoSala=" + tipoSala + ", capacidad=" + capacidad + ", estado=" + estado + '}';
    }
    
}
