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