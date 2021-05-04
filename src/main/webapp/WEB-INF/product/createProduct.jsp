<%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 04.05.2021
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>New product </h3>
<form method="post" action="/create">
    <label>Name</label><br>
    <input type="text" name="name"/><br><br>
    <label>Cost</label><br>
    <input type="text" name="cost"/><br><br>
    <label>Count</label><br>
    <input type="text" name="count"/><br><br>
    <input type="submit" value="Save"/>

</form>
</body>
</html>
