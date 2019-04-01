<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/17
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--prefix：表示标签的前缀，标签的名字--%>
<%--url：表示需要用到的具体标签的路径--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    //    request.setAttribute("name","小仙女");
    List<Integer> list = new ArrayList();
    list.add(0, 100);
    list.add(1, 200);
    list.add(2, 300);
    session.setAttribute("list", list);
%></
>
<%--<c:out value="123"></c:out>--%>
<%--<c:out value="${name}"></c:out>--%>
<%--<c:set value="任静" var="name"></c:set>--%>
<%--<c:out value="${name}"></c:out>--%>
<%--<c:remove var="name"></c:remove>--%>
<%--<c:out value="${name}"></c:out>--%>

<%--items相当于作用域中存储的集合--%>
<%--var相当于foreach循环中的变量，相当于是遍历之后的集合的每一个值保存在作用域中，需要使用out标签或者el表达式输出--%>
<c:forEach items="${list}" var="element">
    <%--<c:out value="${element}"></c:out>--%>
    ${element }
</c:forEach>
<c:forTokens items="121212121" delims="1" var="shu">
    ${shu}
</c:forTokens>
<%--test的值为if判断的值--%>
<c:if test="${1==1}">
    <c:out value="hello"></c:out>
</c:if>
<c:set var="name">巴拉</c:set>
<c:out value="${name}"></c:out>

<c:set var="sw">100</c:set>
<c:choose>
    <c:when test="${sw==100}">
        <c:out value="满分"></c:out>
    </c:when>
    <c:when test="${sw<100}">
        <c:out value="优秀"></c:out>
    </c:when>
    <c:when test="${sw<80}">
        <c:out value="良好"></c:out>
    </c:when>
    <c:when test="${sw>60}">
        <c:out value="及格"></c:out>
    </c:when>
</c:choose>
</body>
</html>
