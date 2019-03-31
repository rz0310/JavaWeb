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

@WebServlet("/ProListServlet")
public class ProListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        查询所有供应商
        ProDao proDao = new ProDaoImp();
        List<Provider> providers = proDao.showAllPro();
//        获取session，保存所有供应商
        HttpSession session = request.getSession();
        session.setAttribute("providers",providers);
        request.getRequestDispatcher("billAdd.jsp").forward(request,response);//转到添加订单界面
    }
}
