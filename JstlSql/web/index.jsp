<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/18
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--url为统一资源定位符 driver为数据库驱动 var为数据库变量名--%>
  <sql:setDataSource url="jdbc:mysql://localhost:3306/up1?" driver="com.mysql.jdbc.Driver" user="root" password="root" var="sqlone"></sql:setDataSource>
  <sql:query var="allUser" sql="select * from user where username=? and id=?;" dataSource="${sqlone}">
    <sql:param value="renjing"></sql:param>
    <sql:param value="1"></sql:param>
  </sql:query>
  <%--下面的标签中的items中的集合必须要.rows，才可以得到结果集中的内容--%>
    <c:forEach items="${allUser.rows}" var="user">
      ${user}<br/>
    </c:forEach>
  <hr>
  <%--<sql:update dataSource="${sqlone}" var="insert">--%>
    <%--insert into user values(?,?,?);--%>
    <%--${insert}--%>
    <%--<sql:param>7</sql:param>--%>
    <%--<sql:param>zhengming</sql:param>--%>
    <%--<sql:param>999</sql:param>--%>
    <%--<sql:param value="5"></sql:param>--%>
    <%--<sql:param value="yangluo"></sql:param>--%>
    <%--<sql:param value="111"></sql:param>--%>
  <%--</sql:update>--%>
  <%--<c:if test="${insert>0}">--%>
    <%--<c:out value="插入成功"></c:out>--%>
  <%--</c:if>--%>
  <%--设置数据源--%>
  <%--<sql:setDataSource></sql:setDataSource>--%>

  <%--事务的一致性：第一条语句出错，第二条语句也不会执行--%>
  <%--<sql:transaction dataSource="${sqlone}">--%>
    <%--<sql:update sql="update uuu set password=? where username=?;">--%>
      <%--<sql:param value="666"></sql:param>--%>
      <%--<sql:param value="666"></sql:param>--%>
    <%--</sql:update>--%>
    <%--<sql:update sql="update user set password=? where username=?;">--%>
      <%--<sql:param>123</sql:param>--%>
      <%--<sql:param>admin</sql:param>--%>
    <%--</sql:update>--%>
  <%--</sql:transaction>--%>
  <%--<form action="IndexServlet" method="post">--%>
    <%--<input type="submit" value="提交">--%>
  <%--</form>--%>
  <a href="IndexServlet">提交</a>
  </body>
</html>
