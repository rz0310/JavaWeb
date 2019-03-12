<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		<a href="login.html">退出</a>
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
			<li><a href="login.jsp">退出系统</a></li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>账单管理页面 >> 订单修改页面</span>
		</div>
		<div class="providerAdd">
			<form action="BillUpdateServlet" method="post">
				<!--div的class 为error是验证错误，ok是验证成功-->
				<div class="">
					<h3 style="color:red">${msg}</h3>
					<label for="billId">订单编码：</label> <input type="text" name="billId"
						id="billId" required /> <span>*</span>
				</div>
				<div>
					<label for="billName">商品名称：</label> <input type="text"
						name="billName" id="billName" required /> <span>*</span>
				</div>
				<div>
					<label for="billPrice">商品单价：</label> <input type="text"
						name="billPrice" id="billPrice" required /> <span>*</span>

				</div>
				<div>
					<label for="billNum">商品数量：</label> <input type="text"
						name="billNum" id="billNum" required /> <span>*</span>
				</div>
				<div>
					<label for="billMoney">总金额：</label> <input type="text" name="billMoney"
						id="billMoney" required /> <span>*</span>
				</div>
				<div>
					<label for="billDate">创建时间：</label> <input type="text" name="billDate"
						id="billDate" required /> <span>*</span>
				</div>
				<div>
					<label>是否付款：</label> <input type="radio" name="billStatus" checked
						value="未付款" />未付款 <input type="radio" name="billStatus" value="已付款" />已付款
				</div>
				<div class="providerAddBtn">
					<!--<a href="#">保存</a>-->
					<!--<a href="billList.html">返回</a>-->
					<input type="submit" value="保存"/>
					<input type="button" value="返回" />
					<!-- 
						<input type="submit" value="保存" onclick="history.back(-1)" /> <input
						type="button" value="返回" onclick="history.back(-1)" />
					 -->
				</div>
			</form>
		</div>

	</div>
	</section>
	<footer class="footer"> </footer>
	<script src="js/time.js"></script>

</body>
</html>