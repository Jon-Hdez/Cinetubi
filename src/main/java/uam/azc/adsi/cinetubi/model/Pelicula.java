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
public class Pelicula {

  private int idPelicula;
  private String titulo;
  private int duracion;
  private String distribuidor;
  private String clasificacion;
  private String director;
  private String pais;
  private String descripcion;
  private String genero;

    public Pelicula(int idPelicula, String titulo, int duracion, String distribuidor, String clasificacion, String director, String pais, String descripcion) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.duracion = duracion;
        this.distribuidor = distribuidor;
        this.clasificacion = clasificacion;
        this.director = director;
        this.pais = pais;
        this.descripcion = descripcion;
    }

    public Pelicula() {
    }
    
    
   

  public Pelicula(int idPelicula, String titulo, int duracion, String distribuidor, String clasificacion, String director, String pais, String descripcion, String genero) {
    this.idPelicula = idPelicula;
    this.titulo = titulo;
    this.duracion = duracion;
    this.distribuidor = distribuidor;
    this.clasificacion = clasificacion;
    this.director = director;
    this.pais = pais;
    this.descripcion = descripcion;
    this.genero = genero;
  }

  public int getIdPelicula() {
    return idPelicula;
  }

  public void setIdPelicula(int idPelicula) {
    this.idPelicula = idPelicula;
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
    return "Pelicula{" + "idPelicula=" + idPelicula + ", titulo=" + titulo + ", duracion=" + duracion + ", distribuidor=" + distribuidor + ", clasificacion=" + clasificacion + ", director=" + director + ", pais=" + pais + ", descripcion=" + descripcion + '}';
  }

}
