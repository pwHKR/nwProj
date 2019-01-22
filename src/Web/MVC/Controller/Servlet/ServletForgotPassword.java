package Web.MVC.Controller.Servlet;

import Email.SSLMail;
import Hibernate.Manage.ManageAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletForgotPassword")
public class ServletForgotPassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String password ="null";
        String mail = request.getParameter("mail");


        ManageAccount manageAccount = new ManageAccount();

        try{

        password = manageAccount.getPassword(mail);}
        catch (Exception e){}

        System.out.println("password in servletForgotPassword: " +password);

        if(password.equalsIgnoreCase("null")){

            System.out.println("no password found");
            //TODO : Response here with html code that notifes user
        }

        else{

            SSLMail sslMail = new SSLMail(mail,"Forgot Password",
                    "Here is your password: "+ password);

            try {
                sslMail.sendMail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        response.sendRedirect("index.jsp");

    }
}
