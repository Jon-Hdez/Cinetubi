package uam.azc.adsi.cinetubi.controller;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uam.azc.adsi.cinetubi.exceptions.ProductNotFoundException;
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
  private NumberFormat formatter;

  public DulceriaController(ProductCatalog snackCatalog) {
    this.productCatalog = snackCatalog;
    this.formatter = NumberFormat.getCurrencyInstance(Locale.US);
  }

  public List<SingleProductPanel> createSnackPanels() {
    List<SingleProductPanel> snackPanels = new ArrayList<>();
    for (Product s : productCatalog.getCatalog()) {
      SingleProductPanel mySnackPanel = new SingleProductPanel(s.getId(), s.getName(), s.getPrice(), this);
      snackPanels.add(mySnackPanel);
    }
    return snackPanels;
  }

  public void createVenta() {
    ventaActual = new Venta();
  }

  public void increaseProductQuantity(int productId, ActionEvent evt) throws ProductNotFoundException {
    LineaVenta lv = ventaActual.findLineaVenta(productId);
    if (lv == null) {
      Product p = productCatalog.findProduct(productId);
      lv = new LineaVenta(p, 1);
      ventaActual.addLineaVenta(lv);
    } else {
      lv.setQuantity(lv.getQuantity() + 1);
    }
    updateVentaDulceriaView(lv, evt);
  }

  public void decreaseProductQuantity(int productId, ActionEvent evt) throws ProductNotFoundException {
    LineaVenta lv = ventaActual.findLineaVenta(productId);
    if (lv == null) {
      return;
    } else if (lv.getQuantity() == 1) {
      lv.setQuantity(0);
      ventaActual.deleteLineaVenta(productId);
    } else {
      lv.setQuantity(lv.getQuantity() - 1);
    }
    updateVentaDulceriaView(lv, evt);
  }

  private void updateVentaDulceriaView(LineaVenta lvActual, ActionEvent evt) {
    JPanel lineaVentaPanel = ventaDulceriaView.getListaVentaDulceriaPanel().getLineaVentaPanel();
    lineaVentaPanel.removeAll();
    for (LineaVenta lv : ventaActual.getLineas()) {
      Product p = lv.getProduct();
      JLabel lineLabel = new JLabel(
              String.format("%-12s", p.getName()) + "\t               "
              + lv.getQuantity() + "\t                     "
              + formatter.format(p.getPrice()));
      lineaVentaPanel.add(lineLabel);
    }
    lineaVentaPanel.revalidate();
    lineaVentaPanel.repaint();

    JLabel total = ventaDulceriaView.getListaVentaDulceriaPanel().getTotalPriceLabel();
    total.setText(formatter.format(ventaActual.getTotal()));
    
    JButton button = (JButton) evt.getSource();
    SingleProductPanel singleProductPanel = (SingleProductPanel) button.getParent();
    singleProductPanel.getQtyLabel().setText(lvActual.getQuantity()  + "");
  }

  public void setVentaDulceriaView(VentaDulceriaView dulceriaView) {
    this.ventaDulceriaView = dulceriaView;
  }

  public NumberFormat getFormatter() {
    return formatter;
  }

}
