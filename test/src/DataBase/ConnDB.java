package DataBase;
import java.sql.*;
import static java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE;

public class ConnDB{
  public static Connection conn = null;
  public static Statement stmt = null;
  public static ResultSet rs = null;
  private static String dbURL = "jdbc:mysql://localhost:3306/CSGOCase?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";

  public static Connection getConnection(){
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      conn = DriverManager.getConnection(dbURL, "root" , "92154986");
    }catch(Exception e){
      e.printStackTrace();
    }
    if(conn == null)
      System.out.println("warning > connect database failed");

    return conn;
  }

  public ResultSet execeteQuert(String sql){
    try{
      conn = getConnection();
      stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      rs = stmt.executeQuery(sql);
    }catch(SQLException ex){
      System.err.println(ex.getMessage());
    }
    return rs;
  }

  public int executeUpdate(String sql){
    int result = 0;
    try{
      conn = getConnection();
      stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      result = stmt.executeUpdate(sql);
    }catch(SQLException ex){
      result = 0;
    }
    return result;
  }

  public void close(){
    try{
      if(rs != null){
        rs.close();
      }
      if(stmt != null){
        stmt.close();
      }
      if(conn != null){
        conn.close();
      }
    }catch(Exception e){
      e.printStackTrace(System.err);
    }
  }
}
