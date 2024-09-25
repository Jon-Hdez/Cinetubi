/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uam.azc.adsi.cinetubi.model.*;

/**
 *
 * @author José Vicente López López 2212002118
 */

public class AsientosDAO {
    private Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/cinetubi";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public AsientosDAO() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.err.println("Error tipo: " +ex);
        }
    }
    
    public List<Integer> asientosFuncion(Funcion funcion) {
        List<Integer> ocupados = new ArrayList<>();

        try {
            // Corregir la consulta SQL
            String sql = "select b.numero_asiento as numAsiento\n" +
                        "from  boleto as b inner join funcion as f on b.id_funcion=f.id\n" +
                        "where f.id= ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, funcion.getId()); // Usa parámetros para evitar inyección SQL

            ResultSet rs = ps.executeQuery();

            // Recorrer el ResultSet
            while (rs.next()) {
                ocupados.add(rs.getInt("numAsiento")); // Agregar el número de asiento a la lista
            }

        } catch (SQLException ex) {
            System.err.println("Error tipo: " + ex);
        }

        return ocupados;
    }

    
        
}
