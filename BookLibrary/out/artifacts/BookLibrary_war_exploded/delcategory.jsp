<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    	<!-- 获取到请求的路径 -->
    	<% String path = request.getContextPath(); %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增加类型</title>

	<!-- 引入jQuery -->
	<script type="text/javascript" src="js/jquery-1.9.0.js" ></script>
	<script type="text/javascript" src="js/jquery-1.9.0.min.js" ></script>
	
	<style type="text/css">
		#h{
		font-family: 楷体;
		}
		#sp{
		color: red;
		}
		
	</style>
	
</head>
<body>
	<center>
		<h3 id="h">增加图书类型</h3>
		<br/>
		请输入您要增加的类型:
		<input type="text" id="name" />
		<br/>
		<span style="display: none" id="sp">请确认您的类型名再提交!</span>
		<br/>
		<input type="button" value="确定" onclick="alter()" />
		<input type="button" value="返回" onclick="back()" />
		<!-- <a href="BookStore/categoryAdminServlet?method=add">确认</a>
		<a href="/BookStore/categoryAdminServlet?method=">返回</a> -->
		
		<!-- 获取到传过来的值2，此处表示要增加的名字和数据库中的名字重复了，不能进行修改 -->
		<input type="hidden" value="${tmp}" id="tmp"/>
	</center>
</body>

	<script type="text/javascript">
		pan = $("#tmp").val();
		if(pan==2){
			$("#sp").css("display","block");
		}
		function alter(){
			pan = 1;
			if(pan!=2){				
			//修改方法
			var name = $("#name").val();
			window.location.href="<%=path %>/categoryAdminServlet?method=add&addName="+name+"";
			
			}
			
		}
		
		function back(){
			window.location.href="<%=path %>/categoryAdminServlet?method=";
		}
		
		
	</script>

</html>










