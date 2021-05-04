<%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 04.05.2021
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>

<jsp:include page="WEB-INF/otherElements/_header.jsp"></jsp:include>
<jsp:include page="WEB-INF/otherElements/_menu.jsp"></jsp:include>

<h3>Home Page</h3>


<div style="padding: 5px;  align: left;">
    <a href="/userList">User List</a>
    <a href="/productList">Product List</a>

</div>

<jsp:include page="WEB-INF/otherElements/_footer.jsp"></jsp:include>

</body>
</html>
