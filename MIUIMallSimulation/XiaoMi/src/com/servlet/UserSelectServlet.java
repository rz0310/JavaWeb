package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UserDao;
import com.imp.UserImp;

/**
 * @desc 用户查询Servlet
 * @author liangqi
 *
 */
@WebServlet("/UserSelectServlet")
public class UserSelectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取要查询的用户名
		String username = request.getParameter("username");
		
		//在数据库中找出订单。
		UserDao userdao = new UserImp();
		List<User> usersList = userdao.getLikesUser(username);
		
		//把要展示的订单存到request中，请求转发到显示页面
		request.setAttribute("usersList",usersList );
		request.getRequestDispatcher("userList.jsp").forward(request, response);	
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
