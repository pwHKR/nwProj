package MVC.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
@WebServlet(name = "MVC.Controller.LoginServlet", urlPatterns = {"/MVC.Controller.LoginServlet"})
public class LoginServlet extends HttpServlet {

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


        String userName = request.getParameter("userName");
        String password = request.getParameter("password");




        String responseContent = "";

        String errmsg = "";
        int err = 0;
        /*

        try {
            String queueMessage = userName + "*" + password + "*" + customer.getName()
                    + "*" + customer.getEmailAddress() +  "*" + customer.getCc()
                    + "*" + film.getTitle() + "*" + film.getRentalDuration();
            sendMessage(queueMessage);
        }
        catch (Exception e) {
            errmsg = e.getMessage();
            //System.err.println("*****RegServlet: Registration NOT Successful. Error in Sending Message: " + errmsg);
            err = 1;
        }

        if (err == 0) {
            responseContent = getRegDetails(userName) + getRegDetails(password);
            responseContent = userName + "*" + password + "*" + customer.getName()
                    + "*" + customer.getEmailAddress() +  "*" + customer.getCc()
                    + "*" + film.getTitle() + "*" + film.getRentalDuration();
        }

        */

        if(!userName.isEmpty() && password.length() >= 4 && password.length() <= 6){


            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet RegServlet</title>");
                out.println("</head>");
                out.println("<body>");
                if (err == 0) {
                    out.println("<h3>Registration Request by </h3> <h2>" + userName + "(" + password + ")</h2>");
                    out.println("<br><br> Courses applied for: [<b>" + userName + "], [" + password + "]</b><br><br>");
                    out.println(responseContent);
                }
                else {
                    out.println("<h2>Registration Request Failed! </h2> <h3>Reason:</h3> <br><br>" + errmsg);
                }
                out.println("</body>");
                out.println("</html>");
            }

        }
    }
}
