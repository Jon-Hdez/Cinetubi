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
public class Funcion {
    private int id;
    private int id_pelicula;
    private String horario;
    private int sala;
    private String idioma;

    public Funcion(int id, int id_pelicula, String horario, int sala, String idioma) {
        this.id = id;
        this.id_pelicula = id_pelicula;
        this.horario = horario;
        this.sala = sala;
        this.idioma = idioma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Funcion{" + "id=" + id + ", id_pelicula=" + id_pelicula + ", horario=" + horario + ", sala=" + sala + ", idioma=" + idioma + '}';
    }
    
}
