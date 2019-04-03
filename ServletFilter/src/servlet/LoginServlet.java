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

@WebServlet(name="login", urlPatterns="/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//将表单参数转码
		req.setCharacterEncoding("utf-8");
		//获取账号
		String userName = req.getParameter("userName");
		//获取密码
		String password = req.getParameter("password");
		
		//获取session中存储的账号密码
		//获取session
		HttpSession session = req.getSession();
		//获取存储的sessionMap
		Map map = (Map)session.getAttribute("sessionMap");
		//取出其中的帐号名
		String sessionUserName = (String)map.get("userName");
		//取出其中的密码
		String sessionPassword = (String)map.get("password");
		
		//比对，如果不匹配，跳回登录
		if(!userName.equals(sessionUserName) || !password.equals(sessionPassword)){
			req.setAttribute("errorMessage", "帐户名和密码不匹配，请重新输入！");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		//否则将账户密码存入session中并跳转到主页
		else{
			Map newMap = new HashMap();
			newMap.put("userName", userName);
			newMap.put("password", password);
			session.setAttribute("sessionMap", newMap);
			resp.sendRedirect("success.jsp");
		}
	}
}
