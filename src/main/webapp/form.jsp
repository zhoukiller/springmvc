<%--
  Created by IntelliJ IDEA.
  User: zhoukiller
  Date: 2019/5/15
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${ctx}/json2/add" method="post">
    姓名：<input type="text" name="name"><br>
    密码：<input type="password" name="pwd"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
