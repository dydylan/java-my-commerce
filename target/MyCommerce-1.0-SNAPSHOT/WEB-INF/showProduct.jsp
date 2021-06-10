<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib
        uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>
<html>
<head>
    <title>One product</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<h2>Product : ${product.name}</h2>
<p>Content : ${product.content}</p>
<p>Price : ${product.price}</p>
<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>