package uam.azc.adsi.cinetubi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class DatabaseConnection {

  private static DatabaseConnection instance;
  private Connection connection;

  private static final String URL = "jdbc:mysql://localhost:3306/cinetubi";
  private static final String USER = "root";
  private static final String PASSWORD = "root";

  private DatabaseConnection() throws SQLException {
    try {
      this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (SQLException e) {
      throw new SQLException("Failed to create the database connection", e);
    }
  }

  public static DatabaseConnection getInstance() throws SQLException {
    if (instance == null) {
      instance = new DatabaseConnection();
    }
    return instance;
  }

  public Connection getConnection() {
    return connection;
  }

}
