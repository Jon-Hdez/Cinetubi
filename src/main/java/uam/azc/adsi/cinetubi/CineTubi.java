/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package uam.azc.adsi.cinetubi;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.azc.adsi.cinetubi.controller.DulceriaController;
import uam.azc.adsi.cinetubi.dao.ComboDAO;
import uam.azc.adsi.cinetubi.dao.SnackDAO;
import uam.azc.adsi.cinetubi.model.ProductCatalog;
import uam.azc.adsi.cinetubi.util.DatabaseConnection;
import uam.azc.adsi.cinetubi.view.Menu;
import uam.azc.adsi.cinetubi.view.Dulceria;

/**
 *
 * @author Jony
 */
public class CineTubi {

  public static void main(String[] args) {
    DatabaseConnection dbConnection;
    try {
      dbConnection = DatabaseConnection.getInstance();
      SnackDAO sDAO = new SnackDAO(dbConnection);
      ComboDAO cDAO = new ComboDAO(dbConnection);
      ProductCatalog sc = new ProductCatalog(sDAO, cDAO);

      DulceriaController dulceriaController = new DulceriaController(sc);

//      Modifiquen la vista que quieren ejecutar
      Menu menuView = new Menu();
      menuView.setDulceriaController(dulceriaController);
      menuView.setVisible(true);
    } catch (SQLException ex) {
      Logger.getLogger(CineTubi.class.getName()).log(Level.SEVERE, null, ex);
    }

  }
}
