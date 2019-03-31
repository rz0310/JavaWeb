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
import java.io.IOException;
import java.util.List;

@WebServlet("/ProQueryServlet")
public class ProQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        获取request参数
        String provider = request.getParameter("providerName");
        ProDao proDao = new ProDaoImp();
        List<Provider> providers = proDao.queryByName(provider);
//        获取session，保存存储供应商的集合
        HttpSession session = request.getSession();
        session.setAttribute("providers",providers);
        request.getRequestDispatcher("providerList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
