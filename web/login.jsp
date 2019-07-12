<%--
  Created by IntelliJ IDEA.
  User: cy
  Date: 2019/5/9
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="/UserServlet" method="post">
        <input type="hidden" name="oper" value="login" />
        账号：<input type="text" name="uname" placeholder="账号"/>
        密码：<input type="text" name="pwd" placeholder="密码"/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
