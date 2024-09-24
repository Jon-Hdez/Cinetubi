/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uam.azc.adsi.cinetubi.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uam.azc.adsi.cinetubi.controller.PeliculaController;
import uam.azc.adsi.cinetubi.dao.FuncionesDAOJony;
import uam.azc.adsi.cinetubi.dao.PeliculaDAOJony;
import uam.azc.adsi.cinetubi.model.FuncionJony;
import uam.azc.adsi.cinetubi.model.PeliculaJony;
import uam.azc.adsi.cinetubi.util.DatabaseConnection;

/**
 *
 * @author Jony
 */
public class AgregarFuncionJony extends javax.swing.JFrame {

    /**
     * Creates new form EditarCartelera
     */
    public AgregarFuncionJony() {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        cargarPeliculas();
  
    }
    
    public void cargarPeliculas(){
        
        try {
            String[] columnNames = {"id","Nombre","Duración","Distribuidor", "Clasificación", "Director", "País"};
            
            DefaultTableModel model = new DefaultTableModel(null, columnNames){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
                
            };
            
            Connection connection = null;
            DatabaseConnection dbConnection = DatabaseConnection.getInstance();
            // Obtener la conexión desde DataBaseConnection
            connection = dbConnection.getConnection();
            PeliculaDAOJony peliculaDAO = new PeliculaDAOJony(connection);
            PeliculaController pelisControl = new PeliculaController(peliculaDAO);
            
            List<PeliculaJony> listaPelicula = pelisControl.obtenerPeliculas();
            for ( PeliculaJony peli: listaPelicula){
                Object[] data = new Object[columnNames.length];
                data[0] = peli.getIdPelicula();
                data[1] = peli.getTitulo();
                data[2] = peli.getDuracion();
                data[3] = peli.getDistribuidor();
                data[4] = peli.getClasificacion();
                data[5] = peli.getDirector();
                data[6] = peli.getPais();
                
                model.addRow(data);
                
            }
            jTpelis.setModel(model);
            
        } catch (SQLException ex) {
            Logger.getLogger(AgregarFuncionJony.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
        
        
    }
    
    private List<Integer> obtenerSalasSeleccionadas() {
    List<Integer> salasSeleccionadas = new ArrayList<>();

    if (chS1.isSelected()) salasSeleccionadas.add(1);
    if (chS2.isSelected()) salasSeleccionadas.add(2);
    if (chS3.isSelected()) salasSeleccionadas.add(3);
    if (chS4.isSelected()) salasSeleccionadas.add(4);
    if (chS5.isSelected()) salasSeleccionadas.add(5);

    return salasSeleccionadas;
}

    private List<String> obtenerHorariosSeleccionados() {
    List<String> horariosSeleccionados = new ArrayList<>();

    if (ch11.isSelected()) horariosSeleccionados.add("11:00");
    if (ch1430.isSelected()) horariosSeleccionados.add("14:30");
    if (ch13.isSelected()) horariosSeleccionados.add("13:00");
    if (ch15.isSelected()) horariosSeleccionados.add("15:00");
    if (ch17.isSelected()) horariosSeleccionados.add("17:00");
    if (ch18.isSelected()) horariosSeleccionados.add("18:00");
    if (ch19.isSelected()) horariosSeleccionados.add("19:00");
    if (ch21.isSelected()) horariosSeleccionados.add("21:00");

    return horariosSeleccionados;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTpelis = new javax.swing.JTable();
        ch11 = new javax.swing.JCheckBox();
        ch13 = new javax.swing.JCheckBox();
        ch15 = new javax.swing.JCheckBox();
        ch17 = new javax.swing.JCheckBox();
        ch19 = new javax.swing.JCheckBox();
        ch21 = new javax.swing.JCheckBox();
        ch1430 = new javax.swing.JCheckBox();
        ch18 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        chS1 = new javax.swing.JCheckBox();
        chS2 = new javax.swing.JCheckBox();
        chS3 = new javax.swing.JCheckBox();
        chS4 = new javax.swing.JCheckBox();
        chS5 = new javax.swing.JCheckBox();
        jBagregar = new javax.swing.JButton();
        jBvolver = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jCidioma = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTfecha = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Agregar Funcion");

        jLabel2.setText("Peliculas: ");

        jLabel3.setText("Horario:");

        jTpelis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTpelis);

        ch11.setText("11:00");
        ch11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch11ActionPerformed(evt);
            }
        });

        ch13.setText("13:00");

        ch15.setText("15:00");

        ch17.setText("17:00");

        ch19.setText("19:00");

        ch21.setText("21:00");

        ch1430.setText("14:30");

        ch18.setText("18:00");

        jLabel4.setText("Sala");

        chS1.setText("Sala 1");

        chS2.setText("Sala 2");
        chS2.setToolTipText("");

        chS3.setText("Sala 3");

        chS4.setText("Sala 4");
        chS4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chS4ActionPerformed(evt);
            }
        });

        chS5.setText("Sala 5");

        jBagregar.setText("Agregar ");
        jBagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBagregarActionPerformed(evt);
            }
        });

        jBvolver.setText("Volver");
        jBvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBvolverActionPerformed(evt);
            }
        });

        jLabel5.setText("Idioma");

        jCidioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "Ingles" }));

        jLabel6.setText("Fecha (Funcion Especial:)");

        jTfecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ch13)
                                        .addGap(18, 18, 18)
                                        .addComponent(ch18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ch15)
                                        .addGap(18, 18, 18)
                                        .addComponent(ch19))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ch11)
                                        .addGap(18, 18, 18)
                                        .addComponent(ch1430)))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chS1)
                                        .addGap(18, 18, 18)
                                        .addComponent(chS4))
                                    .addComponent(chS3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chS2)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jBvolver)
                                                .addGap(165, 165, 165)
                                                .addComponent(jBagregar))
                                            .addComponent(chS5)))))
                            .addComponent(ch17)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(ch21))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addGap(190, 190, 190)
                                .addComponent(jLabel4)
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jCidioma, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jTfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ch11)
                            .addComponent(ch1430))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ch13)
                            .addComponent(ch18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ch15)
                            .addComponent(ch19)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chS1)
                            .addComponent(chS4)
                            .addComponent(jCidioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chS2)
                            .addComponent(chS5)
                            .addComponent(jLabel6))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chS3)
                            .addComponent(jTfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ch17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(ch21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBagregar)
                    .addComponent(jBvolver))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ch11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch11ActionPerformed

    private void chS4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chS4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chS4ActionPerformed

    private void jBagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBagregarActionPerformed
        
         int selectedRow = jTpelis.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona una película.");
        return;
    }

    int peliculaId = (int) jTpelis.getValueAt(selectedRow, 0); // ID de la película
    List<String> horariosSeleccionados = obtenerHorariosSeleccionados();
    
    if (horariosSeleccionados.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona al menos un horario.");
        return;
    }

    List<Integer> salasSeleccionadas = obtenerSalasSeleccionadas();
    if (salasSeleccionadas.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona al menos una sala.");
        return;
    }

    try {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        FuncionesDAOJony funcionDAO = new FuncionesDAOJony(connection);
        FuncionJony funcion = new FuncionJony();
        String fechatxt = jTfecha.getText();
        Date fecha = null;
        if (!fechatxt.isEmpty()) {
            try {
                // Convertir la fecha de texto a java.sql.Date (formato YYYY-MM-DD)
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fechaUtil = formato.parse(fechatxt);
                fecha = new Date(fechaUtil.getTime());
            } catch (ParseException e) {
                // Manejar error de formato de fecha
                System.out.println("Error: Formato de fecha inválido.");
            }
        }
        
        // Agregar función para cada combinación de sala y horario seleccionados
        for (String horario : horariosSeleccionados) {
            for (int salaId : salasSeleccionadas) {
                funcion.setId_pelicula(peliculaId);
                funcion.setSala(salaId);
                funcion.setHorario(horario);
                funcion.setFecha(fecha);
                funcion.setIdioma((String) jCidioma.getSelectedItem());
                funcionDAO.agregarFuncion(funcion);
            }
        }
        
        JOptionPane.showMessageDialog(this, "Funciones agregadas exitosamente.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al agregar las funciones: " + e.getMessage());
    }
        
        
    }//GEN-LAST:event_jBagregarActionPerformed

    private void jBvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBvolverActionPerformed
            dispose();
        MenuProgramacion menu = new MenuProgramacion();
        menu.setVisible(true);
    }//GEN-LAST:event_jBvolverActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ch11;
    private javax.swing.JCheckBox ch13;
    private javax.swing.JCheckBox ch1430;
    private javax.swing.JCheckBox ch15;
    private javax.swing.JCheckBox ch17;
    private javax.swing.JCheckBox ch18;
    private javax.swing.JCheckBox ch19;
    private javax.swing.JCheckBox ch21;
    private javax.swing.JCheckBox chS1;
    private javax.swing.JCheckBox chS2;
    private javax.swing.JCheckBox chS3;
    private javax.swing.JCheckBox chS4;
    private javax.swing.JCheckBox chS5;
    private javax.swing.JButton jBagregar;
    private javax.swing.JButton jBvolver;
    private javax.swing.JComboBox<String> jCidioma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jTfecha;
    private javax.swing.JTable jTpelis;
    // End of variables declaration//GEN-END:variables
}
