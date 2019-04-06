<%@ page import="com.javabean.Goods" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/21
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <script>
      function ff(btn) {
      //      创建Ajax对象
          var xmlhttp;
          if(window.XMLHttpRequest){
              xmlhttp = new XMLHttpRequest();
          }else{
              xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
          }
          xmlhttp.open("get","Servlet?value="+btn.value,true);
          xmlhttp.send();
          xmlhttp.onreadystatechange=function () {
              if(xmlhttp.readyState==4&&xmlhttp.status==200){
                  var json = xmlhttp.responseText;
                  // alert(json);
                  var jsonObj = eval('('+json+')');//将字符串转换为json对象
                  for (var i = 0; i < jsonObj.goodsList.length; i++) {
                      var good = jsonObj.goodsList[i];
                      alert(good);
                      var str = "<tr><td>"+good+"</td><td>"+good.name+"</td><td>"+good.type+"</td><td>"+good.price+"</td><td>"+good.num+"</td></tr>";
                      alert(str);
                  }
                  document.getElementById("tab").innerHTML= str;
              }
          }
      }
  </script>
  <input type="button" value="生活用品" onclick="ff(this)">
  <input type="button" value="学习用品" onclick="ff(this)">
    <table id="tab">

    </table>
  </body>
</html>
