<%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 04.05.2021
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Edit Product:</h3>
<form method="post" action="/product/edit">
    <label>Name</label><br>
    <input name="name" value="${product.name}"/>
    <br><br>
    <label>Cost</label><br>
    <input name="cost" value="${product.cost}"/>
    <br><br>
    <label>Count</label><br>
    <input name="count" value="${product.count}"/>
    <br><br>
    <input type="hidden" name="id" value="${product.id}">
    <input type="submit" value="Save"/>|
    <td colspan="2">
        <a href="${pageContext.request.contextPath}/">Cancel</a>
    </td>
</form>
</body>
</html>
