/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.controller;
import java.sql.SQLException;
import java.util.List;
import uam.azc.adsi.cinetubi.dao.FuncionesDAO;
import uam.azc.adsi.cinetubi.model.Funcion;


public class FuncionController {
    private FuncionesDAO funcionDAO;

    public FuncionController(FuncionesDAO funcionDAO) {
        this.funcionDAO = funcionDAO;
    }

    public void agregarFuncion(Funcion funcion) throws SQLException {
        funcionDAO.agregarFuncion(funcion);
    }

    public List<Funcion> obtenerFunciones() throws SQLException {
        return funcionDAO.obtenerFunciones();
    }

    public void actualizarFuncion(Funcion funcion) throws SQLException {
        funcionDAO.actualizarFuncion(funcion);
    }

    public void eliminarFuncion(int id) throws SQLException {
        funcionDAO.eliminarFuncion(id);
    }
}
