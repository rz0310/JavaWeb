<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/25
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String id = request.getParameter("id");
    %>
    <form action="UpdateServlet" method="post">
        <fieldset style="width: 400px;height: 200px;margin: 0 auto;">
            <legend>修改学生信息</legend>
            <table align="center">
                <tr align="center">
                    <td align="right">编号：</td><td align="left"><input type="text" name="id" readonly="readonly" value="<%=id%>"></td>
                </tr>
                <tr align="center">
                    <td align="right">姓名：</td><td align="left"><input type="text" name="name"></td>
                </tr>
                <tr align="center">
                    <td align="right">年龄：</td><td align="left"><input type="text" name="age"></td>
                </tr>
                <tr align="center">
                    <td align="right">班级：</td><td align="left"><input type="text" name="class"></td>
                </tr>
                <tr align="center">
                    <td align="right">专业：</td><td align="left"><input type="text" name="major"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="确认修改"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
