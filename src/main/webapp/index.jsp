<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br>
<a href="login">Se connecter</a>
<br>
<p>"/listProduct" pour voir la liste des articles ajoutés</p>


<table>
    <td><c:out value="toto"></c:out><td>
</table>

</body>
</html>