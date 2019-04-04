<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2019/4/3
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC</title>
</head>
<body>
    <H3>SpringMVC入门demo</H3>
     <a href="user/hello?username=123456">RequestMapping方法注解入门程序</a>
    <br/>
     <a href="user/testRequestMapping">RequestMapping类注解入门程序</a>
    <h3>params请求参数绑定</h3>
    <a href="params/testParams?username=hahhah">params请求参数绑定</a>
    <%--<h3>params封装JavaBean参数绑定</h3>
   <form action="params/saveAccount" method="post">
       <table>
           <tr>
               <td>名称</td>
               <td><input type="text" name="name" value=""/></td>
           </tr>
           <tr>
               <td>金额</td>
               <td><input type="text" name="money" value=""/></td>
           </tr>
           <tr>
               <td>username</td>
               <td><input type="text" name="user.username" value=""/></td>
           </tr>
           <tr>
               <td>password</td>
               <td><input type="text" name="user.password" value=""/></td>
           </tr>
           <tr>
               <td><input type="submit" value="submit"></td>
           </tr>
       </table>
   </form>--%>
<hr/>
    <h3>params封装JavaBean参数日期转换问题</h3>
    <form action="params/saveUser" method="get">
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
    <hr/>
    <a href="params/testServlet">Servlet原生API</a>
</body>
</html>
