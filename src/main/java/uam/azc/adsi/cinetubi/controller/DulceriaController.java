package uam.azc.adsi.cinetubi.controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uam.azc.adsi.cinetubi.model.Empleado;
import uam.azc.adsi.cinetubi.model.LineaVenta;
import uam.azc.adsi.cinetubi.model.Product;
import uam.azc.adsi.cinetubi.model.Snack;
import uam.azc.adsi.cinetubi.model.Venta;
import uam.azc.adsi.cinetubi.model.SnackCatalog;
import uam.azc.adsi.cinetubi.util.MoneyFormatter;
import uam.azc.adsi.cinetubi.util.StringHTMLPadder;
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
  private Empleado empleadoActual;

  public DulceriaController() {
    this.snackCatalog = new SnackCatalog();
  }

  public List<SnackPanel> crearSnackPanels() {
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

  public void crearVenta() {
    ventaActual = new Venta();
    ventaActual.setIdEmpleado(empleadoActual.getId());
    ventaActual.setArea(empleadoActual.getArea());
    // CORRREGGIIIIIRIRIRIR, sacar un id socio de a de veras
    ventaActual.setIdSocio(null);
  }

  public void incrementarCantidadSnack(int productId, ActionEvent evt) {
    LineaVenta lv = ventaActual.findLineaVenta(productId);
    if (lv == null) {
      Snack p = snackCatalog.findSnack(productId);
      lv = new LineaVenta(p, 1);
      ventaActual.addLineaVenta(lv);
    } else {
      lv.setQuantity(lv.getQuantity() + 1);
    }
  }

  public void decrementarCantidadSnack(int productId, ActionEvent evt) {
    LineaVenta lv = ventaActual.findLineaVenta(productId);
    if (lv == null) {
      return;
    } else if (lv.getQuantity() == 1) {
      lv.setQuantity(0);
      ventaActual.deleteLineaVenta(productId);
    } else {
      lv.setQuantity(lv.getQuantity() - 1);
    }
  }

  public void actualizarDulceria(int productId, ActionEvent evt) {
    actualizarLineaVentaPanel();
    actualizarSnackPanel(productId, evt);
  }

  private void actualizarLineaVentaPanel() {
    JPanel lineaVentaPanel = dulceria.getListaVentaDulceriaPanel().getLineaVentaPanel();
    lineaVentaPanel.removeAll();
    for (LineaVenta lv : ventaActual.getLineas()) {
      Snack s = (Snack) lv.getProduct();
      String paddedText = "<html>"
              + StringHTMLPadder.padString(s.getName() + " " + (s.getTamanio() != null ? s.getTamanio() : ""), 20)
              + StringHTMLPadder.padString(lv.getQuantity() + "", 8)
              + StringHTMLPadder.padString(MoneyFormatter.format(s.getPrice()), 6)
              + "</html>";
      JLabel lineaLabel = new JLabel(paddedText);
      Font monospaceFont = new Font("Monospaced", Font.PLAIN, 14);
      lineaLabel.setFont(monospaceFont);
      lineaVentaPanel.add(lineaLabel);
    }
    lineaVentaPanel.revalidate();
    lineaVentaPanel.repaint();
  }

  private void actualizarSnackPanel(int productId, ActionEvent evt) {
    JLabel total = dulceria.getListaVentaDulceriaPanel().getTotalPriceLabel();
    total.setText(MoneyFormatter.format(ventaActual.getTotal()));

    JPanel btnContainer = (JPanel) (((JButton) evt.getSource()).getParent());
    SnackPanel snackPanel = (SnackPanel) btnContainer.getParent();
    String productTitle = "<html>"
            + snackPanel.getNombre()
            + "<br>"
            + (snackPanel.getTamanio() == null ? "" : snackPanel.getTamanio())
            + "</html>";
    snackPanel.getProductTitle().setText(productTitle);
    String quantity = ventaActual.findLineaVenta(productId) == null ? "0" : ventaActual.findLineaVenta(productId).getQuantity() + "";
    snackPanel.getQtyLabel().setText(quantity);
    snackPanel.revalidate();
    snackPanel.repaint();
  }

  public Venta getVentaActual() {
    return ventaActual;
  }

  public void setDulceria(Dulceria dulceriaView) {
    this.dulceria = dulceriaView;
  }

  public void cancelarVenta(ActionEvent evt) {
    this.ventaActual = new Venta();
  }

  public boolean esVentaActualVacia() {
    return ventaActual.getLineas().isEmpty();
  }

  public Empleado getEmpleadoActual() {
    return empleadoActual;
  }

  public void setEmpleadoActual(Empleado empleadoActual) {
    this.empleadoActual = empleadoActual;
  }

}
