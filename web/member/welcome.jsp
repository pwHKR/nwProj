<%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2018-12-31
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Header Section -->

<%@ include file="fragments/headerSection.jsp" %>

<%   String userNameVar = (String) session.getAttribute("userName_session");
    if (null == userNameVar) {
        request.setAttribute("Error", "Session has ended.  Please login.");
        RequestDispatcher rd = request.getRequestDispatcher("/./index.jsp");
        rd.forward(request, response);}%>


<!-- About Section -->

<%@ include file="fragments/aboutSection.jsp" %>



<!-- Projects Section -->


<%@ include file="fragments/pSection.jsp" %>
<!-- Signup Section -->
<%@ include file="fragments/searchSection.jsp" %>


<!-- Contact Section -->
<%@ include file="fragments/contactSection.jsp" %>


<!-- Footer -->
<%@ include file="fragments/footerSection.jsp" %>


<!-- Bootstrap core JavaScript -->
<%@ include file="fragments/scriptCore.jsp" %>


</body>

</html>