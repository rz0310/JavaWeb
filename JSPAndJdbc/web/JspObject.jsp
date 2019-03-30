<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/24
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("Protocol="+request.getProtocol());//获取客户使用的协议
        System.out.println("ServletPath="+request.getServletPath());//获取客户提交信息的页面路径
        System.out.println("requestURL="+request.getRequestURL());
        System.out.println("Method="+request.getMethod());
        System.out.println("RemoteAddr="+request.getRemoteAddr());
        Enumeration<String> parameterNames = request.getParameterNames();//获取客户端提交的所有参数的名字
        while(parameterNames.hasMoreElements()){
            System.out.println(parameterNames.nextElement());
        }
    %>
</body>
</html>
