<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2019/4/4
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--常用注解--%>
     <a href="anno/testRequestParams?username=hahah">RequestParams</a>
<hr/>
<h3>RequestBody获取请求体</h3>
<form action="anno/testRequestBody" method="post">
    <table>
        <tr>
            <td>username</td>
            <td><input type="text" name="username" value=""/></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="text" name="password" value=""/></td>
        </tr>
        <tr>
            <td>date</td>
            <td><input type="date"  name="date" value=""/></td>
        </tr>
        <tr>
            <td><input type="submit" value="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
