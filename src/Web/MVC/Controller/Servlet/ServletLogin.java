package Web.MVC.Controller.Servlet;

import Web.MVC.Controller.Bean.LoginBean;
import Web.MVC.Controller.Bean.SendMessageBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Web.MVC.Controller.Servlet.ServletLogin", urlPatterns = {"/Web.MVC.Controller.Servlet.ServletLogin"})
public class ServletLogin extends HttpServlet {

    @EJB
    LoginBean loginBean;

    @EJB
    SendMessageBean sendMessageBean;



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        boolean isValidate;


        String userName = request.getParameter("userName");
        String password = request.getParameter("password");


        // For sending message to jms queue

        sendMessageBean.sendMessage(userName+ " accessed login","ServletLogin");







        isValidate = loginBean.validate(request,userName, password);

        System.out.println("isValidate Servlet " + isValidate);

        if (isValidate) {

            request.login(userName,password);
            request.setAttribute(loginBean.getUserAttributeString(),userName);
            loginBean.setUserNameBeanSession(userName);




            sendMessageBean.sendMessage(userName+ " Logged in","ServletLogin");



            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
            response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
            response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
            try (PrintWriter out = response.getWriter()) {


                response.sendRedirect("member/welcome.jsp");


            }


        } else {

            System.out.println("in else : ServletLogin");


            sendMessageBean.sendMessage(userName + " failed to login\npassword used: " + password, "ServletLogin");


            response.sendRedirect("index.jsp");


        }
    }


}
