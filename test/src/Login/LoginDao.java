package Login;
import java.sql.*;
import DataBase.ConnDB;

public class LoginDao{
  private static  Connection conn = null;
  private static PreparedStatement pstmt;
  private static ResultSet rs = null;
  private static long count = -1;

  public static long login(Login login){

    conn = ConnDB.getConnection();

    try{
      String sql = "select userid from user where username = ? and password = ?;";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1,login.getUname());
      pstmt.setString(2,login.getUpwd());
      rs = pstmt.executeQuery();

      if(rs.next()){
        count = rs.getLong(1);
      }
      if(count > 0)//登录成功
        return count;
      else if(count == 0)//用户名密码不存在
        return 0;
      else
        return -1;

    }catch(SQLException e){
      e.printStackTrace();
      return -1;
    }catch(Exception e){
      e.printStackTrace();
      return -1;
    }finally{
      try{
        if(rs != null) rs.close();
        if(pstmt != null) pstmt.close();
        if(conn != null) conn.close();
      }catch(SQLException e){
        e.printStackTrace();
      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }
}
