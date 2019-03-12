package com.servlet;

import java.io.IOException;
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
 * @desc 订单添加Servlet
 * @author liangqi
 *
 */
@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		//获取表单数据，进行封装
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("userPassword"));
		user.setPhone(request.getParameter("userPhone"));
		user.setSign(request.getParameter("userSign"));
		user.setAddress(request.getParameter("userAddress"));
		
		
		//进行添加操作
		UserDao userdao = new UserImp();
		boolean bool_add = userdao.register(user);
		
		if(bool_add == true) {
			request.getRequestDispatcher("UserListServlet?diPage=1").forward(request, response);
		}else {
			request.setAttribute("msg", "用户添加失败");
			request.getRequestDispatcher("userAdd.jsp").forward(request, response);
		}
	}

}
