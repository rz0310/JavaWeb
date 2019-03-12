package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.imp.UserImp;
import com.util.DBUtil;


@WebServlet(name = "LoadServlet",urlPatterns = "/LoadServlet")
public class LoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoadServlet() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao user = new UserImp();
		boolean bool = user.loginCheck(userName, password);
		if(bool){
			request.getSession().setAttribute("username",userName);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			request.setAttribute("error", "账号或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
