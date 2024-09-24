package uam.azc.adsi.cinetubi.controller;

import static com.mysql.cj.util.StringUtils.padString;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uam.azc.adsi.cinetubi.dao.VentaDAO;
import uam.azc.adsi.cinetubi.model.LineaVenta;
import uam.azc.adsi.cinetubi.model.Venta;
import uam.azc.adsi.cinetubi.util.MoneyFormatter;
import uam.azc.adsi.cinetubi.util.StringHTMLPadder;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class VentaController {

  private Venta ventaActual;
  private VentaDAO vDAO;

  public VentaController() {
  }

  public VentaController(Venta ventaActual, VentaDAO vDAO) {
    this.ventaActual = ventaActual;
    this.vDAO = vDAO;
  }

  public Venta getVentaActual() {
    return ventaActual;
  }

  public void setVentaActual(Venta ventaActual) {
    this.ventaActual = ventaActual;
  }

  public void guardarVenta() {
    System.out.println(ventaActual + " venta controller");
    if (this.vDAO == null) {
      this.vDAO = new VentaDAO(ventaActual);
    }
    vDAO.guardarVenta();
  }

  public List<JLabel> createLineaVentaLabels() {
    List<JLabel> lineaLabels = new ArrayList<>();
    for (LineaVenta lv : ventaActual.getLineas()) {
      String paddedText = "<html>"
              + StringHTMLPadder.padString(lv.getProduct().getShortDescription(), 20)
              + StringHTMLPadder.padString(lv.getQuantity() + "", 8)
              + StringHTMLPadder.padString(MoneyFormatter.format(lv.getProduct().getPrice()), 10)
              + "</html>";
      JLabel lineaLabel = new JLabel(paddedText);
      Font monospaceFont = new Font("Monospaced", Font.PLAIN, 14);
      lineaLabel.setFont(monospaceFont);
      lineaLabels.add(lineaLabel);
    }
    return lineaLabels;
  }

}
