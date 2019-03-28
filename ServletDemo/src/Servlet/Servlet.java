package Servlet;

import Bean.Student;
import Dao.StuDao;
import Imp.StuDaoImp;
import Imp.UserDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//@WebServlet("/index")
public class Servlet extends HttpServlet {
//    初始化
    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }
//    post方式提交
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get()方法");
        req.setCharacterEncoding("utf-8");//设置请求的编码
        resp.setCharacterEncoding("utf-8");//设置响应的编码
        resp.setContentType("text/html;charset=utf-8");//设置文本的编码格式
        String username = req.getParameter("username");//获取请求的username参数
        String password = req.getParameter("password");//获取请求的password参数
        UserDaoImp udi = new UserDaoImp();
        boolean flag = udi.getUserByName(username, password);//根据用户名获取用户，flag为true则为登录成功
        PrintWriter out = resp.getWriter();//获取标准打印流
        if(flag){//如果验证登录成功
            StuDaoImp sdi = new StuDaoImp();
            List<Student> allStu = sdi.getAll();//获取所有学生信息，以list的形式返回
            out.print("<table border = '1px' width=1000px align = 'center' cellspacing='0px'><tr><th>ID</th><th>name</th><th>age</th><th>clazz</th><th>major</th></tr>");
            out.print("<caption><h3>学生信息表</h3></caption>");
            for (Student stu : allStu){
                out.print("<tr align = 'center' ><td>");
                out.print(stu.getId());
                out.print("</td><td>");
                out.print(stu.getName());
                out.print("</td><td>");
                out.print(stu.getAge());
                out.print("</td><td>");
                out.print(stu.getClazz());
                out.print("</td><td>");
                out.print(stu.getMajor());
                out.print("</td>");
                out.print("</tr>");
            }
            out.print("</table>");
        }else{//否则登录失败
            out.print("登录失败");
        }
    }
//    执行客户端请求处理的方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
//    由JVM的垃圾回收器进行回收的：销毁
    @Override
    public void destroy() {
        super.destroy();
        System.out.println("销毁");
    }
}
