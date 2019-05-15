<%--
  Created by IntelliJ IDEA.
  User: zhoukiller
  Date: 2019/5/15
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${ctx}/static/plugins/jquery-3.4.1.min.js"></script>
</head>
<body>
<button id="b1">请求得到一个User</button>
<button id="b2">请求得到一个Map</button>
<button id="b3">请求得到一个数组</button>
<button id="b4">请求得到一个List</button>
<button id="b5">请求得到一个List，里面是Map，Key为String，Value为User</button>

<div>

</div>

<script>
    $(function () {
        $('#b1').click(function () {
            $.ajax({
                url:'${ctx}/json/m1',
                type: 'post',
                success:function (data) {
                    alert(data.name);
                    alert(data.pwd);
                }
            })
        })

        <%--$('#b2').click(function () {--%>
        <%--    $.ajax({--%>
        <%--        url:'${ctx}/json/m2',--%>
        <%--        type: 'post',--%>
        <%--        success:function (data) {--%>
        <%--            alert(data.name);--%>
        <%--            alert(data.age);--%>
        <%--        }--%>
        <%--    })--%>
        <%--})--%>

        $('#b2').click(function () {
            $.ajax({
                url:'${ctx}/json/m2',
                type: 'post',
                success:function (data) {
                    for (var key in data) {
                        alert(key);
                        alert(data[key]);
                    }
                }
            })
        })

        $('#b3').click(function () {
            $.ajax({
                url:'${ctx}/json/m3',
                type: 'post',
                success:function (datas) {
                    for (var i = 0; i < datas.length; i++) {
                        alert(datas[i].name);
                        alert(datas[i].pwd);
                    }
                }
            })
        })

        $('#b4').click(function () {
            $.ajax({
                url:'${ctx}/json/m4',
                type: 'post',
                success:function (datas) {
                    for (var i = 0; i < datas.length; i++) {
                        alert(datas[i].name);
                        alert(datas[i].pwd);
                    }
                }
            })
        })

        $('#b5').click(function () {
            $.ajax({
                url:'${ctx}/json/m5',
                type: 'post',
                success:function (datas) {
                    for (var i = 0; i < datas.length; i++) {
                        var listItem = datas[i];
                        for (var key in listItem) {
                            alert(key);
                            alert(listItem[key].name);
                            alert(listItem[key].pwd);
                        }
                    }
                }
            })
        })
    })
</script>
</body>
</html>
