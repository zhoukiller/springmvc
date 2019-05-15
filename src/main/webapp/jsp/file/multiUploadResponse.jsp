<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhoukiller
  Date: 2019/5/15
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <c:if test="${!empty uploadStatus}">
        <c:forEach items="${uploadStatus}" var="item">
            <div>
                ${item.key} ${item.value}。
            </div>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
