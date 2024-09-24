package uam.azc.adsi.cinetubi.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.azc.adsi.cinetubi.dao.ComboDAO;
import uam.azc.adsi.cinetubi.dao.SnackDAO;
import uam.azc.adsi.cinetubi.exceptions.ProductNotFoundException;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class ProductCatalog {

  private HashMap<Integer, Product> catalog;
  private SnackDAO sDAO;
  private ComboDAO cDAO;

  public ProductCatalog(SnackDAO sDAO, ComboDAO cDAO) {
    this.sDAO = sDAO;
    this.cDAO = cDAO;
    this.catalog = createCatalog();
  }

  private HashMap<Integer, Product> createCatalog() {
    try {
      HashMap<Integer, Product> snacksCatalog = sDAO.getAllSnacks();
//      List<Product> comboCatalog = cDAO.getAllCombos();
      catalog = sDAO.getAllSnacks();

    } catch (SQLException ex) {
      Logger.getLogger(ProductCatalog.class.getName()).log(Level.SEVERE, null, ex);
    }
    return catalog;
  }

  public Product findProduct(int productId) throws ProductNotFoundException {
    return catalog.get(productId);
  }

  public HashMap<Integer, Product> getCatalog() {
    return catalog;
  }

  public void setCatalog(HashMap<Integer, Product> catalog) {
    this.catalog = catalog;
  }

}
