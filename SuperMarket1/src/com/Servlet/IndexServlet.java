package com.Servlet;

import com.DB.DBUtil;
import com.Dao.AdminDao;
import com.Dao.BillDao;
import com.Dao.Imp.AdminDaoImp;
import com.Dao.Imp.BillDaoImp;
import com.Dao.Imp.UserDaoImp;
import com.Dao.UserDao;
import com.JavaBean.Bill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        获取request参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AdminDao adminDao = new AdminDaoImp();
        boolean b = adminDao.queryAdmin(username,password);
        if(b){
//        创建订单操作对象
            BillDao billDao = new BillDaoImp();
//        获取session，保存用户名和密码
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            request.getRequestDispatcher("welcome.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
