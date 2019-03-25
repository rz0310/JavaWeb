package JDBC;

import java.sql.*;
import java.util.Scanner;

public class ZhanWeiFu {
    static {
        try {
//            加载驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入ID：");
        int id = sc.nextInt();
        System.out.println("请输入姓名：");
        String name = sc.next();
        Student s =  getById(id,name);
        System.out.println(s);
    }

    public static Student getById(int id,String name) {
        Student s = null;
        try {
//            获取连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/up1", "root", "root");
//            声明sql语句
            String sql = "select * from stu where name = ?;";
//            预编译sql语句
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, id);//参数1：第几个问号 参数2：要修改的真正的值
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();//获取结果集
            while (rs.next()) {
                s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setClazz("class");
                s.setMajor("major");
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
