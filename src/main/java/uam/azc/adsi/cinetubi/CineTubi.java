/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package uam.azc.adsi.cinetubi;

import uam.azc.adsi.cinetubi.controller.DulceriaController;
import uam.azc.adsi.cinetubi.view.Menu;

/**
 *
 * @author Jony
 */
public class CineTubi {

  public static void main(String[] args) {
    DulceriaController dulceriaController = new DulceriaController();

//      Modifiquen la vista que quieren ejecutar
    Menu menuView = new Menu();
    menuView.setDulceriaController(dulceriaController);
    menuView.setVisible(true);

  }
}
