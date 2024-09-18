package uam.azc.adsi.cinetubi.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.azc.adsi.cinetubi.dao.ComboDAO;
import uam.azc.adsi.cinetubi.dao.SnackDAO;
import uam.azc.adsi.cinetubi.exceptions.SnackNotFoundException;
import uam.azc.adsi.cinetubi.util.DatabaseConnection;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class ComboCatalog {

  private List<Combo> catalog;

  public ComboCatalog() {
    this.catalog = new ArrayList<>();
  }

  public ComboCatalog(ArrayList<Combo> catalog) {
    this.catalog = catalog;
  }

  public void fillCatalog(SnackCatalog sc) {
    try {
      ComboDAO cDAO = new ComboDAO(DatabaseConnection.getInstance().getConnection());
      catalog = cDAO.getAllCombos();
      for (Combo c : catalog) {
        List<Snack> snacks = cDAO.getComboSnacksFromCatalog(c.getId(), sc);
        c.setSnacks(snacks);
      }
    } catch (SQLException ex) {
      Logger.getLogger(SnackCatalog.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SnackNotFoundException ex) {
      Logger.getLogger(ComboCatalog.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public List<Combo> getCatalog() {
    return catalog;
  }

  public void setCatalog(List<Combo> catalog) {
    this.catalog = catalog;
  }

}
