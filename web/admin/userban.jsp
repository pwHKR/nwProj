<%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2019-01-16
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Ban User</title>
</head>
<body>


<FORM ACTION="Web.MVC.Controller.Servlet.ServletAdminBan" METHOD="POST">
   Ban account console<br />

        Ban Value 1 = banned<br />
        Ban Value 0 = Not banned
    <br />
    (ID/Ban Value)
    Ex(15/1) = set ID 15 to banned
    <BR>
    <TEXTAREA NAME="banInput" cols="3" ROWS="3"></TEXTAREA>
    <BR>
    <INPUT TYPE="SUBMIT" VALUE="Submit">

</FORM>>

<!-- Print list of users with ID and Ban Status -->

<%@ include file="/java/userban_List.jsp" %>
</body>
</html>
