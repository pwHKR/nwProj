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
  <title>Login Page</title>
</head>
<body>



<form action="Web.MVC.Controller.Servlet.ServletLogin" method="GET" >
  <h2>Login</h2><br>
  <b> UserName: </b>  <input name="userName" type="text" minlength ="1" > <br><br>
  <b> Password: </b> <input name="password" type="password" maxlength="10" minlength="1"> <br><br>



  <input type="submit" value="Login" />
</form>

<a href="<%="http://localhost:8080/nwProj_war_exploded/RegAccount.jsp"%>">Register Account</a>
</body>

</html>
