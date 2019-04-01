<%@ page import="com.JavaBean.Student" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/24
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    System.out.println(session.getAttribute("students"));
    System.out.println(session.getAttribute("username"));
%>
<body background="img/2.jpeg" style="background-repeat: no-repeat;background-size: cover">
        <div align="right">
        <h3>欢迎${username}"来到学生管理系统</h3>
            <a href="index.jsp">登录</a>&nbsp;&nbsp;&nbsp;<a href="RegisterServlet">注册</a>
        </div>
        <form action="FindServlet" method="post">
        <table align="center" border="1px" cellspacing="0px" width="800px" height=140px">
        <caption><h2>学生信息表</h2></caption>
        <tr align="right">
            <td colspan="7"><a href="addStu.jsp"><input type="button" value="添加学生"></a></td>
        </tr>
        <tr align="center">
            <td colspan="7" align="right">
                <select name="select">
                    <option>编号</option>
                    <option>姓名</option>
                    <option>年龄</option>
                    <option>班级</option>
                    <option>专业</option>
                </select>
                <input type="text" placeholder="请输入" name="findVal"><input type="submit" value="搜索" name="find">
            </td>
        </tr>
        <tr align="center">
            <td>编号</td><td>姓名</td><td>年龄</td><td>班级</td><td>专业</td><td>照片</td><td>操作</td>
        </tr>
            <c:forEach items="${students}" var="stu">
                <tr align="center">
                    <td>
                        <c:out value="${stu.id}"></c:out>
                    </td>
                    <td>
                        <c:out value="${stu.name}"></c:out>
                    </td>
                    <td>
                        <c:out value="${stu.age}"></c:out>
                    </td>
                    <td>
                        <c:out value="${stu.clazz}"></c:out>
                    </td>
                    <td>
                        <c:out value="${stu.major}"></c:out>
                    </td>
                    <td>
                        <img src="<c:out value="${stu.image}" ></c:out>" width="100px" height="100px">
                    </td>
                    <td>
                        <a href="update.jsp?id=${stu.id}&name=${stu.name}&age=${stu.age}&class=${stu.clazz}&major=${stu.major}"><input type="button" value="修改">&nbsp;&nbsp;&nbsp;</a>
                        <a href="DeleteServlet?name=${stu.name}"><input type="button" value="删除"></a>
                    </td>
                </tr>
            </c:forEach>
        <%--for (Student s:students){--%>
            <%--%>--%>
            <%--<tr align="center"><td><%=s.getId()%>--%>
                <%--</td><td><%=s.getName()%>--%>
                <%--</td><td><%=s.getAge()%>--%>
                <%--</td><td><%=s.getClazz()%>--%>
                <%--</td><td><%=s.getMajor()%>--%>
                <%--</td><td>--%>
                    <%--<img src=<%=s.getImage()%> width="100px" height="100px">--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--<a href=<%="update.jsp?id="+s.getId()+"&name="+s.getName()+"&age="+s.getAge()+"&class="+s.getClazz()+"&major="+s.getMajor()%>><input type="button" value="修改"></a>&nbsp;&nbsp;&nbsp;--%>
                    <%--<a href=<%="DeleteServlet?name="+s.getName()%>><input type="button" value="删除"></a>--%>
                <%--</td>--%>
            <%--</tr>--%>
    <%--<%--%>
        <%--}--%>
    <%--%>--%>
        </table>
        </form>
</body>
</html>
