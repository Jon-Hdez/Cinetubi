/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uam.azc.adsi.cinetubi.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uam.azc.adsi.cinetubi.controller.FuncionController;
import uam.azc.adsi.cinetubi.dao.FuncionDAO;
import uam.azc.adsi.cinetubi.model.Funcion;
import uam.azc.adsi.cinetubi.util.DatabaseConnection;

/**
 *
 * @author Jony
 */
public class EditarCartelera extends javax.swing.JFrame {

    /**
     * Creates new form EditarCartelera
     */
    public EditarCartelera() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        cargarFunciones();
    }
    
    public void actualizarVentana() {
        // Revalida y repinta para reflejar los cambios
        DefaultTableModel modelo = (DefaultTableModel) jTfunc.getModel();
        modelo.setRowCount(0);  // Esto limpia todas las filas en la tabla 
        cargarFunciones();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTfunc = new javax.swing.JTable();
        jBeliminar = new javax.swing.JButton();
        jBactualizar = new javax.swing.JButton();
        jBvolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Editar Cartelera");

        jTfunc.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTfunc);

        jBeliminar.setText("Eliminar");
        jBeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeliminarActionPerformed(evt);
            }
        });

        jBactualizar.setText("Actualizar");
        jBactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBactualizarActionPerformed(evt);
            }
        });

        jBvolver.setText("Volver");
        jBvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBvolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBvolver)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBactualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBeliminar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBeliminar)
                    .addComponent(jBactualizar)
                    .addComponent(jBvolver))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBvolverActionPerformed
        dispose();
        MenuProgramacion menu = new MenuProgramacion();
        menu.setVisible(true);
    }//GEN-LAST:event_jBvolverActionPerformed

    private void jBeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeliminarActionPerformed
int selectedRow = jTfunc.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona una película.");
        return;
    }

    int funcionId = (int) jTfunc.getValueAt(selectedRow, 0); // ID de la película
    
    try {
        Connection connection = new DatabaseConnection().getConnection();
        FuncionDAO funcionDAO = new FuncionDAO(connection);
        
                funcionDAO.eliminarFuncion(funcionId);
                      actualizarVentana();
        JOptionPane.showMessageDialog(this, "Función eliminada exitosamente.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar función: " + e.getMessage());
    }
        
     
      
        
    }//GEN-LAST:event_jBeliminarActionPerformed

    private void jBactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBactualizarActionPerformed
int selectedRow = jTfunc.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona una funcion.");
        return;
    }
    
     
   
        try {
        Connection connection = new DatabaseConnection().getConnection();
        FuncionDAO funcionDAO = new FuncionDAO(connection);
        Funcion funcion = new Funcion();
        String fechatxt = (String) jTfunc.getValueAt(selectedRow, 2);
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
        // Obtener los datos de la fila seleccionada
        int id = Integer.parseInt((String) jTfunc.getValueAt(selectedRow, 1)); // Asegúrate de que txtId contenga un número válido

        funcion.setId((int) jTfunc.getValueAt(selectedRow, 0));
        funcion.setIdPelicula(id);
        funcion.setFecha(fecha);
        funcion.setHorario((String) jTfunc.getValueAt(selectedRow, 3));
        funcion.setIdSala((int) jTfunc.getValueAt(selectedRow, 4));
        funcion.setIdioma((String) jTfunc.getValueAt(selectedRow, 5));
        // Actualizar película en la base de datos
        funcionDAO.actualizarFuncion(funcion);
        
        // Actualizar la ventana o tabla
        actualizarVentana(); // Aquí deberías recargar los datos de la tabla para que se refleje la actualización
        
        
        JOptionPane.showMessageDialog(this, "Funciones actualizadas exitosamente.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al actualizar las funciones: " + e.getMessage());
    }
    }//GEN-LAST:event_jBactualizarActionPerformed

    public void cargarFunciones(){
        
        try {
            String[] columnNames = {"id","Id Pelicula","Fecha","Horario", "Sala", "Idioma"};
            
            DefaultTableModel model = new DefaultTableModel(null, columnNames);
            
            Connection connection = null;
            DatabaseConnection dbConnection = new DatabaseConnection();
            // Obtener la conexión desde DataBaseConnection
            connection = dbConnection.getConnection();
            FuncionDAO funcionDAO = new FuncionDAO(connection);
            FuncionController funcionControl = new FuncionController(funcionDAO);
            
            List<Funcion> listaFuncion = funcionControl.obtenerFunciones();
           SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd"); // Ajusta el formato según tus necesidades

            for ( Funcion func: listaFuncion){
                Object[] data = new Object[columnNames.length];
                data[0] = func.getId();
                data[1] = func.getIdPelicula();
                if (func.getFecha() != null) {
                data[2] = formatoFecha.format(func.getFecha());
                    System.out.println(data[2]);
            } else {
                data[2] = ""; // O un valor predeterminado como "Sin fecha"
            }
                data[3] = func.getHorario();
                data[4] = func.getIdSala();
                data[5] = func.getIdioma();
                
                
                model.addRow(data);
                
            }
            jTfunc.setModel(model);
            
        } catch (SQLException ex) {
            Logger.getLogger(AgregarFuncion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
        
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBactualizar;
    private javax.swing.JButton jBeliminar;
    private javax.swing.JButton jBvolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTfunc;
    // End of variables declaration//GEN-END:variables
}
