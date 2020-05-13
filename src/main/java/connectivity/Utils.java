package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
  //private static final String DB_DRIVER = "org.h2.Driver";
  private static final String DB_DRIVER = "org.mariadb.jdbc.Driver";
  //private static final String DB_URL = "jdbc:h2:~/test";
  //private static final String DB_URL = "jdbc:h2:~/dao_project";
  private static final String DB_URL = "jdbc:mariadb://nasc52595/igor_master";
  private static final String DB_NAME = "igor_master";
  private static final String DB_PASS = "IgorNasc2020";

  public static Connection getConnection() {
    Connection conn = null;
    try {
      Class.forName(DB_DRIVER);
      conn = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASS);
      System.out.println("Соединение установлено");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      System.out.println("Соединение не установлено");
    }

    return conn;
  }


}
