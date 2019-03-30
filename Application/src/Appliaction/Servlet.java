package Appliaction;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Application的使用
@WebServlet("/index")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();//获取Application
        application.setAttribute("name","renjing");//设置Application的属性
        String name = (String) application.getAttribute("name");
//        System.out.println("Application111的name属性="+name);
        Cookie cookies = new Cookie("name","111");//创建一个新的Cookie对象
        response.addCookie(cookies);//把Cookie添加到response对象中
        Cookie[] cookie = request.getCookies();//获取请求中的所有cookie
        for (Cookie c: cookie) {
            System.out.println("cookie的name="+c.getName()+",cookie的value="+c.getValue());//输出cookie的名字和值
        }
        System.out.println("---------------");
        request.getRequestDispatcher("success").forward(request,response);//请求转发
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
