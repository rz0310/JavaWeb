package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="SecondServlet",urlPatterns = "/SecondServlet")
public class SecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置字符编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        获取request作用域中的值
        String username = (String)request.getAttribute("username");
        String password = (String)request.getAttribute("password");
        PrintWriter out = response.getWriter();//获取标准写出流
        out.write(username+" "+ password);//输出
        System.out.println(username+ " " + password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
