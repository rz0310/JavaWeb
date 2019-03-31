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
import java.util.Calendar;

@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        获取request参数
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userpassword");
        String userPwd2 = request.getParameter("userRemi");
        String userSex = request.getParameter("sex");
        String userBirth = request.getParameter("userBirth");
        String userTel = request.getParameter("userphone");
        String userAdd = request.getParameter("userAddress");
        String userType = request.getParameter("userlei");
        User user = new User();
        user.setUser_id(userId);
        user.setUser_name(userName);
        user.setUser_pwd(userPwd);
        user.setUser_pwd2(userPwd2);
        user.setUser_sex(userSex);
        user.setUser_birth(userBirth);
        user.setUser_tel(userTel);
        user.setUser_add(userAdd);
        user.setUser_type(userType);
//        分割字符串获取年龄
        String[] year = userBirth.split("\\.");
        int userAge = 2018-Integer.valueOf(year[0]);//数组中的第一个值即为年
        user.setUser_age(String.valueOf(userAge));
        Calendar c = Calendar.getInstance();//获取时间
        user.setUser_time(c.getTime().toString());
        UserDao userDao = new UserDaoImp();
        boolean b = userDao.addUser(user);
        if(b){
            request.getRequestDispatcher("UserListServlet").forward(request,response);
        }else{
            JOptionPane.showMessageDialog(null,"添加失败！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
