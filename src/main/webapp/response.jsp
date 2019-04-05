<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2019/4/4
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
</head>
<body>
<a href="us/testResponseString" >testResponseString</a>
<hr/>
<a href="us/testResponseVoid" >testResponseVoid</a>
<hr/>
<a href="us/testModelAndView" >testModelAndView</a>
<hr/>
<a href="us/testForwardOrRedirect" >testForwardOrRedirect</a>
<hr/>
<button id="aj">发送ajax请求</button>
<hr/>
</body>
</html>
<script>
    //页面加载
    $(function () {
        $("#aj").click(function () {
            //alert("hello!");
            var x='{"username":"hehe","password":"123456","date":"2019-02-08"}';
            //发送ajax请求
            $.ajax({
                //编写json格式，设置属性和值
                url:"us/testAjax",
                contentType:"application/json;charset=UTF-8",//发送json格式数据
                data:x,
                dataType:"json",//服务器预期返回数据类型
                type:"post",//请求方式，默认get
                success:function (data) {
                    //data:服务器端响应的json格式数据，进行解析
                    console.log(data);
                }
            });
        });
    });
</script>
