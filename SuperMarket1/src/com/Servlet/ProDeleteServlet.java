package com.Servlet;

import com.Dao.Imp.ProDaoImp;
import com.Dao.ProDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet("/ProDeleteServlet")
public class ProDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        获取request参数
        Integer id = Integer.valueOf(request.getParameter("id"));
        ProDao proDao = new ProDaoImp();
        boolean b = proDao.deletePro(id);
        if(b){
            request.getRequestDispatcher("ProManageServlet").forward(request,response);
        }else{
            JOptionPane.showMessageDialog(null,"删除失败！");
        }
    }
}
