package Logup;

import DataBase.ConnDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogupDao {
    private static Connection conn = null;
    private static PreparedStatement pstmt;
    private static int i = -1;

    public static long logup(Logup logup){
        conn = ConnDB.getConnection();

        try {
            String sql = "select count(*) from user where username = ?;" ;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,logup.getUname());
            ResultSet rs = pstmt.executeQuery();
            int count = -1;

            if(rs.next()){
                count = rs.getInt(1);
            }

            try{
                if(rs != null) rs.close();
            }catch(Exception e){
                e.printStackTrace();
            }

            if(count > 0){//提醒用户
                return -1;
                }//用户名重复
            else{
                sql = "insert into user(userid,username,password,isVip) values(?,?,?,false);";
                pstmt = conn.prepareStatement(sql);
                pstmt.setLong(1,logup.getid());
                pstmt.setString(2,logup.getUname());
                pstmt.setString(3,logup.getUpwd());
                i = pstmt.executeUpdate();
                if(i > 0)
                    return logup.getid();
                else
                    return -1;
            }

        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }finally {
            try{
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
