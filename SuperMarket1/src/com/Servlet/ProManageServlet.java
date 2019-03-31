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

@WebServlet("/ProManageServlet")
public class ProManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        获取所有供应商
        ProDao proDao = new ProDaoImp();
        List<Provider> providers = proDao.showAllPro();
//        获取session，将所有的供应商保存
        HttpSession session = request.getSession();
        session.setAttribute("providers",providers);
        request.getRequestDispatcher("providerList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
