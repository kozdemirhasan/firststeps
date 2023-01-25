<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>Admin</h1>

<%--
<c:if test="${signedIn}">
    <h2>Login erfolgreich</h2>
</c:if>
--%>

<c:choose>
    <c:when test="${signedIn}">
        <h2>Login erfolgreich</h2>

        <c:if test="${signedAs eq 'ADMIN'}">
            <h3>Informationen für Admins</h3>
            <p>admin ... admin..., consectetur adipisicing elit. Accusantium, similique?</p>
            <p>Architecto assumenda maxime modi nam nemo non numquam soluta, veritatis.</p>
            <p>Ex excepturi impedit, ipsa placeat quae quia! Accusamus, ducimus recusandae?</p>
        </c:if>
    </c:when>

    <c:otherwise>
        <h2>Du bist nicht angemeldet</h2>
        <a href="login">Anmeldung</a>
    </c:otherwise>
</c:choose>

</body>
</html>