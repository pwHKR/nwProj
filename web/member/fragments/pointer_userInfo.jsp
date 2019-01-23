<%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2019-01-04
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="contact-section bg-black">
    <div class="container">
        <h2 class="text-white mb-5"> ${result}</h2>
        <br />
       <h4 class="text-white mb-5">Username - ${pointerUser}</h4>

        <div class="row">

            <div class="col-md-4 mb-3 mb-md-0">
                <div class="card py-4 h-100">
                    <div class="card-body text-center">
                        <i class="fas fa-map-marked-alt text-primary mb-2"></i>
                        <h4 class="text-uppercase m-0">Presentation</h4>
                        <hr class="my-4">
                        <div class="small text-black-50">${pointerUser_press}</div>
                    </div>
                </div>
            </div>

            <div class="col-md-4 mb-3 mb-md-0">
                <div class="card py-4 h-100">
                    <div class="card-body text-center">
                        <i class="fas fa-envelope text-primary mb-2"></i>
                        <h4 class="text-uppercase m-0">Adress</h4>
                        <hr class="my-4">
                        <div class="small text-black-50">
                            <a href="#">${pointerUser_address}</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-4 mb-3 mb-md-0">
                <div class="card py-4 h-100">
                    <div class="card-body text-center">
                        <i class="fas fa-mobile-alt text-primary mb-2"></i>
                        <h4 class="text-uppercase m-0">Phone</h4>
                        <hr class="my-4">
                        <div class="small text-black-50">${pointerUser_phone}</div>
                    </div>

                </div>
            </div>
        </div>

        <div class="social d-flex justify-content-center">

            <a href="<%="https://github.com/pwHKR"%>" class="mx-2">
                <i class="fab fa-github"></i>
            </a>
        </div>

    </div>
</section>

