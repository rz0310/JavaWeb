<%@ page import="com.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/6
  Time: 8:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>我的购物车-小米商城</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <link rel="stylesheet" type="text/css" href="./css/paid.css">
</head>
<body>
<!-- <script type="text/javascript">
    function app(div) {
        var weixin = document.getElementById("J_modalWeixinPay");
        weixin.style.display = "block";
        weixin.aria-hidden = "true";
    }
</script> -->
<!-- start header -->
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">
    <a href="index.jsp" target="_blank">
        <div class="logo fl"></div>
    </a>

    <div class="wdgwc fl ml40">我的购物车</div>
    <div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
    <div class="dlzc fr">
        <ul>
            <li><a href="./login.jsp" target="_blank">登录</a></li>
            <li>|</li>
            <li><a href="./register.jsp" target="_blank">注册</a></li>
        </ul>

    </div>
    <div class="clear"></div>
</div>
<div class="xiantiao"></div>

<div class="page-main">
    <div class="container">
        <div class="section section-order">
            <div class="order-info clearfix">
                <div class="fl">
                    <h2 class="title">订单提交成功！去付款咯～</h2>
                    <p class="order-time" id="J_deliverDesc"></p>
                    <p class="order-time">请在<span class="pay-time-tip">30分钟</span>内完成支付, 超时后将取消订单</p>
                    <p class="post-info" id="J_postInfo">
                        <%
                            User user = (User) request.getSession().getAttribute("user");
                        %>
                        收货信息：<%=user.getUserName()%> <%=user.getPhone()%> &nbsp;&nbsp;
                        <%--陕西&nbsp;&nbsp;西安市&nbsp;&nbsp;临潼区&nbsp;&nbsp;斜口街道&nbsp;&nbsp;西安工程大学 陕鼓大道58号 --%>
                        <%=user.getAddress()%>
                    </p>
                </div>
                <div class="fr">
                    <p class="total">
                        应付总额：<span class="money"><em>2499</em>元</span>
                    </p>
                    <a href="javascript:void(0);" class="show-detail" id="J_showDetail">订单详情<i class="iconfont"></span></a>
                </div>
            </div>
            <i class="iconfont icon-right">√</i>
            <!-- <div class="order-detail">
                <ul>
                    <li class="clearfix">
                        <div class="label">订单号：</div>
                        <div class="content">
                            <span class="order-num">
                                5190305756550315                                </span>
                        </div>
                    </li>
                    <li class="clearfix">
                        <div class="label">收货信息：</div>
                        <div class="content">
                        张聪 135****2521&nbsp;&nbsp;
                        陕西&nbsp;&nbsp;西安市&nbsp;&nbsp;临潼区&nbsp;&nbsp;斜口街道&nbsp;&nbsp;西安工程大学 陕鼓大道58号                            </div>
                    </li>
                    <li class="clearfix">
                        <div class="label">商品名称：</div>
                        <div class="content">
                            小米8 屏幕指纹版 6GB内存 黑色 128GB<br/>米粉卡日租卡                            </div>
                    </li>
                    <li class="clearfix hide">
                        <div class="label">配送时间：</div>
                        <div class="content">
                            不限送货时间                            </div>
                    </li>
                    <li class="clearfix">
                        <div class="label">发票信息：</div>
                        <div class="content">
                            电子发票 个人                            </div>
                    </li>
                </ul>
            </div> -->
        </div>
        <div class="payment-box ">
            <div class="cash-title" id="J_cashTitle" style="padding-left: 50px;padding-top: 50px">选择以下支付方式付款</div>
            <div class="payment-header clearfix">
                <h3 class="title" style="padding-left: 50px">支付平台</h3>
                <span class="desc"></span>
            </div>
            <div class="payment-body" style="padding-left: 50px">
                <ul class="clearfix payment-list J_paymentList J_linksign-customize">
                    <li id="J_weixin" onclick="app(this)"><img src="image/weixinpay.png" alt="微信支付"
                                                               style="margin-left: 0;"/></li>
                    <li class="J_bank"><img src="image/payOnline_zfb.png" alt="支付宝" style="margin-left: 0;"/></li>
                    <li class="J_bank"><img src="image/unionpay.png" alt="银联" style="margin-left: 0;"/></li>
                    <li class="J_bank"><img src="image/micash.png" alt="小米钱包" style="margin-left: 0;"/></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- footer -->
<footer class="center">

    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>
</body>
</html>

