package Web.MVC.Controller.Bean;

import Hibernate.Entity.Account;
import Hibernate.Entity.Person;
import Hibernate.Manage.ManageAccount;

import javax.ejb.Stateless;

@Stateless(name = "RegisterEJB")
public class RegisterBean {
    public RegisterBean() {
    }





    public void registerAccount(Account account, Person person){

        ManageAccount manageAccount = new ManageAccount();

        manageAccount.AddAccount(account,person);


    }
}
