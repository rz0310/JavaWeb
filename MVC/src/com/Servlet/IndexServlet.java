package com.Servlet;

import com.Dao.Imp.StuDaoImp;
import com.Dao.Imp.UserDaoImp;
import com.Dao.StuDao;
import com.Dao.UserDao;
import com.JavaBean.Student;
import com.JavaBean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        进行数据库的验证，验证成功，查询所有学生信息保存在作用域session中
//        验证失败，证明没有此用户，跳转至注册页面，或者返回重新登陆
        UserDao userDao = new UserDaoImp();
        UserBean user = userDao.getUser(username);
        if(user!=null){//验证成功
            StuDao stuDao = new StuDaoImp();
            List<Student> students = stuDao.QueryAll();
            if(password.equals(user.getPassWord())){
//            创建session，将学生信息保存在session作用域中
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                session.setAttribute("students",students);
                request.getRequestDispatcher("student.jsp").forward(request,response);
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
