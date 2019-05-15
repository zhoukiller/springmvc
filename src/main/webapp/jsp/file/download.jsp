<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhoukiller
  Date: 2019/5/15
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <c:forEach items="${fileList}" var="file">
        <div>
            <%--            第一种下载方式通过弹出快速弹出窗口并关闭，来下载    --%>
            下载：<button type="submit" onclick="window.open('${ctx}/download/down/${file}')">${file}</button>
            <%--            通过a标签的download属性来下载并指定文件    --%>
            Download <a href="${ctx}/download/down/${file}" download="${file}">${file}</a>
        </div>
    </c:forEach>
</div>

</body>
</html>
