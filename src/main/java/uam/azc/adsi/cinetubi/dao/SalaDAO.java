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
import uam.azc.adsi.cinetubi.model.Funcion;

/**
 *
 * @author vicen
 */
public class SalaDAO {
    private Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/CineTubi";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public SalaDAO() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.err.println("Error tipo: " +ex);
        }
    }
    
    public int asientosFuncion(Funcion funcion){
        
        try {
            String sql = "SELECT id_sala FROM funcion WHERE id= "+ funcion.getId()+";";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int sala = rs.getInt(1);
                System.out.println(sala+"\n");
                return sala;
            }
        } catch (SQLException ex) {
            System.err.println("Error tipo: " +ex);
        }
        return 0;
    }
    
    
}
