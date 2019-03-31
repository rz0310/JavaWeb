package com.Servlet;

import com.Dao.Imp.ProDaoImp;
import com.Dao.Imp.UserDaoImp;
import com.Dao.ProDao;
import com.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //        获取request参数
        Integer id = Integer.valueOf(request.getParameter("id"));
        UserDao userDao = new UserDaoImp();
        boolean b = userDao.deleteUser(id);
        if(b){
            request.getRequestDispatcher("UserListServlet").forward(request,response);
        }else{
            JOptionPane.showMessageDialog(null,"删除失败！");
        }
    }
}
