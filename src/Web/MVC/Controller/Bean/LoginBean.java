package Web.MVC.Controller.Bean;

import Hibernate.Manage.ManageAccount;

import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;


@Stateful(name = "LoginEJB")
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 60)
public class LoginBean {

    private final String userAttribute = "userName_session";

    private String userNameBeanSession;


    public LoginBean() {

    }

    public boolean validate(HttpServletRequest httpServletRequest, String userName, String password) {

        boolean isValidate;

        ManageAccount manageAccount = new ManageAccount();


        isValidate = manageAccount.validatePassword(userName, password);


        if (isValidate) {



            try {
                httpServletRequest.getRemoteUser();
                if (!httpServletRequest.getRemoteUser().equalsIgnoreCase(userName)) {


                    //httpServletRequest.login(userName, password);



                httpServletRequest.getSession().setAttribute(userAttribute, userName);

                    System.out.println("Log in 1 passed in code");

                    }

                    else{httpServletRequest.getSession().invalidate();

                    System.out.println("In else of validate method in login bean");

                    //httpServletRequest.getSession().setAttribute(userAttribute,userName);
                }

            } catch (NullPointerException e) {

            }


            try {
                System.out.println(httpServletRequest.getAuthType());
            } catch (NullPointerException e) {
            }


            try {
                System.out.println("Remote user: " + httpServletRequest.getRemoteUser());
            } catch (NullPointerException e) {
            }

            try {
                System.out.println("is user in normal accses role ?: " + httpServletRequest.isUserInRole("level_1"));
            } catch (NullPointerException e) {
            }

            try {
                System.out.println("name of user " + httpServletRequest.getUserPrincipal().getName());
            } catch (NullPointerException e) {
            }


        }

        System.out.println("LoginBean "+ isValidate);
        return isValidate;
    }

    public boolean logout(HttpServletRequest httpServletRequest) {

        boolean result;
        try {

                httpServletRequest.getSession().removeAttribute(userAttribute);

                System.out.println(httpServletRequest.getRemoteUser() + " logged out");
            setUserNameBeanSession(httpServletRequest.getRemoteUser());

                try {
                    httpServletRequest.logout();
                    httpServletRequest.getSession(true).invalidate();

                    result = true;
                } catch (ServletException e) {
                   result = false;
                }




        } catch (NullPointerException e) {

            System.out.println("(no user logged in)");
            result = false;
        }

        System.out.println("logout result = " + result);
        return result;
    }

    public String getUserAttributeString() {
        return userAttribute;
    }


    public void setUserNameBeanSession(String userNameBeanSession) {
        this.userNameBeanSession = userNameBeanSession;
    }

    public String getUserName(){

        if(userNameBeanSession != null) {

            System.out.println("Login Bean Remote User");
            return userNameBeanSession;
        }

        else{return "null";}

    }


}

