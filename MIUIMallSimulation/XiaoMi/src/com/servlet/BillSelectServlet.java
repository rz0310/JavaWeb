package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Bill;
import com.imp.BillImp;

/**
 * @desc 订单查询Servlet
 * @author liangqi
 *
 */
@WebServlet("/BillSelectServlet")
public class BillSelectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取要查询的订单的关键字
		String keyName = request.getParameter("keyName");
		
		//在数据库中找出订单。
		BillImp billImp = new BillImp();
		List<Bill> billList = billImp.getBill(keyName);
		
		//把要展示的订单存到request中，请求转发到显示页面
		request.getSession().setAttribute("billList",billList );
		request.getRequestDispatcher("billList.jsp").forward(request, response);	
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
