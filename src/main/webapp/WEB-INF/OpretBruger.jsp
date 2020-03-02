<%--
  Created by IntelliJ IDEA.
  User: thorc
  Date: 02-03-2020
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Opret Bruger</title>
</head>
<body>

Her kan du oprette en bruger på huskelisten
<br>
<br>
${requestScope.besked}
<br>
<br>
<form action="OpretServlet" method="post">
    <label for="fname">Username:</label><br>
    <input type="text" id="fname" name="brugernavn"><br>
    <label for="lname">Password:</label><br>
    <input type="text" id="lname" name="kodeord"><br><br>
    <input type="submit" value="Opret Bruger">
</form>

</body>
</html>
