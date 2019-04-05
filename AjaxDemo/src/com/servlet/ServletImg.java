package com.servlet;

import com.db.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ServletImg",urlPatterns = "/ServletImg")
public class ServletImg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        PrintWriter writer = response.getWriter();
//        writer.print("小仙女");
        try {
            Connection conn = DBUtil.getConn();
            String sql = "select image from image where id=2;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String images = rs.getString("image");
            response.getWriter().write(images);
            System.out.println(images);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
