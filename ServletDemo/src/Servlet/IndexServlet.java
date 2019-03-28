package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndexServlet",urlPatterns = "/html/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        response.setIntHeader("Refresh",1);//设置自动在1s钟刷新页面
//        获取页面填写的内容
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        将页面输入的值保存在request作用域中
        request.setAttribute("username",username);//设置request的作用域的属性
        request.setAttribute("password",password);

//        获取request的作用域的属性
        System.out.println(request.getAttribute("username"));//request.getAttribute("username")：得到的object类型，需要强转为String
        System.out.println(request.getAttribute("password"));
        System.out.println("----------------------------");
        System.out.println(request.getRequestURL());//获取请求路径
//        使用request作用域进行页面之间值的传递,使用请求转发的方式
        request.getRequestDispatcher("../SecondServlet").forward(request,response);
//        使用(响应)重定向不能进行页面之间的值的传递
//        response.sendRedirect("SecondServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
