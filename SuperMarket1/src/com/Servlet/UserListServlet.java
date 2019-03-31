package com.Servlet;

import com.Dao.Imp.UserDaoImp;
import com.Dao.UserDao;
import com.JavaBean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        获取保存所有用户的集合
        UserDao userDao = new UserDaoImp();
        List<User> userList = userDao.showAllUser();
//        获取session，保存集合
        HttpSession session = request.getSession();
        session.setAttribute("userList",userList);
        request.getRequestDispatcher("userList.jsp").forward(request,response);//转到显示用户页面
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
