<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
      	<!-- 引入c标签 -->
      	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      	<!-- 获取请求的路径 -->
      	<% String path = request.getContextPath(); %>
      	
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- 引入jQuery -->
<script type="text/javascript" src="js/jquery-1.9.0.js" ></script>
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>书的类型管理</title>
	<style type="text/css">
		table,tr,th
		{
			border:1px solid black;
			width:480px;
			height:10px;
			border-collapse:collapse;
		}
		.tr{
		border:1px solid black;
		height:10px;
		width:120px;
		}
		#add{
		margin-top: 0px;
		
		}
		.fen{
		width: 50px;
		text-align: center;
		}
		#df{
		margin-top: 15px;
		}
	</style>
</head>
<body>
	<center>
	<div id="fx">
	<table id="table">
		<tr class="tr">
			<th>序号</th>
			<th>类型</th>
			<th>操作</th>
		</tr>
		<c:set var="x" value="0" />
		<c:forEach items="${categoryList}" var="category">
		<c:set var="x" value="${x+1}" />
			<tr class="tr" id="tr${category.categoryId}">
				<th >${x}</th>
				<%-- <th>${category.categoryId}</th> --%>
				<th id="th${category.categoryId}">${category.categoryName}</th>
				<th>
				<a onclick="return del(${category.categoryId})">删除</a>
				&nbsp;&nbsp;&nbsp;
				<a href="/BookStore/categoryAdminServlet?method=alter&id1=${category.categoryId}&page=1" >修改</a>
				<%-- <a onclick="alter(${category.categoryId})">修改</a> --%>
				</th>
			</tr>
		</c:forEach>
	</table>
	</div>
	<!-- 分页 -->
	<div id="df">
	<input type="submit" value="上一页" onclick="up()" id="up" />
	<input type="text"  class="fen" id="nowPage" readonly="readonly" />
	<input type="submit" value="下一页" onclick="np()" id="np" />
	<input type="text" value="共${count}页" class="fen" readonly="readonly"/>
	<!-- <input type="submit" value="增加" onclick="add()" id="add" /> -->
	<a href="<%=path %>/admin/delcategory.jsp">增加</a>
	</div>
	</center>
</body>
	<script type="text/javascript">
		
		
		/* 分页的ajax */
		var p = 1;
		$("#nowPage").val(p);
		//先实现下一页
		function np() {
			$("#up").attr("disabled",false);
			if(p<${count}){
				p++;
				$("#nowPage").val(p);
			}else{
				$("#np").attr("disabled",true);
				/* alert("这是最后一页了!"); */
			}
			$.ajax({
				type:"post",
				url:"<%=path %>/categoryAdminServlet",
				data:{"method":"","page":p},
				success:function(data){
					var nestPage = "<table id='table'><tr class='tr'>"
					+"<th>序号</th>"
					+"<th>类型</th>"
					+"<th>操作</th></tr>";
					var arr = eval(data); 
					for(var i=0;i<arr.length;i++){
						nestPage +=
							"<tr class='tr' id='tr"+arr[i].categoryId+"'>"
							+"<th >"+(i+1)+"</th>"
							+"<th id='th"+arr[i].categoryId+"'>"+arr[i].categoryName+"</th><th>"
							+"<a onclick='return del("+arr[i].categoryId+")'>删除</a>&nbsp;&nbsp;&nbsp;"
							+"<a href='/BookStore/categoryAdminServlet?method=alter&id1="+arr[i].categoryId+"&page="+p+"' >修改</a>"
							/* +"<a onclick='alter("+arr[i].categoryId+")'>修改</a></th></tr>" */
					}
					nestPage += "</table>";
					$("#fx").html(nestPage);
				}
			});
		}
		
		//实现上一页
		function up() {
			$("#np").attr("disabled",false);
			if(p>1){
				p--;
				$("#nowPage").val(p);
			}else{
				$("#up").attr("disabled",true);
				/* alert("这已经是第一页了!"); */
			}
			$.ajax({
				type:"post",
				url:"<%=path %>/categoryAdminServlet",
				data:{"method":"","page":p,"up":"up"},
				success:function(data){
					var nestPage = "<table id='table'><tr class='tr'>"
						+"<th>序号</th>"
						+"<th>类型</th>"
						+"<th>操作</th></tr>";
						var arr = eval(data); 
						for(var i=0;i<arr.length;i++){
							nestPage +=
								"<tr class='tr' id='tr"+arr[i].categoryId+"'>"
								+"<th id='xuhao'>"+(i+1)+"</th>"
								+"<th id='th"+arr[i].categoryId+"'>"+arr[i].categoryName+"</th><th>"
								+"<a onclick='return del("+arr[i].categoryId+")'>删除</a>&nbsp;&nbsp;&nbsp;"
								+"<a href='/BookStore/categoryAdminServlet?method=alter&id1="+arr[i].categoryId+"&page="+p+"' >修改</a>"
								/* +"<a onclick='alter("+arr[i].categoryId+")'>修改</a></th></tr>" */
						}
						nestPage += "</table>";
						$("#fx").html(nestPage);
				}
			});
			
		}
	
		
		/* 删除类型的ajax */
		function del(id1) {
			if(confirm('您确定要删除吗？')){
				<%-- $.ajax({
					type:"post",
					url:"<%=path %>/categoryAdminServlet",
					data:{"method":"delete","id":id},
					success:function(data){
						/* 点击删除的时候，移除该行 */
						$("#tr"+id).remove();
					}
				}); --%>
				window.location.href="<%=path %>/categoryAdminServlet?method=delete&id="+id1+"";
			}else{
				return false;
			}
			
		}
		
		<%-- //增加类型的方法
		function add(){
			var name = prompt("请输入类型的名称");
			$.ajax({
				type:"post",
				url:"<%=path %>/categoryAdminServlet",
				data:{"name":name,"method":"add"},
				success:function(data){
					
					if(data==1){
						alert("您输入的类型名有误!");
					}else{
						//判断当前是否在最后一页，如果不在最后一页就提示去最后一页查看
						var x = eval(data);
						//获取到当前页
						var nowPage = $("#nowPage").val();
						//获取到总的页数
						var pageCount = ${count};
						if(nowPage == pageCount){
							$(".tr:last").after(  
									 "<tr class='tr' id='tr"+x[0].categoryId+"' >"
									 +"<th>"+x[0].categoryId+"</th>"
									+"<th>"+x[0].categoryName+"</th><th>"
									+"<a onclick='return del("+x[0].categoryId+")'>删除</a>"
									+"&nbsp;&nbsp;&nbsp;"
									+"<a onclick='alter("+x[0].categoryId+")'>修改</a>"
									+"</th></tr>"  
									 );   
						}else{
							alert("请您在最后一页查看!");
						}
					}
				}
			});
		} --%>
		
		
		
		<%-- //修改类型的方法
		function alter(id){
			/* var id = prompt("请输入你要修改的类型的编号"); */
			var name = prompt("请输入类型的名称");
			if(false){
				return false;
			}
			$.ajax({
				type:"post",
				url:"<%=path %>/categoryAdminServlet",
				data:{"id1":id,"name1":name,"method":"alter"},
				success:function(data){
					if(data==2){
						alert("您输入的类型名称有误!");
					}else{
						 var x = eval(data);
						$("#th"+id).html(x[0].categoryName); 
					}
				}
			});
			
		} --%>
		
		
		
		
	</script>


</html>














