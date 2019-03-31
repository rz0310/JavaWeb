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
	<center>

	<form action="<%=request.getContextPath()%>/bookManage">
		名称：<input  name="bookName" /><br>
		价格：<input  name="bookPrice"/><br>
		简介：<input  name="bookSynopsis"/><br>
		时间：<input  name="bookTime"/><br>
		作者：<input  name="bookAuthor"/><br>
		类型：<input  name="categoryName"/><br>
		图片：<input  name="bookImage"/><br>
		<input value="add" name="Method" hidden/><br>
	<input type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" onclick="javascript:window.history.go(-1);" value="返回">
	</form>

</center>
</body>


</html>