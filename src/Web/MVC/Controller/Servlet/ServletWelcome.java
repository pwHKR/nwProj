package Web.MVC.Controller.Servlet;

import Hibernate.Entity.Person;
import Web.MVC.Controller.Bean.SearchBean;
import Web.MVC.Controller.Bean.SendMessageBean;
import Web.MVC.View.ResponseHTML;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(name = "Web.MVC.Controller.Servlet.ServletWelcome",urlPatterns = {"/Web.MVC.Controller.Servlet.ServletWelcome"})
@DeclareRoles("level_1")


@ServletSecurity(
        @HttpConstraint(transportGuarantee = ServletSecurity.TransportGuarantee.NONE,
                rolesAllowed = {"level_1"}))

public class ServletWelcome extends HttpServlet {

    @EJB
    SendMessageBean sendMessageBean;

    @EJB
    SearchBean searchBean;


    @RolesAllowed("level_1")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        processRequest(request,response);
    }

    @RolesAllowed("level_1")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        processRequest(request,response);
    }

    @RolesAllowed("level_1")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {





            String output = "";
            String personPrint = "";





            ArrayList<Person> person;

            if (request.getParameter("inputSearch") != null) {

                String searchFor = request.getParameter("inputSearch");



                try {
                    person = searchBean.searchForPersons(searchFor);

                    //TODO: insert loop and use String builder to get all the persons into one String
                    personPrint = person.get(0).getFirstName() + " " + person.get(0).getLastName() +
                            "\nUsername: " + person.get(0).getUserNameFK();

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("IndexOutOfBoundsException 1st on search");
                    personPrint = "no result found on your search";

                }

                sendMessageBean.sendMessage("searched for:  " + searchFor + " executed by username", "ServletWelcome");
            }


            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
            response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
            response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
            try (PrintWriter out = response.getWriter()) {


                ResponseHTML rh = new ResponseHTML();


                try {
                    out.println(rh.searchFriend(personPrint, request.getRemoteUser()));
                } catch (Exception e) {
                    System.out.println("exeption 2nd search");
                }


                response.sendRedirect("member/welcome.jsp");


            }


        }


    }


