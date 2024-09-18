/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.clases;

/**
 *
 * @author Jony
 */
class Funcion {
    
    
    private Pelicula pelicula;
    private Sala sala;
    private String horario;

    public Funcion() {
    }

    public Funcion(Pelicula pelicula, Sala sala, String horario) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.horario = horario;
    }

    
    
    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
}
