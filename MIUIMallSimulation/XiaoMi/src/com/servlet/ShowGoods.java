package com.servlet;

import com.bean.Goods;
import com.dao.GoodsDao;
import com.imp.GoodsImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "showGoods",urlPatterns = "/showGoods")
public class ShowGoods extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type1 = request.getParameter("type1");
        String type2 = request.getParameter("type2");
        GoodsDao goodsDao = new GoodsImp();
        ArrayList<Goods> goods = goodsDao.getLikesGoods(type1);
        ArrayList<Goods> goods2 = goodsDao.getLikesGoods(type2);
        PrintWriter writer = response.getWriter();
        String s = "";
        for (Goods g: goods) {
            s += "<div>" +
                    "<div class='xuangou_left fl'>" +
                        "<a href=''>" +
                            "<div class='img fl'><img src='"+g.getImg()+"' alt=''></div>" +
                                "<span class='fl'>"+g.getName()+"</span>" +
                            "<div class='clear'></div>" +
                        "</a>" +
                    "</div>" +
                    "<div class='xuangou_right fr'><a href='./BuyGoods?name="+g.getName()+"' target='_blank'>选购</a></div>" +
                    "<div class='clear'></div>" +
                 "</div>";
        }
        s += "+--+";
        for (Goods g: goods2) {
            s += "<div>" +
                    "<div class='xuangou_left fl'>" +
                    "<a href=''>" +
                    "<div class='img fl'><img src='"+g.getImg()+"' alt=''></div>" +
                    "<span class='fl'>"+g.getName()+"</span>" +
                    "<div class='clear'></div>" +
                    "</a>" +
                    "</div>" +
                    "<div class='xuangou_right fr'><a href='./BuyGoods?name="+g.getName()+"' target='_blank'>选购</a></div>"+
                    "<div class='clear'></div>" +
                    "</div>";
        }
        writer.print(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
