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
<h1>Anmeldung</h1>

    <%--
    <% if(request.getAttribute("msg") != null) { %>
         <p>Fehler bei der Anmeldung </p>
    <% }%>
   --%>

    <c:if test="${msg eq 'LOGIN_ERROR'}">
        <p>Fehler bei der Anmeldung </p>
    </c:if>

<form action="login" method="post">
    <div>
        <input type="text" name="user" id="user" , placeholder="Benutzername">
    </div>
    <br>
    <div>
        <input type="password" name="password" id="password" , placeholder="Password">
    </div>
    <br>
    <button type="submit">Anmelden</button>
</form>

</body>
</html>



