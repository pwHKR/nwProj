package Web.MVC.Controller.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletFriendButton")
public class ServletFriendButton extends HttpServlet {
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

        try{

        System.out.println(request.getParameter("button1").toString());

        selection = 1;
        }
        catch (NullPointerException e){
            System.out.println("null on button 1");
        }

        try{

            System.out.println(request.getParameter("button2").toString());
        selection = 2;
        }
        catch (NullPointerException e){
            System.out.println("null on button 2");
        }

        try{

            System.out.println(request.getParameter("button3").toString());

            selection = 3;
        }
        catch (NullPointerException e){
            System.out.println("null on button 3");
        }


        switch(selection){

            case 1:
                addFriend();

            case 2:

                messageFriend();

            case 3:
                removeFriend();


                }

    }


    private void addFriend(){

        System.out.println("in add friend : FRIEND SERVLET");
    }

    private void messageFriend(){

        System.out.println("in message friend : FRIEND SERVLET");
    }

    private void removeFriend(){

        System.out.println("in remove friend : FRIEND SERVLET");
    }
}
