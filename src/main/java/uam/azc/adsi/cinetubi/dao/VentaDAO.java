package uam.azc.adsi.cinetubi.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public VentaDAO() {
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
  
  public int agregarVenta(int empleado, int socio, String metodo, String area, double total) {
        String query = "INSERT INTO venta (id_empleado, id_socio, metodo_pago, area, total) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, empleado);
            stmt.setInt(2, Integer.parseInt("null"));
            stmt.setString(3, metodo);
            stmt.setString(4, area);
            stmt.setDouble(5, total);

            // Ejecutar la inserción
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("La inserción de la venta falló, no se añadió ninguna fila.");
            }

            // Obtener el ID generado
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int nuevaVentaId = generatedKeys.getInt(1);
                    System.out.println("Se ha creado con éxito la venta: " + nuevaVentaId + " " + empleado + " " + socio + " " + metodo + " " + area);
                    return nuevaVentaId-1;
                } else {
                    throw new SQLException("La inserción de la venta falló, no se pudo obtener el ID generado.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, "Error al agregar venta", ex);
        }
        return -1;
    }
    
    public int nuevo(){
        int max = 0;
        String query = "SELECT MAX(id_pelicula) FROM venta";
        try (Statement stmt = dbConnection.getConnection().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            max=rs.getInt(1);
        } catch (SQLException ex) {
            System.err.println("Error en encontrar MAX ID VENTA");;
        }
        return max;
    }

}
