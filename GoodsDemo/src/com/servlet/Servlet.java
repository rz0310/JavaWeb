package com.servlet;

import com.db.DBUtil;
import com.javabean.Goods;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet",urlPatterns = "/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String value = request.getParameter("value");
        try {
            Connection conn = DBUtil.getConn();
            PreparedStatement ps = conn.prepareStatement("select * from goods where type='"+value+"';");
            ResultSet rs = ps.executeQuery();
            List<Goods> goodsList = new ArrayList<>();
            while(rs.next()){
                Goods goods = new Goods();
                goods.setId(rs.getInt("id"));
                goods.setName(rs.getString("name"));
                goods.setType(rs.getString("type"));
                goods.setPrice(rs.getString("price"));
                goods.setNum(rs.getString("num"));
                goodsList.add(goods);
            }
//            创建JSON对象
            JSONObject jsonObject = new JSONObject();
//            将集合添加到Json对象
            jsonObject.put("goodsList",goodsList);
//            做出响应(先获取PrintWriter对象，将JSON对象转为字符串的形式作为参数)
            response.getWriter().write(jsonObject.toString());
//            未使用Json
//            StringBuffer str = new StringBuffer();
//            str.append("<form align='left'><table align='center' border='1px' cellspacing='0'><tr><td>编号</td><td>姓名</td><td>类型</td><td>价格</td><td>数量</td></tr>");
//            for (Goods goods:goodsList) {
//                str.append("<tr><td>"+goods.getId()+"</td><td>"+goods.getName()+"</td><td>"+goods.getType()+"</td><td>"+goods.getPrice()+"</td><td>"+goods.getNum()+"</td></tr>");
//            }
//            str.append("</table></form>");
//            response.getWriter().write(String.valueOf(str));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
