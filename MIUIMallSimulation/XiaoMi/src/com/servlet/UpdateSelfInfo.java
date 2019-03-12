package com.servlet;

import com.bean.User;
import com.dao.UserDao;
import com.imp.UserImp;
import com.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "UpdateSelfInfo",urlPatterns = "/UpdateSelfInfo")
public class UpdateSelfInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String item = request.getParameter("item");
        String content = request.getParameter("value");
        User user = (User) request.getSession().getAttribute("user");
        UserDao userDao = new UserImp();
        boolean b = userDao.updateInfo(item, content, user.getUserName());
        if (b) {
            request.getRequestDispatcher("self_info.jsp").forward(request, response);
        } else {
            JOptionPane.showMessageDialog(null,"修改失败");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
