package PT;
import java.sql.*;
import DataBase.ConnDB;

public class HistoryDao{
  private static  Connection conn = null;
  private static PreparedStatement pstmt;
  private static ResultSet rs = null;
  private static int count = -1;

  public static int addHistory(History his){
    conn = ConnDB.getConnection();

    try{
      String sql = "insert into history(userid,caseid,ptid) values(?,?,?);";
      pstmt = conn.prepareStatement(sql);
      pstmt.setLong(1, his.getUserid());
      pstmt.setInt(2, his.getCaseid());
      pstmt.setInt(3, his.getPtid());
      count = pstmt.executeUpdate();
      if(count > 0)
        return 1;
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
          if(pstmt != null) pstmt.close();
          if(conn != null) conn.close();
      }catch(Exception e){
          e.printStackTrace();
      }
    }
  }

  public static String getHistory(History his){
      String history = "";

      conn = ConnDB.getConnection();

    try{
      String sql = "select * from history where userid =?;";
      pstmt = conn.prepareStatement(sql);
      pstmt.setLong(1, his.getUserid());
      rs = pstmt.executeQuery();
      while(rs.next()){
          history = history + "csid>" + rs.getInt(2) + "ptid>" + rs.getInt(3) + "<br>";
      }
      return history;
    }catch(SQLException e){
      e.printStackTrace();
      return "";
    }catch(Exception e){
      e.printStackTrace();
        return "";
    }finally {
        try{
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
  }
}
