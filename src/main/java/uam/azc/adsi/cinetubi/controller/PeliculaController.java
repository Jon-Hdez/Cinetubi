/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.controller;

import java.sql.SQLException;
import java.util.List;
import uam.azc.adsi.cinetubi.dao.PeliculaDAO;
import uam.azc.adsi.cinetubi.model.Pelicula;


public class PeliculaController {
    private PeliculaDAO peliculaDAO;

    public PeliculaController(PeliculaDAO peliculaDAO) {
        this.peliculaDAO = peliculaDAO;
    }

    public void agregarPelicula(Pelicula pelicula) throws SQLException {
        peliculaDAO.agregarPelicula(pelicula);
    }

    public List<Pelicula> obtenerPeliculas() throws SQLException {
        return peliculaDAO.obtenerPeliculas();
    }

    public void actualizarPelicula(Pelicula pelicula) throws SQLException {
        peliculaDAO.actualizarPelicula(pelicula);
    }

    public void eliminarPelicula(int id) throws SQLException {
        peliculaDAO.eliminarPelicula(id);
    }
}
