package uam.azc.adsi.cinetubi.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jony
 */
public class Venta {

  private int idEmpleado;
  private Integer idSocio;
  private String metodoPago;
  private String area;
  private BigDecimal total;

  private List<LineaVenta> lineas;

  public Venta() {
    this.lineas = new ArrayList<>();
    this.total = new BigDecimal(0);
  }

  public void addLineaVenta(LineaVenta lv) {
    lineas.add(lv);
  }

  public LineaVenta findLineaVenta(int productId) {
    for (LineaVenta lv : lineas) {
      if (lv.getProductId() == productId) {
        return lv;
      }
    }
    return null;
  }

  public void deleteLineaVenta(int productId) {
    LineaVenta lv = findLineaVenta(productId);
    if (lv == null) {
      System.out.println("Producto con Id: " + productId + " no encontrado. No se puede eliminar la linea de la venta");
    } else {
      lineas.remove(lv);

    }
  }

  public int getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(int idEmpleado) {
    this.idEmpleado = idEmpleado;
  }

  public Integer getIdSocio() {
    return idSocio;
  }

  public void setIdSocio(Integer idSocio) {
    this.idSocio = idSocio;
  }

  public String getMetodoPago() {
    return metodoPago;
  }

  public void setMetodoPago(String metodoPago) {
    this.metodoPago = metodoPago;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public BigDecimal getTotal() {
    total = BigDecimal.ZERO;
    for (LineaVenta lv : lineas) {
      total = total.add(lv.getSubtotal());
    }
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  public List<LineaVenta> getLineas() {
    return lineas;
  }

  public void setLineas(List<LineaVenta> lineas) {
    this.lineas = lineas;
  }

  @Override
  public String toString() {
    return "Venta{" + "idEmpleado=" + idEmpleado + ", idSocio=" + idSocio + ", metodoPago=" + metodoPago + ", area=" + area + ", total=" + total + ", lineas=" + lineas + '}';
  }

}
