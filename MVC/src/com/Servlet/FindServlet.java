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

@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        获取request作用域中的参数
        String select = request.getParameter("select");//选择的查询属性
        String findVal = request.getParameter("findVal");//查找的真正的值
        StuDao stuDao = new StuDaoImp();
        HttpSession session = null;
        List<Student> students = null;
        if(findVal == null||findVal.equals("")){
            students = stuDao.QueryAll();
            session = request.getSession();
            session.setAttribute("students",students);
            request.getRequestDispatcher("student.jsp").forward(request,response);
        }
        switch (select){
            case "编号":
                Integer id = Integer.valueOf(findVal);
                students = stuDao.queryById(id);
                session = request.getSession();
                session.setAttribute("students",students);
                request.getRequestDispatcher("student.jsp").forward(request,response);
                break;
            case "姓名":
                students = stuDao.queryByName(findVal);
                session = request.getSession();
                session.setAttribute("students",students);
                request.getRequestDispatcher("student.jsp").forward(request,response);
                break;
            case "年龄":
                Integer age = Integer.valueOf(findVal);
                students = stuDao.queryByAge(age);
                session = request.getSession();
                session.setAttribute("students",students);
                request.getRequestDispatcher("student.jsp").forward(request,response);
                break;
            case "班级":
                students = stuDao.queryByClass(findVal);
                session = request.getSession();
                session.setAttribute("students",students);
                request.getRequestDispatcher("student.jsp").forward(request,response);
                break;
            case "专业":
                students = stuDao.queryByMajor(findVal);
                session = request.getSession();
                session.setAttribute("students",students);
                request.getRequestDispatcher("student.jsp").forward(request,response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
