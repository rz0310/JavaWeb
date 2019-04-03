<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript">
	//跳转到注册页面
	function toRegist(){
		window.location.href = 'regist.jsp';		
	}
</script>
</head>
<body>
	<div>
		<font color="red"><%=request.getAttribute("errorMessage") %></font>
	</div>
	<form action="login" method="post">
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<td>
					用户名：
				</td>
				<td>
					<input type="text" name="userName"/>
				</td>
			</tr>
			<tr>
				<td>
					密码：
				</td>
				<td>
					<input type="password" name="password"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="提交"/>
					<input type="button" onclick="toRegist()" value="注册"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>