/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uam.azc.adsi.cinetubi.view;

import javax.swing.JOptionPane;
import uam.azc.adsi.cinetubi.controller.DulceriaController;
import uam.azc.adsi.cinetubi.controller.LoginController;
import uam.azc.adsi.cinetubi.model.Empleado;

/**
 *
 * @author José Vicente López López 2212002118
 */
public class Login extends javax.swing.JFrame {

  private LoginController loginController;

  /**
   * Creates new form Login
   */
  public Login() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jLabel6 = new javax.swing.JLabel();
    pnlFondo = new javax.swing.JLayeredPane();
    pnlAux = new javax.swing.JPanel();
    jLabel7 = new javax.swing.JLabel();
    txtCinetubi = new javax.swing.JLabel();
    lblLogin = new javax.swing.JLabel();
    lblUser = new javax.swing.JLabel();
    txtUser = new javax.swing.JTextField();
    lblPsw = new javax.swing.JLabel();
    pswUser = new javax.swing.JPasswordField();
    btnLogin = new javax.swing.JButton();

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jScrollPane1.setViewportView(jTextArea1);

    jLabel6.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 255, 255));
    jLabel6.setText("Company Name");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Login");
    setFocusable(false);
    setResizable(false);

    pnlFondo.setBackground(new java.awt.Color(255, 255, 255));
    pnlFondo.setToolTipText("");
    pnlFondo.setOpaque(true);
    pnlFondo.setPreferredSize(new java.awt.Dimension(700, 400));

    pnlAux.setBackground(new java.awt.Color(0, 102, 102));
    pnlAux.setPreferredSize(new java.awt.Dimension(300, 400));

    jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setText("copyright © company name All rights reserved");

    txtCinetubi.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
    txtCinetubi.setForeground(new java.awt.Color(255, 255, 255));
    txtCinetubi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    txtCinetubi.setText("CINETUBI");

    javax.swing.GroupLayout pnlAuxLayout = new javax.swing.GroupLayout(pnlAux);
    pnlAux.setLayout(pnlAuxLayout);
    pnlAuxLayout.setHorizontalGroup(
      pnlAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pnlAuxLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
        .addContainerGap())
      .addGroup(pnlAuxLayout.createSequentialGroup()
        .addGap(80, 80, 80)
        .addComponent(txtCinetubi, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pnlAuxLayout.setVerticalGroup(
      pnlAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAuxLayout.createSequentialGroup()
        .addGap(101, 101, 101)
        .addComponent(txtCinetubi)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
        .addComponent(jLabel7)
        .addContainerGap())
    );

    lblLogin.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    lblLogin.setForeground(new java.awt.Color(0, 102, 102));
    lblLogin.setText("LOGIN");

    lblUser.setBackground(new java.awt.Color(102, 102, 102));
    lblUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    lblUser.setForeground(new java.awt.Color(0, 102, 102));
    lblUser.setText("Usuario");

    txtUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    txtUser.setForeground(new java.awt.Color(102, 102, 102));
    txtUser.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtUserActionPerformed(evt);
      }
    });

    lblPsw.setBackground(new java.awt.Color(102, 102, 102));
    lblPsw.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    lblPsw.setForeground(new java.awt.Color(0, 102, 102));
    lblPsw.setText("Contraseña");

    pswUser.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        pswUserActionPerformed(evt);
      }
    });

    btnLogin.setBackground(new java.awt.Color(0, 102, 102));
    btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    btnLogin.setForeground(new java.awt.Color(255, 255, 255));
    btnLogin.setText("Login");
    btnLogin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnLoginActionPerformed(evt);
      }
    });

    pnlFondo.setLayer(pnlAux, javax.swing.JLayeredPane.DEFAULT_LAYER);
    pnlFondo.setLayer(lblLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);
    pnlFondo.setLayer(lblUser, javax.swing.JLayeredPane.DEFAULT_LAYER);
    pnlFondo.setLayer(txtUser, javax.swing.JLayeredPane.DEFAULT_LAYER);
    pnlFondo.setLayer(lblPsw, javax.swing.JLayeredPane.DEFAULT_LAYER);
    pnlFondo.setLayer(pswUser, javax.swing.JLayeredPane.DEFAULT_LAYER);
    pnlFondo.setLayer(btnLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);

    javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
    pnlFondo.setLayout(pnlFondoLayout);
    pnlFondoLayout.setHorizontalGroup(
      pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pnlFondoLayout.createSequentialGroup()
        .addComponent(pnlAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(29, 29, 29)
        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(pnlFondoLayout.createSequentialGroup()
            .addGap(108, 108, 108)
            .addComponent(lblLogin))
          .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(lblUser)
            .addComponent(txtUser)
            .addComponent(lblPsw)
            .addComponent(pswUser, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(28, Short.MAX_VALUE))
    );
    pnlFondoLayout.setVerticalGroup(
      pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pnlFondoLayout.createSequentialGroup()
        .addComponent(pnlAux, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
      .addGroup(pnlFondoLayout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addComponent(lblLogin)
        .addGap(40, 40, 40)
        .addComponent(lblUser)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(lblPsw)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(pswUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(26, 26, 26)
        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(pnlFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    getAccessibleContext().setAccessibleDescription("Frame que valida al usuario");

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  /**
   * Se valida el usuario con su contraseña
   *
   * @param evt
   */
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
      // TODO add your handling code here:
      String user = txtUser.getText();
      char[] password = pswUser.getPassword();
      String psw = new String(password);

      Empleado empleado = loginController.validarUsuario(user, psw);
      System.out.println("El empleado es: " + empleado);
      if (empleado == null) {
        JOptionPane.showMessageDialog(null,
                "Usuario no reconocido",
                "Intenta de nuevo",
                JOptionPane.WARNING_MESSAGE);
      } else {
        // Selecciona pantalla en funcion del area del empleado
        if (empleado.getArea().equals("dulceria")) {
          DulceriaController dulceriaController = new DulceriaController();
          dulceriaController.setEmpleadoActual(empleado);
          dulceriaController.crearVenta();

          Dulceria dulceria = new Dulceria(dulceriaController);
          dulceriaController.setDulceria(dulceria);

          dulceria.setVisible(true);
          this.dispose();
        }
        if (empleado.getArea().equals("cartelera")) {
          DulceriaController dulceriaController = new DulceriaController();
            dispose();
    MenuProgramacion menu = new MenuProgramacion();
    menu.setDulceriaController(dulceriaController);
    menu.setVisible(true);
        }
        if (empleado.getCategoria().equals("Gerente")) {
          DulceriaController dulceriaController = new DulceriaController();
            dispose();
    Menu menu = new Menu();
    menu.setDulceriaController(dulceriaController);
    menu.setVisible(true);
        }
      }


    }//GEN-LAST:event_btnLoginActionPerformed

  private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_txtUserActionPerformed

  private void pswUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswUserActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_pswUserActionPerformed

//  /**
//   * @param args the command line arguments
//   */
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
//      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    } catch (InstantiationException ex) {
//      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    } catch (IllegalAccessException ex) {
//      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    }
//    //</editor-fold>
//    //</editor-fold>
//
//    /* Create and display the form */
//    java.awt.EventQueue.invokeLater(new Runnable() {
//      public void run() {
//        new Login().setVisible(true);
//      }
//    });
//  }
  public void setLoginController(LoginController loginController) {
    this.loginController = loginController;
  }


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnLogin;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JLabel lblLogin;
  private javax.swing.JLabel lblPsw;
  private javax.swing.JLabel lblUser;
  private javax.swing.JPanel pnlAux;
  private javax.swing.JLayeredPane pnlFondo;
  private javax.swing.JPasswordField pswUser;
  private javax.swing.JLabel txtCinetubi;
  private javax.swing.JTextField txtUser;
  // End of variables declaration//GEN-END:variables
    /**
   * Funcion que inicialiaza los cajas con su icono, Falta la dependencia
   * swingx-all-1.6.4-1.jar.
   */
}
