/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package uam.azc.adsi.cinetubi;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.azc.adsi.cinetubi.controller.DulceriaController;
import uam.azc.adsi.cinetubi.dao.SnackDAO;
import uam.azc.adsi.cinetubi.model.Combo;
import uam.azc.adsi.cinetubi.model.ComboCatalog;
import uam.azc.adsi.cinetubi.model.SnackCatalog;
import uam.azc.adsi.cinetubi.util.DatabaseConnection;
import uam.azc.adsi.cinetubi.view.MenuView;
import uam.azc.adsi.cinetubi.view.VentaDulceriaView;

/**
 *
 * @author Jony
 */
public class CineTubi {

  public static void main(String[] args) {
    System.out.println("Hello World!");
    DatabaseConnection dbConn;
    try {
      dbConn = DatabaseConnection.getInstance();
      SnackDAO sDAO = new SnackDAO(dbConn.getConnection());
      SnackCatalog sc = new SnackCatalog(sDAO);
      DulceriaController dulceriaController = new DulceriaController(sc);
      MenuView menuView = new MenuView(dulceriaController);
      menuView.setVisible(true);
//      VentaDulceriaView dulceriaView = new VentaDulceriaView(dulceriaController);
//      dulceriaView.setVisible(true);
    } catch (SQLException ex) {
      Logger.getLogger(CineTubi.class.getName()).log(Level.SEVERE, null, ex);
    }

  }
}
