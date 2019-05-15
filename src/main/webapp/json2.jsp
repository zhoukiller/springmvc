<%--
  Created by IntelliJ IDEA.
  User: zhoukiller
  Date: 2019/5/15
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${ctx}/static/plugins/jquery-3.4.1.min.js"></script>
</head>
<body>
<button id="b1">使用Ajax发送一个User对象到后台</button>
<button id="b2">使用Ajax发送一组User对象到后台</button>
<script>
    $(function () {
        $('#b1').click(function () {

            var obj = {
                'name':'叶问',
                'pwd':'456987'
            };
            //
            $.ajax({
                url:'${ctx}/json2/add',
                type: 'post',
                contentType:'application/json',
                data:JSON.stringify(obj),
                success:function (data) {

                }
            })
        });

        $('#b2').click(function () {

            var obj1 = {
                'name':'叶问',
                'pwd':'456987'
            };
            var obj2 = {
                'name':'李小龙',
                'pwd':'456987'
            };
            var array = new Array();
            array.push(obj1);
            array.push(obj2);
            //
            $.ajax({
                url:'${ctx}/json2/addList',
                type: 'post',
                contentType:'application/json',
                data:JSON.stringify(array),
                success:function (data) {
                    alert(data.status);
                }
            })
        })
    })
</script>
</body>
</html>
