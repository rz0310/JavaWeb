package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Bill;
import com.imp.BillImp;

/**
 * @desc 订单添加Servlet
 * @author liangqi
 *
 */
@WebServlet("/BillAddServlet")
public class BillAddServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bill bill = new Bill();
		//获取表单数据，进行封装
		bill.setId(request.getParameter("billId"));
		bill.setGoodsName(request.getParameter("billName"));
		bill.setGoodsPrice(Double.valueOf(request.getParameter("billPrice")));
		bill.setGoodsNum(Integer.valueOf(request.getParameter("billNum")));
		bill.setMoney(Double.valueOf(request.getParameter("billMoney")));
		bill.setDate((request.getParameter("billDate")));
		bill.setStatus(request.getParameter("billStatus"));
		
		//进行添加操作
		BillImp billImp = new BillImp();
		boolean bool_add = billImp.addBill(bill);
		
		if(bool_add) {
			request.getRequestDispatcher("BillListServlet?diPage=1").forward(request, response);
		}else {
			request.setAttribute("msg", "订单添加失败");
			request.getRequestDispatcher("billAdd.jsp").forward(request, response);
		}
	}

}
