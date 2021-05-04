<%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 04.05.2021
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>New product </h3>
<form method="post" action="product/create">
    <label>Name</label><br>
    <input name="name"/><br><br>
    <label>Count</label><br>
    <input count="mail"/><br><br>
    <label>Cost</label><br>
    <input cost="password"/><br><br>

    <input type="submit" value="Save"/>
</form>
</body>
</html>
