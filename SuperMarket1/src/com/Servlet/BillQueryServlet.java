package com.Servlet;

import com.Dao.BillDao;
import com.Dao.Imp.BillDaoImp;
import com.JavaBean.Bill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/BillQueryServlet")
public class BillQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        获取request参数
        String name = request.getParameter("commodityName");
        String provider = request.getParameter("tigong");
        String isPay = request.getParameter("fukuan");
//        创建订单操作对象
        BillDao billDao = new BillDaoImp();
//        创建集合保存查询结果
        List<Bill> billList = new ArrayList<>();
        if(name != null&&provider == null&&isPay == null){
            billList  = billDao.queryByName(name);
        }else if(name == null&&provider != null&&isPay == null){
            billList = billDao.queryByPro(provider);
        }else if(name == null&&provider ==null&&isPay != null){
            billList = billDao.queryByIsPay(isPay);
        }else if(name != null&&provider != null&&isPay == null){
            billList = billDao.queryByNameAndPro(name,provider);
        }else if(name != null&&provider == null&&isPay != null){
            billList = billDao.queryByNameAndIsPay(name,isPay);
        }else if(name == null&&provider != null&&isPay != null){
            billList = billDao.queryByProAndIsPay(provider,isPay);
        }else{
            billList = billDao.queryByThree(name,provider,isPay);
        }
//        获取session，保存集合
        HttpSession session = request.getSession();
        session.setAttribute("billList",billList);
        request.getRequestDispatcher("billList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
