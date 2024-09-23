/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setId(rs.getInt("id"));
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
            stmt.setInt(8, pelicula.getId());
            
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
}
