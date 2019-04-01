package com.DB;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private String userName;
    private String passWord;
    private String url;
//    加载驱动
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//    获取连接
    public static Connection getConn() throws IOException {
        try {
            InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");//反射获取
            Properties p = new Properties();
            p.load(is);
            return DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
