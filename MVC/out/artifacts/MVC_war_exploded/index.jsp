<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/25
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body  background="img/2.jpeg" style="overflow: hidden;background-repeat: no-repeat;background-size: cover">
  <div align="right">
    <h3>欢迎${username}来到学生管理系统</h3>
    <a href="index.jsp">登录</a>&nbsp;&nbsp;&nbsp;<a href="register.jsp">注册</a>
  </div>
  <form action="index" method="post">
    <fieldset style="width: 400px;height: 80px;margin: 0 auto;">
      <legend>登录</legend>
      <table align="center">
        <tr>
          <td align="right">用户名：</td><td align="left"><input type="text" name="username"></td>
        </tr>
        <tr>
          <td align="right">密码：</td><td align="left"><input type="password" name="password"></td>
        </tr>
        <tr>
          <td><input type="submit" name="name" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" name="name" value="取消"></td>
        </tr>
      </table>
    </fieldset>
  </form>
  </body>
</html>
