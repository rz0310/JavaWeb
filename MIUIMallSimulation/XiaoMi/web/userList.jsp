<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- jstl的核心标签c -->
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>小米商城账单管理系统</title>
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
	<section class="publicTime">
		<span id="time">2015年1月1日 11:11 星期一</span> <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
	</section>
	<!--主体内容-->
	<section class="publicMian ">
		<div class="left">
			<h2 class="leftH2">
				<span class="span1"></span>功能列表 <span></span>
			</h2>
			<nav>
				<ul class="list">
					<li><a href="BillListServlet?diPage=1">账单管理</a></li>
					<li><a href="ProviderListServlet?diPage=1">供应商管理</a></li>
					<li id="active"><a href="UserListServlet?diPage=1">用户管理</a></li>
					<li><a href="backlogin.jsp">退出系统</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
			<div class="location">
				<strong>你现在所在的位置是:</strong> <span>用户管理页面</span>
			</div>
			<div class="search">
			<form action="UserSelectServlet" method="post">
				<span>用户名：</span> <input type="text" placeholder="请输入用户名" name="username"/>
				<%--<input type="submit" value="查询" /> <a href="userAdd.jsp">添加用户</a>--%>
			</form>
			</div>
			
			<!--用户-->
			<table class="providerTable" cellpadding="0" cellspacing="0">
				<tr class="firstTr">
					<th width="10%">用户名称</th>
					<th width="10%">用户密码</th>
					<th width="15%">电话</th>
					<th width="20%">个性签名</th>
					<th width="20%">地址</th>
					<th width="25%">操作</th>
				</tr>

				<c:forEach items="${usersList}" var="user">
					<tr>
						<td>${user.userName}</td>
						<td>${user.password}</td>
						<td>${user.phone}</td>
						<td>${user.sign}</td>
						<td>${user.address}</td>
						<td>
							<a href="userUpdate.jsp"><img src="image/xiugai.png" alt="修改" title="修改" /></a>
							<a href="UserDeleteServlet?username=${user.userName}" class="removeUser"><img src="image/schu.png" alt="删除" title="删除"/></a>
						</td>
					</tr>

				</c:forEach>
				<tr>
					<td colspan="4">总共${pageCounts}页,当前是第${page}页。 
						<c:if test="${page!=1}">
							<a href="UserListServlet?diPage=1">首页</a>
							<a href="UserListServlet?diPage=${page-1}">上一页</a>
						</c:if> 
						<c:if test="${page!=pageCounts}">
							<a href="UserListServlet?diPage=${page+1}">下一页</a>
							<a href="UserListServlet?diPage=${pageCounts}">尾页</a>
						</c:if>
					</td>
				</tr>
			</table>
		</div>
	</section>

	<!--点击删除按钮后弹出的页面-->
	<div class="zhezhao"></div>
	<div class="remove" id="removeUse">
		<div class="removerChid">
			<h2>提示</h2>
			<div class="removeMain">
				<p>你确定要删除该用户吗？</p>
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