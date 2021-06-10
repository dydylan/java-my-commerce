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
<table>
    <c:forEach items="${products}" var="t">
        <tr>
            <td><c:out value="${t.name}" /></td>
            <td><c:out value="${t.content}" /></td>
            <td><c:out value="${t.price}" /></td>
            <td>
                <a href="${pageContext.request.contextPath}/auth/show-product?id=${t.id}">Voir</a>
                <a href="${pageContext.request.contextPath}/auth/removeProduct?id=${t.id}">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>