<%@ page import="com.JavaBean.Bill" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/29
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="../css/public.css"/>
    <link rel="stylesheet" href="../css/style.css"/>
</head>
<body>
<%
    List<Bill> billList = (List<Bill>) session.getAttribute("billList");
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
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表<span></span></h2>
        <nav>
            <ul class="list">
                <li id="active"><a href="BillListServlet">账单管理</a></li>
                <li><a href="ProManageServlet">供应商管理</a></li>
                <li><a href="UserListServlet">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>账单管理页面</span>
        </div>
        <form action="BillQueryServlet" method="post">
            <div class="search">
                <span>商品名称：</span>
                <input type="text" placeholder="请输入商品的名称" name="commodityName"/>
                <span>供应商：</span>
                <select name="tigong">
                    <option name="provider">--请选择--</option>
                    <%
                        for(Bill bill:billList){
                            %>
                        <option name="provider"><%=bill.getBill_provider()%></option>
                    <%
                        }
                    %>

                </select>
                <span>是否付款：</span>
                <select name="fukuan">
                    <option name="isPay">--请选择--</option>
                    <option name="isPay">已付款</option>
                    <option name="isPay">未付款</option>
                </select>

                <input type="submit" value="查询"/>
                <a href="ProListServlet">添加订单</a>
            </div>
        </form>
        <!--账单表格 样式和供应商公用-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">账单编码</th>
                <th width="20%">商品名称</th>
                <th width="10%">供应商</th>
                <th width="10%">账单金额</th>
                <th width="10%">是否付款</th>
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>
        <%
            for(Bill bill:billList){
                %>
            <tr>
                <td><%=bill.getBill_id()%></td>
                <td><%=bill.getBill_name()%></td>
                <td><%=bill.getBill_provider()%></td>
                <td><%=bill.getBill_money()%></td>
                <td><%=bill.getBill_isPay()%></td>
                <td><%=bill.getBill_time()%></td>
                <td>
                    <a href=<%="jhbillView.jsp?id="+bill.getBill_id()+"&name="+bill.getBill_name()+"&unit="+bill.getBill_unit()+"&amount="+bill.getBill_amount()+"&money="+bill.getBill_money()+"&provider="+bill.getBill_provider()+"&isPay="+bill.getBill_isPay()%>><img src="../img/read.png" alt="查看" title="查看"/></a>
                    <a href=<%="billUpdate.jsp?id="+bill.getBill_id()+"&name="+bill.getBill_name()+"&unit="+bill.getBill_unit()+"&amount="+bill.getBill_amount()+"&money="+bill.getBill_money()+"&provider="+bill.getBill_provider()+"&isPay="+bill.getBill_isPay()+"&time"+bill.getBill_time()%>><img src="../img/xiugai.png" alt="修改" title="修改"/></a>
                    <a href=<%="DeleteServlet?billId="+bill.getBill_id()%> class="removeBill"><img src="../img/schu.png" alt="删除" title="删除"/></a>
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
<%--<div class="remove" id="removeBi">--%>
    <%--<div class="removerChid">--%>
        <%--<h2>提示</h2>--%>
        <%--<div class="removeMain">--%>
            <%--<p>你确定要删除该订单吗？</p>--%>
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

