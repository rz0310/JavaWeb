<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bean.Goods" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/22
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>小米6立即购买-小米商城</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <script src="js/xiangqing.js"></script>
</head>
<body>
<%
    ArrayList<Goods> goodsList = (ArrayList<Goods>) session.getAttribute("goodsList");
    ArrayList<Goods> goodsList2 = new ArrayList<>();
    for (Goods goods : goodsList) {
        Goods goods1 = new Goods();
        goods1.setVersion(goods.getVersion());
        goods1.setPrice(goods.getPrice());
        goodsList2.add(goods1);
    }
%>
<!-- start header -->
<header>
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="http://www.mi.com/" target="_blank">小米商城</a></li>
                <li>|</li>
                <li><a href="">MIUI</a></li>
                <li>|</li>
                <li><a href="">米聊</a></li>
                <li>|</li>
                <li><a href="">游戏</a></li>
                <li>|</li>
                <li><a href="">多看阅读</a></li>
                <li>|</li>
                <li><a href="">云服务</a></li>
                <li>|</li>
                <li><a href="">金融</a></li>
                <li>|</li>
                <li><a href="">小米商城移动版</a></li>
                <li>|</li>
                <li><a href="">问题反馈</a></li>
                <li>|</li>
                <li><a href="">Select Region</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="right fr">
            <div class="gouwuche fr"><a href="gouwuche.jsp">购物车</a></div>
            <div class="fr">
                <ul>
                    <li><a href="./login.html" target="_blank">登录</a></li>
                    <li>|</li>
                    <li><a href="./register.html" target="_blank" >注册</a></li>
                    <li>|</li>
                    <li><a href="">消息通知</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</header>
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">
    <a href="./index.html" target="_blank"><div class="logo fl"></div></a>
    <a href=""><div class="ad_top fl"></div></a>
    <div class="nav fl">
        <ul>
            <li><a href="">小米手机</a></li>
            <li><a href="">红米</a></li>
            <li><a href="">平板·笔记本</a></li>
            <li><a href="">电视</a></li>
            <li><a href="">盒子·影音</a></li>
            <li><a href="">路由器</a></li>
            <li><a href="">智能硬件</a></li>
            <li><a href="">服务</a></li>
            <li><a href="">社区</a></li>
        </ul>
    </div>
    <div class="search fr">
        <form action="" method="post">
            <div class="text fl">
                <input type="text" class="shuru"  placeholder="小米6&nbsp;小米MIX现货">
            </div>
            <div class="submit fl">
                <input type="submit" class="sousuo" value="搜索"/>
            </div>
            <div class="clear"></div>
        </form>
        <div class="clear"></div>
    </div>
</div>
<!-- end banner_x -->


<!-- xiangqing -->
<form action="post" method="">
    <div class="xiangqing">
        <div class="neirong w">
            <div class="xiaomi6 fl">${phoneName}</div>
            <nav class="fr">
                <li><a href="">概述</a></li>
                <li>|</li>
                <li><a href="">变焦双摄</a></li>
                <li>|</li>
                <li><a href="">设计</a></li>
                <li>|</li>
                <li><a href="">参数</a></li>
                <li>|</li>
                <li><a href="">F码通道</a></li>
                <li>|</li>
                <li><a href="">用户评价</a></li>
                <div class="clear"></div>
            </nav>
            <div class="clear"></div>
        </div>
    </div>

    <div class="jieshao mt20 w" id="hh">
        <div class="left fl"><img src="./image/liebiao_xiaomi6.jpg"></div>
        <div class="right fr">
            <%
                for (Goods good : goodsList) {
                    %>
            <div class="h3 ml20 mt20" id="goodsName"><%=good.getName()%></div>
            <div class="jianjie mr40 ml20 mt10"><%=good.getDesc()%></div>
            <div class="jiage ml20 mt10" id="goodPrice"></div>
            <div class="ft20 ml20 mt20">选择版本</div>
            <div id="showGoodsInfo" onclick="xiaoji(this)"><div class="xzbb ml20 mt10"><form><tr><%for(Goods goods : goodsList2){%><td id="<%=goods.getId()%>"><div class="banben fl" id="goodsType" onclick="updatePrice(this)"><a><span id="goodsVersion"><%=goods.getVersion()%></span><span id="goodsPrice"><%=goods.getPrice()%>元</span></a></div></td><%}%></tr><div class="clear"></div></form></div><div class="ft20 ml20 mt20">选择颜色</div><div class="xzbb ml20 mt10"><div class="banben" onclick="updateColor(this)"><a><span class="yuandian"></span><span class="yanse" id="goodsColor"><%=good.getColor()%></span></a></div></div></div>
            <%
                    break;
                }
            %>
            <div class="xqxq mt20 ml20" id="xiaoji"><div class="top1 mt10"><div class="left1 fl"></div><div class="right1 fr"></div><div class="clear"></div></div><div class="bot mt20 ft20 ftbc" id="totalPrice">总计：0.00元</div></div>
            <div class="xiadan ml20 mt20">
                <input class="jrgwc"  type="button" name="jrgwc" value="立即选购" />
                <a id="cart" onclick="xiaoji(this)"><input class="jrgwc" type="button" name="jrgwc" value="加入购物车"/></a>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</form>
<!-- footer -->
<footer class="mt20 center">

    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>

</footer>

</body>
</html>
