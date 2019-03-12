package com.servlet;

import com.bean.Carts;
import com.dao.CartDao;
import com.imp.CartImp;
import com.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "DeleteCartGoods",urlPatterns = "/DeleteCartGoods")
public class DeleteCartGoods extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        获取request参数
        String id = request.getParameter("id");
        CartDao cartDao = new CartImp();
        boolean delete = cartDao.delete(Integer.parseInt(id));
        if (delete) {
            ArrayList<Carts> cartsList = cartDao.getAll();
            HttpSession session = request.getSession();
            session.setAttribute("cartsList", cartsList);
            request.getRequestDispatcher("gouwuche.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("delerror.jsp").forward(request, response);
        }
    }
}
