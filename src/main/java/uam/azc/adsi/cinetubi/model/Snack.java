package uam.azc.adsi.cinetubi.model;

import java.math.BigDecimal;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class Snack {

  private int id;
  private String nombre;
  private BigDecimal precio;

  public Snack(int id, String nombre, BigDecimal precio) {
    this.id = id;
    this.nombre = nombre;
    this.precio = precio;
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

  public BigDecimal getPrecio() {
    return precio;
  }

  public void setPrecio(BigDecimal precio) {
    this.precio = precio;
  }

  @Override
  public String toString() {
    return "Snack{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + '}';
  }
}
