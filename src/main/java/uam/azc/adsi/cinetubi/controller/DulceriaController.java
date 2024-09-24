package uam.azc.adsi.cinetubi.controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uam.azc.adsi.cinetubi.model.LineaVenta;
import uam.azc.adsi.cinetubi.model.Product;
import uam.azc.adsi.cinetubi.model.Snack;
import uam.azc.adsi.cinetubi.model.Venta;
import uam.azc.adsi.cinetubi.model.SnackCatalog;
import uam.azc.adsi.cinetubi.util.MoneyFormatter;
import uam.azc.adsi.cinetubi.view.SnackPanel;
import uam.azc.adsi.cinetubi.view.Dulceria;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class DulceriaController {

  private final SnackCatalog snackCatalog;
  private Dulceria dulceria;
  private Venta ventaActual;

  public DulceriaController(SnackCatalog snackCatalog) {
    this.snackCatalog = snackCatalog;
  }

  public List<SnackPanel> createSnackPanels() {
    List<SnackPanel> snackPanels = new ArrayList<>();
    for (Snack s : snackCatalog.getCatalog().values()) {
      SnackPanel mySnackPanel = new SnackPanel(
              s.getId(),
              s.getName(),
              s.getPrice(),
              s.getTamanio(),
              this);
      snackPanels.add(mySnackPanel);
    }
    return snackPanels;
  }

  public void createVenta() {
    ventaActual = new Venta();
  }

  public void increaseProductQuantity(int productId, ActionEvent evt) {
    LineaVenta lv = ventaActual.findLineaVenta(productId);
    if (lv == null) {
      Snack p = snackCatalog.findSnack(productId);
      lv = new LineaVenta(p, 1);
      ventaActual.addLineaVenta(lv);
    } else {
      lv.setQuantity(lv.getQuantity() + 1);
    }
    updateVentaDulceriaView(lv, evt);
  }

  public void decreaseProductQuantity(int productId, ActionEvent evt) {
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
    this.ventaActual = new Venta();
  }

  public boolean esVentaActualVacia() {
    return ventaActual.getLineas().isEmpty();
  }
}
