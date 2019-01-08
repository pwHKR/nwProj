<%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2019-01-04
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>

<form action="j_security_check" method="POST" >
    <h2>Login</h2><br>
    <b> UserName: </b>  <input name="userName" type="text" id="j_username" minlength ="1" > <br><br>
    <b> Password: </b> <input name="password" type="password" id="j_password" maxlength="30" minlength="1"> <br><br>



    <input type="submit" value="Login" />
</form>

<a href="<%="http://localhost:8080/nwProj_war_exploded/RegAccount.jsp"%>">Register Account</a>
</body>

</html>