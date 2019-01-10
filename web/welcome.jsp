<%@ page import="Web.MVC.Controller.Bean.SearchBean" %><%--
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

<!-- About Section -->

<%@ include file="fragments/aboutSection.jsp" %>



<!-- Projects Section -->

<div class="row align-items-center no-gutters mb-4 mb-lg-5">
    <div class="col-xl-8 col-lg-7">
        <img class="img-fluid mb-3 mb-lg-0" src="img/bg-masthead.jpg" alt="">
    </div>
    <div class="col-xl-4 col-lg-5">
        <div class="featured-text text-center text-lg-left">
            <h4>Friend search</h4>
            <p class="text-black-50 mb-0"><%

                if(request.getParameter("inputSearch") != null){

                    SearchBean searchBean_jsp = new SearchBean();
                    out.print(searchBean_jsp.searchForPersons(
                            request.getParameter("inputSearch")
                    ));

                }
            %></p>
        </div>
    </div>
</div>
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