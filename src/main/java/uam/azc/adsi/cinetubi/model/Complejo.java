/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.model;

import java.util.List;

/**
 *
 * @author Jony
 */
public class Complejo {
    
    private String nombre;
    private String direccion;
    private List<Sala> salas;

    public Complejo() {
    }

    public Complejo(String nombre, String direccion, List<Sala> salas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.salas = salas;
    }

    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
    
    
    
    
}
