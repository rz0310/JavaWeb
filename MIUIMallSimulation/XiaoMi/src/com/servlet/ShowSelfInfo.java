package com.servlet;

import com.bean.User;
import com.dao.UserDao;
import com.imp.UserImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowSelfInfo",urlPatterns = "/ShowSelfInfo")
public class ShowSelfInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        UserDao userDao = new UserImp();
        User user = userDao.getUserByUserName(username);
        request.getSession().setAttribute("user", user);
        request.getRequestDispatcher("self_info.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
