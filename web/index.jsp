<%@ page import="Pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: cy
  Date: 2019/5/9
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>

  <% if (((User)session.getAttribute("user"))!=null){
  User u = ((User)session.getAttribute("user"));
  %>
  当前用户：<%=((User)session.getAttribute("user")).getUname()%>
  <a href="exitServlet?url=index.jsp">退出登录</a>
  <%}else {%>
  未登录 <a href="login.jsp">点击登录</a><%}%>

  </body>
</html>
