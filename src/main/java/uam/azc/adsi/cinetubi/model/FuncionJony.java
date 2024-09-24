/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.model;

import java.util.Date;

/**
 *
 * @author Jony
 * @author José Vicente López López 2212002118
 */
public class FuncionJony {
    private int id;
    private int id_pelicula;
    private String horario;
    private int sala;
    private String idioma;
    private Date fecha;

    public FuncionJony() {
    }

    public FuncionJony(int id, int id_pelicula, String horario, int sala, String idioma, Date fecha) {
        this.id = id;
        this.id_pelicula = id_pelicula;
        this.horario = horario;
        this.sala = sala;
        this.idioma = idioma;
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Funcion{" + "id=" + id + ", id_pelicula=" + id_pelicula + ", horario=" + horario + ", sala=" + sala + ", idioma=" + idioma + '}';
    }
    
}
