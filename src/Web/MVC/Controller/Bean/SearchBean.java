package Web.MVC.Controller.Bean;

import Hibernate.Entity.Person;
import Hibernate.Manage.ManagePerson;

import javax.ejb.Stateful;
import java.util.ArrayList;

@Stateful(name = "SearchBeanEJB")
public class SearchBean {
    public SearchBean() {
    }




    public ArrayList<Person> searchForPersons(String username){


        ManagePerson mp = new ManagePerson();



        ArrayList<Person> persons;

        persons = mp.searchBy_userName(username);

        return persons;



    }
}
