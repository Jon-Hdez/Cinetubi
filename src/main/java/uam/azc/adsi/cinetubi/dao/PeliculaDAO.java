/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.azc.adsi.cinetubi.model.Pelicula;

public class PeliculaDAO {

  private Connection connection;

  public PeliculaDAO(Connection connection) {
    this.connection = connection;
  }

  // Crear película
  public boolean agregarPelicula(Pelicula pelicula) throws SQLException {
    String query = "INSERT INTO pelicula (titulo, duracion, distribuidor, clasificacion, director, pais, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, pelicula.getTitulo());
      stmt.setInt(2, pelicula.getDuracion());
      stmt.setString(3, pelicula.getDistribuidor());
      stmt.setString(4, pelicula.getClasificacion());
      stmt.setString(5, pelicula.getDirector());
      stmt.setString(6, pelicula.getPais());
      stmt.setString(7, pelicula.getDescripcion());
      return stmt.executeUpdate() > 0;
    }
  }

  // Leer todas las películas
  public List<Pelicula> obtenerPeliculas() throws SQLException {
    List<Pelicula> peliculas = new ArrayList<>();
    String query = "SELECT * FROM pelicula";
    try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
      while (rs.next()) {
        Pelicula pelicula = new Pelicula();
        pelicula.setIdPelicula(rs.getInt("id"));
        pelicula.setTitulo(rs.getString("titulo"));
        pelicula.setDuracion(rs.getInt("duracion"));
        pelicula.setDistribuidor(rs.getString("distribuidor"));
        pelicula.setClasificacion(rs.getString("clasificacion"));
        pelicula.setDirector(rs.getString("director"));
        pelicula.setPais(rs.getString("pais"));
        pelicula.setDescripcion(rs.getString("descripcion"));
        peliculas.add(pelicula);
      }
    }
    return peliculas;
  }

  // Actualizar película
  public void actualizarPelicula(Pelicula pelicula) throws SQLException {
    String query = "UPDATE pelicula SET titulo = ?, duracion = ?, distribuidor = ?, clasificacion = ?, director = ?, pais = ?, descripcion = ? WHERE id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, pelicula.getTitulo());
      stmt.setInt(2, pelicula.getDuracion());
      stmt.setString(3, pelicula.getDistribuidor());
      stmt.setString(4, pelicula.getClasificacion());
      stmt.setString(5, pelicula.getDirector());
      stmt.setString(6, pelicula.getPais());
      stmt.setString(7, pelicula.getDescripcion());
      stmt.setInt(8, pelicula.getIdPelicula());

      int filasActualizadas = stmt.executeUpdate();

      if (filasActualizadas == 0) {
        throw new SQLException("No se pudo actualizar la película, no se encontró el ID.");
      }
    }
  }

  // Eliminar película
  public boolean eliminarPelicula(int id) throws SQLException {
    String query = "DELETE FROM pelicula WHERE id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setInt(1, id);
      return stmt.executeUpdate() > 0;
    }
  }

  public Pelicula searchMovie(int idP) {

    String URL = "jdbc:mysql://localhost:3306/CineTubi";
    String USER = "root";
    String PASSWORD = "root";

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "select * from pelicula where id=" + idP + ";";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
              int id = rs.getInt(1);
              String titulo = rs.getString(2);
              int duracion = rs.getInt(3);
              String distribuidor = rs.getString(4);
              String clasifiacion = rs.getString(5);
              String director = rs.getString(6);
              String pais = rs.getString(7);
              String descripcion = rs.getString(8);
              Pelicula pelicula = new Pelicula(id, titulo, duracion, distribuidor, clasifiacion, director, pais, descripcion);
              return pelicula;
            }
        }   catch (SQLException ex) {   
            System.err.println("Error en buscar pelicula: "+ex.getSQLState());
      }   
      return null;
}
  
}
