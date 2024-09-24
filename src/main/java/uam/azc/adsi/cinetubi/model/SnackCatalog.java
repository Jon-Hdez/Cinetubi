package uam.azc.adsi.cinetubi.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.azc.adsi.cinetubi.dao.SnackDAO;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class SnackCatalog {

  private final SnackDAO sDAO;
  private HashMap<Integer, Snack> catalog;

  public SnackCatalog() {
    this.sDAO = new SnackDAO();
    this.catalog = createSnackCatalog();
  }

  private HashMap<Integer, Snack> createSnackCatalog() {
    HashMap<Integer, Snack> snacks = new HashMap<>();
    snacks = sDAO.obtenerTodosSnacks();
    return snacks;
  }

  public Snack findSnack(int snackId) {
    return catalog.get(snackId);
  }

  public HashMap<Integer, Snack> getCatalog() {
    return catalog;
  }

  public void setCatalog(HashMap<Integer, Snack> catalog) {
    this.catalog = catalog;
  }

}
