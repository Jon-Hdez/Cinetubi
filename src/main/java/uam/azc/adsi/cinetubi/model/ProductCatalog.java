package uam.azc.adsi.cinetubi.model;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.azc.adsi.cinetubi.dao.SnackDAO;
import uam.azc.adsi.cinetubi.exceptions.SnackNotFoundException;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class ProductCatalog {

  private List<Product> catalog;
  private SnackDAO sDAO; 

  public ProductCatalog(SnackDAO sDAO) {
    this.sDAO = sDAO;
    this.catalog = createCatalog();
  }

  private List<Product> createCatalog() {
    try {
      catalog = sDAO.getAllSnacks();
    } catch (SQLException ex) {
      Logger.getLogger(ProductCatalog.class.getName()).log(Level.SEVERE, null, ex);
    }
    return catalog;
  }
  
  public Product findProduct(int productId) throws SnackNotFoundException{
    for(Product s: catalog){
      if(s.getId() == productId){
        return s;
      }
    }
    throw new SnackNotFoundException("Snack con id: " + productId + " no encontrado");
  }

  public List<Product> getCatalog() {
    return catalog;
  }

  public void setCatalog(List<Product> catalog) {
    this.catalog = catalog;
  }

}
