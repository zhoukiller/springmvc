<%--
  Created by IntelliJ IDEA.
  User: zhoukiller
  Date: 2019/5/14
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${ctx}/user/put" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="text" name="name">
    <input type="password" name="password">
    <input type="date" name="birth">
    <input type="submit" value="提交">
</form>
</body>
</html>
