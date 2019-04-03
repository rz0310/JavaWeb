package com.servletfilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/FilterDemo")
public class FilterDemo implements Filter {
    public FilterDemo(){
        System.out.println("过滤器的构造方法");
    }
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        response.sendRedirect("success.jsp");
        System.out.println("继续");
//        req.getRequestDispatcher("success.jsp").forward(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
    }
}
