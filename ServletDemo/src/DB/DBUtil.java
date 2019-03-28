package DB;

import java.sql.*;

public class DBUtil {
    static {
        try {
            Class.forName(DBVar.DRIVER);//加载驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DBVar.URL,DBVar.USERNAME,DBVar.PASSWORD);//获取连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
//    关闭资源
    public static void close(Connection conn, ResultSet rs, PreparedStatement s){
        try {
            s.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
