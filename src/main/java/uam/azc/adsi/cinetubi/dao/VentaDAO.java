package uam.azc.adsi.cinetubi.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.azc.adsi.cinetubi.util.DatabaseConnection;
import uam.azc.adsi.cinetubi.model.Venta;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class VentaDAO {

  private DatabaseConnection dbConnection;
  private Venta venta;

  public VentaDAO(Venta venta) {
    this.venta = venta;
    try {
      this.dbConnection = DatabaseConnection.getInstance();
    } catch (SQLException ex) {
      Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public boolean guardarVenta() {
    String query = "INSERT INTO venta (id_empleado, id_socio, metodo_pago, area, total) VALUES (?, ?, ?, ?, ?)";
    System.out.println(venta);
    try (PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query)) {
      stmt.setInt(1, venta.getIdEmpleado());
      Integer idSocio = venta.getIdSocio();
      if (idSocio == null) {
        stmt.setNull(2, Types.INTEGER);
      } else {
        stmt.setInt(2, venta.getIdSocio());
      }

      stmt.setString(3, venta.getMetodoPago());
      stmt.setString(4, venta.getArea());
      stmt.setString(5, venta.getTotal().toString());

      return stmt.executeUpdate() > 0;
    } catch (SQLException ex) {
      Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
  }

  public DatabaseConnection getdConn() {
    return dbConnection;
  }

  public void setdConn(DatabaseConnection dConn) {
    this.dbConnection = dConn;
  }

  public Venta getVenta() {
    return venta;
  }

  public void setVenta(Venta venta) {
    this.venta = venta;
  }

}
