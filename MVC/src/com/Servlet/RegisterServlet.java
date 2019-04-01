package com.Servlet;

import com.Dao.Imp.StuDaoImp;
import com.Dao.Imp.UserDaoImp;
import com.Dao.StuDao;
import com.Dao.UserDao;
import com.JavaBean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        获取request作用域中的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        username = username.trim();
        password = password.trim();
        password2 = password2.trim();
        if((password!=null||!password.equals(""))&&password.equals(password2)){
            UserBean userBean = new UserBean();
            userBean.setUserName(username);
            userBean.setPassWord(password);
            UserDao userDao = new UserDaoImp();
            boolean register = userDao.register(userBean);
            if(register){
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }
        }else{
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
