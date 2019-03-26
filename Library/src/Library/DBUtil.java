package Library;

import java.sql.*;

public class DBUtil {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
//    加载驱动
    static {
        try {
            Class.forName(JDBCVar.DRIVER);//加载驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
}
//    增加
    public static int insert(String sql){
        int i = 0;
        try {
            conn = DriverManager.getConnection(JDBCVar.URL,JDBCVar.USERNAME,JDBCVar.PASSWORD);//获取数据库连接
            ps = conn.prepareStatement(sql);//预编译sql语句
            i = ps.executeUpdate();//执行sql语句
            close(conn, ps, rs);//关闭资源
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
//    删除
    public static int delete(String sql){
        int i = 0;
        try {
            conn = DriverManager.getConnection(JDBCVar.URL,JDBCVar.USERNAME,JDBCVar.PASSWORD);//获取数据库连接
            ps = conn.prepareStatement(sql);//预编译sql语句
            i = ps.executeUpdate();//执行sql语句
            close(conn, ps, rs);//关闭资源
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
//    查找
    public static ResultSet query(String sql){
        try {
            conn = DriverManager.getConnection(JDBCVar.URL,JDBCVar.USERNAME,JDBCVar.PASSWORD);//获取数据库连接
            ps = conn.prepareStatement(sql);//预编译sql语句
            rs = ps.executeQuery();//执行sql语句
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
//    修改
    public static int update(String sql){
        int result = 0;
        try {
            conn = DriverManager.getConnection(JDBCVar.URL,JDBCVar.USERNAME,JDBCVar.PASSWORD);//获取数据库连接
            ps = conn.prepareStatement(sql);//预编译sql语句
            result = ps.executeUpdate();//执行sql语句
            close(conn, ps, rs);//关闭资源
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
//    关闭资源
    public static void close(Connection conn,Statement s,ResultSet rs) throws SQLException {
        if(rs != null){
            rs.close();
        }
        if(s != null){
            s.close();
        }
        if(conn != null){
            conn.close();
        }
    }
}
