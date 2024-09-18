package uam.azc.adsi.cinetubi.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class Combo {

  private int id;
  private String nombre;
  private BigDecimal precio;
  private List<Snack> snacks;

  public Combo(int id, String nombre, BigDecimal precio) {
    this.id = id;
    this.nombre = nombre;
    this.precio = precio;
    this.snacks = new ArrayList<>();
  }

  public Combo(int id, String nombre, BigDecimal precio, ArrayList<Snack> snacks) {
    this.id = id;
    this.nombre = nombre;
    this.precio = precio;
    this.snacks = snacks;
  }

  public void addSnack(Snack s){
    this.snacks.add(s);
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

  public List<Snack> getSnacks() {
    return snacks;
  }

  public void setSnacks(List<Snack> snacks) {
    this.snacks = snacks;
  }

  @Override
  public String toString() {
    return "Combo{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + '}';
  }

}
