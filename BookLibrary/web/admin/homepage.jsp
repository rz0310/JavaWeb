<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书管理系统主页</title>
<script type="text/javascript">
	window.onload = function() {
		function $(id) {
			return document.getElementById(id)
		}
		var menu = $("topTags").getElementsByTagName("ul")[0];//顶部菜单容器
		var tags = menu.getElementsByTagName("li");//顶部菜单
		var ck = $("leftMenu").getElementsByTagName("ul")[0]
				.getElementsByTagName("li");//左侧菜单
		var j;
		//点击左侧菜单增加新标签
		for (i = 0; i < ck.length; i++) {
			ck[i].onclick = function() {
				$("welcome").style.display = "none"//欢迎内容隐藏
				clearMenu();
				this.style.background = 'url(admin/image/f1_03.gif)'
				//循环取得当前索引
				for (j = 0; j < 8; j++) {
					if (this == ck[j]) {
						if ($("p" + j) == null) {
							openNew(j, this.innerHTML);//设置标签显示文字
						}
						clearStyle();
						$("p" + j).style.background = 'url(admin/image/tabbg1.gif)';
						$("p" + j).style.color = '#000000';
						clearContent();
						$("c" + j).style.display = "block";
					}
				}
				return false;
			}
		}
		//增加或删除标签
		function openNew(id, name) {
			var tagMenu = document.createElement("li");
			tagMenu.id = "p" + id;
			tagMenu.innerHTML = name
					+ ""
					+ "<img src='admin/image/off.gif' style='vertical-align:middle'/>";
			//标签点击事件
			tagMenu.onclick = function(evt) {
				clearMenu();
				ck[id].style.background = 'url(admin/image/f1_03.gif)'
				clearStyle();
				tagMenu.style.background = 'url(admin/image/tabbg1.gif)';
				tagMenu.style.color = '#000000';
				clearContent();
				$("c" + id).style.display = "block";
				$("c" + id).style.width = "100%";
			}
			//标签内关闭图片点击事件
			tagMenu.getElementsByTagName("img")[0].onclick = function(evt) {
				evt = (evt) ? evt : ((window.event) ? window.event : null);
				if (evt.stopPropagation) {
					evt.stopPropagation()
				} //取消opera和Safari冒泡行为;
				this.parentNode.parentNode.removeChild(tagMenu);//删除当前标签
				var color = tagMenu.style.backgroundColor;
				//设置如果关闭一个标签时，让最后一个标签得到焦点
				if (color == "#ffff00" || color == "yellow") {//区别浏览器对颜色解释
					if (tags.length - 1 >= 0) {
						clearStyle();
						tags[tags.length - 1].style.background = 'url(admin/image/tabbg1.gif)';
						clearContent();
						var cc = tags[tags.length - 1].id.split("p");
						$("c" + cc[1]).style.display = "block";
						clearMenu();
						ck[cc[1]].style.background = 'url(admin/image/tabbg1.gif)';
					} else {
						clearContent();
						clearMenu();
						$("welcome").style.display = "block"
					}
				}
			}
			menu.appendChild(tagMenu);
		}
		//清除菜单样式
		function clearMenu() {
			for (i = 0; i < ck.length; i++) {
				ck[i].style.background = 'url(admin/image/tabbg01.gif)';
			}
		}
		//清除标签样式
		function clearStyle() {
			for (i = 0; i < tags.length; i++) {
				var dTag = menu.getElementsByTagName("li")[i];
				dTag.style.background = 'url(admin/image/tabbg2.gif)';
				dTag.style.color = '#59814C';
				//alert(dTag.outerHTML);
			}
		}
		//清除内容
		function clearContent() {
			for (i = 0; i < 7; i++) {
				$("c" + i).style.display = "none";
			}
		}
	}
</script>
<style type="text/css">
<!--
* {
	margin: 0;
	padding: 0;
	border: 0;
}

ul {
	margin: 0px;
	padding: 0px;
	list-style: none;
}

body {
	margin-top: 0px;
	margin-bottom: 0px;
	background-color: #FFFFFF;
}

#top {
	height: 70px;
	width: 100%;
	background-image: url(<%=path%>/admin/image/126_f2_01.gif);
	background-repeat: repeat-x;
	background-position: bottom;
}

#top #logo {
	float: left;
	height: 50px;
	width: 168px;
	padding-top: 20px;
	padding-left: 23px;
}

#top #xx {
	float: left;
	height: 70px;
}

#top #xx #hy {
	font-size: 12px;
	height: 30px;
	color: #1D4A03;
	position: relative;
	padding-top: 11px;
}

#top #xx #hy span {
	position: absolute;
	right: 10px;
}

#top   #xx   #hy   .input1 {
	border: 1px solid #769744;
	background-image: url(<%=path%>/admin/image/inputbg_01.gif);
	background-repeat: repeat-x;
	font-size: 12px;
	color: #999999;
	height: 18px;
}

#top #xx #hy .input2 {
	position: relative;
	top: 4px;
}

#top #xx #topTags {
	height: 29px;
}

#top #xx #topTags li {
	float: left;
	font-size: 12px;
	font-weight: bold;
	color: #1D4A03;
	height: 23px;
	width: 80px;
	line-height: 24px;
	padding-top: 6px;
	padding-left: 10px;
}

#zhong {
	height: 100%;
	width: 100%;
}

#zhong #zb {
	float: left;
	height: 100%;
	width: 191px;
}

#zhong #zb #shb {
	height: 38px;
	width: 192px;
}

#zhong #zb #shb a {
	text-decoration: none;
	color: #000000;
	font-size: 12px;
	font-weight: bold;
}

.aa {
	background-image: url(<%=path%>/admin/image/xxbg_aa.gif);
	background-repeat: no-repeat;
	float: left;
	width: 50px;
	height: 28px;
	font-size: 12px;
	color: #000000;
	padding-top: 10px;
	padding-left: 45px;
	font-weight: bold;
	line-height: 20px;
}

.bb {
	background-image: url(<%=path%>/admin/image/xxbg_bb.gif);
	background-repeat: no-repeat;
	float: left;
	width: 50px;
	height: 28px;
	font-size: 12px;
	color: #000000;
	padding-top: 10px;
	padding-left: 45px;
	font-weight: bold;
	line-height: 20px;
}

.cc {
	background-image: url(<%=path%>/admin/image/xxbg_cc.gif);
	background-repeat: no-repeat;
	float: left;
	width: 51px;
	height: 28px;
	font-size: 12px;
	color: #000000;
	padding-top: 10px;
	padding-left: 45px;
	font-weight: bold;
	line-height: 20px;
}

.dd {
	background-image: url(<%=path%>/admin/image/xxbg_dd.gif);
	background-repeat: no-repeat;
	float: left;
	width: 51px;
	height: 28px;
	font-size: 12px;
	color: #000000;
	padding-top: 10px;
	padding-left: 45px;
	font-weight: bold;
	line-height: 20px;
}

#zhong #zb #sys {
	background-image: url(<%=path%>/admin/image/sysbg_01.gif);
	background-repeat: repeat-x;
	height: 27px;
	background-position: 0px -1px;
	font-size: 12px;
	font-weight: bold;
	color: #3E6444;
	padding-top: 4px;
	padding-left: 20px;
	line-height: 20px;
	border-right-width: 1px;
	border-right-style: solid;
	border-right-color: #80AB73;
}

#zhong #zb #sys2 {
	background-image: url(<%=path%>/admin/image/sysbg_01.gif);
	background-repeat: repeat-x;
	height: 27px;
	font-size: 12px;
	font-weight: bold;
	color: #3E6444;
	padding-top: 4px;
	padding-left: 20px;
	line-height: 20px;
	border-right-width: 1px;
	border-right-style: solid;
	border-right-color: #80AB73;
}

#zhong #zb #leftMenu {
	border-right-width: 1px;
	border-right-style: solid;
	border-right-color: #80AB73;
	clear: both;
}

#zhong #zb #leftMenu ul {
	margin-right: 10px;
	margin-left: 10px;
	/*background-image: url(<%=path%>/admin/image/mun_bg.gif);*/
	background-repeat: no-repeat;
	margin-top: 0px;
}

#leftMenuPic {
	position: absolute;
	clear: both;
}

#zhong #zb #leftMenu li {
	font-size: 12px;
	line-height: 31px;
	padding-left: 30px;
}

#zhong #zb #ot {
	font-size: 12px;
	padding: 10px;
	border-right-width: 1px;
	border-right-style: solid;
	border-right-color: #80AB73;
	height: 210px;
}

#zhong #zb #ot {
	font-size: 12px;
	padding: 10px;
	border-right-width: 1px;
	border-right-style: solid;
	border-right-color: #80AB73;
	height: 210px;
}

#zhong  #content {
	width: 940px;
	height: 100%;
	float: left;
	margin: auto;
	background-image: url(<%=path%>/admin/image/f2_10.gif);
	background-repeat: repeat-x;
	background-position: top;
	padding-right: 10px;
	padding-bottom: 10px;
	padding-left: 10px;
}

#zhong #content #sm {
	height: 60px;
	font-size: 14px;
	font-weight: bold;
	color: #124313;
	padding-top: 14px;
	padding-left: 10px;
}

#zhong #content #sm span {
	font-size: 12px;
	font-weight: bold;
	margin-left: 30px;
}

#zhong .content {
	width: 940px;
	height: 100%;
	display: none;
	padding: 5px;
	overflow-y: auto;
	line-height: 30px;
	background-color: #FFFFFF;
}

#zhong .content1 {
	width: 500px;
	height: 490px;
	display: block;
	padding: 5px;
	overflow-y: auto;
	line-height: 30px;
}

#footer {
	width: 100%;
	height: 26px;
	background-color: #FFFFFF;
	line-height: 20px;
	text-align: center;
	margin-top: 0;
	margin-right: auto;
	margin-bottom: 0;
	margin-left: auto;
	background-image: url(<%=path%>/admin/image/h2bg.gif);
	background-repeat: repeat-x;
}
a {
	text-decoration: none;
	color: black;
}

a:hover {
	color: #ff00cc;
}
/**/
-->
</style>
</head>

<body>
	<div id=top>
		<div id=logo>
			<img src="admin/image/126logo_tsp.gif" width="120" height="30" />
		</div>
		<div id=xx>
			<div id=hy>
			&nbsp;&nbsp;
				<font size="+1">您好，${sessionScope.adminuser.userName}</font> 
			&nbsp;&nbsp;
				<font size="+1">[</font>
				<a href="<%=path%>/admin?method=quit"><font size="+1">退出</font></a>
				<font size="+1">]</font>
			&nbsp;&nbsp;
			</div>
			<div id=topTags>
				<ul></ul>
			</div>
		</div>
	</div>
	<!---->
	<div id=zhong>
		<div id=zb>
			<div id=shb>
				<ul>
					<li class="aa" onmouseover="this.className='bb'"
						onmouseout="this.className='aa'"><a href="#">收信</a></li>
					<li class="cc" onmouseover="this.className='dd'"
						onmouseout="this.className='cc'"><a href="#">写信</a></li>
				</ul>
			</div>
			<div id=sys>
				<img src="admin/image/icon01.gif" width="11" height="6" /> 主系统设置
			</div>
			<div id=leftMenu>
				<div id="leftMenuPic">
					<img src="admin/image/mun_bg.gif" />
				</div>
				<ul>
					<li>个人资料</li>
					<li>图书管理</li>
					<li>类型管理</li>
					<li>修改密码</li>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>
			<div id=sys2>
				<img src="admin/image/icon01.gif" width="11" height="6" /> 主系统设置
			</div>
			<div id=ot>仿126风格 bg 865171</div>
		</div>
		<div id=content>
		<div id=sm>
			<font size="+2">
		<%
			String time = (String)request.getSession().getAttribute("time");
			int hour = Integer.parseInt(time.substring(0,2));
			if(hour>=6&&hour<12){
		%>
			早上好，
		<%
			}else if(hour>=12&&hour<15){
		%>
			中午好，
		<%
			}else if(hour>=15&&hour<19){
		%>
			下午好，
		<%
			}else{
		%>
			晚上好，
		<%
			}
		%>
			 ${sessionScope.adminuser.userName}
			 </font>
		</div>
			<div id=welcome class=content style="display: block;">
				<div align=center>
					<p>&nbsp;</p>
					<p>
						<strong><font size="+3">欢迎使用用户管理系统！</font></strong>
					</p>
					<p>&nbsp;</p>
				</div>
			</div>
			<div id="c0" class="content">
				<jsp:include page="change.jsp" flush="true"></jsp:include>
			</div>
			<div id="c1" class="content">
				<iframe src="admin/aa.jsp" height="400" width="940px"  frameborder="0" scrolling="no"></iframe>
			</div>
			<div id="c2" class="content">
				<iframe src="admin/bb.jsp" height="400" width="930"  frameborder="0" scrolling="no"></iframe>
			</div>
			<div id="c3" class="content">
				<jsp:include page="alterPassword.jsp"></jsp:include>
			</div>
			<div id="c4" class="content"></div>
			<div id="c5" class="content"></div>
			<div id="c6" class="content"></div>
		</div>
	</div>
</body>
</html>


