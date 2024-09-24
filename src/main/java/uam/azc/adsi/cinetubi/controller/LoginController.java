package uam.azc.adsi.cinetubi.controller;

import uam.azc.adsi.cinetubi.dao.EmpleadoDAO;
import uam.azc.adsi.cinetubi.model.Empleado;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class LoginController {

  private EmpleadoDAO eDAO;

  public LoginController() {
    this.eDAO = new EmpleadoDAO();
  }

  public Empleado validarUsuario(String user, String psw) {
    return eDAO.buscarUsuario(user, psw);
  }
}
