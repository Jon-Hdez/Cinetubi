package uam.azc.adsi.cinetubi.controller;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import uam.azc.adsi.cinetubi.exceptions.SnackNotFoundException;
import uam.azc.adsi.cinetubi.model.LineaVenta;
import uam.azc.adsi.cinetubi.model.Product;
import uam.azc.adsi.cinetubi.model.Venta;
import uam.azc.adsi.cinetubi.model.Snack;
import uam.azc.adsi.cinetubi.model.ProductCatalog;
import uam.azc.adsi.cinetubi.view.SingleProductPanel;
import uam.azc.adsi.cinetubi.view.VentaDulceriaView;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class DulceriaController {

  private ProductCatalog productCatalog;
  private VentaDulceriaView ventaDulceriaView;
  private Venta ventaActual;

  public DulceriaController(ProductCatalog snackCatalog) {
    this.productCatalog = snackCatalog;
  }

  public List<SingleProductPanel> createSnackPanels() {
    List<SingleProductPanel> snackPanels = new ArrayList<>();
    for (Product s : productCatalog.getCatalog()) {
      SingleProductPanel mySnackPanel = new SingleProductPanel(s.getId(), s.getName(), s.getPrice(), this);
      snackPanels.add(mySnackPanel);
    }
    return snackPanels;
  }

  public ProductCatalog getSnackCatalog() {
    return productCatalog;
  }

  public void setSnackCatalog(ProductCatalog snackCatalog) {
    this.productCatalog = snackCatalog;
  }

  public void createVenta() {
    ventaActual = new Venta();
  }

  public void increaseProductQuantity(int productId) throws SnackNotFoundException {
    LineaVenta lv = ventaActual.findLineaVenta(productId);
    if (lv == null) {
      Product p = productCatalog.findProduct(productId);
      lv = new LineaVenta(p, 1);
      ventaActual.addLineaVenta(lv);
    } else {
      lv.setQuantity(lv.getQuantity() + 1);
    }
    System.out.println(lv);
  }

}
