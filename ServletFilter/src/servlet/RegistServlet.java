package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="regist", urlPatterns="/regist")
public class RegistServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取账号
		String userName = req.getParameter("userName");
		// 获取密码
		String password = req.getParameter("password");

		// 获取session
		HttpSession session = req.getSession();
		// 存储账号信息进session
		Map newMap = new HashMap();
		newMap.put("userName", userName);
		newMap.put("password", password);
		session.setAttribute("sessionMap", newMap);
		// 跳转到主页
		resp.sendRedirect("success.jsp");
	}
}
