<%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2019-01-11
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:useBean id="LoginBean" class="Web.MVC.Controller.Bean.LoginBean" />
    <%


        LoginBean.logout(request);
    %>


</head>
<body>

You have logged out

</body>
</html>