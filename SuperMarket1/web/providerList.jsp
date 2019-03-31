<%@ page import="java.util.List" %>
<%@ page import="com.JavaBean.Provider" %>
<%@ page import="com.Dao.ProDao" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/29
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="../css/public.css"/>
    <link rel="stylesheet" href="../css/style.css"/>
</head>
<body>
<%
    List<Provider> providers = (List<Provider>)session.getAttribute("providers");
%>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${username}</span> , 欢迎你！</p>
        <a href="login.html">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正，常浏览，请使用高版本浏览器！（IE10+）</a>
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
            <span>供应商管理页面</span>
        </div>
        <form method="post" action="ProQueryServlet">
            <div class="search">
                <span>供应商名称：</span>
                <input type="text" placeholder="请输入供应商的名称" name="providerName"/>
                <input type="submit" value="查询"/>
                <a href="providerAdd.jsp">添加供应商</a>
            </div>
        </form>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">供应商编码</th>
                <th width="20%">供应商名称</th>
                <th width="10%">联系人</th>
                <th width="10%">联系电话</th>
                <th width="10%">传真</th>
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>
            <%
                for (Provider provider:providers) {
            %>
                    <tr>
                <td><%=provider.getPro_id()%></td>
                <td><%=provider.getPro_name()%></td>
                <td><%=provider.getPro_conn()%></td>
                <td><%=provider.getPro_tel()%></td>
                <td><%=provider.getPro_fax()%></td>
                <td><%=provider.getPro_time()%></td>
                <td>
                    <a href=<%="providerView.jsp?id="+provider.getPro_id()+"&name="+provider.getPro_name()+"&conn="+provider.getPro_conn()+"&tel="+provider.getPro_tel()+"&fax="+provider.getPro_fax()+"&desc="+provider.getPro_desc()%>><img src="../img/read.png" alt="查看" title="查看"/></a>
                    <a href=<%="providerUpdate.jsp?id="+provider.getPro_id()+"&name="+provider.getPro_name()+"&conn="+provider.getPro_conn()+"&tel="+provider.getPro_tel()+"&add="+provider.getPro_add()+"&fax="+provider.getPro_fax()+"&desc="+provider.getPro_desc()%>><img src="../img/xiugai.png" alt="修改" title="修改"/></a>
                    <a href=<%="ProDeleteServlet?id="+provider.getPro_id()%> class="removeProvider"><img src="../img/schu.png" alt="删除" title="删除"/></a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<%--<div class="zhezhao"></div>--%>
<%--<div class="remove" id="removeProv">--%>
    <%--<div class="removerChid">--%>
        <%--<h2>提示</h2>--%>
        <%--<div class="removeMain" >--%>
            <%--<p>你确定要删除该供应商吗？</p>--%>
            <%--<a href="#" id="yes">确定</a>--%>
            <%--<a href="#" id="no">取消</a>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>


<footer class="footer">
</footer>

<script src="../js/jquery.js"></script>
<script src="../js/js.js"></script>
<script src="../js/time.js"></script>

</body>
</html>
