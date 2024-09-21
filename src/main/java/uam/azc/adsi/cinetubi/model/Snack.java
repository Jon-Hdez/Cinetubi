package uam.azc.adsi.cinetubi.model;

import java.math.BigDecimal;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class Snack extends Product {

  public Snack(int id, String nombre, BigDecimal precio) {
    super(id, nombre, precio);
  }

  @Override
  public String toString() {
    return "Snack{" + "id=" + this.getId() + ", nombre=" + this.getName() + ", precio=" + this.getPrice() + '}';
  }
}
