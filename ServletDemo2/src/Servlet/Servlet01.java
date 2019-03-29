package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/index")
public class Servlet01 extends HttpServlet {
    private int num;
    public Servlet01() {
        super();
        System.out.println("构造方法");//开启服务器后，服务器不关闭，只执行一次
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化");//开启服务器后，服务器不关闭，只执行一次
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get()");
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        num++;
//        设置编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setIntHeader("Refresh",1);//每隔1s自动刷新
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write("欢迎第"+num+"个用户");
        System.out.println("Post()");
        destroy();//执行完操作后销毁
    }

    @Override
    public void destroy() {
        num--;
        System.out.println("销毁");
    }

}
