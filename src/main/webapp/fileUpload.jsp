<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2019/4/5
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>title</title>
</head>
<body>
<h3>文件上传</h3>
<form action="fileUp/fileUpload1" method="post" enctype="multipart/form-data">
    <input type="file" name="upload" />
    <br/>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
