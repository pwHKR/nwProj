<%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2019-01-04
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section id="signup" class="signup-section">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-lg-8 mx-auto text-center">

                <i class="far fa-paper-plane fa-2x mb-2 text-white"></i>
                <h2 class="text-white mb-5">Search for friends!</h2>

                <form class="form-inline d-flex"action="Web.MVC.Controller.Servlet.ServletWelcome">
                    <input type="text" class="form-control flex-fill mr-0 mr-sm-2 mb-3 mb-sm-0" id="inputSearch" name ="inputSearch" placeholder="Search for username...">
                    <button type="submit" class="btn btn-primary mx-auto">Search</button>
                </form>

            </div>
        </div>
    </div>
</section>