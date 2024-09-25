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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    String query = "INSERT INTO boleto (id_funcion, id_venta, id_sala, numero_asiento) VALUES (?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        for (Boleto boleto : boletos) {
            stmt.setInt(1, boleto.getIdFuncion());
            stmt.setInt(2, venta);
            stmt.setInt(3, boleto.getIdSala());
            stmt.setInt(4, boleto.getNumeroAsiento());
            
            // Ejecutar la inserción para cada boleto
            stmt.executeUpdate();
        }
        System.out.println("Se han agregado los boletos correctamente.");
    } catch (SQLException ex) {
        Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, "Error al agregar boletos", ex);
    }
}

}
