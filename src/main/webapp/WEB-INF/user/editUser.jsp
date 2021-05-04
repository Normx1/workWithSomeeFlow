<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit</title>
</head>
<body>
<h3>Edit user</h3>
<form method="post" action="/user/edit">
    <input type="hidden" name="id" value="${users.id}" />
    <label>Name</label><br>
    <input name="name" value="${users.name}"/>
    <br><br>
    <label>Mail</label><br>
    <input name="mail" value="${users.mail}"/>
    <br><br>
    <label>Password</label><br>
    <input name="password" value="${users.password}"/><br><br>
    <input type="submit" value="Send"/>
</form>
</body>
</html>
