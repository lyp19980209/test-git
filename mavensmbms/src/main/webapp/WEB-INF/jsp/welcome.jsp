<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/8/28
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>欢迎</title>
</head>
<body>
<h1>学框架就学spring MVC</h1>
</body>
</html>
