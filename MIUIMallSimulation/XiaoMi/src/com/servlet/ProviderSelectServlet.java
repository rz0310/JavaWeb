package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Bill;
import com.bean.Goods;
import com.dao.GoodsDao;
import com.imp.GoodsImp;

/**
 * @desc 关键字查询商品记录
 * @author liangqi
 *
 */
@WebServlet("/ProviderSelectServlet")
public class ProviderSelectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取要查询的商品的类型名称
		String typeName = request.getParameter("typeName");
		//在数据库中找出商品。
		GoodsDao goodsdao = new GoodsImp();
		List<Goods> goodsList = goodsdao.getLikesGoods(typeName);
		
		//存值，转发
		request.getSession().setAttribute("goodsList",goodsList );
		request.getRequestDispatcher("providerList.jsp").forward(request, response);	
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
