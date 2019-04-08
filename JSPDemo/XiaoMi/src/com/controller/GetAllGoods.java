package com.controller;

import com.bean.Carts;
import com.dao.CartDao;
import com.imp.CartImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "GetAllGoods",urlPatterns = "/GetAllGoods")
public class GetAllGoods extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        CartDao cartDao = new CartImp();
        HashMap<Carts, Integer> goodsHashMap = cartDao.getAll();
        HttpSession session = request.getSession();
        session.setAttribute("goodsHashMap",goodsHashMap);
        request.getRequestDispatcher("gouwuche.jsp");
    }
}
