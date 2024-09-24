/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package uam.azc.adsi.cinetubi;

import uam.azc.adsi.cinetubi.controller.DulceriaController;
import uam.azc.adsi.cinetubi.controller.LoginController;
import uam.azc.adsi.cinetubi.view.Login;
import uam.azc.adsi.cinetubi.view.Menu;

/**
 *
 * @author Jony
 */
public class CineTubi {

  public static void main(String[] args) {
    LoginController loginController = new LoginController();
    Login login = new Login();
    login.setLoginController(loginController);
    login.setVisible(true);
  }
}
