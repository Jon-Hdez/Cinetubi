package uam.azc.adsi.cinetubi.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import uam.azc.adsi.cinetubi.model.Product;
import uam.azc.adsi.cinetubi.model.Snack;
import uam.azc.adsi.cinetubi.util.DatabaseConnection;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class SnackDAO {

  private final DatabaseConnection dbConnection;

  public SnackDAO(DatabaseConnection dbConnection) {
    this.dbConnection = dbConnection;
  }

  public HashMap<Integer, Product> getAllSnacks() throws SQLException {
    String sql = "SELECT * FROM snack";

    PreparedStatement ps = dbConnection.getConnection().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    HashMap<Integer, Product> snackList = new HashMap<>() {
    };
    while (rs.next()) {
      int id = rs.getInt("id");
      String nombre = rs.getString("nombre");
      BigDecimal precio = rs.getBigDecimal("precio");
      Snack mySnack = new Snack(id, nombre, precio);
      snackList.put(id, mySnack);
    }
    return snackList;
  }
}
