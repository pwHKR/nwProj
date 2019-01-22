<%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2019-01-04
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section id="about" class="about-section text-center">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mx-auto">
                <h2 class="text-white mb-4">Presentation</h2>
                <p class="text-white-50">  ${myPress}
                <form action="Web.MVC.Controller.Servlet.ServletFriendButton" method="post">
                    <input type="submit" name="pressButton" value="Edit Presentation" />

                </form>
                    <a href="http://startbootstrap.com/template-overviews/grayscale/"></a> </p>
            </div>

        </div>
        <img src="img/frontIMG.png" class="img-fluid" alt="">
    </div>
</section>
