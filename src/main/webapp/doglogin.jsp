<%--
  Created by IntelliJ IDEA.
  User: zhoukiller
  Date: 2019/5/14
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${ctx}/dog/login" method="post">
    <input type="text" name="name">
    <input type="submit" value="提交">
</form>
</body>
</html>
