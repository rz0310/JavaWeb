<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/16
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<%
    //        设置编码
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
%>
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

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
                <li><a href="BillListServlet">账单管理</a></li>
                <li ><a href="ProManageServlet">供应商管理</a></li>
                <li id="active"><a href="UserListServlet">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="UserUpdateServlet" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="userId">用户名称：</label>
                    <input type="text" name="userId" id="userId" placeholder="<%=request.getParameter("id")%>"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" placeholder="<%=request.getParameter("name")%>"/>
                    <span >*</span>
                </div>
            <%
                String sex = request.getParameter("sex");
                String type = request.getParameter("type");
            %>
                <div>
                    <label >用户性别：</label>
                    <select name="sex">
                        <%
                            if("男".equals(sex)){
                                %>
                        <option value="男" selected>男</option>
                        <option value="女">女</option>
                        <%
                            }else{
                                %>
                        <option value="男" name="sex">男</option>
                        <option value="女" name="sex" selected>女</option>
                        <%
                            }
                        %>

                    </select>
                </div>
                <div>
                    <label for="data">出生日期：</label>
                    <input type="text" name="birth" id="data" placeholder="<%=request.getParameter("birth")%>"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="userphone" id="userphone" placeholder="<%=request.getParameter("tel")%>"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="userAddress" id="userAddress" placeholder="<%=request.getParameter("add")%>"/>
                </div>
                <div>
                    <label >用户类别：</label>
                    <%
                        if("管理员".equals(type)){
                            %>
                    <input type="radio" name="userlei" value="管理员" checked/>管理员
                    <input type="radio" name="userlei" value="经理"/>经理
                    <input type="radio" name="userlei" value="普通用户"/>普通用户
                    <%
                        }else if("经理".equals(type)){
                            %>
                    <input type="radio" name="userlei" value="管理员"/>管理员
                    <input type="radio" name="userlei" value="经理" checked/>经理
                    <input type="radio" name="userlei" value="普通用户"/>普通用户
                    <%
                        }else{
                    %>
                    <input type="radio" name="userlei " value="管理员"/>管理员
                    <input type="radio" name="userlei" value="经理"/>经理
                    <input type="radio" name="userlei" value="普通用户" checked/>普通用户
                    <%
                        }
                    %>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
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
