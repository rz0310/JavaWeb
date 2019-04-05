<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/21
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <script>
        // window.onload=function(){
        //     document.getElementById("hello").innerHTML="拜拜";
        // }
        // function change(id) {
        //     id.innerHTML="拜拜";
        // }
        function loadXMLdoc() {
            //创建Ajax对象
            var xmlhttp;
            //判断浏览器是否含有XMLHttpRequest对象，如果没有则为老版本ie
            if(window.XMLHttpRequest){
                xmlhttp = new XMLHttpRequest();
            }else{
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            // alert(xmlhttp);
            //open(参数一：(请求方式method：post或者get),参数二：(url:文件在服务器上的位置),参数三：(async：true（异步）或 false（同步）)
            // xmlhttp.open("get","txt/show.txt",true);
            xmlhttp.open("get","ServletImg",true);
            xmlhttp.send();//将请求发送到服务器，仅用于post请求
            xmlhttp.onreadystatechange=function () {
                if(xmlhttp.readyState == 4&&xmlhttp.status == 200){
                    // xmlhttp.responseText:获得字符串形式的响应数据
                    //xmlhttp.responseHTML:获得XML形式的响应数据
                    document.getElementById("img").src = xmlhttp.responseText;
                }
            }
        }
        function file() {
        //    创建Ajax对象
            var xmlhttp;
        //    判断浏览器版本
            if(window.XMLHttpRequest){
              xmlhttp = new XMLHttpRequest();
            }else{
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            //设置请求方式以及请求的url，然后发送请求
            xmlhttp.open("get","ServletFile",true);
            xmlhttp.send();
            //显示数据
            xmlhttp.onreadystatechange=function () {
                if(xmlhttp.readyState==4&&xmlhttp.status==200){
                    document.getElementById("hello").innerText = xmlhttp.responseText;
                }
            }
        }
    </script>
    <h1 id="hello" onclick="file()">hello</h1>
  <img src="img/1.jpg" alt="未找到" id="img" width="50%" height="60%">
  <h1 onclick="loadXMLdoc()">更换图片</h1>
  </body>
</html>
