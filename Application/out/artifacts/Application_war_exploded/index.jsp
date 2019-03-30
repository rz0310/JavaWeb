<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/24
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%--errorPage="error.jsp"  import="java.util.Scanner"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%--<%@include file="show.jsp"%>&lt;%&ndash;页面编译的时候才引入，发送请求的时候真正引入外部文件&ndash;%&gt;--%>
<html lang="en">
  <head>
    <title>$Title$</title>
  </head>
  <body>
  1111111
    <%--<%--%>
       <%--out.print(1/0);//错误--%>
    <%--%>--%>
  <%--<jsp:include page="show.jsp">:在本页面运行时直接引入show.jsp--%>
  <%--以下三行中间不可以加注释：否则会报错：org.apache.jasper.JasperException: java.lang.ClassNotFoundException: org.apache.jsp.index_jsp--%>
    <jsp:include page="show.jsp">
      <jsp:param name="111" value="222"/>
    </jsp:include>
  <%--<jsp:param name="111" value="222"/>:将本页面的参数传递到要跳转的页面--%>
    <%--<jsp:forward page="show.jsp">--%><%--跳转页面--%>
      <%--<jsp:param name="name" value="renjing"></jsp:param>--%>
    <%--</jsp:forward>--%>
  <%--全局变量--%>
    <%--<%!--%>
      <%--int id;--%>
      <%--String name;--%>
      <%--int age;--%>
    <%--%>--%>
    <%--<hr>--%>
  <%--&lt;%&ndash;Java代码 jsp代码&ndash;%&gt;--%>
    <%--<%--%>
      <%--id = 1;--%>
      <%--if(id==1){--%>
          <%--%>--%>
            <%--<img src="img/timg.jpg">--%>
          <%--<%--%>
            <%--name="任静";--%>
            <%--age=20;--%>
      <%--}--%>
    <%--%>--%>
  <%--&lt;%&ndash;表达式&ndash;%&gt;--%>
    <%--<%=id%>--%>
    <%--<%=name%>--%>
    <%--<%=age%>--%>
  </body>
</html>
