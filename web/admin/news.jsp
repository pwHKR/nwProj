<%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2019-01-16
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Post News</title>
</head>
<body>

<textarea name="paragraph_text" cols="50" rows="10"></textarea>

<form action="Web.MVC.Controller.Servlet.ServletLogin" method="GET" >
    <h2>Login</h2><br>
    <b> UserName: </b>  <input name="userName" type="text" minlength ="1" > <br><br>
    <b> Password: </b> <input name="password" type="password" maxlength="10" minlength="1"> <br><br>


    <input type="submit" value="Login" />
</form>

</body>
</html>
