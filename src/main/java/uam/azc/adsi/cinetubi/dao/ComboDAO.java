package uam.azc.adsi.cinetubi.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uam.azc.adsi.cinetubi.exceptions.ProductNotFoundException;
import uam.azc.adsi.cinetubi.model.Combo;
import uam.azc.adsi.cinetubi.model.Snack;
import uam.azc.adsi.cinetubi.model.ProductCatalog;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class ComboDAO {

  private Connection connection;

  public ComboDAO(Connection connection) {
    this.connection = connection;
  }

//  public List<Combo> getAllCombos() throws SQLException {
//    String sql = "SELECT * FROM combo";
//    PreparedStatement ps = connection.prepareStatement(sql);
//    ResultSet rs = ps.executeQuery();
//    List<Combo> combos = new ArrayList<>();
//    while (rs.next()) {
//      int id = rs.getInt("id");
//      String nombre = rs.getString("nombre");
//      BigDecimal precio = rs.getBigDecimal("precio");
//      Combo myCombo = new Combo(id, nombre, precio);
//      combos.add(myCombo);
//    }
//    return combos;
//  }
//
//  public List<Snack> getComboSnacksFromCatalog(int comboId, ProductCatalog sc) throws SQLException, SnackNotFoundException {
//    List<Snack> comboSnacks = new ArrayList<>();
//    String sql = "SELECT s.id FROM snack s "
//            + "INNER JOIN combo_snack cs ON s.id = cs.id_snack "
//            + "WHERE cs.id_combo = ?";
//
//    PreparedStatement ps = connection.prepareStatement(sql);
//    ps.setInt(1, comboId);
//    ResultSet rs = ps.executeQuery();
//    while (rs.next()) {
//      int snackId = rs.getInt("id");
//      Snack snack = sc.findSnack(snackId);
//      comboSnacks.add(snack);
//    }
//    return comboSnacks;
//  }
}
