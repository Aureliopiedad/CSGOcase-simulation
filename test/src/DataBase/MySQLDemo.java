package DataBase;
import java.sql.*;

/*
public class MySQLDemo {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;

        conn = ConnDB.getConnection();
    }
}

        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CSGOCase?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT",
                    "root" , "92154986");

            // 创建Statement对象
            stmt = conn.createStatement();

            // 执行SQL语句
            stmt.executeUpdate("insert into product(CSID,PTID,PTNAME,RAGE,WearRAGE,Probability) values(1,2,'HD','3','3',0.5)");



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
*/
