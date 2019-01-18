package Web.MVC.Controller.Servlet;

import Hibernate.Manage.ManageAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletAdminBan")
public class ServletAdminBan extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String banID = request.getParameter("banInput");

        boolean isBanned;

        ManageAccount manageAccount = new ManageAccount();


        try {

            int[] parts = splitIntoSegments(banID);


            if (parts[1] == 1) {

                isBanned = true;

            } else {
                isBanned = false;
            }

            manageAccount.setBan(parts[0], isBanned);

        } catch (Exception e){

            e.printStackTrace();
        }


        // TODO: Reload page here

        response.sendRedirect("userban.jsp");
    }


    private int[] splitIntoSegments(String input){




        // Split input into two segments
        String segments[] = input.split("/");

        String id = segments[0];
        String setBan = segments[1];


        int[] output = new int[2];



        // Id
        output[0] = Integer.valueOf(id);

        // Set Ban status value
        output[1] = Integer.valueOf(setBan);


        return output;

    }
}
