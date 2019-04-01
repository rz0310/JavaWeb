<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/25
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body background="img/2.jpeg" style="overflow: hidden;background-repeat: no-repeat;background-size: cover">
    <form method="post" action="addStu">
        <fieldset style="width: 500px;height: 210px;margin: 0 auto;">
            <legend>添加学生</legend>
            <table align="center">
                <tr>
                    <td>编号：</td><td><input type="text" name="id"></td>
                </tr>
                <tr>
                    <td>姓名：</td><td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>年龄：</td><td><input type="text" name="age"></td>
                </tr>
                <tr>
                    <td>班级：</td><td><input type="text" name="class"></td>
                </tr>
                <tr>
                    <td>专业：</td><td><input type="text" name="major"></td>
                </tr>
                <tr>
                    <td>照片：</td><td><input type="file" name="pic"></td>
                </tr>
                <tr>
                    <td></td><td><input type="submit" name="name" value="确认添加"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
