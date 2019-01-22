<%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2019-01-22
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forgot password</title>
</head>
<body>

<form action="Web.MVC.Controller.Servlet.ServletForgotPassword" method="POST" >
    <h2>Enter your email here</h2><br>

    <b> Email: </b> <input name="mail" type="text" maxlength="50" minlength="1"> <br><br>


    <input type="submit" value="Send password to my Email" />
</form>

</body>
</html>
