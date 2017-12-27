<%--
  Created by IntelliJ IDEA.
  User: MicroKibaco
  Date: 26/12/2017
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Servlet基础</title>
  </head>
  <body>
  <h1>第一个Servlet小程序</h1>
  <hr>
  <a href="servlet/HelloServlet">Get方式请求HelloServlet</a><br>
  <form action="servlet/HelloServlet" method="post">
    <input type="submit" value="Post方式请求HelloServlet"/>
  </form>
  </body>
</html>
