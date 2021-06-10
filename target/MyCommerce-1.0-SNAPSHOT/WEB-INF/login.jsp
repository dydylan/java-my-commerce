<!DOCTYPE html>
<html lang="en" xmlns:c="">
<head>
    <meta charset="UTF-8">
    <title>Formulaire</title>
</head>
<body>
<h2>Log in</h2>
<form method="post" action="login">
    <p>
        <label for="name">Nom : </label>
        <input type="text" name="name" id="name" />
        <input type="submit" />
    </p>

</form>
</br>
<%@ include file="/WEB-INF/footer.jsp" %>

</body>
</html>