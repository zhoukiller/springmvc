<%--
  Created by IntelliJ IDEA.
  User: zhoukiller
  Date: 2019/5/13
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
    请求路径一定要写/
    / 代表此时处于上下文容器中，servlet容器，即tomcat
    /项目名称/URI
--%>

<%--
    使用WebPathInitServlet，
    根据其在application Context中设定的值，
    获取当前项目的部署路径
--%>
form1
<form action="${ctx}/web/m3" method="post">
    <input type="submit" value="提交">
</form>
form2
<form action="${ctx}/web/m3" method="post">
    <input type="submit" value="提交">
</form>
form3
<form action="${ctx}/web/m6" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="提交">
</form>

form4
<form action="${ctx}/web/m7" method="post">
    <input type="hidden" name="_method" value="PUT">
    <p>姓名：</p><input type="text" name="name" /><br/>
    <p>性别：</p><input type="text" name="sex" /><br/>
    <p>年龄：</p><input type="text" name="age" /><br/>
    <input type="submit" value="提交">
</form>

</body>
</html>
