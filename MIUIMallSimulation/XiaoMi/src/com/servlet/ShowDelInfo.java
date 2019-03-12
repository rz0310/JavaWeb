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

@WebServlet(name = "ShowDelInfo",urlPatterns = "/ShowDelInfo")
public class ShowDelInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String billId = request.getParameter("billId");
        BillDao billDao = new BillImp();
        Bill bill = billDao.getBillById(billId);
        request.getSession().setAttribute("onebill",bill);
        request.getRequestDispatcher("billsDesInfo.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
