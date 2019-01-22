package Web.MVC.Controller.Servlet;

import Hibernate.Manage.ManagePerson;
import Web.MVC.Controller.Bean.LoginBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletPresentation")
public class ServletPresentation extends HttpServlet {

    @EJB
    LoginBean LoginEJB;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String input = request.getParameter("press_user");

        iniCookieValues(request,response);

        ManagePerson managePerson = new ManagePerson();

        managePerson.setPresentation(LoginEJB.getU_name(),input);

        String url = "/./nwProj_war_exploded/member/welcome.jsp";


        try {
            response.sendRedirect(response.encodeRedirectURL(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Ini Method
    private void iniCookieValues(HttpServletRequest request, HttpServletResponse response){

        Cookie[] cookies;
        cookies = request.getCookies();

        for(Cookie c : cookies){

            System.out.println("name: "+c.getName());

            if(c.getName().equalsIgnoreCase("name")){
                LoginEJB.setU_name(c.getValue());}


            if(c.getName().equalsIgnoreCase("pointerUser")){

                LoginEJB.setTemp_pointerUser(c.getValue());}

            System.out.println("value: "+c.getValue());
        }
    }
}
