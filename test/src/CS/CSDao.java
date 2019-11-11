package CS;

import DataBase.ConnDB;
import PT.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CSDao {
    private static Connection conn = null;
    private static PreparedStatement pstmt;
    private static ResultSet rs = null;
    private static long count = -1;
    private static List<Product> productList = new ArrayList<>();

    public static List<Product> CSDao(Docase docase){
        conn = ConnDB.getConnection();
        try{
            String sql = "select * from product where csid =?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,docase.getCsid());
            rs = pstmt.executeQuery();
            while(rs.next()){
                productList.add(new Product(rs.getInt(2),rs.getString(3),rs.getInt(4),
                        rs.getInt(5),rs.getDouble(6)));
            }
            return productList;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try{
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }


    }
}
