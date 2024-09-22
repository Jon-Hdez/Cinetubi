package uam.azc.adsi.cinetubi.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author aldai
 */
public class ListaVentaDulceriaPanel extends javax.swing.JPanel {

  /**
   * Creates new form ListaVentaDulceriaPanel
   */
  public ListaVentaDulceriaPanel() {
    initComponents();
  }

  public JPanel getLineaVentaPanel() {
    return lineaVentaPanel;
  }

  public JPanel getTotalPanel() {
    return totalPanel;
  }

  public JLabel getTotalPriceLabel() {
    return totalPriceLabel;
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    titlePanel = new javax.swing.JPanel();
    titleLabel = new javax.swing.JLabel();
    contentPanel = new javax.swing.JPanel();
    contentHeaderPanel = new javax.swing.JPanel();
    contentHeaderLabel = new javax.swing.JLabel();
    lineaVentaPanel = new javax.swing.JPanel();
    totalPanel = new javax.swing.JPanel();
    totalTextLabel = new javax.swing.JLabel();
    totalPriceLabel = new javax.swing.JLabel();

    titlePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    titleLabel.setBackground(new java.awt.Color(204, 255, 204));
    titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    titleLabel.setText("  Lista de Venta");
    titleLabel.setOpaque(true);

    javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
    titlePanel.setLayout(titlePanelLayout);
    titlePanelLayout.setHorizontalGroup(
      titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    titlePanelLayout.setVerticalGroup(
      titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
    );

    contentPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    contentHeaderLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    contentHeaderLabel.setText("Producto               Cantidad         Precio");

    javax.swing.GroupLayout contentHeaderPanelLayout = new javax.swing.GroupLayout(contentHeaderPanel);
    contentHeaderPanel.setLayout(contentHeaderPanelLayout);
    contentHeaderPanelLayout.setHorizontalGroup(
      contentHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(contentHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
    );
    contentHeaderPanelLayout.setVerticalGroup(
      contentHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(contentHeaderPanelLayout.createSequentialGroup()
        .addComponent(contentHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );

    lineaVentaPanel.setLayout(new javax.swing.BoxLayout(lineaVentaPanel, javax.swing.BoxLayout.Y_AXIS));

    totalTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    totalTextLabel.setText("Total:");

    totalPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    totalPriceLabel.setText("$0.00");
    totalPriceLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    javax.swing.GroupLayout totalPanelLayout = new javax.swing.GroupLayout(totalPanel);
    totalPanel.setLayout(totalPanelLayout);
    totalPanelLayout.setHorizontalGroup(
      totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(totalPanelLayout.createSequentialGroup()
        .addGap(66, 66, 66)
        .addComponent(totalTextLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(totalPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    totalPanelLayout.setVerticalGroup(
      totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(totalPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(totalTextLabel)
          .addComponent(totalPriceLabel))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
    contentPanel.setLayout(contentPanelLayout);
    contentPanelLayout.setHorizontalGroup(
      contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(contentPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lineaVentaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(totalPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(contentHeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    contentPanelLayout.setVerticalGroup(
      contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(contentPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(contentHeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(lineaVentaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(totalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(21, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel contentHeaderLabel;
  private javax.swing.JPanel contentHeaderPanel;
  private javax.swing.JPanel contentPanel;
  private javax.swing.JPanel lineaVentaPanel;
  private javax.swing.JLabel titleLabel;
  private javax.swing.JPanel titlePanel;
  private javax.swing.JPanel totalPanel;
  private javax.swing.JLabel totalPriceLabel;
  private javax.swing.JLabel totalTextLabel;
  // End of variables declaration//GEN-END:variables
}
