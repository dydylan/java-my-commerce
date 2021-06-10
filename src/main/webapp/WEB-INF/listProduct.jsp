<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib
        uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>
<html>
<head>
    <title>Liste des produits</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<h2>List product :</h2>
<table>
    <c:forEach items="${products}" var="t">
        <p>Product ${t.id} : ${t.name}</p>
        <p>Content : ${t.content}</p>
        <p>Price : ${t.price}</p>
        <p><a href="${pageContext.request.contextPath}/auth/show-product?id=${t.id}">Voir</a></p>
        <p><a href="${pageContext.request.contextPath}/auth/removeProduct?id=${t.id}">Supprimer</a></p>
        </br>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>