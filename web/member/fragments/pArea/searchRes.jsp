<%@ page import="Web.MVC.Controller.Bean.SearchBean" %><%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2019-01-04
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row align-items-center no-gutters mb-4 mb-lg-5">
    <div class="col-xl-8 col-lg-7">
        <img class="img-fluid mb-3 mb-lg-0" src="img/bg-masthead.jpg" alt="">
    </div>
    <div class="col-xl-4 col-lg-5">
        <div class="featured-text text-center text-lg-left">
            <h4>Friend search</h4>
            <p class="text-black-50 mb-0">
                <jsp:useBean id="SearchBeanEJB" class="Web.MVC.Controller.Bean.SearchBean" />
                <% %></p>
            ${result}
        </div>
        <form action="Web.MVC.Controller.Servlet.ServletFriendButton" method="post">
            <input type="submit" name="button1" value="Add Friend" />
            <input type="submit" name="button2" value="Message friend" />
            <input type="submit" name="button3" value="Remove friend" />
        </form>
    </div>
</div>