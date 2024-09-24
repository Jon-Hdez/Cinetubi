package uam.azc.adsi.cinetubi.model;

import java.math.BigDecimal;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class Snack extends Product {

  private String tamanio;

  public Snack(int id, String nombre, BigDecimal precio, String tamanio) {
    super(id, nombre, precio);
    this.tamanio = tamanio;
  }

  public String getTamanio() {
    return tamanio;
  }

  public void setTamanio(String tamanio) {
    this.tamanio = tamanio;
  }

  @Override
  public String toString() {
    return "Snack{" + "id=" + this.getId() + ", nombre=" + this.getName() + ", precio=" + this.getPrice() + '}';
  }
}
