package com.Servlet;

import com.Dao.BillDao;
import com.Dao.Imp.BillDaoImp;
import com.JavaBean.Bill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;

@WebServlet("/BillAddServlet")
public class BillAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
//      获取request参数
        int billId = Integer.parseInt(request.getParameter("billId"));
        String billName = request.getParameter("billName");
        String billCom = request.getParameter("billCom");
        String billNum = request.getParameter("billNum");
        String money = request.getParameter("money");
        String provider = session.getAttribute("provider").toString();
        String isPay = request.getParameter("zhifu");
        Bill newBill = new Bill();
        System.out.println(newBill.toString());
        newBill.setBill_id(billId);
        newBill.setBill_name(billName);
        newBill.setBill_unit(billCom);
        newBill.setBill_amount(billNum);
        newBill.setBill_money(money);
        newBill.setBill_provider(provider);
        newBill.setBill_isPay(isPay);
        System.out.println(newBill);
//        将新订单插入到数据库
        BillDao billDao = new BillDaoImp();
        boolean b = billDao.addBill(newBill);
        if(b){
            request.getRequestDispatcher("IndexServlet").forward(request,response);//添加成功，转到订单管理页面
        }else{
            JOptionPane.showMessageDialog(null,"添加失败，请重试");//添加失败
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
