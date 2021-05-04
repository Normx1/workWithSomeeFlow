<%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 28.04.2021
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding: 5px;  align: left;">

    <a href="${pageContext.request.contextPath}/">News</a>
    |
    <a href="${pageContext.request.contextPath}/">About as</a>
    |
    <a href="${pageContext.request.contextPath}/productList">Product List</a>
    |
<%--    <a href="${pageContext.request.contextPath}/userInfo">My Account Info</a>--%>
<%--    |--%>
    <a href="${pageContext.request.contextPath}/login">Login/Sign in</a>

    |
    <a href="../adminPage/drugs">AdminPage</a>



</div>
<div style=" align: left;">
    <br>
    <!-- User store in session with attribute: loginedUser -->
    Hello <b>${loginedUser.name} </b>
    <br/>
    <a href="${pageContext.request.contextPath}/basket"> Basket </a>


</div>
<br>
<div style="align: right;">
    Search <input name="search">

</div>