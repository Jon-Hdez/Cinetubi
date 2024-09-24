/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uam.azc.adsi.cinetubi.view;

import java.math.BigDecimal;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import uam.azc.adsi.cinetubi.controller.DulceriaController;
import uam.azc.adsi.cinetubi.controller.VentaController;
import uam.azc.adsi.cinetubi.util.MoneyFormatter;

/**
 *
 * @author José Vicente López López 2212002118
 */
public class ProcesarVenta extends javax.swing.JFrame {

  private VentaController ventaController;

  /**
   * Creates new form ProcesarVenta
   *
   * @param ventaController
   */
  public ProcesarVenta(VentaController ventaController) {
    initComponents();
    this.ventaController = ventaController;

    btnEfectivo.setSelected(true);
    this.ventaController.getVentaActual().setMetodoPago("efectivo");
    btnConfirmarVenta.setEnabled(false);

    cargarInformacionProcesarVenta();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    btgForma = new javax.swing.ButtonGroup();
    txtForma = new javax.swing.JLabel();
    txtPagar1 = new javax.swing.JLabel();
    txtEfectivo = new javax.swing.JLabel();
    txtCambio = new javax.swing.JLabel();
    lblTotal = new javax.swing.JTextField();
    lblRecibo = new javax.swing.JTextField();
    lblCambio = new javax.swing.JTextField();
    btnEfectivo = new javax.swing.JRadioButton();
    btnCredito = new javax.swing.JRadioButton();
    pnlDescripcionVenta = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    pnlDescripcionVentaBoxLayout = new javax.swing.JPanel();
    btnConfirmarVenta = new javax.swing.JButton();
    btnCancelar = new javax.swing.JButton();
    btnMenu = new javax.swing.JButton();
    btnTaquilla = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Procesar Venta");
    setPreferredSize(new java.awt.Dimension(1024, 768));
    setResizable(false);

    txtForma.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    txtForma.setText("Forma de pago");

    txtPagar1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    txtPagar1.setText("Total a pagar");

    txtEfectivo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    txtEfectivo.setText("Efectivo recibido");

    txtCambio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    txtCambio.setText("Cambio");

    lblTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    lblTotal.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        lblTotalActionPerformed(evt);
      }
    });

    lblRecibo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    lblRecibo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        lblReciboActionPerformed(evt);
      }
    });
    lblRecibo.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        lblReciboKeyTyped(evt);
      }
    });

    lblCambio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    lblCambio.setEnabled(false);
    lblCambio.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        lblCambioActionPerformed(evt);
      }
    });

    btgForma.add(btnEfectivo);
    btnEfectivo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    btnEfectivo.setText("Efectivo");
    btnEfectivo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEfectivoActionPerformed(evt);
      }
    });

    btgForma.add(btnCredito);
    btnCredito.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    btnCredito.setText("Credito");
    btnCredito.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCreditoActionPerformed(evt);
      }
    });

    pnlDescripcionVenta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 18))); // NOI18N
    pnlDescripcionVenta.setPreferredSize(new java.awt.Dimension(700, 400));
    pnlDescripcionVenta.setRequestFocusEnabled(false);
    pnlDescripcionVenta.setVerifyInputWhenFocusTarget(false);

    jLabel1.setText("Producto                             Cantidad                             Precio");

    pnlDescripcionVentaBoxLayout.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
    pnlDescripcionVentaBoxLayout.setLayout(new javax.swing.BoxLayout(pnlDescripcionVentaBoxLayout, javax.swing.BoxLayout.Y_AXIS));

    javax.swing.GroupLayout pnlDescripcionVentaLayout = new javax.swing.GroupLayout(pnlDescripcionVenta);
    pnlDescripcionVenta.setLayout(pnlDescripcionVentaLayout);
    pnlDescripcionVentaLayout.setHorizontalGroup(
      pnlDescripcionVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pnlDescripcionVentaLayout.createSequentialGroup()
        .addGroup(pnlDescripcionVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(pnlDescripcionVentaBoxLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(pnlDescripcionVentaLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addGap(325, 325, 325))
    );
    pnlDescripcionVentaLayout.setVerticalGroup(
      pnlDescripcionVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pnlDescripcionVentaLayout.createSequentialGroup()
        .addComponent(jLabel1)
        .addGap(28, 28, 28)
        .addComponent(pnlDescripcionVentaBoxLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    btnConfirmarVenta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    btnConfirmarVenta.setText("Confirmar Venta");
    btnConfirmarVenta.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnConfirmarVentaActionPerformed(evt);
      }
    });

    btnCancelar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    btnCancelar.setText("Cancelar");
    btnCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCancelarActionPerformed(evt);
      }
    });

    btnMenu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    btnMenu.setText("Menu");
    btnMenu.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnMenuActionPerformed(evt);
      }
    });

    btnTaquilla.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    btnTaquilla.setText("Taquilla");
    btnTaquilla.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnTaquillaActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(lblCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(lblRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(txtCambio)
              .addComponent(txtEfectivo)
              .addComponent(txtPagar1)
              .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(btnEfectivo)
                  .addComponent(txtForma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCredito)
                .addGap(31, 31, 31))))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnConfirmarVenta))
          .addGroup(layout.createSequentialGroup()
            .addComponent(btnCancelar)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(pnlDescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(57, 57, 57))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(btnTaquilla)
        .addGap(52, 52, 52)
        .addComponent(btnMenu)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addGap(86, 86, 86)
            .addComponent(txtPagar1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20, 20, 20)
            .addComponent(txtForma)
            .addGap(8, 8, 8)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(btnEfectivo)
              .addComponent(btnCredito))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txtEfectivo)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txtCambio)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnConfirmarVenta)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCancelar))
          .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(btnMenu)
              .addComponent(btnTaquilla))
            .addGap(62, 62, 62)
            .addComponent(pnlDescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(267, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void cargarInformacionProcesarVenta() {
    lblTotal.setText(MoneyFormatter.format(ventaController.getVentaActual().getTotal()));

    //Llenas la descripcion de la venta, agregando todas las lineas de venta
    pnlDescripcionVentaBoxLayout.removeAll();
    List<JLabel> lineaVentaLabels = ventaController.createLineaVentaLabels();
    for (JLabel lvLabel : lineaVentaLabels) {
      pnlDescripcionVentaBoxLayout.add(lvLabel);
    }
    pnlDescripcionVentaBoxLayout.revalidate();
    pnlDescripcionVentaBoxLayout.repaint();
    this.revalidate();
    this.repaint();
  }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
//      // TODO add your handling code here:
//      if (origen == VistaDeOrigen.DULCERIA) {
//        Dulceria dulceria = new Dulceria(ventaController);
//        ventaController.setVentaDulceriaView(dulceria);
//      }
//      Menu menu = new Menu();
//      menu.setVisible(true);
//      this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
//      // TODO add your handling code here:
//      this.dispose();
//      Menu menu = new Menu();
//      menu.setDulceriaController(ventaController);
//      menu.setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnTaquillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaquillaActionPerformed
      // TODO add your handling code here:
      this.dispose();
      Taquilla taquilla = new Taquilla();
      taquilla.setVisible(true);
    }//GEN-LAST:event_btnTaquillaActionPerformed

    private void btnConfirmarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarVentaActionPerformed
      // TODO add your handling code here:
      ventaController.guardarVenta();
      DulceriaController dulceriaController = new DulceriaController();
      Dulceria dulceria = new Dulceria(dulceriaController);
      dulceriaController.setDulceria(dulceria);
      dulceria.setVisible(true);
//      Dulceria dulceria = new Dulceria(dulceriaController);
//      Taquilla taquilla = new Taquilla();
//      taquilla.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btnConfirmarVentaActionPerformed

  private void lblTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblTotalActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_lblTotalActionPerformed

  private void btnEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfectivoActionPerformed
    // TODO add your handling code here:
    ventaController.getVentaActual().setMetodoPago("efectivo");
  }//GEN-LAST:event_btnEfectivoActionPerformed

  private void btnCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditoActionPerformed
    ventaController.getVentaActual().setMetodoPago("credito");
  }//GEN-LAST:event_btnCreditoActionPerformed

  private void lblReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblReciboActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_lblReciboActionPerformed

  private void lblReciboKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblReciboKeyTyped
    // TODO add your handling code here:
    String efectivoRecibido = ((JTextField) evt.getSource()).getText();
    if ("".equals(efectivoRecibido)) {
      return;
    }

    if (evt.getKeyChar() == '\n') {
      BigDecimal efectivo = new BigDecimal(((JTextField) evt.getSource()).getText());
      BigDecimal cambio = efectivo.subtract(ventaController.getVentaActual().getTotal());

      if (cambio.compareTo(BigDecimal.ZERO) < 0) {
        JOptionPane.showMessageDialog(null,
                "Efectivo Recibido Insuficiente",
                "Efectivo Insuficiente",
                JOptionPane.WARNING_MESSAGE);
      } else {
        lblCambio.setText(MoneyFormatter.format(cambio));
        btnConfirmarVenta.setEnabled(true);
      }

    }
  }//GEN-LAST:event_lblReciboKeyTyped

  private void lblCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblCambioActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_lblCambioActionPerformed

  /**
   * @param args the command line arguments
   */
//  public static void main(String args[]) {
//    /* Set the Nimbus look and feel */
//    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//     */
//    try {
//      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//        if ("Nimbus".equals(info.getName())) {
//          javax.swing.UIManager.setLookAndFeel(info.getClassName());
//          break;
//        }
//      }
//    } catch (ClassNotFoundException ex) {
//      java.util.logging.Logger.getLogger(ProcesarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    } catch (InstantiationException ex) {
//      java.util.logging.Logger.getLogger(ProcesarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    } catch (IllegalAccessException ex) {
//      java.util.logging.Logger.getLogger(ProcesarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//      java.util.logging.Logger.getLogger(ProcesarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    }
//    //</editor-fold>
//    //</editor-fold>
//    //</editor-fold>
//    //</editor-fold>
//
//    /* Create and display the form */
//    java.awt.EventQueue.invokeLater(new Runnable() {
//      public void run() {
//        new ProcesarVenta().setVisible(true);
//      }
//    });
//  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.ButtonGroup btgForma;
  private javax.swing.JButton btnCancelar;
  private javax.swing.JButton btnConfirmarVenta;
  private javax.swing.JRadioButton btnCredito;
  private javax.swing.JRadioButton btnEfectivo;
  private javax.swing.JButton btnMenu;
  private javax.swing.JButton btnTaquilla;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JTextField lblCambio;
  private javax.swing.JTextField lblRecibo;
  private javax.swing.JTextField lblTotal;
  private javax.swing.JPanel pnlDescripcionVenta;
  private javax.swing.JPanel pnlDescripcionVentaBoxLayout;
  private javax.swing.JLabel txtCambio;
  private javax.swing.JLabel txtEfectivo;
  private javax.swing.JLabel txtForma;
  private javax.swing.JLabel txtPagar1;
  // End of variables declaration//GEN-END:variables
}
