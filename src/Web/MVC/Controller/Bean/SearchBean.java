package Web.MVC.Controller.Bean;

import Hibernate.Entity.Person;
import Hibernate.Manage.ManagePerson;

import javax.ejb.Stateful;
import java.util.ArrayList;

@Stateful(name = "SearchBeanEJB")
public class SearchBean {
    public SearchBean() {
    }



    //TODO: Return Arraylist to Servlet for HTTP Response
    public void searchUserName(String username){


        ManagePerson managePerson = new ManagePerson();



        ArrayList<Person> p;

        p = managePerson.searchList(username);

        for (Person person: p){

            System.out.println(person.toString());
        }


    }
}
