<%@page import="javafx.scene.chart.PieChart.Data"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.9.0.js"></script>
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<title>图书管理</title>
</head>
<body>

<table align="center">
<tr>
<td>
	<img alt="${bookup.bookName}" width="172px" height="201px" src="./images/${bookup.bookImage}">
</td>
	<td>
			<form action="<%=request.getContextPath()%>/bookManage">
				名称：<input value="${bookup.bookName}" name="bookName" /><br>
				价格：<input value="${bookup.bookPrice}" name="bookPrice"/><br>
				简介：<input value="${bookup.bookSynopsis}" name="bookSynopsis"/><br>
				时间：<input value="${bookup.bookTime}" name="bookTime"/><br>
				作者：<input value="${bookup.bookAuthor}" name="bookAuthor" /><br>
				类型：<select  style="width: 173px;height: 21px;" name="categoryName">
								<c:forEach items="${categoryList}" var="category">
									<c:if test="${category.categoryName==bookup.categoryName}">
									<option value="${category.categoryName}" selected = "selected">----------- ${category.categoryName} -----------</option>
									</c:if>
									<c:if test="${category.categoryName!=bookup.categoryName}">
									<option value="${category.categoryName}">----------- ${category.categoryName} -----------</option>
									</c:if>
								</c:forEach>
							</select><br>
				图片：<input value="${bookup.bookImage}" name="bookImage"/><br>
				<input value="${bookup.bookId}" name="bookId" hidden/>
				<input value="uped" name="Method" hidden/><br>
			<input type="submit"> 
			<input type="reset" style="margin-left: 40px;margin-right: 40px;">
			<input name="dangqian" value="${pageInt}" hidden>
			<input type="button" onclick="fanhui(${pageInt})" value="返回">
			
			</form>
	
	</td>

</tr>
	
</table>

</body>
<script type="text/javascript">
function fanhui(page) {
	window.location.href="<%=request.getContextPath()%>/bookManage?Method=shouci&dangqian="+page;
}

</script>

</html>