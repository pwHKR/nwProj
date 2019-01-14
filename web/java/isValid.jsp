<%@ page import="javax.ejb.EJB" %>
<%@ page import="Web.MVC.Controller.Bean.LoginBean" %>
<%@ page import="javax.ejb.Stateful" %><%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2019-01-12
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="LoginEJB" scope="session" class="Web.MVC.Controller.Bean.LoginBean" />
<%

    try {
        if (LoginEJB.isLoggedOut()){

            //request.getSession(true).invalidate();

            String redirect =
                    response.encodeRedirectURL(request.getContextPath());
            response.sendRedirect(redirect);


    //RequestDispatcher rd=request.getRequestDispatcher("/getJsp.jsp");
   // rd.forward(request,response);
            }}catch (Exception e){e.printStackTrace();}

%>




