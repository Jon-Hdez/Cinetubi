/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.model;

import java.math.BigDecimal;

/**
 *
 * @author Jony
 */
public class Empleado {

  private int id;
  private String nombre;
  private String paterno;
  private String materno;
  private String categoria;
  private BigDecimal sueldo;
  private String area;

  public Empleado(int id, String nombre, String paterno, String materno, String categoria, BigDecimal sueldo, String area) {
    this.id = id;
    this.nombre = nombre;
    this.paterno = paterno;
    this.materno = materno;
    this.categoria = categoria;
    this.sueldo = sueldo;
    this.area = area;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getPaterno() {
    return paterno;
  }

  public void setPaterno(String paterno) {
    this.paterno = paterno;
  }

  public String getMaterno() {
    return materno;
  }

  public void setMaterno(String materno) {
    this.materno = materno;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public BigDecimal getSueldo() {
    return sueldo;
  }

  public void setSueldo(BigDecimal sueldo) {
    this.sueldo = sueldo;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  @Override
  public String toString() {
    return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", categoria=" + categoria + ", sueldo=" + sueldo + ", area=" + area + '}';
  }

}
