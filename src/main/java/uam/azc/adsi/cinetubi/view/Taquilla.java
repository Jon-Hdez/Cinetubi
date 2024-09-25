/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uam.azc.adsi.cinetubi.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.azc.adsi.cinetubi.controller.DulceriaController;
import uam.azc.adsi.cinetubi.controller.TaquillaController;
import uam.azc.adsi.cinetubi.dao.PeliculaDAO;
import uam.azc.adsi.cinetubi.model.*;
import uam.azc.adsi.cinetubi.util.DatabaseConnection;
import uam.azc.adsi.cinetubi.util.VistaDeOrigen;

/**
 *
 * @author José Vicente López López 2212002118
 */
public class Taquilla extends javax.swing.JFrame {

  private DulceriaController dulceriaController;
  private PeliculaDAO peli;
  private Funcion funcion;
  private Pelicula pelicula;
  private DatabaseConnection dbConnection;
  private TaquillaController taquilla = new TaquillaController();

  /**
   * Creates new form Taquilla
   */
  public Taquilla() {
    initComponents();
    try {
        dbConnection = DatabaseConnection.getInstance();
        peli = new PeliculaDAO(dbConnection.getConnection());
        funcion = taquilla.funciones(pnlFunciones, pnlDescripcion, pnlAsientos, pnlResumen);
        pelicula = taquilla.getSeleccion();
    } catch (SQLException ex) {
        System.err.println("Error conexion iniciando taquilla: "+ex);
    }
    
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        pnlFunciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlAsientos = new javax.swing.JPanel();
        pnlResumen = new javax.swing.JPanel();
        lblRBoletos = new javax.swing.JLabel();
        lblRPelicula = new javax.swing.JLabel();
        lblRHorario = new javax.swing.JLabel();
        lblRIdioma = new javax.swing.JLabel();
        lblRTotal = new javax.swing.JLabel();
        lblRPrecio = new javax.swing.JLabel();
        lblRAsientos = new javax.swing.JLabel();
        lblRSala = new javax.swing.JLabel();
        pnlDescripcion = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblMenu = new javax.swing.JLabel();
        lblAux1 = new javax.swing.JLabel();
        lblTaqulla = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        txtPDirector = new javax.swing.JTextField();
        txtPDuracion = new javax.swing.JTextField();
        txtPDistribuidora = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Venta de Boletos");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 102, 102));
        setFocusTraversalPolicyProvider(true);

        pnlFondo.setBackground(new java.awt.Color(0, 102, 102));

        pnlFunciones.setBackground(new java.awt.Color(255, 255, 255));
        pnlFunciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Funciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N
        pnlFunciones.setName(""); // NOI18N
        pnlFunciones.setPreferredSize(new java.awt.Dimension(500, 300));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setMaximumSize(new java.awt.Dimension(490, 400));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(490, 400));
        jScrollPane1.setName(""); // NOI18N

        javax.swing.GroupLayout pnlFuncionesLayout = new javax.swing.GroupLayout(pnlFunciones);
        pnlFunciones.setLayout(pnlFuncionesLayout);
        pnlFuncionesLayout.setHorizontalGroup(
            pnlFuncionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );
        pnlFuncionesLayout.setVerticalGroup(
            pnlFuncionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlAsientos.setBackground(new java.awt.Color(255, 255, 255));
        pnlAsientos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asientos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N
        pnlAsientos.setMaximumSize(new java.awt.Dimension(500, 250));
        pnlAsientos.setMinimumSize(new java.awt.Dimension(500, 250));

        javax.swing.GroupLayout pnlAsientosLayout = new javax.swing.GroupLayout(pnlAsientos);
        pnlAsientos.setLayout(pnlAsientosLayout);
        pnlAsientosLayout.setHorizontalGroup(
            pnlAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlAsientosLayout.setVerticalGroup(
            pnlAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );

        pnlResumen.setBackground(new java.awt.Color(255, 255, 255));
        pnlResumen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resumen de Venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        lblRBoletos.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblRBoletos.setForeground(new java.awt.Color(0, 102, 102));
        lblRBoletos.setText("Boletos: ");

        lblRPelicula.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblRPelicula.setForeground(new java.awt.Color(0, 102, 102));
        lblRPelicula.setText("Pelicula: ");

        lblRHorario.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblRHorario.setForeground(new java.awt.Color(0, 102, 102));
        lblRHorario.setText("Horario: ");

        lblRIdioma.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblRIdioma.setForeground(new java.awt.Color(0, 102, 102));
        lblRIdioma.setText("Idioma:");

        lblRTotal.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblRTotal.setForeground(new java.awt.Color(0, 102, 102));
        lblRTotal.setText("Subtotal: ");

        lblRPrecio.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblRPrecio.setForeground(new java.awt.Color(0, 102, 102));
        lblRPrecio.setText("Precio P/B:");

        lblRAsientos.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblRAsientos.setForeground(new java.awt.Color(0, 102, 102));
        lblRAsientos.setText("Asintos: ");

        lblRSala.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblRSala.setForeground(new java.awt.Color(0, 102, 102));
        lblRSala.setText("Sala: ");

        javax.swing.GroupLayout pnlResumenLayout = new javax.swing.GroupLayout(pnlResumen);
        pnlResumen.setLayout(pnlResumenLayout);
        pnlResumenLayout.setHorizontalGroup(
            pnlResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResumenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRBoletos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRPelicula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addComponent(lblRHorario, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addComponent(lblRIdioma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addComponent(lblRSala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRAsientos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addComponent(lblRPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addComponent(lblRTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlResumenLayout.setVerticalGroup(
            pnlResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResumenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRBoletos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRPelicula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRHorario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRIdioma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRSala)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRAsientos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRPrecio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRTotal)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pnlDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        pnlDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripcion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(0, 102, 102))); // NOI18N
        pnlDescripcion.setEnabled(false);
        pnlDescripcion.setPreferredSize(new java.awt.Dimension(440, 300));

        javax.swing.GroupLayout pnlDescripcionLayout = new javax.swing.GroupLayout(pnlDescripcion);
        pnlDescripcion.setLayout(pnlDescripcionLayout);
        pnlDescripcionLayout.setHorizontalGroup(
            pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        pnlDescripcionLayout.setVerticalGroup(
            pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblTitulo.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Taquilla");

        lblMenu.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu.setText("Menu");
        lblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuMouseClicked(evt);
            }
        });

        lblAux1.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        lblAux1.setForeground(new java.awt.Color(255, 255, 255));
        lblAux1.setText("→");

        lblTaqulla.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        lblTaqulla.setForeground(new java.awt.Color(255, 255, 255));
        lblTaqulla.setText("Taquilla");
        lblTaqulla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblTaqullaMousePressed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 102, 102));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPagar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(0, 102, 102));
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        txtPDirector.setBackground(new java.awt.Color(0, 102, 102));
        txtPDirector.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPDirector.setForeground(new java.awt.Color(255, 255, 255));

        txtPDuracion.setBackground(new java.awt.Color(0, 102, 102));
        txtPDuracion.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPDuracion.setForeground(new java.awt.Color(255, 255, 255));

        txtPDistribuidora.setBackground(new java.awt.Color(0, 102, 102));
        txtPDistribuidora.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPDistribuidora.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlFunciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlAsientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(pnlFondoLayout.createSequentialGroup()
                                    .addComponent(btnCancelar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPagar))
                                .addComponent(pnlResumen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtPDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtPDistribuidora, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(427, 427, 427))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(lblMenu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAux1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTaqulla))
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAux1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTaqulla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(txtPDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPDistribuidora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(pnlDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(pnlResumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPagar)))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(pnlFunciones, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1008, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
      VentaTaquilla venta = new VentaTaquilla(VistaDeOrigen.TAQUILLA, taquilla);
      venta.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
      // TODO add your handling code here:
      Taquilla taq = new Taquilla();
      taq.setDulceriaController(dulceriaController);
      taq.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void lblTaqullaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaqullaMousePressed
      // TODO add your handling code here:
      Taquilla taq = new Taquilla();
      taq.setDulceriaController(dulceriaController);
      taq.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_lblTaqullaMousePressed

    private void lblMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuMouseClicked
      // TODO add your handling code here:
      Menu menu = new Menu();
      menu.setDulceriaController(dulceriaController);
      menu.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_lblMenuMouseClicked

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(Taquilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Taquilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Taquilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Taquilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> {
        //new Taquilla().setVisible(true);
    });
  }

  void setDulceriaController(DulceriaController dulceriaController) {
    this.dulceriaController = dulceriaController;
  }



    public void setEmpleado(Empleado empleado) {
        taquilla.setEmpleado(empleado);
    }
  
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAux1;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblRAsientos;
    private javax.swing.JLabel lblRBoletos;
    private javax.swing.JLabel lblRHorario;
    private javax.swing.JLabel lblRIdioma;
    private javax.swing.JLabel lblRPelicula;
    private javax.swing.JLabel lblRPrecio;
    private javax.swing.JLabel lblRSala;
    private javax.swing.JLabel lblRTotal;
    private javax.swing.JLabel lblTaqulla;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAsientos;
    private javax.swing.JPanel pnlDescripcion;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlFunciones;
    private javax.swing.JPanel pnlResumen;
    private javax.swing.JTextField txtPDirector;
    private javax.swing.JTextField txtPDistribuidora;
    private javax.swing.JTextField txtPDuracion;
    // End of variables declaration//GEN-END:variables

}
