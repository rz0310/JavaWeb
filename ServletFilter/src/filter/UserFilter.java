package filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// 获取HttpServletRequest
		HttpServletRequest request = (HttpServletRequest) arg0;
		// 获取session
		HttpSession session = request.getSession();
		// 获取其中存储的账户信息map
		Map map = (Map) session.getAttribute("sessionMap");
		// 获取请求的页面
		String url = request.getRequestURI();
		// 如果访问的不是注册或登录页面，则进行验证
		if (!url.contains("login") && url.contains("regist")) {
			// 如果获取不到，跳转到登录页面
			if (map == null) {
				arg0.getRequestDispatcher("login.jsp").forward(arg0, arg1);
			} else {
				arg2.doFilter(arg0, arg1);
			}
		} else {
			arg2.doFilter(arg0, arg1);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
