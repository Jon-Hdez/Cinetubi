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
import uam.azc.adsi.cinetubi.model.Funcion;
import uam.azc.adsi.cinetubi.util.DatabaseConnection;

/**
 *
 * @author vicen
 */
public class FuncionesDAO {
    
    private Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/cinetubi";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public FuncionesDAO() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.err.println("Error tipo: " +ex);
        }
      
    }
    
    public List<Funcion> getAllFuncion(){
        try {
            String sql = "SELECT * FROM funcion ORDER BY id_pelicula AND horario;";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            List<Funcion> funciones = new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt(1);
                int id_pelicula = rs.getInt(2);
                String hora=rs.getString(3);
                int sala=rs.getInt(4);
                String idioma=rs.getString(5);
                Funcion funcion = new Funcion(id,id_pelicula, hora, sala, idioma);
                System.out.println(funcion.toString()+"\n");
                funciones.add(funcion);
            }
            return funciones;
        } catch (SQLException ex) {
            System.err.println("Error tipo: " +ex);
        }
        return null;
    }
    
    
}
