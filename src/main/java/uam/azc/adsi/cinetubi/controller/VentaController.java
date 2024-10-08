package uam.azc.adsi.cinetubi.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import uam.azc.adsi.cinetubi.dao.BoletoDAO;
import uam.azc.adsi.cinetubi.dao.VentaDAO;
import uam.azc.adsi.cinetubi.model.Boleto;
import uam.azc.adsi.cinetubi.model.Empleado;
import uam.azc.adsi.cinetubi.model.LineaVenta;
import uam.azc.adsi.cinetubi.model.Venta;
import uam.azc.adsi.cinetubi.util.MoneyFormatter;
import uam.azc.adsi.cinetubi.util.StringHTMLPadder;
import uam.azc.adsi.cinetubi.view.Taquilla;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class VentaController {

  private Venta ventaActual;
  private Empleado empleadoActual;
  private VentaDAO vDAO;
  private boolean estado=false;

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

  public Empleado getEmpleadoActual() {
    return empleadoActual;
  }

  public void setEmpleadoActual(Empleado empleadoActual) {
    this.empleadoActual = empleadoActual;
  }

  public void confirmarVenta() {
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

    public void configurarPanel(JPanel descripcion, String datos) {
        descripcion.removeAll(); // Limpiar el panel
        descripcion.setEnabled(true);
        // Crear un nuevo JPanel interno
        JPanel panelInterno = new JPanel();
        panelInterno.setBackground(Color.WHITE); // Color de fondo del panel interno
        panelInterno.setPreferredSize(new Dimension(200, 100)); // Tamaño preferido del panel interno

        // Crear el JLabel
        JLabel lblDatos = new JLabel(datos);
        lblDatos.setFont(new Font("Arial", Font.PLAIN, 14)); // Configurar fuente
        lblDatos.setForeground(Color.BLACK); // Color del texto
        lblDatos.setOpaque(true); // Habilitar opacidad
        lblDatos.setBackground(new Color(0, 102, 102)); // Fondo del JLabel

        // Agregar el JLabel al panel interno
        panelInterno.add(lblDatos);

        // Agregar el panel interno al panel principal
        descripcion.add(panelInterno);

        descripcion.revalidate(); // Revalidar el panel
        descripcion.repaint(); // Repintar el panel
        System.out.println("Se ejecuto el metodo para descripcion venta");
    }
    
//Vicente
public void panel(JPanel ventaBoletos, TaquillaController taquillaController) {
    ventaBoletos.setLayout(null);

    // Etiquetas y campos de texto
    JLabel lblTotal = new JLabel("Total a pagar");
    lblTotal.setBounds(20, 20, 100, 25);
    ventaBoletos.add(lblTotal);

    JTextField txtTotal = new JTextField(String.valueOf(taquillaController.getSubtotal()));
    txtTotal.setBounds(120, 20, 100, 25);
    ventaBoletos.add(txtTotal);
    txtTotal.setEditable(false);

    JLabel lblFormaPago = new JLabel("Forma de pago");
    lblFormaPago.setBounds(20, 60, 100, 25);
    ventaBoletos.add(lblFormaPago);

    JRadioButton rbContado = new JRadioButton("Efectivo");
    rbContado.setBounds(120, 60, 80, 25);
    ventaBoletos.add(rbContado);

    JRadioButton rbCredito = new JRadioButton("Credito");
    rbCredito.setBounds(200, 60, 80, 25);
    ventaBoletos.add(rbCredito);

    ButtonGroup bgFormaPago = new ButtonGroup();
    bgFormaPago.add(rbContado);
    bgFormaPago.add(rbCredito);

    JLabel lblEfectivo = new JLabel("Efectivo recibido");
    lblEfectivo.setBounds(20, 100, 100, 25);
    ventaBoletos.add(lblEfectivo);

    // Establecer un filtro para el campo de efectivo
    JTextField txtEfectivo = new JTextField();
    txtEfectivo.setBounds(120, 100, 100, 25);
    ventaBoletos.add(txtEfectivo);

    // Limitar la entrada a solo números
    txtEfectivo.setDocument(new PlainDocument() {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str == null) return;
            if (str.matches("[0-9]*")) {  // Solo permitir dígitos
                super.insertString(offs, str, a);
            }
        }
    });

    JLabel lblCambio = new JLabel("Cambio");
    lblCambio.setBounds(20, 140, 100, 25);
    ventaBoletos.add(lblCambio);

    JTextField txtCambio = new JTextField();
    txtCambio.setBounds(120, 140, 100, 25);
    txtCambio.setEditable(false);
    ventaBoletos.add(txtCambio);

    JButton btnProcesarVenta = new JButton("Procesar Venta");
    btnProcesarVenta.setBounds(120, 180, 150, 25);
    ventaBoletos.add(btnProcesarVenta);

    JButton btnCancelar = new JButton("Cancelar");
    btnCancelar.setBounds(20, 220, 100, 25);
    ventaBoletos.add(btnCancelar);

    JTextArea textAreaDescripcion = new JTextArea(taquillaController.ventaActual());
    textAreaDescripcion.setBounds(300, 20, 400, 200);
    textAreaDescripcion.setBackground(new Color(0, 102, 102));
    textAreaDescripcion.setEditable(false);
    ventaBoletos.add(textAreaDescripcion);

    // Lógica para calcular el cambio y mostrarlo
    btnProcesarVenta.addActionListener((ActionEvent e) -> {
        try {
            int efectivoRecibido = Integer.parseInt(txtEfectivo.getText());
            int subtotal = (int) taquillaController.getSubtotal(); // Asegurarte de que sea un int
            int cambio = efectivoRecibido - subtotal;
            if (cambio >= 0) {
                txtCambio.setText(String.valueOf(cambio));

                BoletoDAO bol = new BoletoDAO();
                String modo = rbCredito.isSelected() ? "credito" : "efectivo";

                cambiarEstado();
                if (estado) {
                    int idVenta = crearVenta(1, 1, modo, "taquilla", subtotal);
                    bol.agregarBoletos(crearVentaBoletos(taquillaController, modo, "taquilla", subtotal), idVenta);

                    // Cerrar el JFrame actual
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ventaBoletos);
                    frame.dispose();

                    // Abrir el nuevo JFrame (Taquilla)
                    Taquilla nuevaTaquilla = new Taquilla();
                    nuevaTaquilla.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El efectivo recibido es insuficiente.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingresa un número válido.");
        }
    });

    // Acción para cancelar
    btnCancelar.addActionListener(e -> {
        txtTotal.setText("");
        txtEfectivo.setText("");
        txtCambio.setText("");
        bgFormaPago.clearSelection();
    });
}


    public List<Boleto> crearVentaBoletos(TaquillaController taquilla, String modo, String area, double total) {
        // Pruebas
        int idVenta = crearVenta(taquilla.getEmpleado().getId(), 1, modo, area, total);
        List<Boleto> boletos = new ArrayList<>();  // Corregido: Uso de ArrayList

        List<Integer> numeros = taquilla.aux;
        for (int i : numeros) {
            Boleto nuevo = new Boleto(taquilla.res.getId(), idVenta, taquilla.res.getId_pelicula(), i);
            boletos.add(nuevo);
            System.out.println(nuevo.toString()+"\n");
        }
        return boletos;
    }


    public int crearVenta(int empleado, int socio, String metodo, String area, double total) {
        VentaDAO nueva=new VentaDAO();
        return nueva.agregarVenta(empleado, socio, metodo, "taquilla", total);
    }
    
    public void cambiarEstado(){
        estado=true;
    }

}
