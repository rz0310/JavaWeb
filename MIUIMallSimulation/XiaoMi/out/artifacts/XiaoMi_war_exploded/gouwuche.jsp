<%@ page import="com.bean.Goods" %>
<%@ page import="java.util.*" %>
<%@ page import="com.bean.Carts" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/22
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>我的购物车-小米商城</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <script src="js/gouwuche.js"></script>
</head>
<body>
<%
    HashMap<Carts, Integer> goodsHashMap = (HashMap<Carts, Integer>) session.getAttribute("goodsHashMap");
    int num = 0;
%>
<!-- start header -->
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">
    <a href="./index.html" target="_blank"><div class="logo fl"></div></a>

    <div class="wdgwc fl ml40">我的购物车</div>
    <div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
    <div class="dlzc fr">
        <ul>
            <li><a href="./login.html" target="_blank">登录</a></li>
            <li>|</li>
            <li><a href="./register.html" target="_blank">注册</a></li>
        </ul>

    </div>
    <div class="clear"></div>
</div>
<div class="xiantiao"></div>
<div class="gwcxqbj">
    <div class="gwcxd center">
        <div class="top2 center">
            <div class="sub_top fl">
                <input type="checkbox" value="quanxuan" class="quanxuan" id="quanxuan" onclick="checkAll(this)"/>全选
            </div><div class="sub_top fl">商品名称</div>
            <div class="sub_top fl">单价</div>
            <div class="sub_top fl">数量</div>
            <div class="sub_top fl">小计</div>
            <div class="sub_top fr">操作</div>
            <div class="clear"></div>
        </div>
        <%
            Set<Carts> CartsList = goodsHashMap.keySet();
            Collection<Integer> values = goodsHashMap.values();
            for(Carts carts:CartsList){
                num += carts.getNum();
        %>
        <div class="content2 center">
            <div class="sub_content fl ">
                <input type="checkbox" value="quanxuan" class="quanxuan" name="check" onclick="check(this)"/>
            </div>
                <div class="sub_content fl"><img src="./image/gwc_xiaomi6.jpg"></div>
                <div class="sub_content fl ft20"><%=carts.getName()+" "+carts.getVersion()+" "+carts.getColor()%></div>
                <div class="sub_content fl " id="unitPrice"><span><%=carts.getPrice()%></span></div>
                <div class="sub_content fl">
                    <input class="shuliang" type="number" value="<%=carts.getNum()%>" step="1" min="1" max="10000" id="num" name="changeGoodsNum" onchange="changeGoodsNumber(this)">
                </div>
                <div class="sub_content fl" id="xiaojiPrice"><span id="price" ><%=carts.getPrice()%></span></div>
                <div class="sub_content fl"><a href=<%="DeleteCartGoods?id="+carts.getId()%>>×</a></div>
                <div class="clear"></div>
        </div>
        <%
            }
        %>
    </div>
    <div class="jiesuandan mt20 center">
        <div class="tishi fl ml20">
            <ul>
                <li><a href="index.jsp">继续购物</a></li>
                <li>|</li>
                <li>共<span id="total"><%=num%></span>件商品，已选择<span id="choose">0</span>件</li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="jiesuan fr">
            <div class="jiesuanjiage fl">合计（不含运费）：<span id="totalPrice">0.00元</span></div>
            <div class="jsanniu fr"><a href="paid.jsp"><input class="jsan" type="submit" name="jiesuan" value="去结算"/></a></div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
    <footer class="center">

        <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
        <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
        <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
    </footer>
</div>
<!-- footer -->

</body>
</html>
