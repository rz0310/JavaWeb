package com.servlet;

import com.bean.Bill;
import com.dao.BillDao;
import com.imp.BillImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShowBills", urlPatterns = "/ShowBills")
public class ShowBills extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BillDao billDao = new BillImp();
        ArrayList<Bill> allBill = billDao.getAllBill();
        request.getSession().setAttribute("Bills", allBill);
        request.getRequestDispatcher("dingdanzhongxin.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
