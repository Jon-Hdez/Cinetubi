/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.model;

/**
 *
 * @author Jony
 */
public class Socio {
    private String claveSocio;
    private String nombre;
    private int puntos;
    private String vigencia;

    public Socio() {
    }

    public Socio(String claveSocio, String nombre, int puntos, String vigencia) {
        this.claveSocio = claveSocio;
        this.nombre = nombre;
        this.puntos = puntos;
        this.vigencia = vigencia;
    }

    
    
    
    public String getClaveSocio() {
        return claveSocio;
    }

    public void setClaveSocio(String claveSocio) {
        this.claveSocio = claveSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }
    
    
}
