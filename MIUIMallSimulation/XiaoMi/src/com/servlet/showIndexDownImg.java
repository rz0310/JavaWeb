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

@WebServlet(name = "showIndexDownImg",urlPatterns = "/showIndexDownImg")
public class showIndexDownImg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBUtil db = DBUtil.getDBUtil();
        String sql = "select * from indexdown;";
        ResultSet rs = db.executeQuery(sql);
        ArrayList<String> imgs = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        try {
            while (rs.next()) {
                imgs.add(rs.getString("img"));
                name.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter writer = response.getWriter();
        for (int i = 0; i < imgs.size(); i++) {
            writer.print("<div class='datu fl'><a href='BuyGoods?name="+name.get(i)+"'><img src='" + imgs.get(i) + "' alt=''></a></div>");
        }
        writer.print("<div class='clear'></div>");
    }
}
