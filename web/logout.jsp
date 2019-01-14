<%@ page import="Web.MVC.Controller.Bean.LoginBean" %><%--
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
    <script>

            alert("You have been logged out");

    </script>
    <jsp:useBean id="LoginEJB" scope="session" class="Web.MVC.Controller.Bean.LoginBean" />
    <%



        LoginEJB.setLoggedOut(true);

        LoginEJB.logout(request);



        String redirect =
                response.encodeRedirectURL(request.getContextPath());
        response.sendRedirect(redirect);
    %>




</head>
<body>

You have logged out

</body>
</html>
