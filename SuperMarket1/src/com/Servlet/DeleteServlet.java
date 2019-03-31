package com.Servlet;

import com.Dao.BillDao;
import com.Dao.Imp.BillDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        获取request参数
        Integer billId = Integer.valueOf(request.getParameter("billId"));
        BillDao billDao = new BillDaoImp();
        boolean b = billDao.deleteBill(billId);
        if(b){
            request.getRequestDispatcher("billList.jsp").forward(request,response);
        }else{
            JOptionPane.showMessageDialog(null,"删除失败!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
