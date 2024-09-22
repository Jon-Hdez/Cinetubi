/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.model;

import java.util.List;

/**
 *
 * @author Jony
 * @author José Vicente López López 2212002118
 */
public class Cartelera {
    
    private int id;
    private int idPelicula;

    public Cartelera(int id, int idPelicula) {
        this.id = id;
        this.idPelicula = idPelicula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    @Override
    public String toString() {
        return "Cartelera{" + "id=" + id + ", idPelicula=" + idPelicula + '}';
    }
    
}
