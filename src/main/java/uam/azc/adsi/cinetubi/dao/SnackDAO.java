package uam.azc.adsi.cinetubi.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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

  public SnackDAO() {
    try {
      this.dbConnection = DatabaseConnection.getInstance();
    } catch (SQLException ex) {
      Logger.getLogger(SnackDAO.class.getName()).log(Level.SEVERE, null, ex);
      throw new Error("No fue posible conectarse con la base de datos");
    }
  }

  public HashMap<Integer, Snack> obtenerTodosSnacks() {
    try {
      String sql = "SELECT * FROM snack";

      PreparedStatement ps = dbConnection.getConnection().prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      HashMap<Integer, Snack> snacks = new HashMap<>() {
      };
      while (rs.next()) {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        BigDecimal precio = rs.getBigDecimal("precio");
        String tamanio = rs.getString("tamanio");
        Snack mySnack = new Snack(id, nombre, precio, tamanio);
        snacks.put(id, mySnack);
      }
      return snacks;
    } catch (SQLException ex) {
      Logger.getLogger(SnackDAO.class.getName()).log(Level.SEVERE, null, ex);
      throw new Error("No fue posible acceder a la tabla snack de la base de datos");
    }
  }
}
