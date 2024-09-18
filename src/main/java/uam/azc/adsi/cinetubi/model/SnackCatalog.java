package uam.azc.adsi.cinetubi.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.azc.adsi.cinetubi.dao.SnackDAO;
import uam.azc.adsi.cinetubi.exceptions.SnackNotFoundException;
import uam.azc.adsi.cinetubi.util.DatabaseConnection;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class SnackCatalog {

  private List<Snack> catalog;

  public SnackCatalog() {
    this.catalog = new ArrayList<>();
  }

  public SnackCatalog(ArrayList<Snack> catalog) {
    this.catalog = catalog;
  }

  public void fillCatalog() {
    try {
      SnackDAO sDAO = new SnackDAO(DatabaseConnection.getInstance().getConnection());
      catalog = sDAO.getAllSnacks();
    } catch (SQLException ex) {
      Logger.getLogger(SnackCatalog.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public Snack findSnack(int idSnack) throws SnackNotFoundException{
    for(Snack s: catalog){
      if(s.getId() == idSnack){
        return s;
      }
    }
    throw new SnackNotFoundException("Snack con id: " + idSnack + " no encontrado");
  }

  public List<Snack> getCatalog() {
    return catalog;
  }

  public void setCatalog(List<Snack> catalog) {
    this.catalog = catalog;
  }

}
