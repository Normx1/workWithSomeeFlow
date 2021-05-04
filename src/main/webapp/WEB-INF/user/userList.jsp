<%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 04.05.2021
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h2>Users List</h2>
<p><a href='<c:url value="/createUser" />'>Create new</a></p>

<table>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Mail</th>
        <th>Password</th>
        <th>edit/delete</th>
        <th></th>
    </tr>
    <c:forEach var="users" items="${requestScope.users}">
    <tr>
        <td>${users.id}</td>
        <td>${users.name}</td>
        <td>${users.mail}</td>
        <td>${users.password}</td>
        <td>
            <a href='<c:url value="/user/edit?id=${users.id}" />'>Edit</a> |
            <form method="post" action='<c:url value="user/delete" />' style="display:inline;">
                <input type="hidden" name="id" value="${users.id}">
                <input type="submit" value="Delete">
            </form>
        </td>
    </tr>
    </c:forEach>

</body>
</html>
