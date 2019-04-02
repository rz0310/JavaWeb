<%@ page import="com.db.DBUtil" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/18
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%!
      int nowPage=1;//当前页
      int totalCount;//总数据
      int pageNum=4;//每页显示的数据量
      int totalPage;//总页数
    %>
    <%
//      获取传过来的页数
      String pageNow = request.getParameter("pageNow");
      if(pageNow==null||pageNow.equals("")){
        pageNow="1";
      }
      nowPage=Integer.parseInt(pageNow);

//      获取数据库连接
      Connection conn = DBUtil.getConn();
      String sql = "select * from user;";//声明sql语句
      PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
      ResultSet rs = ps.executeQuery();//执行sql语句
      rs.last();//将游标移动到最后一行
      totalCount = rs.getRow();//得到总的数据数

//      判断总共显示的页数
      if(totalCount%pageNum==0){
        totalPage = totalCount/pageNum;
      }else{
          totalPage = totalCount/pageNum+1;
      }
      System.out.println(totalPage);

//      根据不同的页数判断每页要显示的数据
      if((nowPage-1)*pageNum==0){//此处表示为第一页
          rs.beforeFirst();//将游标移动到第一行的前面
      }else{//否则移动到当前页面的最后一行
          rs.absolute((nowPage-1)*pageNum);
      }
    %>
  <table align="center" border="1px" cellspacing="0">
    <tr>
      <td>编号</td><td>用户名</td><td>密码</td>
    </tr>
    <%
      int count=1;//使用计数器来统计
      while(rs.next()){
        %>
    <tr>
      <td><%=rs.getInt("id")%></td>
      <td><%=rs.getString("username")%></td>
      <td><%=rs.getString("password")%></td>
    </tr>
    <%
          if(count==pageNum){
              break;
          }
        count++;
      }
    %>
    <c:if test="<%=nowPage!=1%>">
      <a href="index.jsp?pageNow=1">首页</a> <a href="index.jsp?pageNow=<%=nowPage-1%>">上一页</a>
    </c:if>
    <c:if test="<%=nowPage!=totalPage%>">
      <a href="index.jsp?pageNow=<%=nowPage+1%>">下一页</a> <a href="index.jsp?pageNow=<%=totalPage%>">末页</a>
    </c:if>
  </table>
  </body>
</html>
