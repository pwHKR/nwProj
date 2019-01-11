package Web.MVC.Controller.Servlet;

import Web.MVC.Controller.Bean.LoginBean;
import Web.MVC.Controller.Bean.SendMessageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;







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








        String userName = request.getParameter("userName");
        String password = request.getParameter("password");




        // For sending message to jms queue
        SendMessageBean sendMessageBean = new SendMessageBean();




        LoginBean loginBean = new LoginBean();



        isValidate = loginBean.validate(userName,password);










        if(isValidate){


            boolean isUserPrincipal = false;
            // login User java ee auth method








            try{
            request.getRemoteUser();
            if(!request.getRemoteUser().equalsIgnoreCase(userName)){

                request.logout();
                request.login(userName, password);

            }}
            catch (NullPointerException e){isUserPrincipal = true;}



            if(isUserPrincipal) {

                    request.login(userName, password);

                System.out.println("passed 'request.login' line in code");


            }

            try{
                System.out.println(request.getAuthType());}
            catch (NullPointerException e){}


            try{
                System.out.println("Remote user: "+request.getRemoteUser());}
            catch (NullPointerException e){}

            try{
                System.out.println("is user in normal accses role ?: "+request.isUserInRole("level_1"));}
            catch (NullPointerException e){}

            try{
                System.out.println("name of user " +request.getUserPrincipal().getName());}
            catch (NullPointerException e){}







            sendMessageBean.sendMessage(userName+ " accessed login","ServletLogin");





            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
            response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
            response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
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


                //ResponseHTML responseHTML = new ResponseHTML();

              // System.out.println(responseHTML.loginOK(userName));

                //out.println(responseHTML.loginOK(userName));

                response.sendRedirect("member/welcome.jsp");





                }


        }

        else{


            sendMessageBean.sendMessage(userName+ " failed to login\npassword used: "+password,"ServletLogin");



            response.sendRedirect("index.jsp");





        }
    }




}
