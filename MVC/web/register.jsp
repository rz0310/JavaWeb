<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/25
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body background="img/2.jpeg" style="overflow: hidden;background-repeat: no-repeat;background-size: cover">
<div align="right">
    <h3>欢迎${username}来到学生管理系统</h3>
    <a href="index.jsp">登录</a>&nbsp;&nbsp;&nbsp;<a href="RegisterServlet">注册</a>
</div>
<form action="RegisterServlet" method="post">
    <fieldset style="width: 300px;height: 100px;margin: 0 auto;">
        <legend>注册</legend>
        <table align="center">
            <tr>
                <td>用户名：</td><td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td><td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>确认密码：</td><td><input type="password" name="password2"></td>
            </tr>
            <tr>
                <td></td><td><input type="submit" name="name" value="注册"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
