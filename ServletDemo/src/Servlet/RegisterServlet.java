package Servlet;

import Bean.User;
import Imp.UserDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");//设置请求编码
        resp.setCharacterEncoding("utf-8");//设置响应编码
        resp.setContentType("text/html;charset=utf-8");//设置文本编码
//        获取注册页面用户输入的所有数据
        String username = req.getParameter("username");
        String nickname = req.getParameter("nickname");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        User user = new User();
        PrintWriter out = resp.getWriter();
        username = username.trim();
        password = password.trim();
        if(password.equals(password2)){//判断两次密码是否一致
            UserDaoImp udi = new UserDaoImp();
            boolean isExists = udi.findUser(username);
            if(!isExists){
                user.setUserName(username);
                user.setPassWord(password);
                user.setNickName(nickname);
                boolean isok = udi.addUser(user);
                System.out.println(isok);
                if(isok){
                    out.print("<script language='javascript'>alert('注册成功')</script>");
                    resp.sendRedirect("index.html");
//                    req.getRequestDispatcher("index.html").forward(req,resp);
                }else{
                    out.print("<script language='javascript'>alert('注册失败')</script>");
                    resp.sendRedirect("register.html");
//                    req.getRequestDispatcher("register.html").forward(req,resp);
                }
            }else{
                out.print("<script language='javascript'>alert('您输入的用户名已存在')</script>");
            }
        }else{
            out.print("<script>alert('两次密码不一致！')</script>");
        }
    }
}
