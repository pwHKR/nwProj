package Web.MVC.Controller.Servlet;

import Hibernate.Entity.Person;
import Web.MVC.Controller.Bean.SearchBean;
import Web.MVC.Controller.Bean.SendMessageBean;
import Web.MVC.View.ResponseHTML;

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


@WebServlet(name = "ServletWelcome")
//@DeclareRoles("normalUser")


@ServletSecurity(
        @HttpConstraint(transportGuarantee = ServletSecurity.TransportGuarantee.NONE,
                rolesAllowed = {"normalUser"}))

public class ServletWelcome extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {




        String output = "";
       String personPrint= "";



        // For sending message to jms queue
        SendMessageBean sendMessageBean = new SendMessageBean();


       ArrayList<Person> person;

       if(request.getParameter("inputSearch") != null){

        String searchFor = request.getParameter("inputSearch");

           SearchBean searchBean = new SearchBean();

           person = searchBean.searchForPersons(searchFor);

           //TODO: insert loop and use String builder to get all the persons into one String
            personPrint =person.get(0).getFirstName()+" "+person.get(0).getLastName()+
                   "\nUsername: "+person.get(0).getUserNameFK();



           sendMessageBean.sendMessage("searched for:  "+searchFor+ " executed by username","ServletWelcome");
       }




























            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {

                ResponseHTML rh = new ResponseHTML();




               out.println(rh.searchFriend(personPrint,request.getRemoteUser()));



                //response.sendRedirect("welcome.jsp");


            }


        }


}
