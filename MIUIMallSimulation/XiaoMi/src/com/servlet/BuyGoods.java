package com.servlet;

import com.bean.Goods;
import com.dao.GoodsDao;
import com.imp.GoodsImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BuyGoods",urlPatterns = "/BuyGoods")
public class BuyGoods extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        GoodsDao goodsDao = new GoodsImp();
        ArrayList<Goods> goodsList = goodsDao.getByName(name);
        System.out.println(goodsList);
        HttpSession session = request.getSession();
        session.setAttribute("goodsList",goodsList);
        session.setAttribute("name",name);
        request.getRequestDispatcher("xiangqing.jsp").forward(request,response);
    }
}
