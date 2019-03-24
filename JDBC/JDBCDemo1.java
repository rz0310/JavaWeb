package JDBC;

import java.sql.*;
import java.util.ArrayList;

public class JDBCDemo1 {
    String url = "jdbc:mysql://localhost:3306/up1";
    String user = "root";
    String password = "";
    ArrayList<Student> alist = new ArrayList<Student>();
    public void QueryAll() throws ClassNotFoundException, SQLException {
//        加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
//        获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/up1","root","root");
        Statement s = conn.createStatement();
        String sql = "select * from stu";
        ResultSet rs = s.executeQuery(sql);
        while(rs.next()){
            Student stu = new Student();
            stu.setId(rs.getInt("id"));
            stu.setName(rs.getString("name"));
            stu.setAge(rs.getInt("age"));
            stu.setClazz(rs.getString("class"));
            stu.setMajor(rs.getString("major"));
            alist.add(stu);
        }
        System.out.println(alist);
//        关闭资源
        rs.close();
        s.close();
        conn.close();
    }
//    删除
    public void delete() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/up1?characterEncoding = utf-8","root","root");
        Statement s = conn.createStatement();
        String sql = "delete from stu where id = 7";
       int affectedRow =  s.executeUpdate(sql);
        if(affectedRow != 0){
            System.out.println("删除成功！");
        }
        if(s != null){
            s.close();
        }
        if(conn != null){
            conn.close();
        }
    }
//    插入
    public void insert() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/up1?characterEncoding=utf-8", "root", "root");
        Statement s = conn.createStatement();
        String sql = "insert into stu(name,age,class,major,image) values('小任5',23,'4班','树莓','')";
       int i = s.executeUpdate(sql);
        if(i != 0){
            System.out.println("插入成功！");
        }
        if(s != null){
            s.close();
        }
        if(conn != null){
            conn.close();
        }
    }
    public void update() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/up1?characterEncoding=utf-8");
        String sql = "update stu(name) where id = 11";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = ps.executeUpdate();
        if(i != 0){
            System.out.println("更新成功！");
        }
        if(ps != null){
            ps.close();
        }
        if(conn != null){
            conn.close();
        }
    }
}
