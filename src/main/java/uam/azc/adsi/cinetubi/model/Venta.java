/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jony
 */
public class Venta {

  private int idVenta;
  private List<LineaVenta> lineas;
  private BigDecimal total;

  public Venta() {
    this.lineas = new ArrayList<>();
    this.total = new BigDecimal(0);
  }

  public void addLineaVenta(LineaVenta lv) {
    lineas.add(lv);
  }

  public int getIdVenta() {
    return idVenta;
  }

  public void setIdVenta(int idVenta) {
    this.idVenta = idVenta;
  }

  public BigDecimal getTotal() {
    total = BigDecimal.valueOf(0);
    for (LineaVenta lv : lineas) {
      total = total.add(lv.getSubtotal());
    }
    System.out.println(total);
    return total;
  }

  public List<LineaVenta> getLineas() {
    return lineas;
  }

  public LineaVenta findLineaVenta(int productId) {
    for (LineaVenta lv : lineas) {
      if (lv.getProductId() == productId) {
        return lv;
      }
    }
    return null;
  }
}
