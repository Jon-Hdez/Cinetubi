/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.model;

/**
 *
 * @author Jony
 */
public class Pelicula {
    private int id;
    private String titulo;
    private int duracion;
    private String distribuidor;
    private String clasificacion;
    private String director;
    private String pais;
    private String descripcion;
    private String genero;

    // Constructor, getters y setters

    public Pelicula() {
    }

    public Pelicula(int id, String titulo, int duracion, String distribuidor, String clasificacion, String director, String pais, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.distribuidor = distribuidor;
        this.clasificacion = clasificacion;
        this.director = director;
        this.pais = pais;
        this.descripcion = descripcion;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id=" + id + ", titulo=" + titulo + ", duracion=" + duracion + ", distribuidor=" + distribuidor + ", clasificacion=" + clasificacion + ", director=" + director + ", pais=" + pais + ", descripcion=" + descripcion + ", genero=" + genero + '}';
    }
    
    
    
}
