<%@page import="com.yzx.entity.UserBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<!-- 获取路径 -->
	<%String path=request.getContextPath();%>
<% UserBean user = (UserBean) request.getSession().getAttribute("adminuser"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script type="text/javascript" src="js/jquery-1.9.0.js"></script>
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<style type="text/css">
input{border: 1px solid grey;}
</style>

</head>
<body>
<center>
	<form action="<%=path %>/admin" method="post"  onclick="return tiao()">
	<input type="hidden" value="alter" name="method" >
	<input value="<%=user.getUserPassword() %>" type="hidden" id="a">
		<table align="center">
			<tr>
				<td>原&nbsp密&nbsp码 ：&nbsp<input type="text" id="oldPassword" maxlength="20" name="oldPassword"></td>
				<td class="oldPassword1" style=" font-size: 12px"></td>
			</tr>
			<tr>
				<td>新&nbsp密&nbsp码 ：&nbsp<input type="password" id="newPasswrd" maxlength="20" name="newPassword"></td>
				<td class="newPasswrd1" style=" font-size: 12px"></td>
			</tr>
			<tr>
				<td>确认密码&nbsp：&nbsp<input type="password" id="newPassword2" maxlength="20" name="new2Password"></td>
				<td class="newPasswrd3" style="font-size: 12px"></td>
			</tr>

			<tr>
				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit">&nbsp&nbsp&nbsp&nbsp <input type="button" id="re" value="重置">

				</td>
			</tr>

		</table>
	
	</form>
	</center>
</body>
<script type="text/javascript">


//重置
$("#re").click(function (){
	$(".oldPassword1").html("");
	$(".newPasswrd1").html("");
	$(".newPasswrd3").html("");
	$("#oldPassword").val("");
	$("#newPasswrd").val("");
	$("#newPassword2").val("");
});
//提交  
function tiao() {
	if(x1==true&&x2==true&&x3==true){
		return true;
	}else{
		return false;
	}
}


//旧密码 
	var x1 = false;
	$("#oldPassword").blur(function() {
		var x = $("#oldPassword").val();
		var x9=$("#a").val();
		if (x == "") {
			$(".oldPassword1").css('color', '#FF0000');
			$(".oldPassword1").html("密码不能为空");
			x1 = false;
		} else if(x==x9){
				$(".oldPassword1").css('color', '#00CC00');
				$(".oldPassword1").html("密码正确");
				x1 = true;
			}else{
				$(".oldPassword1").css('color', '#FF0000');
				$(".oldPassword1").html("密码错误");
				x1 = false;
			}
		
	});
//	新密码 
	var x2 = false;
	$("#newPasswrd").blur(function() {
		var x = $("#newPasswrd").val();

		var re = /^[a-z][a-zA-Z0-9]{3,11}$/;
		var result = re.test(x);
		if (x == "") {
			
			$(".newPasswrd1").css('color', '#FF0000');
			$(".newPasswrd1").html("密码不能为空");
			x2 = false;

		} else {
			if (result == false) {
				$(".newPasswrd1").html("支持字母数字下划线组合,6-20字符 如abc123");
				$(".newPasswrd1").css('color', '#FF0000');
				x2 = false;
			} else {
				$(".newPasswrd1").css('color', '#00CC00');
				$(".newPasswrd1").html("密码格式正确");
				x2 = true;
			}
		}
	});
	//确认新密码 
	var x3 = false;
	$("#newPassword2").blur(function() {
		var x = $("#newPassword2").val();
		var x8 = $("#newPasswrd").val();
		var re = /^[a-z][a-zA-Z0-9]{3,11}$/;
		var result = re.test(x);
		if (x == "") {
			
			$(".newPasswrd3").css('color', '#FF0000');
			$(".newPasswrd3").html("密码不能为空");
			x3 = false;
		} else {
			if (result == false) {
				$(".newPasswrd3").html("支持字母数字下划线组合,6-20字符 如abc123");
				$(".newPasswrd3").css('color', '#FF0000');
				x3 = false;
			} else if(x==x8){
				$(".newPasswrd3").css('color', '#00CC00');
				$(".newPasswrd3").html("密码正确");
				x3 = true;
			}else{
				$(".newPasswrd3").html("与上次密码不一致");
				$(".newPasswrd3").css('color', '#FF0000');
				x3 = false;
			}
		}
	});
</script>
</html>