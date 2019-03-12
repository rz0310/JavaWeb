package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.imp.BillImp;

/**
 * @desc 订单删除
 * @author liangqi
 *
 */
@WebServlet("/BillDeleteServlet")
public class BillDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取你要删除的订单记录的bill_Id
		String bill_id = request.getParameter("bill_id");
		//进行删除操作
		BillImp billImp = new BillImp();
		Boolean bool_delete = billImp.deleteBill(bill_id);
		
		if(bool_delete) {
			request.getRequestDispatcher("BillListServlet?diPage=1").forward(request, response);
		}else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
