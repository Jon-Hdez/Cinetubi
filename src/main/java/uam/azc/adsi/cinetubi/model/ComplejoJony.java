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
public class ComplejoJony {
    
    private String nombre;
    private String direccion;
    private List<SalaJony> salas;

    public ComplejoJony() {
    }

    public ComplejoJony(String nombre, String direccion, List<SalaJony> salas) {
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

    public List<SalaJony> getSalas() {
        return salas;
    }

    public void setSalas(List<SalaJony> salas) {
        this.salas = salas;
    }
    
    
    
    
}
