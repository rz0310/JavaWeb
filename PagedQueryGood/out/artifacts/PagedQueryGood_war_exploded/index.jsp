<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/18
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%
    Integer totalPage = Integer.valueOf(session.getAttribute("totalPage").toString());
%>
  <table align="center" border="1px" cellspacing="0" width="500px" height="400px">
    <tr align="center">
      <td>编号</td><td>姓名</td><td>年龄</td><td>班级</td><td>专业</td><td>照片</td>
    </tr>
      <c:forEach items="${stuList}" var="stu">
          <tr align="center">
              <td>${stu.id}</td>
              <td>${stu.name}</td>
              <td>${stu.age}</td>
              <td>${stu.clazz}</td>
              <td>${stu.major}</td>
              <td><img src="${stu.image}" width="100px" height="100px"></td>
          </tr>
      </c:forEach>
      <tr align="center">
          <c:if test="${nowPage!=1}">
              <td><a href="Servlet?pageNow=1">首页</a></td> <td><a href="Servlet?pageNow=${nowPage-1}">上一页</a></td>
          </c:if>
          <c:if test="${nowPage!=totalPage}">
              <td><a href="Servlet?pageNow=${nowPage+1}">下一页</a></td> <td><a href="Servlet?pageNow=${totalPage}">末页</a></td>
          </c:if>
          <td colspan="3">
              页数：<select name="selectName" id="selectId">
                  <%
                      for(int i=1;i<=totalPage;i++){
                  %>
                  <option value="<%=i%>"><%=i%></option>
                  <%
                      }
                  %>
              </select>
              <a href="" id="jump" onclick="change()">查找</a>
          </td>
      </tr>
      <script>
          function change() {
              var selectId = document.getElementById("selectId").value;
              var href = "Servlet?pageNow="+selectId;
              var jump = document.getElementById("jump");
              jump.setAttribute("href",href);
          }
      </script>
      <%--<form action="Servlet">--%>
          <%--<input type="text" name="find">--%>
          <%--<input type="submit" value="跳转">--%>
      <%--</form>--%>
  </table>
  </body>
</html>
