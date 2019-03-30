<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/24
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body background="img/2.jpeg" style="overflow: hidden;background-repeat: no-repeat;background-size: cover">
    <%!

    %>
    <%
        List<Student> list = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载驱动
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/up1","root","root");//连接数据库
            String sql = "select * from stu";//声明sql语句
            PreparedStatement ps = conn.prepareStatement(sql);//预编译sql语句
            ResultSet rs = ps.executeQuery();//执行sql语句，获得结果集
            while(rs.next()){
                Student stu = new Student();
                stu.setId(rs.getInt("id"));
                stu.setName(rs.getString("name"));
                stu.setAge(rs.getInt("age"));
                stu.setClazz(rs.getString("class"));
                stu.setMajor(rs.getString("major"));
                stu.setImage(rs.getString("image"));
                list.add(stu);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    %>
        <div align="right">
        <h3>欢迎<label name="name"></label>来到学生管理系统</h3>
            <a href="index.html">登录</a>&nbsp;&nbsp;&nbsp;<a href="register.html">注册</a>
        </div>
        <form action="register.html" method="post">
        <table align="center" border="1px" cellspacing="0px" width="800px" height=140px">
        <caption><h2>学生信息表</h2></caption>
        <tr align="right">
        <td colspan="6"><input type="button" value="添加学生"></td>
        </tr>
        <tr align="center">
        <td colspan="6" align="right"><input type="text" placeholder="请输入">&nbsp;&nbsp;<input type="button" value="搜索"></td>
        </tr>
        <tr align="center">
        <td>编号</td><td>姓名</td><td>年龄</td><td>专业</td><td>照片</td><td>操作</td>
        </tr>
        <%
        for (Student s:list){
            %>
            <tr align="center"><td><%=s.getId()%>
            </td><td><%=s.getName()%>
            </td><td><%=s.getAge()%>
            </td><td><%=s.getMajor()%>
            </td><td>
                <img src=<%=s.getImage()%> width="100px" height="100px">
            </td>
            <td><input type="button" value="修改">&nbsp;&nbsp;&nbsp;<input type="button" value="删除"></td>
            </tr>
    <%
        }
    %>
        </table>
        </form>
</body>
</html>
