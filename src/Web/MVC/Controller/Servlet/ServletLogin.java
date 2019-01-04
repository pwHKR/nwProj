package Web.MVC.Controller.Servlet;

import Web.MVC.Controller.Bean.LoginBean;
import Web.MVC.Controller.Bean.SendMessageBean;
import Web.MVC.View.ResponseHTML;

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


                ResponseHTML responseHTML = new ResponseHTML();

               // System.out.println(responseHTML.loginOK(userName));

                out.println(responseHTML.loginOK(userName));




                }


        }

        else{


            sendMessageBean.sendMessage(userName+ " failed to login\npassword used: "+password,"ServletLogin");



            response.sendRedirect("loginFailed.jsp");





        }
    }


}
