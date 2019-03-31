<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
         <!-- 获取到请求的路径 -->
    	<% String path = request.getContextPath(); %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>类型修改</title>

<!-- 引入jQuery -->
<script type="text/javascript" src="js/jquery-1.9.0.js" ></script>
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>

	<style type="text/css">
		#h{
		font-family: 楷体;
		text-align: center;
				
		}
		#d{
		
		}
		input{
		margin-top: 10px;
		}
		#sp{
		color: red;
		}
	</style>
</head>
<body>
	<center>
		<div id="d">
		<h3 id="h">图书类型的修改</h3>
		
		编号：<input type="text" value="${list.categoryId}" readonly="readonly" id="id1"/>
		<br/>
	          名称：<input type="text" value="${list.categoryName}" id="name"/>
	    <br/>
		<span style="display: none" id="sp">请确认您的类型名再提交!</span>	
		<br/>	    
	  <!--   <input type="submit" value="确定" />
	    <input type="submit" value="返回" /> -->
	    <a onclick="alter()">确定</a>
	    <a onclick="back()" >返回</a>
	    <br/>
	   <input type="hidden" value="${page}" id="page"/>
	   <input type="hidden" value="${tmp}" id="tmp"/>
	    </div>
	</center>
</body>

	<script type="text/javascript">
		
		var x = $("#tmp").val();
		if(x==2){
			$("#sp").css("display","block");
		}
		/* 修改的方法 */
		function alter(){
			x = 1;
			if(x==2){
				
			}else{
				/* 获取修改的名字 */
				var n = $("#name").val();
				var i = $("#id1").val();
				var p = $("#page").val();
				window.location.href="<%=path %>/categoryAdminServlet?name2="+n+"&id1="+i+"&method=alter1&page1="+p+"";
			}
		}
		
		function back(){
			
			window.location.href="<%=path %>/categoryAdminServlet?method=";
		}
		
	</script>



</html>









