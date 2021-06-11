<%@ include file="/WEB-INF/header.jsp" %>

<h2>Add a product :</h2>
<form action="<c:url value="/auth/addProduct" />" method="post">
    <p>
        <label for="name">Product name :</label>
        <input type="text" name="name" id="name">
    </p>

    <p>
        <label for="content">Content :</label>
        <input type="text" name="content" id="content">
    </p>

    <p>
        <label for="price"> price :</label>
        <input type="number" min="0.0" name="price" id="price">
    </p>

    <p><input type="submit" value="Ajouter"></p>

</form>

<%@ include file="/WEB-INF/footer.jsp" %>
