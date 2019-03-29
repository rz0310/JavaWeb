package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//Session的使用
@WebServlet("/index")
public class Servlet extends HttpServlet {
    public Servlet() {
        System.out.println("构造");
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("第一个");
        System.out.println("Post");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        HttpSession session = request.getSession();//创建Session
        System.out.println("Session的创建时间："+session.getCreationTime());
        System.out.println("Session是否为新创建："+session.isNew());//打开的浏览器的所有页面必须关闭然后重新开启，则session为重新创建
//        session.setMaxInactiveInterval(3);//设置session在3s后销毁
        session.setAttribute("name",name);
        String attribute = (String) session.getAttribute("name");
        System.out.println("Session中的name="+attribute);
        request.getRequestDispatcher("success").forward(request,response);//请求转发
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("Get");
        doPost(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
