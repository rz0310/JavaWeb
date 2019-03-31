<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/jquery-1.9.0.js"></script>
<style type="text/css">
#table{
	
	font-size: large;
}
</style>
</head>
<body>
<center>
	<form action="/BookStore/admin" method="get" >
	<input type="hidden" value="update" name="method">
		<table id="table" align="center" border="1" width="40%" height="30%">
			<tr>
				<td>姓名${sessionScope.adminuser.userName}</td>
				<td><input id="name"  type="hidden" name="name"
					 value="${sessionScope.adminuser.userName}" />
					<p></p>
				</td>
			</tr>
			<tr>
				<td >账号${sessionScope.adminuser.userAccount}</td>
				<td><input type="hidden" id="account" value="${sessionScope.adminuser.userAccount}"></td>
			</tr>
			<tr>
			<c:choose>
				<c:when test="${sessionScope.adminuser.userSex.equals('男')}">
				   <td><input name="sex"  type="radio" value="男" checked="checked" />男&nbsp;
					<input name="sex"  type="radio" value="女" />女</td>
				</c:when>
				<c:otherwise>
					<td><input name="sex"  type="radio" value="男"  />男&nbsp;
					<input name="sex"  type="radio" value="女" checked="checked" />女</td>
				</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>电话<input name="phone"  id="phone" type="text"
					value="${sessionScope.adminuser.userPhone}" />
					<p></p>
				</td>
			</tr>
			<tr>
				<td>邮箱<input name="email" id="email" type="text"
					value="${sessionScope.adminuser.userEmail}" />
					<p></p>
				</td>
			</tr>
			<tr>
				<td>住址<input name="address" id="address" type="text"
					value="${sessionScope.adminuser.userAddress}" />
					<p></p>
				</td>
			</tr>
			<tr>
				<td id="return chick">核对信息</td>
				<td><input type="submit" value="确认修改"  id="update"></td>
			</tr>
		</table>
		
	</form>
</center>
</body>
<script>
function chick(){
	var a=0;
	var name = $("#name").val();
	var namereg = /^[\u4e00-\u9fa5]{2,4}$/;
	var phone = $("#phone").val();
	var phonereg = /^[0-9]{11}$/;
	var email = $("#email").val();
	var emailreg = /^[a-zA-Z0-9]{3,10}[@]{1}[q1639sin]{2,3}.[comn]{2,3}$/;
	var address = $("#address").val();
	var addressreg = /^[\u4e00-\u9fa5]{2,}省[\u4e00-\u9fa5]{2,}市[\u4e00-\u9fa5]{2,}县$/;
	if (namereg.test(name)) {
		$("#name").next().text("");
		a++;
	} else{
		$("#name").next().text("例如:马华腾").css("color", "red");
	}
	 if (phonereg.test(phone)) {
		$("#phone").next().text("");
		a++;
	} else {
		$("#phone").next().text("例如:17802973265").css("color", "red");
	}
	 if (emailreg.test(email)) {
			$("#email").next().text("");
			a++;
		} else {
			$("#email").next().text("例如:196xxxxx.@qq.com").css("color", "red");
		} 
	 if (addressreg.test(address)) {
			$("#address").next().text("");
			a++;
		} else {
			$("#address").next().text("例如:北京市朝阳区").css("color", "red");
		}
	 return a;
}	

</script>
</html>