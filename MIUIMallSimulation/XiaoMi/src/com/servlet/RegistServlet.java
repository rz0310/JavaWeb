package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UserDao;
import com.imp.UserImp;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String phone = request.getParameter("tel");
		//调用密码是否一致方法，如果一致，执行注册方法，注册完成后跳到登陆界面，如果不一致，继续在当前页面注册
		UserDao user = new UserImp();
		User users = new User();
		users.setUserName(userName);
		users.setPassword(password);
		users.setPhone(phone);
		boolean same = user.isSame(password, repassword);
		if (same) {
			boolean register = user.register(users);
			if (register) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "*注册失败，请稍后重试!");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("error", "*两次密码输入不一致，请重新输入!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}
