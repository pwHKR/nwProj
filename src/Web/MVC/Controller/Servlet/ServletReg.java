package Web.MVC.Controller.Servlet;

import Hibernate.Entity.AccountData;
import Hibernate.Entity.Person;
import Web.MVC.Controller.Bean.RegisterBean;
import Web.MVC.Controller.Bean.SendMessageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Web.MVC.Controller.Servlet.ServletReg",urlPatterns = {"/Web.MVC.Controller.Servlet.ServletReg"})
public class ServletReg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);
    }



    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SendMessageBean sendMessageBean = new SendMessageBean();



            boolean isFormValid = false;




        //



        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");









        if(!userName.isEmpty()){

            isFormValid = true;
        }



        if(isFormValid){


            RegisterBean registerBean = new RegisterBean();

            AccountData accountData = new AccountData(userName,password,email);
            Person person = new Person(firstName,lastName,"na");


            registerBean.registerAccount(accountData,person);

            sendMessageBean.sendMessage(userName+ " Registerd","ServletReg");




            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */



                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ServletLogin</title>");
                out.println("</head>");
                out.println("<body>");


                out.println("<h3>Welcome to the social network </h3> <h2>" + userName+"</h2>");





            }


        }

        else{




            response.sendRedirect("RegAccount.jsp");





        }
    }



}