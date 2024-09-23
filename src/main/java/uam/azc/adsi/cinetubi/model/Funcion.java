/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.model;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Jony
 */
public class Funcion {
    private int id;
    private int idPelicula;
    private String horario;
    private int idSala;
    private String idioma;
    private Date fecha;

    // Constructor, getters y setters

    public Funcion(int id, int idPelicula, String horario, int idSala, String idioma, Date fecha) {
        this.id = id;
        this.idPelicula = idPelicula;
        this.horario = horario;
        this.idSala = idSala;
        this.idioma = idioma;
        this.fecha = fecha;
    }

    

    public Funcion() {
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
