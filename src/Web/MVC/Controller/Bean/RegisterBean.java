package Web.MVC.Controller.Bean;

import Hibernate.DB.ManageAccount;

import javax.ejb.Stateful;

@Stateful(name = "RegisterEJB")
public class RegisterBean {
    public RegisterBean() {
    }


    public void registerAccont(String username,String password,String email){

        ManageAccount manageAccount = new ManageAccount();

        manageAccount.AddAccount(username,password,email);


    }
}
