<%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2019-01-18
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>banned</title>
</head>
<body>

<jsp:useBean id="LoginEJB" scope="session" class="Web.MVC.Controller.Bean.LoginBean" />
<%LoginEJB.setBanned(true);%>

You have been temporarily banned from the social network

</body>
</html>
