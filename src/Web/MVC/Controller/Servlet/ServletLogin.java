package Web.MVC.Controller.Servlet;

import Web.MVC.Controller.Bean.LoginBean;
import Web.MVC.Controller.Bean.SendMessageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
@WebServlet(name = "Web.MVC.Controller.Servlet.ServletLogin", urlPatterns = {"/Web.MVC.Controller.Servlet.ServletLogin"})
public class ServletLogin extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        processRequest(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



      boolean isValidate = false;





        // For sending message to jms queue
        SendMessageBean sendMessageBean = new SendMessageBean();



        String userName = request.getParameter("userName");
        String password = request.getParameter("password");



        LoginBean loginBean = new LoginBean();

        isValidate = loginBean.validate(userName,password);








        if(isValidate){






            sendMessageBean.sendMessage(userName+ " accessed login","ServletLogin");




            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */

                /*

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ServletLogin</title>");
                out.println("</head>");
                out.println("<body>");



                    out.println("<h3>Welcome to the social network </h3> <h2>" + userName+"</h2>");


                    */



                out.println("<!DOCTYPE html>");
                out.println("<head>\n" +
                        "\n" +
                        "    <meta charset=\"utf-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                        "    <meta name=\"description\" content=\"\">\n" +
                        "    <meta name=\"author\" content=\"\">\n" +
                        "\n" +
                        "    <title>Grayscale - Start Bootstrap Theme</title>\n" +
                        "\n" +
                        "    <!-- Bootstrap core CSS -->\n" +
                        "    <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                        "\n" +
                        "    <!-- Custom fonts for this template -->\n" +
                        "    <link href=\"vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\">\n" +
                        "    <link href=\"https://fonts.googleapis.com/css?family=Varela+Round\" rel=\"stylesheet\">\n" +
                        "    <link href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\" rel=\"stylesheet\">\n" +
                        "\n" +
                        "    <!-- Custom styles for this template -->\n" +
                        "    <link href=\"css/grayscale.min.css\" rel=\"stylesheet\">\n" +
                        "\n" +
                        "</head>\n" +
                        "\n" +
                        "<body id=\"page-top\">\n" +
                        "\n" +
                        "<!-- Navigation -->\n" +
                        "<nav class=\"navbar navbar-expand-lg navbar-light fixed-top\" id=\"mainNav\">\n" +
                        "    <div class=\"container\">\n" +
                        "        <a class=\"navbar-brand js-scroll-trigger\" href=\"#page-top\">\n" +
                        "\n" +
                        "            "+userName+"</a>\n" +
                        "        <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                        "            Menu\n" +
                        "            <i class=\"fas fa-bars\"></i>\n" +
                        "        </button>\n" +
                        "        <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n" +
                        "            <ul class=\"navbar-nav ml-auto\">\n" +
                        "                <li class=\"nav-item\">\n" +
                        "                    <a class=\"nav-link js-scroll-trigger\" href=\"#about\">Chat</a>\n" +
                        "                </li>\n" +
                        "                <li class=\"nav-item\">\n" +
                        "                    <a class=\"nav-link js-scroll-trigger\" href=\"#projects\">Friends</a>\n" +
                        "                </li>\n" +
                        "                <li class=\"nav-item\">\n" +
                        "                    <a class=\"nav-link js-scroll-trigger\" href=\"http://localhost:8080/nwProj_war_exploded/\">Log out</a>\n" +
                        "                </li>\n" +
                        "            </ul>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</nav>\n" +
                        "\n" +
                        "<!-- Header -->\n" +
                        "<header class=\"masthead\">\n" +
                        "    <div class=\"container d-flex h-100 align-items-center\">\n" +
                        "        <div class=\"mx-auto text-center\">\n" +
                        "            <h1 class=\"mx-auto my-0 text-uppercase\">Social Network</h1>\n" +
                        "            <h2 class=\"text-white-50 mx-auto mt-2 mb-5\">Privacy and Technolgy.</h2>\n" +
                        "            <a href=\"#about\" class=\"btn btn-primary js-scroll-trigger\">Get Started</a>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</header>\n" +
                        "\n" +
                        "<!-- About Section -->\n" +
                        "<section id=\"about\" class=\"about-section text-center\">\n" +
                        "    <div class=\"container\">\n" +
                        "        <div class=\"row\">\n" +
                        "            <div class=\"col-lg-8 mx-auto\">\n" +
                        "                <h2 class=\"text-white mb-4\">Built with Bootstrap 4</h2>\n" +
                        "                <p class=\"text-white-50\">Grayscale is a free Bootstrap theme created by Start Bootstrap. It can be yours right now, simply download the template on\n" +
                        "                    <a href=\"http://startbootstrap.com/template-overviews/grayscale/\">the preview page</a>. The theme is open source, and you can use it for any purpose, personal or commercial.</p>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "        <img src=\"img/ipad.png\" class=\"img-fluid\" alt=\"\">\n" +
                        "    </div>\n" +
                        "</section>\n" +
                        "\n" +
                        "<!-- Projects Section -->\n" +
                        "<section id=\"projects\" class=\"projects-section bg-light\">\n" +
                        "    <div class=\"container\">\n" +
                        "\n" +
                        "        <!-- Featured Project Row -->\n" +
                        "        <div class=\"row align-items-center no-gutters mb-4 mb-lg-5\">\n" +
                        "            <div class=\"col-xl-8 col-lg-7\">\n" +
                        "                <img class=\"img-fluid mb-3 mb-lg-0\" src=\"img/bg-masthead.jpg\" alt=\"\">\n" +
                        "            </div>\n" +
                        "            <div class=\"col-xl-4 col-lg-5\">\n" +
                        "                <div class=\"featured-text text-center text-lg-left\">\n" +
                        "                    <h4>Shoreline</h4>\n" +
                        "                    <p class=\"text-black-50 mb-0\">Grayscale is open source and MIT licensed. This means you can use it for any project - even commercial projects! Download it, customize it, and publish your website!</p>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <!-- Project One Row -->\n" +
                        "        <div class=\"row justify-content-center no-gutters mb-5 mb-lg-0\">\n" +
                        "            <div class=\"col-lg-6\">\n" +
                        "                <img class=\"img-fluid\" src=\"img/demo-image-01.jpg\" alt=\"\">\n" +
                        "            </div>\n" +
                        "            <div class=\"col-lg-6\">\n" +
                        "                <div class=\"bg-black text-center h-100 project\">\n" +
                        "                    <div class=\"d-flex h-100\">\n" +
                        "                        <div class=\"project-text w-100 my-auto text-center text-lg-left\">\n" +
                        "                            <h4 class=\"text-white\">Misty</h4>\n" +
                        "                            <p class=\"mb-0 text-white-50\">An example of where you can put an image of a project, or anything else, along with a description.</p>\n" +
                        "                            <hr class=\"d-none d-lg-block mb-0 ml-0\">\n" +
                        "                        </div>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <!-- Project Two Row -->\n" +
                        "        <div class=\"row justify-content-center no-gutters\">\n" +
                        "            <div class=\"col-lg-6\">\n" +
                        "                <img class=\"img-fluid\" src=\"img/demo-image-02.jpg\" alt=\"\">\n" +
                        "            </div>\n" +
                        "            <div class=\"col-lg-6 order-lg-first\">\n" +
                        "                <div class=\"bg-black text-center h-100 project\">\n" +
                        "                    <div class=\"d-flex h-100\">\n" +
                        "                        <div class=\"project-text w-100 my-auto text-center text-lg-right\">\n" +
                        "                            <h4 class=\"text-white\">Mountains</h4>\n" +
                        "                            <p class=\"mb-0 text-white-50\">Another example of a project with its respective description. These sections work well responsively as well, try this theme on a small screen!</p>\n" +
                        "                            <hr class=\"d-none d-lg-block mb-0 mr-0\">\n" +
                        "                        </div>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "\n" +
                        "    </div>\n" +
                        "</section>\n" +
                        "\n" +
                        "<!-- Signup Section -->\n" +
                        "<section id=\"signup\" class=\"signup-section\">\n" +
                        "    <div class=\"container\">\n" +
                        "        <div class=\"row\">\n" +
                        "            <div class=\"col-md-10 col-lg-8 mx-auto text-center\">\n" +
                        "\n" +
                        "                <i class=\"far fa-paper-plane fa-2x mb-2 text-white\"></i>\n" +
                        "                <h2 class=\"text-white mb-5\">Subscribe to receive updates!</h2>\n" +
                        "\n" +
                        "                <form class=\"form-inline d-flex\">\n" +
                        "                    <input type=\"email\" class=\"form-control flex-fill mr-0 mr-sm-2 mb-3 mb-sm-0\" id=\"inputEmail\" placeholder=\"Enter email address...\">\n" +
                        "                    <button type=\"submit\" class=\"btn btn-primary mx-auto\">Subscribe</button>\n" +
                        "                </form>\n" +
                        "\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</section>\n" +
                        "\n" +
                        "<!-- Contact Section -->\n" +
                        "<section class=\"contact-section bg-black\">\n" +
                        "    <div class=\"container\">\n" +
                        "\n" +
                        "        <div class=\"row\">\n" +
                        "\n" +
                        "            <div class=\"col-md-4 mb-3 mb-md-0\">\n" +
                        "                <div class=\"card py-4 h-100\">\n" +
                        "                    <div class=\"card-body text-center\">\n" +
                        "                        <i class=\"fas fa-map-marked-alt text-primary mb-2\"></i>\n" +
                        "                        <h4 class=\"text-uppercase m-0\">Address</h4>\n" +
                        "                        <hr class=\"my-4\">\n" +
                        "                        <div class=\"small text-black-50\">4923 Market Street, Orlando FL</div>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div class=\"col-md-4 mb-3 mb-md-0\">\n" +
                        "                <div class=\"card py-4 h-100\">\n" +
                        "                    <div class=\"card-body text-center\">\n" +
                        "                        <i class=\"fas fa-envelope text-primary mb-2\"></i>\n" +
                        "                        <h4 class=\"text-uppercase m-0\">Email</h4>\n" +
                        "                        <hr class=\"my-4\">\n" +
                        "                        <div class=\"small text-black-50\">\n" +
                        "                            <a href=\"#\">hello@yourdomain.com</a>\n" +
                        "                        </div>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div class=\"col-md-4 mb-3 mb-md-0\">\n" +
                        "                <div class=\"card py-4 h-100\">\n" +
                        "                    <div class=\"card-body text-center\">\n" +
                        "                        <i class=\"fas fa-mobile-alt text-primary mb-2\"></i>\n" +
                        "                        <h4 class=\"text-uppercase m-0\">Phone</h4>\n" +
                        "                        <hr class=\"my-4\">\n" +
                        "                        <div class=\"small text-black-50\">+1 (555) 902-8832</div>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <div class=\"social d-flex justify-content-center\">\n" +
                        "            <a href=\"#\" class=\"mx-2\">\n" +
                        "                <i class=\"fab fa-twitter\"></i>\n" +
                        "            </a>\n" +
                        "            <a href=\"#\" class=\"mx-2\">\n" +
                        "                <i class=\"fab fa-facebook-f\"></i>\n" +
                        "            </a>\n" +
                        "            <a href=\"#\" class=\"mx-2\">\n" +
                        "                <i class=\"fab fa-github\"></i>\n" +
                        "            </a>\n" +
                        "        </div>\n" +
                        "\n" +
                        "    </div>\n" +
                        "</section>\n" +
                        "\n" +
                        "<!-- Footer -->\n" +
                        "<footer class=\"bg-black small text-center text-white-50\">\n" +
                        "    <div class=\"container\">\n" +
                        "        Copyright &copy; Your Website 2018\n" +
                        "    </div>\n" +
                        "</footer>\n" +
                        "\n" +
                        "<!-- Bootstrap core JavaScript -->\n" +
                        "<script src=\"vendor/jquery/jquery.min.js\"></script>\n" +
                        "<script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n" +
                        "\n" +
                        "<!-- Plugin JavaScript -->\n" +
                        "<script src=\"vendor/jquery-easing/jquery.easing.min.js\"></script>\n" +
                        "\n" +
                        "<!-- Custom scripts for this template -->\n" +
                        "<script src=\"js/grayscale.min.js\"></script>\n" +
                        "\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>\n");



                }


        }

        else{


            sendMessageBean.sendMessage(userName+ " failed to login\npassword used: "+password,"ServletLogin");



            response.sendRedirect("loginFailed.jsp");





        }
    }


}
