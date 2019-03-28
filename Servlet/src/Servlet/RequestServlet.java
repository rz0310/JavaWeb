package Servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//使用注解配置Servlet
//@WebServlet("/index")
public class RequestServlet extends HttpServlet {
    public RequestServlet() {
        System.out.println("构造方法");
    }

//    初始化Servlet()：init()
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("初始化");
        try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get()方法");
        String relName = null;
        String relPwd = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载驱动
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/up1?characterEncoding=utf-8", "root", "root");//获取连接
            String sql = "select username,password from user where id = 1";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ResultSet rs = ps.executeQuery();//执行sql语句
            while(rs.next()){
                relName = rs.getString("username");//获取结果集的中的username属性
                relPwd = rs.getString("password");//获取结果集的中的password属性
            }
            System.out.println(relName+ " "+ relPwd);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
//        doPost(req,resp);
//        PrintWriter writer = resp.getWriter();//获取标准打印对象
//        writer.write("Hello");
        System.out.println(req.getRequestURL());//获取
        String name = req.getParameter("name");
        String password = req.getParameter("pwd");
        System.out.println("请求的用户名是："+name);
        System.out.println("请求的密码是："+password);
        if(relName.equals(name)&&relPwd.equals(password)){
            req.getRequestDispatcher("success.html").forward(req,resp);
        }else {
            System.out.println("用户名或密码不正确");
            req.getRequestDispatcher("index.html").forward(req, resp);
        }
    }

//   只用来接收客户端请求
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("销毁");//默认30分钟销毁，如果再次发送请求，会激活Servlet
    }

}
