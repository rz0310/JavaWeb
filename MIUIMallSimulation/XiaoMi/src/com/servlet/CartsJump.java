package com.servlet;

import com.bean.Carts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "CartsJump",urlPatterns = "/CartsJump")
public class CartsJump extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        HashMap<Carts, Integer> cartsHashMap = (HashMap<Carts,Integer>) request.getSession().getAttribute("goodsHashMap");
        if (username != null && cartsHashMap!=null) {
            request.getRequestDispatcher("gouwuche.jsp").forward(request,response);
        } else {
            request.getRequestDispatcher("emptycart.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
