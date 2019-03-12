<%@ page import="com.bean.Goods" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/22
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="author" content="order by dede58.com"/>
  <title>小米商城</title>
  <link rel="stylesheet" type="text/css" href="./css/style.css">
  <script type="text/javascript" src="js/Ajax.js"></script>
</head>
<body>
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
        <li><a href="backlogin.jsp">后台入口</a></li>
        <div class="clear"></div>
      </ul>
    </div>
    <div class="right fr">
      <div class="gouwuche fr"><a href="CartsJump">购物车</a></div>
      <div class="fr">
        <ul>
          <c:if test="${empty username}">
          <li><a href="login.jsp">登录</a></li>
          </c:if>
          <c:if test="${!empty username}">
            <li><span id="username">${username}</span></li>
            <li><a href="LoginOut" id="loginAndOut">注销</a></li>
          </c:if>
          <li>|</li>
          <li><a href="register.jsp">注册</a></li>
          <li>|</li>
          <c:if test="${!empty username}">
          <li><a href="ShowSelfInfo">个人中心</a></li>
          </c:if>
          <c:if test="${empty username}">
            <li><a href="">消息中心</a></li>
          </c:if>
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
      <li><a href="./liebiao.html" target="_blank">小米手机</a></li>
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

<!-- start banner_y -->
<div class="banner_y center">
  <div class="nav">
    <ul>
      <li  onmouseover="user(this)" onmouseout="unuser(this)">
        <a href="">手机</a>
        <a href="">电话卡</a>
        <div class="pop">
          <div class="left fl"><%--显示信息在Ajax里面--%></div>
          <div class="ctn fl"><%--显示信息在Ajax里面--%></div>
          <div class="right fl"><%--显示信息在Ajax里面--%></div>
          <div class="clear"></div>
        </div>
      </li>
      <li onmouseover="user(this)">
        <a href="">笔记本</a>
        <a href="">平板</a>
        <div class="pop">
          <div class="left fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="ctn fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="right fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="clear"></div>
        </div>
      </li>
      <li>
        <a href="">电视</a>
        <a href="">盒子</a>
        <div class="pop">
          <div class="left fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="ctn fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="right fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="clear"></div>
        </div>
      </li>
      <li>
        <a href="">路由器</a>
        <a href="">智能硬件</a>
        <div class="pop">
          <div class="left fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="ctn fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="right fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="clear"></div>
        </div>
      </li>
      <li>
        <a href="">移动电源</a>
        <a href="">电池</a>
        <a href="">插线板</a>
        <div class="pop">
          <div class="left fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="ctn fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="right fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="clear"></div>
        </div>
      </li>
      <li>
        <a href="">耳机</a>
        <a href="">音箱</a>
        <div class="pop">
          <div class="left fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="ctn fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="right fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="clear"></div>
        </div>
      </li>
      <li>
        <a href="">保护套</a>
        <a href="">贴膜</a>
        <div class="pop">
          <div class="left fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="ctn fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="clear"></div>
        </div>
      </li>
      <li>
        <a href="">线材</a>
        <a href="">支架</a>
        <a href="">储存卡</a>
        <div class="pop">
          <div class="left fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="ctn fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="clear"></div>
        </div>
      </li>
      <li>
        <a href="">箱包</a>
        <a href="">服饰</a>
        <a href="">鞋</a>
        <a href="">眼镜</a>
        <div class="pop">
          <div class="left fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="ctn fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="clear"></div>
        </div>
      </li>
      <li>
        <a href="">米兔</a>
        <a href="">生活周边</a>
        <div class="pop">
          <div class="left fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="ctn fl">
            <%--信息在Ajax里面添加--%>
          </div>
          <div class="clear"></div>
        </div>
      </li>
    </ul>
  </div>

</div>

<div class="sub_banner center" id="indexdown">
  <div class="sidebar fl">
    <div class="fl"><a href=""><img src="./image/hjh_01.gif"></a></div>
    <div class="fl"><a href=""><img src="./image/hjh_02.gif"></a></div>
    <div class="fl"><a href=""><img src="./image/hjh_03.gif"></a></div>
    <div class="fl"><a href=""><img src="./image/hjh_04.gif"></a></div>
    <div class="fl"><a href=""><img src="./image/hjh_05.gif"></a></div>
    <div class="fl"><a href=""><img src="./image/hjh_06.gif"></a></div>
    <div class="clear"></div>
  </div>
</div>
<!-- end banner -->
<div class="tlinks">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>

<!-- start danpin -->
<div class="danpin center">

  <div class="biaoti center">小米明星单品</div>
  <div class="main center" id="mainCenter">
    <%--数据在Ajax中返回--%>
  </div>
</div>
<div class="peijian w">
  <div class="biaoti center">配件</div>
  <div class="main center">
    <div class="content">
      <div class="remen fl"><a href=""><img src="./image/peijian1.jpg"></a></div>
      <div id="content"></div>
    </div>
    <div class="content">
      <div class="remen fl"><a href=""><img src="./image/peijian6.png"></a></div>
      <div id="content2"></div>
      <div class="remenlast fr" style="margin-right: 11px">
        <div class="hongmi"><a href=""><img src="./image/hongmin4.png" alt=""></a></div>
        <div class="liulangengduo"><a href=""><img src="./image/liulangengduo.png" alt=""></a></div>
      </div>
      <div class="clear"></div>
    </div>
  </div>
  </div>
<footer class="mt20 center">
  <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
  <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
  <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>
</body>
</html>
