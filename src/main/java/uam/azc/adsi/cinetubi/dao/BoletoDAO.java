/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import uam.azc.adsi.cinetubi.model.Boleto;

/**
 *
 * @author vicen
 */
public class BoletoDAO {
    private Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/CineTubi";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public BoletoDAO() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.err.println("Error tipo: " +ex);
        }
    }
    
    public void agregarBoletos(List<Boleto> boletos, int venta) {
        // Prepara la inserción en la base de datos
        String sql = "INSERT INTO boleto (id_funcion, id_venta, id_sala, numero_asiento) VALUES (?, ?, ?, ?)";

        try {
            // Iniciar transacción
            connection.setAutoCommit(false);
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                for (Boleto bol : boletos) {
                    stmt.setInt(1, bol.getIdFuncion());       // Asegúrate de que id_funcion es válido
                    stmt.setInt(2, venta);                     // Usar el valor de venta pasado como parámetro
                    stmt.setInt(3, bol.getIdSala());          // Asegúrate de que id_sala es válido
                    stmt.setInt(4, bol.getNumeroAsiento());   // Asegúrate de que numero_asiento es válido

                    stmt.addBatch();  // Agrega la inserción al batch
                    System.out.println(bol.toString());
                }
                stmt.executeBatch();  // Ejecuta todas las inserciones en el batch
                connection.commit();  // Confirma la transacción
            } catch (SQLException e) {
                connection.rollback();  // Deshacer cambios en caso de error
                System.err.println("Error en agregar asientos: " + e.toString());
            } finally {
                connection.setAutoCommit(true);  // Restablecer el auto commit
            }
        } catch (SQLException e) {
            System.err.println("Error en la conexión: " + e.toString());
        }
    }


}
