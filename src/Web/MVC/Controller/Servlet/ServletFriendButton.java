package Web.MVC.Controller.Servlet;

import Hibernate.Manage.ManageFriend;
import Web.MVC.Controller.Bean.LoginBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletFriendButton")
public class ServletFriendButton extends HttpServlet {

    @EJB
    LoginBean LoginEJB;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //     button1

        int selection = 0;

        try {

            System.out.println(request.getParameter("button1").toString());

            selection = 1;
        } catch (NullPointerException e) {
            System.out.println("null on button 1");
        }

        try {

            System.out.println(request.getParameter("button2").toString());
            selection = 2;
        } catch (NullPointerException e) {
            System.out.println("null on button 2");
        }

        try {

            System.out.println(request.getParameter("button3").toString());

            selection = 3;
        } catch (NullPointerException e) {
            System.out.println("null on button 3");
        }


        switch (selection) {

            case 1:
                addFriend(request, response);
                break;

            case 2:
                messageFriend();
                break;

            case 3:
                removeFriend(request, response);
                break;


        }

    }




    private void addFriend(HttpServletRequest request, HttpServletResponse response) {


        System.out.println("in add friend : FRIEND SERVLET");

        iniCookieValues(request,response);


        ManageFriend manageFriend = new ManageFriend();

        try {

            manageFriend.AddFriend(LoginEJB.getU_name(), LoginEJB.getTemp_pointerUser());
        } catch (Exception e) {
            System.out.println(" Exeption in ServletFriend Button - Add Friend");
        }

        String url = "/./nwProj_war_exploded/member/welcome.jsp";


        try {
            response.sendRedirect(response.encodeRedirectURL(url));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void messageFriend() {

        System.out.println("in message friend : FRIEND SERVLET");
    }

    private void removeFriend(HttpServletRequest request, HttpServletResponse response) {


        System.out.println("in remove friend : FRIEND SERVLET");

        iniCookieValues(request,response);

        ManageFriend manageFriend = new ManageFriend();

        manageFriend.RemoveFriend(LoginEJB.getU_name(),LoginEJB.getTemp_pointerUser());

        String url = "/./nwProj_war_exploded/member/welcome.jsp";


        try {
            response.sendRedirect(response.encodeRedirectURL(url));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





    // Ini Method
    private void iniCookieValues(HttpServletRequest request, HttpServletResponse response){

        Cookie[] cookies;
        cookies = request.getCookies();

        for(Cookie c : cookies){

            System.out.println("name: "+c.getName());

            if(c.getName().equalsIgnoreCase("name")){
                LoginEJB.setU_name(c.getValue());}


            if(c.getName().equalsIgnoreCase("pointerUser")){

                LoginEJB.setTemp_pointerUser(c.getValue());}

            System.out.println("value: "+c.getValue());
        }
    }



}
