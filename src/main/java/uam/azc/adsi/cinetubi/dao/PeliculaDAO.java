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
 * @author vicen
 */
public class PeliculaDAO {
    private Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/cinetubi";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public PeliculaDAO() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.err.println("Error tipo: " +ex);
        }
      
    }
    
    public Pelicula searchMovie(int idP){
        try {
            String sql = "SELECT * FROM pelicula WHERE id="+idP +";";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id =rs.getInt(1);
                String titulo = rs.getString(2);
                int duracion=rs.getInt(3);
                String distribuidor=rs.getString(4);
                String clasifiacion=rs.getString(5);
                String director=rs.getString(6);
                String pais=rs.getString(7);
                String descripcion=rs.getString(8);
                Pelicula pelicula = new Pelicula(id,titulo, duracion, distribuidor, clasifiacion, director, pais, descripcion);
                return pelicula;
            }
        } catch (SQLException ex) {
            System.err.println("Error tipo: " +ex);
        }
        return null;
    }
    
}
