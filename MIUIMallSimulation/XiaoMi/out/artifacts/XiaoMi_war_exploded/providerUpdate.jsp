<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>小米商城账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/backstyle.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>小米商城账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="login.html">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="BillListServlet?diPage=1">账单管理</a></li>
                <li id="active"><a href="ProviderListServlet?diPage=1">供应商管理</a></li>
                <li><a href="UserListServlet?diPage=1">用户管理</a></li>
                <li><a href="backlogin.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 供应商修改页</span>
        </div>
        <div class="providerAdd">
            <form action="ProviderUpdateServlet">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="providerId">商品编号：</label>
                    <input type="text" name="goodsId" id="providerId" placeholder="如：1"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="providerName">商品名称：</label>
                    <input type="text" name="goodsName" id="providerName" placeholder="如：小米9"/>
                    <span >*</span>
                </div>
                <div>
                    <label>商品图片：</label>
                    <input type="file" name="goodsImg"> 
                    <span>*</span>

                </div>
                <div>
                    <label for="phone">商品价格：</label>
                    <input type="text" name="goodsPrice" id="phone" placeholder="如：2999"/>元
                    <span></span>
                </div>
                <div>
                    <label for="address">商品库存：</label>
                    <input type="text" name="goodsNum" id="address" placeholder="如：1200"/>件
                    <span></span>

                </div>
                <div>
                    <label for="fax">商品详情：</label>
                    <input type="text" name="goodsDesc" id="fax" placeholder="如：小米9，全球首发855骁龙旗舰处理器，4800W超清摄像头"/>
                    <span></span>

                </div>
                <div>
                    <label for="describe">商品版本：</label>
                    <input type="text" name="goodsVersion" id="describe1" placeholder="如：9.0版本"/>
                    <span></span>
                </div>
                <div>
                    <label for="describe">商品颜色：</label>
                    <input type="text" name="goodsColor" id="describe2" placeholder="如：黑色"/>
                    <span></span>
                </div>
                <div>
                    <label for="describe">商品类型：</label>
                    <input type="text" name="goodsType" id="describe3" placeholder="如：手机填1，电脑填写2"/>
                    <span></span>
                </div>
                <div>
                    <label for="describe">买过的人数：</label>
                    <input type="text" name="goodsPaid" id="describe" placeholder="如：13561564"/>人
                    <span></span>
                </div>
                <h3 style="color:red">${msg}</h3>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="providerList.html">返回</a>-->
                    <input type="submit" value="保存" onclick="history.back(-1)"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>