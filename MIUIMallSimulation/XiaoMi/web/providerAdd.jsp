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
        <a href="login.jsp">退出</a>
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
            <span>商品管理页面 >> 商品添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="ProviderAddServlet" method="post" enctype="multipart/form-data">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="name">商品名称：</label>
                    <input type="text" name="name" id="name"/>
                    <span >*请输入商品名称</span>
                </div>
                <div>
                    <label for="img">商品图片：</label>
                    <input type="file" name="img" id="img">
                    <span>*请上传商品图片</span>

                </div>
                <div>
                    <label for="goodsPrice">商品单价：</label>
                    <input type="text" name="price" id="goodsPrice"/>
                    <span>*请输入商品单价</span>
                </div>
                <div>
                    <label for="num">库存数量：</label>
                    <input type="text" name="num" id="num"/>
                    <span>*请输入商品库存数量</span>
                </div>
                <div>
                    <label for="desc">商品详情：</label>
                    <input type="text" name="desc" id="desc"/>
                    <span>*请输入商品详情</span>
                </div>
                <div>
                    <label for="version">商品版本：</label>
                    <input type="text" name="version" id="version"/>
                    <span>*请输入商品版本</span>
                </div>
                <div>
                    <label for="color">商品颜色：</label>
                    <input type="text" name="color" id="color"/>
                    <span>*请输入商品颜色</span>
                </div>
                <div>
                    <label for="type">商品类型：</label>
                    <input type="text" name="type" id="type"/>
                    <span>*请输入商品类型</span>
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