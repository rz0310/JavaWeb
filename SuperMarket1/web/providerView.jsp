<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/16
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");

    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String conn = request.getParameter("conn");
    String tel = request.getParameter("tel");
    String fax = request.getParameter("fax");
    String desc = request.getParameter("desc");
%>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="login.html">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="BillListServlet">账单管理</a></li>
                <li id="active"><a href="ProManageServlet">供应商管理</a></li>
                <li><a href="UserListServlet">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <p><strong>供应商编码：</strong><span><%=id%></span></p>
            <p><strong>供应商名称：</strong><span><%=name%></span></p>
            <p><strong>联系人：</strong><span><%=conn%></span></p>
            <p><strong>联系电话：</strong><span><%=tel%></span></p>
            <p><strong>传真：</strong><span><%=fax%></span></p>
            <p><strong>描述：</strong><span><%=desc%></span></p>
            <a href="providerList.jsp">返回</a>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>
