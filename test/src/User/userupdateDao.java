package User;
import DataBase.ConnDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userupdateDao {
    private static Connection conn = null;
    private static PreparedStatement pstmt;
    private static ResultSet rs = null;
    private static int count = -1;

    public static int  userupdate(userupdate up){
        conn = ConnDB.getConnection();

        try{

            String sql = "select count(*) from user where username =?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, up.getUserName());
            rs = pstmt.executeQuery();
            if(rs.next()){
              count = rs.getInt(1);
            }
            System.out.println("dao + " + count);
            if(count > 0){
              //用户名重复
              return -2;
            }
            else{
                sql = "update user set username =?,password =?,isVip=? where userid =?;";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, up.getUserName());
                pstmt.setString(2, up.getPassWD());
                pstmt.setBoolean(3, up.getvip());
                pstmt.setLong(4, up.getUserID());
                pstmt.executeUpdate();
                return 1;
              }
        }catch (SQLException e){
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
          }catch(Exception e){
            e.printStackTrace();
          }
        }
    }
}
