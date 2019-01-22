package Web.MVC.Controller.Servlet;

import Hibernate.Manage.ManageAccount;
import Web.MVC.Controller.Bean.LoginBean;
import Web.MVC.Controller.Bean.SendMessageBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Web.MVC.Controller.Servlet.ServletLogin", urlPatterns = {"/Web.MVC.Controller.Servlet.ServletLogin"})
public class ServletLogin extends HttpServlet {

    @EJB
    LoginBean LoginEJB;

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

       // sendMessageBean.sendMessage(userName+ " accessed login","ServletLogin");








        isValidate = LoginEJB.validate(request,userName, password);





        System.out.println("isValidate Servlet " + isValidate);

        if (isValidate) {

            ManageAccount manageAccount = new ManageAccount();




               if(manageAccount.isBanned(userName)){

                 response.sendRedirect("banned.jsp");

                   System.out.println("Banned");

                   //TODO: Code Here for redirecting banned users
               }

                     else{




            //TODO: catch already auth exception

            request.login(userName,password);
            request.setAttribute(LoginEJB.getUserAttributeString(),userName);




            LoginEJB.setLoggedOut(false);
            LoginEJB.setU_name(request.getRemoteUser());
                  // System.out.println("LoginEJB in Login userName: "+LoginEJB.getU_name());









           // sendMessageBean.sendMessage(userName+ " Logged in","ServletLogin");




            try (PrintWriter out = response.getWriter()) {



                String url = "member/welcome.jsp";

                //response.sendRedirect("member/welcome.jsp");

                Cookie cookie = new Cookie("name",userName);

                response.addCookie(cookie);



                response.sendRedirect(response.encodeRedirectURL(url));

               // request.getRequestDispatcher("/member/welcome.jsp").forward(request, response);

                //RequestDispatcher rd=request.getRequestDispatcher("member/welcome.jsp");
                //rd.forward(request,response);


            }}


        } else {

          //  System.out.println("in else : ServletLogin");


         //   sendMessageBean.sendMessage(userName + " failed to login\npassword used: " + password, "ServletLogin");


            response.sendRedirect("index.jsp");


        }
    }


}
