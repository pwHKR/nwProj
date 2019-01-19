<%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2019-01-19
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%try {
if (LoginEJB.isBanned()){

//request.getSession(true).invalidate();

String redirect =
response.encodeRedirectURL("banned.jsp");
response.sendRedirect(redirect);



}}catch (Exception e){e.printStackTrace();} %>
