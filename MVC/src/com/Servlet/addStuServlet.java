package com.Servlet;

import com.Dao.Imp.StuDaoImp;
import com.Dao.Imp.UserDaoImp;
import com.Dao.StuDao;
import com.Dao.UserDao;
import com.JavaBean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addStu")
public class addStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        获取request中所有的参数
        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.valueOf(request.getParameter("age"));
        String aClass = request.getParameter("class");
        String major = request.getParameter("major");
//        创建集合保存学生对象
        List<Student> students = new ArrayList<>();
        StuDao stuDao = new StuDaoImp();
        students = stuDao.QueryAll();
//        创建学生对象
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setClazz(aClass);
        student.setMajor(major);
        student.setImage("");
//        添加到集合
        students.add(student);
        System.out.println(students);
        boolean insert = stuDao.insertStu(student);
        if(insert){//插入成功
            HttpSession session = request.getSession();//获取session
            session.setAttribute("students",students);//将新添加的学生对象保存到session中
            request.getRequestDispatcher("student.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("addStu.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
