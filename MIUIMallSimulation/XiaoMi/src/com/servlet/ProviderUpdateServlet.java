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
 * @desc 修改商品信息
 * @author liangqi
 *
 */
@WebServlet("/ProviderUpdateServlet")
public class ProviderUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Goods goods = new Goods();
		//获取表单数据，进行封装
		goods.setId(Integer.valueOf(request.getParameter("goodsId")));
        goods.setName(request.getParameter("goodsName"));
        goods.setImg(request.getParameter("goodsImg"));
        goods.setPrice(Double.valueOf(request.getParameter("goodsPrice")));
        goods.setNum(Integer.valueOf(request.getParameter("goodsNum")));
        goods.setDesc(request.getParameter("goodsDesc"));
        goods.setVersion(request.getParameter("goodsVersion"));
        goods.setColor(request.getParameter("goodsColor"));
        goods.setType(Integer.valueOf(request.getParameter("goodsType")));
        goods.setPaid(Integer.valueOf(request.getParameter("goodsPaid")));
        
		
		//进行更新操作
		GoodsDao goodsdao = new GoodsImp();
		boolean bool_update = goodsdao.update(goods);
		
		if(bool_update == true) {
			request.getRequestDispatcher("ProviderListServlet?diPage=1").forward(request, response);
		}else {
			request.setAttribute("msg", "修改失败");
			request.getRequestDispatcher("providerUpdate.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
