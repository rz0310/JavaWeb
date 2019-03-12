package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.imp.UserImp;

/**
 * @desc 用户删除
 * @author liangqi
 *
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取你要删除的用户的username
		String username = request.getParameter("username");
		//进行删除操作
		UserDao userdao = new UserImp();
		Boolean bool_delete = userdao.delete(username);
		if(bool_delete) {
			request.getRequestDispatcher("UserListServlet?diPage=1").forward(request, response);
		}else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
