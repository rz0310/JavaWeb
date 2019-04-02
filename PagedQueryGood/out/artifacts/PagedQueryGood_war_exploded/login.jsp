<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/18
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="Servlet?pageNow=1" method="post">
        <table>
            用户名：<input type="text" name="username">
            密码：<input type="password" name="password"><br/>
            <input type="submit" value="登陆">&nbsp;&nbsp;&nbsp;
            <input type="reset" value="重置">
        </table>
    </form>
</body>
</html>
