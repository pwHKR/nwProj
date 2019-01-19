<%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2019-01-04
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row justify-content-center no-gutters mb-5 mb-lg-0">
    <div class="col-lg-6">
        <img class="img-fluid" src="img/demo-image-01.jpg" alt="">
    </div>
    <div class="col-lg-6">
        <div class="bg-black text-center h-100 project">
            <div class="d-flex h-100">
                <div class="project-text w-100 my-auto text-center text-lg-left">
                    <h4 class="text-white">Friends</h4>
                    <p class="mb-0 text-white-50"><%@ include file="/java/friendList_code.jsp" %></p>
                    <hr class="d-none d-lg-block mb-0 ml-0">
                </div>
            </div>
        </div>
    </div>
</div>