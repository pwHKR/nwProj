package Web.MVC.Controller.Servlet;

import Web.MVC.Controller.Bean.LoginBean;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
@WebServlet(name = "Web.MVC.Controller.Servlet.LoginServlet", urlPatterns = {"/Web.MVC.Controller.Servlet.LoginServlet"})
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



      boolean isValidate = false;





        //



        String userName = request.getParameter("userName");
        String password = request.getParameter("password");



        LoginBean loginBean = new LoginBean();

        isValidate = loginBean.validate(userName,password);








        if(isValidate){




           // boolean isLoginValid = manageAccount.validatePassword(userName,password);

            sendMessage(userName+ " accessed login");




            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet LoginServlet</title>");
                out.println("</head>");
                out.println("<body>");


                    out.println("<h3>Welcome to the social network </h3> <h2>" + userName+"</h2>");




                }


        }

        else{

            sendMessage(userName+ " failed to login\npassword used: "+password);



            response.sendRedirect("loginFailed.jsp");





        }
    }

    private void sendMessage(String message) throws IOException {
        try{
            Context ctx = new InitialContext();
            ConnectionFactory connectionFactory = (ConnectionFactory)ctx.lookup("jms/RegConnectionFactory");
            Queue queue = (Queue)ctx.lookup("jms/RegQueue");

            javax.jms.Connection  connection = connectionFactory.createConnection();
            javax.jms.Session        session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            TextMessage JMSmessage = session.createTextMessage();
            JMSmessage.setText(message);
            System.out.println( "***** LoginServlet: Sent the message to YourQueue:"+ JMSmessage.getText());
            messageProducer.send(JMSmessage);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
