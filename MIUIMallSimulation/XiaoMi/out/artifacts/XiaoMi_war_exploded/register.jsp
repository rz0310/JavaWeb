<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>用户注册</title>
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<script type="text/javascript" src="js/registerJS.js"></script>
	</head>
	<body>
		<form  method="post" action="RegistServlet" name="regist" onsubmit="return onblur1()"> 
		<div class="regist">
			<div class="regist_center">
				<div class="regist_top">
					<div class="left fl">会员注册</div>
					<div class="right fr"><a href="./index.html" target="_self">小米商城</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="regist_main center">
					<div class="username" id="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input class="shurukuang" type="text" onblur="onblur1()" onfocus="onfocus1()" name="username" placeholder="请输入你的用户名"/><span id="space1" style="color: red">请不要输入汉字</span></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="shurukuang" type="password" onblur="onblur2()" name="password" placeholder="请输入你的密码"/><span id="space2" style="color: red">请输入6位以上字符</span></div>
					
					<div class="username">确认密码:&nbsp;&nbsp;<input class="shurukuang" type="password" onblur="onblur3()" name="repassword" placeholder="请确认你的密码"/><span id="space3" style="color: red">两次密码要输入一致哦</span></div>
					<div class="username">手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;<input class="shurukuang" type="text" onblur="onblur4()" name="tel" placeholder="请填写正确的手机号"/><span id="space4" style="color: red">填写下手机号吧，方便我们联系您！</span></div>
					<div class="username">
						<div class="left fl">验&nbsp;&nbsp;证&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="yanzhengma" type="text" onblur="onblur5()" name="yanzhengma" placeholder="请输入验证码"/></div>
						<div class="right fl"><img src="./image/yanzhengma.jpg"></div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="regist_submit">
				   
					<input class="submit" type="submit" name="submit" value="立即注册"><br>
					<span class="tishi2"><font color="red" size="3">${error }</font></span>
				</div>
				
			</div>
		</div>
		</form>
	</body>
</html>