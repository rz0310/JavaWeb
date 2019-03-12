package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsDao;
import com.imp.GoodsImp;

/**
 * @desc 商品删除
 * @author liangqi
 *
 */
@WebServlet("/ProviderDeleteServlet")
public class ProviderDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取你要删除的订单记录的goods_id
		int goods_id = Integer.valueOf(request.getParameter("goods_id"));
		//进行删除操作
		GoodsDao goodsdao = new GoodsImp();
		Boolean bool_delete = goodsdao.delete(goods_id);
		
		if(bool_delete) {
			request.getRequestDispatcher("ProviderListServlet?diPage=1").forward(request, response);
		}else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
