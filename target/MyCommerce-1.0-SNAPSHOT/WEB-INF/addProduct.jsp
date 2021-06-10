<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib
        uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>
<html>
<head>
    <title> Ajouter un produit</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<form action="<c:url value="/auth/addProduct" />" method="post">
    <label for="name">Product name :</label>
    <input type="text" name="name" id="name">

    <label for="content">Description :</label>
    <input type="text" name="content" id="content">

    <label for="price"> price :</label>
    <input type="number" min="0.0" name="price" id="price">

    <input type="submit" value="Ajouter">
</form>
<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
