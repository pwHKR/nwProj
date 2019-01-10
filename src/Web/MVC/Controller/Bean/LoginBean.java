package Web.MVC.Controller.Bean;

import Hibernate.Manage.ManageAccount;

import javax.ejb.Stateless;


@Stateless(name = "LoginEJB")
public class LoginBean {



    public LoginBean() {

    }

    public boolean validate(String userName,String password){

    ManageAccount manageAccount = new ManageAccount();



        return manageAccount.validatePassword(userName,password);
}

   public void test(){

       System.out.println("calling test in Login Bean");
   }
}
