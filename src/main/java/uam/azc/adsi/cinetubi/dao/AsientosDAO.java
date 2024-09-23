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
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.azc.adsi.cinetubi.model.*;
import uam.azc.adsi.cinetubi.util.DatabaseConnection;

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
    
    public List<Integer> asientosFuncion(Funcion funcion){
        
        try {
            String sql = "SELECT numero_asiento FROM boleto WHERE id_funcion="+funcion.getId();
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            List<Integer> ocupados=new ArrayList<>();
            while(rs.next()){
                ocupados.add(rs.getInt("numero_asiento"));
            }
            return ocupados;
        } catch (SQLException ex) {
            System.err.println("Error tipo: " +ex);
        }
        return null;
    }
    
        
}
