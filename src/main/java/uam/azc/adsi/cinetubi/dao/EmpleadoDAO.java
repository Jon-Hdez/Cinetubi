package uam.azc.adsi.cinetubi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.azc.adsi.cinetubi.model.Empleado;
import uam.azc.adsi.cinetubi.model.Pelicula;
import uam.azc.adsi.cinetubi.util.DatabaseConnection;
import java.math.BigDecimal;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class EmpleadoDAO {

  private DatabaseConnection dbConnection;

  public EmpleadoDAO() {
    try {
      dbConnection = DatabaseConnection.getInstance();
    } catch (SQLException ex) {
      Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public Empleado buscarUsuario(String user, String psw) {
    String query = "SELECT empleado.id, nombre, paterno, materno, categoria, sueldo, area "
            + "FROM empleado JOIN categoria_empleado ON empleado.id_categoria = categoria_empleado.id "
            + "WHERE nombre = ? AND psw = ?";
    try {
      PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
      // se asume que el user es unico en la tabla empleado
      stmt.setString(1, user);
      stmt.setString(2, psw);

      ResultSet rs = stmt.executeQuery();
      

      // si la consulta regresa un resultado, regresa a un Empleado
      if (rs.next()) {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String paterno = rs.getString("paterno");
        String materno = rs.getString("materno");
        String categoria = rs.getString("categoria");
        BigDecimal sueldo = new BigDecimal(rs.getString("sueldo"));
        String area = rs.getString("area");
        
        Empleado e = new Empleado(id, nombre, paterno, materno, categoria, sueldo, area);
        System.out.println(e);
        return e;
      }
    } catch (SQLException ex) {
      System.out.println(ex);
    }
    return null;
  }

}
