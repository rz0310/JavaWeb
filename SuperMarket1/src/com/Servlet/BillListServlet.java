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
import java.io.IOException;
import java.util.List;

@WebServlet("/BillListServlet")
public class BillListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //        创建订单操作对象
        BillDao billDao = new BillDaoImp();
//        保存所有订单
        List<Bill> billList = billDao.showAllBill();
//        获取session，保存所有订单的集合
        HttpSession session = request.getSession();
        session.setAttribute("billList",billList);
        request.getRequestDispatcher("billList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
