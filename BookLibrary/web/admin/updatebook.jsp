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

<style type="text/css">
#div1{
	width: 100%;
}

.bianhao{
	width: 40px;
}

.mingcheng{
	width: 120px;
}

.jiage{
	width: 45px;
}

.jianjie{
	width: 130px;
}

.shijian{
width: 110px;
}

.zuozhe{
width: 80px;
}

.leixing{
width: 50px;
}

.zhuangtai{
width: 70px;
}

.bianji{
width: 50px;
}

.jia{
width: *;
}
</style>
</head>
<body>
<div align="left">
	<form action="<%=request.getContextPath()%>/bookManage">
	<input placeholder="请输入书名" name="bookName">
	<input value="mohu" name="Method" hidden>
	<input type="submit" value="查询">
	</form>
</div>
<div id="div1">
<table  border="1">
	<tr>
		<th class="bianhao">编号</th>
		<th class="mingcheng">名称</th>
		<th class="jiage">价格</th>
		<th class="jianjie">简介</th>
		<th class="shijian">时间</th>
		<th class="zuozhe">作者</th>
		<th class="leixing">类型</th>
		<th class="zhuangtai">状态</th>
		
		<th class="bianji">编辑</th>
		<th class="jia">上、下架</th>
	</tr>
<c:forEach var="book" items="${list}">
	<tr align="center" >
		<td class="bianhao">${book.bookId}</td>
		<td class="mingcheng">${book.bookName}</td>
		<td class="jiage">${book.bookPrice}</td>
		<td class="jianjie">${book.bookSynopsis}</td>
		<td class="shijian">${book.bookTime}</td>
		<td class="zuozhe">${book.bookAuthor}</td>
		<td class="leixing">${book.categoryName}</td>
		<td class="zhuangtai" id="zhuangtai${book.bookId}">${book.bookIsDeleteString}</td>
		
		<td class="bianji" ><a href="<%=request.getContextPath()%>/bookManage?Method=up&bookId=${book.bookId}&dangqian=${pageInt}" >编辑</a></td>
		<c:if test="${book.bookIsDelete==0}">
			<td class="jia" id="jia${book.bookId}" onclick="jia(${book.bookId})">下架</td>
		</c:if>
		<c:if test="${book.bookIsDelete==1}">
			<td class="jia" id="jia${book.bookId}" onclick="jia(${book.bookId})">上架</td>
		</c:if>
	</tr>
</c:forEach>


</table>
</div>
<button onclick="huan(0)">上一页</button>
<input id="in2"  value="${sumPage}" hidden>
<c:forEach var="pages" items="${pages}" varStatus="index">
<c:if test="${pages==pageInt}">
	<span id="${pages}" class="pa1" onclick="huan(this.id)" style="color: red;">&nbsp;${pages}&nbsp;</span>
</c:if>
<c:if test="${pages!=pageInt}">
	<span id="${pages}" class="pa1" onclick="huan(this.id)">&nbsp;${pages}&nbsp;</span>
</c:if>
</c:forEach>
<button onclick="huan(-1)">下一页</button>
<span>共${sumPage}页&nbsp;前往</span>
<select id="in1"  style="width: 40px" name="dangqian"  onchange="tiao(value)">
<c:forEach var="pages" items="${pages}" varStatus="index">
	<c:if test="${pageInt==pages}">
		<option selected = "selected">${pages}</option>
	</c:if>
	<c:if test="${pageInt!=pages}">
		<option>${pages}</option>
	</c:if>
</c:forEach>
</select>
<span>页&nbsp;&nbsp;&nbsp;&nbsp;</span>

<button ><a href="/BookStore/admin/addbook.jsp">增加图书</a></button>

</body>

<script type="text/javascript">



function jia(id) {
	
	$.ajax({
		type:"post",
		url:"<%=request.getContextPath()%>/bookManage",
		data:{"Method":"jia","bookId":id},
		success:function(data){
			if(data==0){
				$("#jia"+id).html("上架");
				$("#zhuangtai"+id).html("已下架");
			}else{
				$("#jia"+id).html("下架");
				$("#zhuangtai"+id).html("已上架");
			}
		}
	});
}


function tiao(up) {
	if(up<1){
		up=1;
		alert("页码最小为1");
	}else if(up>$("#in2").val()){
		up=$("#in2").val();
		alert("页码最大为"+up);
	}
	huan(up);
}
function huan(up) {
	
	if(up==0){
		var x1=$("#in1").val()-1;
		if(x1<1){
			x1=1;
			}
	}else if(up==-1){
			var x1=$("#in1").val()-1+2;
			if(x1>$("#in2").val()){
				x1=$("#in2").val();
				}
		}else {
				var x1=up;
			}
		$("#in1").val(x1);
		$(".pa1").css("color","black");
		$("#"+x1).css("color","red");
		$.ajax({
			type:"post",
			url:"<%=request.getContextPath()%>/bookManage",
			data:{"Method":"change","page":x1},
			success:function(data){
				var html = "";
				var arr = eval(data);
					for(var i=0;i<arr.length;i++){
						html +="	<tr align='center' ><td class='bianhao'>"+arr[i].bookId+"</td>"+
						"<td class='mingcheng'>"+arr[i].bookName+"</td><td class='jiage'>"+arr[i].bookPrice+"</td>"+
						"<td class='jianjie'>"+arr[i].bookSynopsis+"</td><td class='shijian'>"+arr[i].bookTime+"</td>"+
						"<td class='zuozhe'>"+arr[i].bookAuthor+"</td><td class='leixing'>"+arr[i].categoryName+"</td>"+
						"<td class='zhuangtai' id='zhuangtai"+arr[i].bookId+"'>"+arr[i].bookIsDeleteString+"</td>"+
						"<td class='bianji' ><a href='<%=request.getContextPath()%>/bookManage?Method=up&dangqian="+x1+"&bookId="+arr[i].bookId+"'>编辑</a></td>";
						if(arr[i].bookIsDelete==0){
							html +="<td class='jia' id='jia"+arr[i].bookId+"' onclick='jia("+arr[i].bookId+")'>下架</td></tr>";
						}else{
							html +="<td class='jia' id='jia"+arr[i].bookId+"' onclick='jia("+arr[i].bookId+")'>上架</td></tr>";
						}
					}
					html="<table  border='1'><tr><th class='bianhao'>编号</th>"+
					"<th class='mingcheng'>名称</th><th class='jiage'>价格</th>"+
					"<th class='jianjie'>简介</th><th class='shijian'>时间</th>"+
						"<th class='zuozhe'>作者</th><th class='leixing'>类型</th>"+
						"<th class='zhuangtai'>状态</th>"+
						"<th class='bianji'>编辑</th><th class='jia'>上、下架</th>"+
					"</tr>"+html+"</table>";
				$("#div1").html(html);
				sheng();
			}
		});
}
	


$(document).ready(function(){
	//限制字符个数
	sheng();
});
function sheng() {
	$(".mingcheng").each(function(){
		var maxwidth=6;
		if($(this).text().length>maxwidth){
			$(this).text($(this).text().substring(0,maxwidth));
			$(this).html($(this).html()+"...");
		}
	});
	$(".jianjie").each(function(){
		var maxwidth=6;
		if($(this).text().length>maxwidth){
			$(this).text($(this).text().substring(0,maxwidth));
			$(this).html($(this).html()+"...");
		}
	});
	$(".zuozhe").each(function(){
		var maxwidth=4;
		if($(this).text().length>maxwidth){
			$(this).text($(this).text().substring(0,maxwidth));
			$(this).html($(this).html()+"...");
		}
	});
	$(".tupian").each(function(){
		var maxwidth=8;
		if($(this).text().length>maxwidth){
			$(this).text($(this).text().substring(0,maxwidth));
			$(this).html($(this).html()+"...");
		}
	});
	$(".leixing").each(function(){
		var maxwidth=3;
		if($(this).text().length>maxwidth){
			$(this).text($(this).text().substring(0,maxwidth));
			$(this).html($(this).html()+"...");
		}
	});
}

</script>
</html>