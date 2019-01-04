package Web.MVC.Controller.Servlet;

import Web.MVC.Controller.Bean.SearchBean;
import Web.MVC.Controller.Bean.SendMessageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletWelcome")
public class ServletWelcome extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        boolean isValidate = false;





        // For sending message to jms queue
        SendMessageBean sendMessageBean = new SendMessageBean();



        String searchFor = request.getParameter("inputSearch");


        SearchBean searchBean = new SearchBean();

        searchBean.searchForPersons(searchFor);












            sendMessageBean.sendMessage("searched for:  "+searchFor+ " executed by username","ServletWelcome");




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



                response.sendRedirect("welcome.jsp");


            }


        }


}
