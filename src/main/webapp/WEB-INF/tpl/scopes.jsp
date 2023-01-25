<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scopes</title>
</head>
<body>

<p>Application: ${appCounter}</p>
<p>Session: ${sessCounter}</p>
<p>Request: ${reqCounter}</p>

<div>
    <form action="">
        <label for="application">Application: </label>
        <input type="text" id="application" name="application" value=${appCounter}>
        <br>
        <label for="session">Session: </label>
        <input type="text" id="session" name="session" value=${sessCounter}>
        <br>
        <label for="request">Request: </label>
        <input type="text" id="request" name="request" value=${reqCounter}>
    </form>

</div>

<p>Application: ${appCounter}</p>
<p>Session: ${sessCounter}</p>
<p>Request: ${reqCounter}</p>
</body>
</html>
