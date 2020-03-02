<%--
  Created by IntelliJ IDEA.
  User: thorc
  Date: 02-03-2020
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Indkøbsliste</title>
</head>
<body>

<h1>Velkommen til min online indkøbsliste</h1>
<br>
<br>
${requestScope.besked}
<br>
<h2>Login side</h2>
<br>
<form action="LoginServlet" method="post">
    <label for="fname">Username:</label><br>
    <input type="text" id="fname" name="brugernavn"><br>
    <label for="lname">Password:</label><br>
    <input type="text" id="lname" name="kodeord"><br><br>
    <input type="submit" value="Login">
</form>

</body>
</html>
