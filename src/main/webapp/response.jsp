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
            alert("hello!");
        });
    });
</script>