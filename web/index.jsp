<%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2018-12-29
  Time: 09:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Login Page Page</title>
</head>
<body>
<form action="LoginServlet" method="GET">
  <h2>Login</h2><br>
  <b> UserName: </b>  <input name="userName" type="text" minlength ="1" > <br><br>
  <b> Password: </b> <input name="password" type="text" maxlength="6" minlength="4"> <br><br>



  <input type="submit" value="Register" />
</form>
</body>
</html>
