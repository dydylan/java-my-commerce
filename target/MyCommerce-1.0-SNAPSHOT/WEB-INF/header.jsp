<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib
        uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>

<p>Vous êtes connecté en tant que ${user}</p>

<nav>
    <ul>
        <li><a href="<c:url value="/auth/listProduct" />">List product</a></li>
        <li><a href="<c:url value="/auth/addProduct" />">Add a product</a></li>
        <li><a href="<c:url value="/log-out" />">Log out</a></li>
        <li><a href="<c:url value="/login" />">Log in</a></li>
    </ul>
</nav>
</body>
</html>