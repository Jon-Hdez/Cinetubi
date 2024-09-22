package uam.azc.adsi.cinetubi.model;

import java.math.BigDecimal;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class LineaVenta {

  private Product product;
  private int quantity;
  private BigDecimal subtotal;

  public LineaVenta(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
    this.subtotal = product.getPrice().multiply(BigDecimal.valueOf(quantity));
  }

  public Product getProduct() {
    return product;
  }

  public int getProductId() {
    return product.getId();
  }

  public BigDecimal getSubtotal() {
    setSubTotal(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
    return subtotal;
  }

  private void setSubTotal(BigDecimal st) {
    this.subtotal = st;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "LineaVenta{" + "product=" + product + ", quantity=" + quantity + ", subtotal=" + subtotal + '}';
  }

}
