<%--
  Created by IntelliJ IDEA.
  User: zhoukiller
  Date: 2019/5/15
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui-v2.4.5/layui/css/layui.css">

    <style>
        form>div {
            width: 300px;
            margin: auto;
        }
    </style>
<%--    <script type="text/javascript" src="${ctx}/static/plugins/jquery-3.4.1.min.js"></script>--%>
</head>
<body>
<form action="${ctx}/user/register" class="layui-form">
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="name" placeholder="请输入姓名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="password" name="pwd" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit lay-filter="*">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script src="${ctx}/static/plugins/layui-v2.4.5/layui/layui.js"></script>

<script>

    layui.use(['element','jquery', 'layer'], function(){
        var element = layui.element;
        var jquery, $ = layui.jquery;
        var layer = layui.layer;

        $(function () {
            $('input[name=name]').blur(function () {
                // 获取名字
                var name = $('input[name=name]').val();
                var obj = {
                    name:name
                };
                //
                $.ajax({
                    url:'${ctx}/user/checkName',
                    type: 'post',
                    contentType:'application/json',
                    data:JSON.stringify(obj),
                    success:function (data) {
                        if (data.status == 200) {
                            layer.msg('用户名可以使用', {icon: 6});
                        } else {
                            layer.msg('名字已被使用', {icon: 5});
                        }
                    }
                })
            })
        })

    });

</script>
</body>
</html>
