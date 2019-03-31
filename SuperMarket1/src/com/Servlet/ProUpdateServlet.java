package com.Servlet;

import com.Dao.Imp.ProDaoImp;
import com.Dao.ProDao;
import com.JavaBean.Provider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.util.Calendar;

@WebServlet("/ProUpdateServlet")
public class ProUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        获取request参数
        Integer providerId = Integer.valueOf(request.getParameter("providerId"));
        String providerName = request.getParameter("providerName");
        String providerConn = request.getParameter("people");
        String providerTel = request.getParameter("phone");
        String providerAdd = request.getParameter("address");
        String providerFax = request.getParameter("fax");
        String providerDesc = request.getParameter("describe");
        Provider provider = new Provider();
        provider.setPro_id(providerId);
        provider.setPro_name(providerName);
        provider.setPro_conn(providerConn);
        provider.setPro_tel(providerTel);
        provider.setPro_add(providerAdd);
        provider.setPro_fax(providerFax);
        provider.setPro_desc(providerDesc);
        Calendar c = Calendar.getInstance();//更新时间
        provider.setPro_time(c.getTime().toString());
        ProDao proDao = new ProDaoImp();
        boolean b = proDao.updatePro(provider);
        if(b){
            request.getRequestDispatcher("ProManageServlet").forward(request,response);
        }else{
            JOptionPane.showMessageDialog(null,"更新失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
