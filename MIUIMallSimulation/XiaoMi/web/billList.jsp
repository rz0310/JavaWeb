<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- jstl的核心标签c -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/backstyle.css" />
</head>
<body>
	<!--头部-->
	<header class="publicHeader">
	<h1>小米商城账单管理系统</h1>
	<div class="publicHeaderR">
		<p>
			<span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！
		</p>
		<a href="login.jsp">退出</a>
	</div>
	</header>
	<!--时间-->
	<section class="publicTime"> <span id="time">2015年1月1日
		11:11 星期一</span> <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a> </section>
	<!--主体内容-->
	<section class="publicMian ">
	<div class="left">
		<h2 class="leftH2">
			<span class="span1"></span>功能列表 <span></span>
		</h2>
		<nav>
		<ul class="list">
			<li id="active"><a href="BillListServlet?diPage=1">账单管理</a></li>
			<li><a href="ProviderListServlet?diPage=1">供应商管理</a></li>
			<li><a href="UserListServlet?diPage=1">用户管理</a></li>
			<li><a href="backlogin.jsp">退出系统</a></li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>账单管理页面</span>
		</div>
		<div class="search">
			<span>订单编号：</span>
			<form action="BillSelectServlet">
				<input type="text" placeholder="请输入订单关键字" name="keyName"/>
				<input type="submit" value="查询" >
				<b>${prompt}</b>
				<a href="billAdd.jsp">添加订单</a>
			</form>
		</div>
		<!--账单表格 样式和供应商公用-->
		<table class="providerTable" cellpadding="0" cellspacing="0">
			<tr class="firstTr">
				<th width="10%">账单编号</th>
				<th width="20%">商品名称</th>
				<th width="10%">商品单价</th>
				<th width="5%">商品数量</th>
				<th width="10%">订单状态</th>
				<th width="10%">是否付款</th>
				<th width="15%">创建时间</th>
				<th width="20%">操作</th>
			</tr>
			<%-- 展示订单的记录 --%>
			<c:forEach items="${billList}" var="bill">
				<tr>
					<td>${bill.id}</td>
					<td>${bill.goodsName}</td>
					<td>${bill.goodsPrice}</td>
					<td>${bill.goodsNum}</td>
					<td>${bill.status}</td>
					<td>${bill.money}</td>
					<td>${bill.date}</td>
					<td>
						<a href="billUpdate.jsp?bill_id=${bill.id}"><img src="image/xiugai.png" alt="修改" title="修改" /></a>
						<a href="BillDeleteServlet?bill_id=${bill.id}" class="removeBill"><img src="image/schu.png" alt="删除" title="删除" /></a>
					</td>
				</tr>
			</c:forEach>
		<tr>
			<td colspan="8">总共${pageCounts}页,当前是第${page}页。
				<c:if test="${page!=1}">
					<a href="BillListServlet?diPage=1">首页</a>
					<a href="BillListServlet?diPage=${page-1}">上一页</a>
				</c:if>
				<c:if test="${page!=pageCounts}">
					<a href="BillListServlet?diPage=${page+1}">下一页</a>
					<a href="BillListServlet?diPage=${pageCounts}">尾页</a>
				</c:if>
			</td>
		</tr>
		</table>
	</div>
	</section>

	<!--点击删除按钮后弹出的页面-->
	<div class="zhezhao"></div>
	<div class="remove" id="removeBi">
		<div class="removerChid">
			<h2>提示</h2>
			<div class="removeMain">
				<p>你确定要删除该订单吗？</p>
				<a href="#" id="yes">确定</a> <a href="#" id="no">取消</a>
			</div>
		</div>
	</div>

	<footer class="footer"> </footer>

	<script src="js/jquery.js"></script>
	<script src="js/js.js"></script>
	<script src="js/time.js"></script>

</body>
</html>