/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.controller;

import java.sql.SQLException;
import java.util.List;
import uam.azc.adsi.cinetubi.dao.PeliculaDAOJony;
import uam.azc.adsi.cinetubi.model.PeliculaJony;


public class PeliculaController {
    private PeliculaDAOJony peliculaDAO;

    public PeliculaController(PeliculaDAOJony peliculaDAO) {
        this.peliculaDAO = peliculaDAO;
    }

    public void agregarPelicula(PeliculaJony pelicula) throws SQLException {
        peliculaDAO.agregarPelicula(pelicula);
    }

    public List<PeliculaJony> obtenerPeliculas() throws SQLException {
        return peliculaDAO.obtenerPeliculas();
    }

    public void actualizarPelicula(PeliculaJony pelicula) throws SQLException {
        peliculaDAO.actualizarPelicula(pelicula);
    }

    public void eliminarPelicula(int id) throws SQLException {
        peliculaDAO.eliminarPelicula(id);
    }
}
