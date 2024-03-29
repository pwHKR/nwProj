package Web.MVC.Controller.Servlet;


import Hibernate.Entity.Person;
import Hibernate.Manage.ManagePerson;
import Web.MVC.Controller.Bean.LoginBean;
import Web.MVC.Controller.Bean.SearchBean;
import Web.MVC.Controller.Bean.SendMessageBean;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(name = "Web.MVC.Controller.Servlet.ServletWelcome")
@DeclareRoles("level_1")


@ServletSecurity(
        @HttpConstraint(transportGuarantee = ServletSecurity.TransportGuarantee.NONE,
                rolesAllowed = {"level_1"}))

public class ServletWelcome extends HttpServlet {

    @EJB
    SendMessageBean sendMessageBean;

    @EJB
    SearchBean searchBean;

    @EJB
    LoginBean LoginEJB;





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




        //System.out.println("isRequestedSessionIdFromCookie? "+request.isRequestedSessionIdFromCookie());

        Cookie[] cookies;
        cookies = request.getCookies();

        for(Cookie c : cookies){

            //System.out.println("name: "+c.getName());

            if(c.getName().equalsIgnoreCase("name")){
            LoginEJB.setU_name(c.getValue());}

           // System.out.println("value: "+c.getValue());
        }



        ManagePerson managePerson = new ManagePerson();

        request.setAttribute("myPress",managePerson.getPresentation(LoginEJB.getU_name()));



        String personPrint = "";





        ArrayList<Person> person;

        if (request.getParameter("inputSearch") != null) {

            String searchFor = request.getParameter("inputSearch");



            try {
                person = searchBean.searchForPersons(searchFor);

                //TODO: insert loop and use String builder to get all the persons into one String
                personPrint = person.get(0).getFirstName() + " " + person.get(0).getLastName();


                request.setAttribute("pointerUser",person.get(0).getUserNameFK());

                request.setAttribute("pointerUser_address",  person.get(0).getAdress());
                request.setAttribute("pointerUser_phone",  person.get(0).getPhone());
                request.setAttribute("pointerUser_press",  person.get(0).getPres());
                Cookie cookie = new Cookie("pointerUser",person.get(0).getUserNameFK());
                response.addCookie(cookie);

            } catch (IndexOutOfBoundsException e) {
               // System.out.println("IndexOutOfBoundsException 1st on search");
                personPrint = "no result found on your search";

            }


            searchBean.setSearchResult(personPrint);



         //   sendMessageBean.sendMessage("searched for:  " + searchFor + " executed by "+LoginEJB.getU_name(), "ServletWelcome");
            request.setAttribute("result",searchBean.getSearchResult());
        }


        //response.setContentType("text/html;charset=UTF-8");
        //response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        //response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
        //response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        //response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
        try (PrintWriter out = response.getWriter()) {




           //ResponseHTML rh = new ResponseHTML();



            try {
               //out.println(rh.searchFriend(personPrint, request.getRemoteUser()));
            } catch (Exception e) {
                System.out.println("exeption 2nd search");
            }





                String redirect =
                        response.encodeRedirectURL(request.getContextPath() + "/member/welcome.jsp");
                //response.sendRedirect(redirect)
            //
            //
            request.getRequestDispatcher("/member/welcome.jsp").forward(request, response);


        }


    }


}


