package uam.azc.adsi.cinetubi.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.azc.adsi.cinetubi.util.DatabaseConnection;
import uam.azc.adsi.cinetubi.model.Venta;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class VentaDAO {

  private DatabaseConnection dConn;
  private Venta venta;

  public VentaDAO(DatabaseConnection dConn) {
    this.dConn = dConn;
  }

  public boolean agregarVenta() {
    String query = "INSERT INTO venta (id_empleado, id_socio, metodo_pago, area) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = dConn.getConnection().prepareStatement(query)) {
      stmt.setInt(1, venta.getIdEmpleado());
      stmt.setInt(2, venta.getIdSocio());
      stmt.setString(3, venta.getMetodoPago());
      stmt.setString(4, venta.getArea());
      stmt.setString(5, venta.getTotal().toString());
      
      return stmt.executeUpdate() > 0;
    } catch (SQLException ex) {
      Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
  }
}
