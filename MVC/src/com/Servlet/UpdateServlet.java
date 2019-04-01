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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        获取request作用域的参数并保存在学生对象中
        Student student = new Student();
        student.setId(Integer.valueOf(request.getParameter("id")));
        student.setName(request.getParameter("name"));
        student.setAge(Integer.valueOf(request.getParameter("age")));
        student.setClazz(request.getParameter("class"));
        student.setMajor(request.getParameter("major"));
        StuDao stuDao = new StuDaoImp();
        boolean update = stuDao.updateStu(student);//进行更新学生信息
        if(update){//修改成功，重新显示修改后的页面
            request.getRequestDispatcher("student.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("update.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
