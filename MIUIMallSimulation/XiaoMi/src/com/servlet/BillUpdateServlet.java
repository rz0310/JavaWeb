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
 * @desc 修改订单的Servlet
 * @author liangqi
 *
 */
@WebServlet("/BillUpdateServlet")
public class BillUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bill bill = new Bill();
		//获取表单数据，进行封装
		bill.setId(request.getParameter("billId"));
		bill.setGoodsName(request.getParameter("billName"));
		bill.setGoodsPrice(Double.valueOf(request.getParameter("billPrice")));
		bill.setGoodsNum(Integer.valueOf(request.getParameter("billNum")));
		bill.setMoney(Double.valueOf(request.getParameter("billMoney")));
		bill.setDate((request.getParameter("billDate")));
		bill.setStatus(request.getParameter("billStatus"));
		
		//进行更新操作
		BillImp billImp = new BillImp();
		boolean bool_update = billImp.updateBill(bill);
		
		if(bool_update) {
			request.getRequestDispatcher("BillListServlet?diPage=1").forward(request, response);
		}else {
			request.setAttribute("msg", "修改失败");
			request.getRequestDispatcher("billUpdate.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
