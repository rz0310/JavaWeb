package com.servlet;

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

@WebServlet(name = "showIdleGoods",urlPatterns = "/showIdleGoods")
public class showIdleGoods extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from idlegoods;";
        ResultSet rs = db.executeQuery(sql);
        ArrayList<String> imgs = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> desc = new ArrayList<>();
        try {
            while (rs.next()) {
                imgs.add(rs.getString("img"));
                name.add(rs.getString("idle_name"));
                desc.add(rs.getString("desc"));
            }
            PrintWriter writer = response.getWriter();
            for (int i = 0; i < imgs.size(); i++) {
                ResultSet resultSet = db.executeQuery("select goods_price from goods where goods_name ='" + name.get(i)+"'");
                if (resultSet.next()) {
                    writer.print("<div class='mingxing fl'>" +
                            "      <div class='sub_mingxing'><a href='BuyGoods?name=" + name.get(i) + "'><img src='" + imgs.get(i) + "' alt=''></a></div>" +
                            "      <div class='pinpai'><a href='BuyGoods?name=" + name.get(i) + "'>" + name.get(i) + "</a></div>" +
                            "      <div class='youhui'>" + desc.get(i) + "</div>" +
                            "      <div class='jiage'>" + resultSet.getDouble("goods_price") + "</div>" +
                            "    </div>");
                }
            }
            writer.print("<div class='clear'></div>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
