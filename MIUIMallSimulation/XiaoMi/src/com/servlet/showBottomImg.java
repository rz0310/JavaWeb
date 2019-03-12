package com.servlet;

import com.dao.GoodsDao;
import com.imp.GoodsImp;
import com.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "showBottomImg", urlPatterns = "/showBottomImg")
public class showBottomImg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBUtil db = DBUtil.getDBUtil();
        ResultSet rs = db.executeQuery("select * from parts");
        PrintWriter writer = response.getWriter();
        ArrayList<Integer> random = new ArrayList<>();
        try {
            // 获取记录的总行数
            rs.last();
            int row = rs.getRow();
            // 取出一个0到row的不重复的随机数作为记录的索引
            for (int i = 1; i <= row; i++) {
                random.add(i);
            }
            GoodsDao goodsDao = new GoodsImp();
            String innerHtml = "";
            while (random.size() != 0) {
                int temp = (int) (Math.random() * (random.size()));
                if (rs.absolute(random.get(temp))) {
                    String name1 = rs.getString("name");
                    String evaluate = goodsDao.getEvaluateByName(name1);
                    if (evaluate != null) {
                        String[] names = evaluate.split(":");
                        innerHtml += "<div class='remen fl'>";
                        if (rs.getString("tag") != null) {
                            innerHtml += "<div class='xinpin'><span>" + rs.getString("tag") + "</span></div>";
                        }
                        innerHtml += "<div class='tu'><a href='BuyGoods?name="+name1+"'><img src='" + rs.getString("img") + "'></a></div>" +
                                "<div class='miaoshu'><a href='BuyGoods?name="+name1+"'>" + name1 + "</a></div>" +
                                "<div class='jiage'>" + goodsDao.getPriceByName(name1) + "</div>" +
                                "<div class='pingjia'>" + rs.getInt("evluateNum") + "人评价</div>" +
                                "<div class='piao'>" +
                                "<a href=''>" +
                                "<span>" + names[1] + "</span>" +
                                "<span>来自于" + names[0] + "的评价</span>" +
                                "</a>" +
                                "</div>" +
                                "</div>";
                    } else {
                        innerHtml += "<div class='remen fl'>";
                        if (rs.getString("tag") != null) {
                            innerHtml += "<div class='xinpin'><span>" + rs.getString("tag") + "</span></div>";
                        }
                        innerHtml += "<div class='tu'><a href='BuyGoods?name="+name1+"'><img src='" + rs.getString("img") + "'></a></div>" +
                                "<div class='miaoshu'><a href='BuyGoods?name="+name1+"'>" + name1 + "</a></div>" +
                                "<div class='jiage'>" + goodsDao.getPriceByName(name1) + "</div>" +
                                "<div class='pingjia'>0人评价</div>" +
                                "<div class='piao'>" +
                                "<a href=''>" +
                                "<span>" + "暂无用户评论" + "</span>" +
                                "<span></span>" +
                                "</a>" +
                                "</div>" +
                                "</div>";
                    }
                    random.remove(temp);
                    if (random.size() == 3) {
                        innerHtml += "+--+";
                    }
                }
            }
            writer.print(innerHtml);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
