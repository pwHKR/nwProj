package Web.MVC.Controller.Bean;

import Hibernate.Entity.AccountData;
import Hibernate.Entity.Person;
import Hibernate.Manage.ManageAccount;

import javax.ejb.Stateless;

@Stateless(name = "RegisterEJB")
public class RegisterBean {
    public RegisterBean() {
    }





    public void registerAccount(AccountData accountData,Person person){

        ManageAccount manageAccount = new ManageAccount();

        manageAccount.AddAccount(accountData,person);


    }
}
