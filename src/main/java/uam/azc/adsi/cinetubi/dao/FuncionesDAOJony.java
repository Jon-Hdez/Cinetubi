/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import uam.azc.adsi.cinetubi.model.FuncionJony;


public class FuncionesDAOJony {
    private Connection connection;

    public FuncionesDAOJony(Connection connection) {
        this.connection = connection;
    }

    // Crear función
    public boolean agregarFuncion(FuncionJony funcion) throws SQLException {
        String query = "INSERT INTO funcion (id_pelicula, horario, id_sala, idioma, fecha) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, funcion.getId_pelicula());
            stmt.setString(2, funcion.getHorario());
            stmt.setInt(3, funcion.getSala());
            stmt.setString(4, funcion.getIdioma());
            stmt.setDate(5, (Date) funcion.getFecha());
            return stmt.executeUpdate() > 0;
        }
    }

    // Leer todas las funciones
    public List<FuncionJony> obtenerFunciones() throws SQLException {
        List<FuncionJony> funciones = new ArrayList<>();
        String query = "SELECT * FROM funcion";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                FuncionJony funcion = new FuncionJony();
                funcion.setId(rs.getInt("id"));
                funcion.setId_pelicula(rs.getInt("id_pelicula"));
                funcion.setHorario(rs.getString("horario"));
                funcion.setSala(rs.getInt("id_sala"));
                funcion.setIdioma(rs.getString("idioma"));
                funciones.add(funcion);
            }
        }
        return funciones;
    }

    // Actualizar función
    public boolean actualizarFuncion(FuncionJony funcion) throws SQLException {
        String query = "UPDATE funcion SET id_pelicula = ?, horario = ?, id_sala = ?, idioma = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, funcion.getId_pelicula());
            stmt.setString(2, funcion.getHorario());
            stmt.setInt(3, funcion.getSala());
            stmt.setString(4, funcion.getIdioma());
            stmt.setInt(5, funcion.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    // Eliminar función
    public boolean eliminarFuncion(int id) throws SQLException {
        String query = "DELETE FROM funcion WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
    
    
      public List<FuncionJony> getAllFuncion(){
        try {
            String sql = "SELECT * FROM funcion ORDER BY id_pelicula AND horario;";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            List<FuncionJony> funciones = new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt(1);
                int id_pelicula = rs.getInt(2);
                String hora=rs.getString(3);
                int sala=rs.getInt(4);
                String idioma=rs.getString(5);
                Date fecha=rs.getDate(6);
                FuncionJony funcion = new FuncionJony(id,id_pelicula, hora, sala, idioma, fecha);
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
