/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.adsi.cinetubi.controller;
import java.sql.SQLException;
import java.util.List;
import uam.azc.adsi.cinetubi.dao.FuncionesDAOJony;
import uam.azc.adsi.cinetubi.model.FuncionJony;


public class FuncionController {
    private FuncionesDAOJony funcionDAO;

    public FuncionController(FuncionesDAOJony funcionDAO) {
        this.funcionDAO = funcionDAO;
    }

    public void agregarFuncion(FuncionJony funcion) throws SQLException {
        funcionDAO.agregarFuncion(funcion);
    }

    public List<FuncionJony> obtenerFunciones() throws SQLException {
        return funcionDAO.obtenerFunciones();
    }

    public void actualizarFuncion(FuncionJony funcion) throws SQLException {
        funcionDAO.actualizarFuncion(funcion);
    }

    public void eliminarFuncion(int id) throws SQLException {
        funcionDAO.eliminarFuncion(id);
    }
}
