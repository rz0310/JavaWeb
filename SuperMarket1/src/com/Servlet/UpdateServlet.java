package com.Servlet;

import com.Dao.BillDao;
import com.Dao.Imp.BillDaoImp;
import com.JavaBean.Bill;
import jdk.nashorn.internal.scripts.JO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        获取request参数
        int billId = Integer.valueOf(request.getParameter("billId"));
        String billName = request.getParameter("billName");
        String billUnit = request.getParameter("billUnit");
        String billAmount = request.getParameter("billAmount");
        String billMoney = request.getParameter("billMoney");
        String billPro = request.getParameter("billPro");
        String isPay = request.getParameter("isPay");
        Bill bill = new Bill();
        bill.setBill_id(billId);
        bill.setBill_name(billName);
        bill.setBill_unit(billUnit);
        bill.setBill_amount(billAmount);
        bill.setBill_money(billMoney);
        bill.setBill_provider(billPro);
        bill.setBill_isPay(isPay);
        BillDao billDao = new BillDaoImp();
        boolean b = billDao.updateBill(bill);
        if(b){
            request.getRequestDispatcher("billList.jsp").forward(request,response);
        }else{
            JOptionPane.showMessageDialog(null,"更新失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
