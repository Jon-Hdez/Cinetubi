package uam.azc.adsi.cinetubi.controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
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
import uam.azc.adsi.cinetubi.model.ProductCatalog;
import uam.azc.adsi.cinetubi.util.MoneyFormatter;
import uam.azc.adsi.cinetubi.view.ProductPanel;
import uam.azc.adsi.cinetubi.view.Dulceria;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class DulceriaController {

  private final ProductCatalog productCatalog;
  private Dulceria dulceria;
  private Venta ventaActual;

  public DulceriaController(ProductCatalog snackCatalog) {
    this.productCatalog = snackCatalog;
  }

  public List<ProductPanel> createSnackPanels() {
    List<ProductPanel> snackPanels = new ArrayList<>();
    for (Product s : productCatalog.getCatalog().values()) {
      ProductPanel mySnackPanel = new ProductPanel(s.getId(), s.getName(), s.getPrice(), this);
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
    JPanel lineaVentaPanel = dulceria.getListaVentaDulceriaPanel().getLineaVentaPanel();
    lineaVentaPanel.removeAll();
    for (LineaVenta lv : ventaActual.getLineas()) {
      Product p = lv.getProduct();
      String paddedText = "<html>"
              + padString(p.getName(), 15)
              + padString(lv.getQuantity() + "", 8)
              + padString(MoneyFormatter.format(p.getPrice()), 10)
              + "</html>";
      JLabel lineaLabel = new JLabel(paddedText);
      Font monospaceFont = new Font("Monospaced", Font.PLAIN, 14);
      lineaLabel.setFont(monospaceFont);
      lineaVentaPanel.add(lineaLabel);
    }
    lineaVentaPanel.revalidate();
    lineaVentaPanel.repaint();

    JLabel total = dulceria.getListaVentaDulceriaPanel().getTotalPriceLabel();
    total.setText(MoneyFormatter.format(ventaActual.getTotal()));

    JButton button = (JButton) evt.getSource();
    JPanel subPanel = (JPanel) button.getParent();
    JLabel qtyLabel = (JLabel) subPanel.getComponent(1);
    qtyLabel.setText(lvActual.getQuantity() + "");
  }

  private String padString(String input, int length) {
    StringBuilder sb = new StringBuilder(input);
    int spacesToAdd = length - input.length();
    if (spacesToAdd > 0) {
      for (int i = 0; i < spacesToAdd; i++) {
        sb.append("&nbsp;"); // Append non-breaking spaces
      }
    }
    return sb.toString();
  }

  public Venta getVentaActual() {
    return ventaActual;
  }

  public void setVentaDulceriaView(Dulceria dulceriaView) {
    this.dulceria = dulceriaView;
  }

  public void cancelVenta(ActionEvent evt) {
    System.out.println("NO ESTA IMPLEMENTADO ESE BOTON");

  }

  public boolean esVentaActualVacia() {
    return ventaActual.getLineas().isEmpty();
  }
}
