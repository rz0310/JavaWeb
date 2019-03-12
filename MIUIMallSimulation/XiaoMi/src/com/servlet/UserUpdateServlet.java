package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Bill;
import com.bean.User;
import com.dao.UserDao;
import com.imp.UserImp;

/**
 * @desc 用户信息修改
 * @author liangqi
 *
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		//获取表单数据，进行封装
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("userPassword"));
		user.setPhone(request.getParameter("userPhone"));
		user.setSign(request.getParameter("userSign"));
		user.setAddress(request.getParameter("userAddress"));
		
		
		//进行更新操作
		UserDao userdao = new UserImp();
		Boolean bool_update = userdao.update(user);
		if(bool_update) {
			request.getRequestDispatcher("UserListServlet?diPage=1").forward(request, response);
		}else {
			request.setAttribute("msg", "修改失败");
			request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
