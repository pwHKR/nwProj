<%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2018-12-31
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>
<form action="Web.MVC.Controller.Servlet.LoginServlet" method="GET">
    <h2>Login</h2><br>

    <h4>Login failed, try again</h4><br>
    <b> UserName: </b>  <input name="userName" type="text" minlength ="1" > <br><br>
    <b> Password: </b> <input name="password" type="text" maxlength="10" minlength="1"> <br><br>



    <input type="submit" value="Register" />
</form>
</body>
</html>
