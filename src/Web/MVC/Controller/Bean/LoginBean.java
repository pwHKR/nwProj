package Web.MVC.Controller.Bean;

import Hibernate.DB.ManageAccount;

import javax.ejb.Stateful;

@Stateful(name = "LoginEJB")
public class LoginBean {



    public LoginBean() {


    }


    public boolean validateLogin(String userName,String password){




        return false;
    }

    public void test(){

        ManageAccount manageAccount = new ManageAccount();

        System.out.println("calling test in Login Bean");

        manageAccount.listAccounts();
    }
}
