package com.Servlet;

import com.Dao.AdminDao;
import com.Dao.Imp.AdminDaoImp;
import com.Dao.UserDao;
import com.JavaBean.Admin;
import jdk.nashorn.internal.scripts.JO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;

@WebServlet("/PwdServlet")
public class PwdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        获取request参数
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        String oldPassword = request.getParameter("oldPassword");
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(oldPassword);
        String newPassword = request.getParameter("newPassword");
        String reNewPassword = request.getParameter("reNewPassword");
        if(newPassword.equals(reNewPassword)){
            AdminDao adminDao = new AdminDaoImp();
            boolean b = adminDao.modifyPwd(admin,newPassword);
            if(b){
                request.getRequestDispatcher("UserListServlet").forward(request,response);
            }else{
                JOptionPane.showMessageDialog(null,"密码修改失败！");
            }
        }else{
            JOptionPane.showMessageDialog(null,"两次密码不一致！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
