package connectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StartApplication {
  public static void main(String[] args) {
    Connection conn = Utils.getConnection();
    String query = "SELECT * FROM igor_master.user";
    PreparedStatement ps = null;
    try{
      String pattern = "dd.MM.yyyy";
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
      ps = conn.prepareStatement(query);
      ResultSet rs = ps.executeQuery(query);
      while (rs.next())
      {
        int ID = rs.getInt("ID");
        String FIRST_NAME = rs.getString("FIRST_NAME");
        String LAST_NAME = rs.getString("LAST_NAME");
        String PATRONYMIC = rs.getString("PATRONYMIC");
        String DESCRIPTION = rs.getString("DESCRIPTION");
        int STATUS = rs.getInt("STATUS");
        String VDAT = simpleDateFormat.format(rs.getDate("VDAT"));

        System.out.format("%d, %s, %s, %s, %s, %d, %s\n", ID, FIRST_NAME, LAST_NAME, PATRONYMIC, DESCRIPTION, STATUS, VDAT);
      }
    } catch(SQLException sex){
      sex.printStackTrace();
    }finally {
      try {
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}