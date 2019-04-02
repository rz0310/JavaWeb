package com.Servlet;

import com.Dao.Imp.StuDaoImp;
import com.Dao.StuDao;
import com.JavaBean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        声明初始页
        int nowPage=1;
        String pageNow = request.getParameter("pageNow");
        if(pageNow != null){
            nowPage = Integer.parseInt(pageNow);
        }

        String find = request.getParameter("find");
        if(find != null){
            nowPage = Integer.valueOf(find);
        }

//        调用实际的操作类
        StuDao stuDao = new StuDaoImp();
        int totalPage = stuDao.getTotalPage();
        List<Student> stuList = stuDao.getStuByPage(nowPage);

//        获取session
        HttpSession session = request.getSession();
        session.setAttribute("nowPage",nowPage);
        session.setAttribute("totalPage",totalPage);
        session.setAttribute("stuList",stuList);
//        跳转到成功页面
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
