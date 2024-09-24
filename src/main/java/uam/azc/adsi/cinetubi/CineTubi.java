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
    DulceriaController dulceriaController = new DulceriaController();
    LoginController loginController = new LoginController();

//      Modifiquen la vista que quieren ejecutar
//    DulceriaController dulceriaController = new DulceriaController();
//    Menu menuView = new Menu();
//    menuView.setDulceriaController(dulceriaController);
//    menuView.setVisible(true);

    Login login = new Login();
    login.setLoginController(loginController);

    login.setVisible(true);

  }
}
