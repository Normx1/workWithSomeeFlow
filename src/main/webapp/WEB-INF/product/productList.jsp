<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.Products.Product" %>
<%@ page import="com.example.Dao.ProductDao" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 04.05.2021
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Админ Лекарства</h2>
<p><a href='<c:url value="/create" />'>Create new product</a></p>
<table>
    <h3>Products</h3>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Count</th>
        <th>Cost</th>
        <th></th>
    </tr>

    <c:forEach var="product" items="${requestScope.products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.count}</td>
            <td>${product.cost}</td>
            <td>
                <a href='<c:url value="/product/edit?id=${product.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/product/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${product.id}">
                    <input type="submit" value="Delete">
                </form>
        </tr>
    </c:forEach>
</table>

</body>
</html>
