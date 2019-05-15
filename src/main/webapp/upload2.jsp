<%--
  Created by IntelliJ IDEA.
  User: zhoukiller
  Date: 2019/5/15
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--多个文件上传--%>
<form action="${ctx}/file/upload2" method="post" enctype="multipart/form-data">
    文件 <input type="file" name="file" multiple="multiple"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
