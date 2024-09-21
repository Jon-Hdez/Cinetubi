package uam.azc.adsi.cinetubi.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uam.azc.adsi.cinetubi.model.Product;
import uam.azc.adsi.cinetubi.model.Snack;


/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */

public class SnackDAO {
  private Connection connection;

  public SnackDAO(Connection connection) {
    this.connection = connection;
  }
  
  public List<Product> getAllSnacks()throws SQLException {
    String sql = "SELECT * FROM snack";
    PreparedStatement ps = connection.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    List<Product> snackList = new ArrayList<>();
    while(rs.next()){
      int id = rs.getInt("id");
      String nombre = rs.getString("nombre");
      BigDecimal precio = rs.getBigDecimal("precio");
      Snack mySnack = new Snack(id, nombre, precio);
      snackList.add(mySnack);
    }
    return snackList;
  }
}
