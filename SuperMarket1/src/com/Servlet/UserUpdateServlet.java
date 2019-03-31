package com.Servlet;

import com.Dao.Imp.UserDaoImp;
import com.Dao.UserDao;
import com.JavaBean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String userSex = request.getParameter("sex");
        String userBirth = request.getParameter("birth");
        String userTel = request.getParameter("userphone");
        String userAdd = request.getParameter("userAddress");
        String userType = request.getParameter("userlei");
        User user = new User();
        user.setUser_id(userId);
        user.setUser_name(userName);
        user.setUser_sex(userSex);
        user.setUser_birth(userBirth);
        user.setUser_tel(userTel);
        user.setUser_add(userAdd);
        user.setUser_type(userType);
        UserDao userDao = new UserDaoImp();
        boolean b = userDao.updateUser(user);
        if(b){
            request.getRequestDispatcher("UserListServlet").forward(request,response);
        }else{
            JOptionPane.showMessageDialog(null,"修改失败！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
