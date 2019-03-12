package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.Goods;
import com.dao.GoodsDao;
import com.imp.GoodsImp;

/**
 * @desc 展示所有的商品
 * @author liangqi
 *
 */
@WebServlet("/ProviderListServlet")
public class ProviderListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定义 int变量 记录 要显示的页面
		int page = 0;

		// 获取请求的 页面 参数
		String diPage = request.getParameter("diPage");
		if (!"".equals(diPage) && diPage != null) {
			page = Integer.parseInt(diPage);
		}
		// 获取页面对应的数据 和 总共的页面个数
		GoodsDao goodsdao = new GoodsImp();
		List<Goods> goodsList = goodsdao.getBillByPage(page);
		int pageCounts = goodsdao.getCountPages();

		// 封装数据到request作用域中
		request.setAttribute("goodsList", goodsList);
		request.setAttribute("pageCounts", pageCounts);
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("providerList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
