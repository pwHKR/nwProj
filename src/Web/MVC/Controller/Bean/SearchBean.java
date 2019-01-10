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

    public String testList(String search){



        String personPrint = "";


        ArrayList<Person> persons;


        persons = searchForPersons(search);


        //TODO: insert loop and use String builder to get all the persons into one String
        personPrint =persons.get(0).getFirstName()+" "+persons.get(0).getLastName()+
                "\nUsername: "+persons.get(0).getUserNameFK();

        return personPrint;
    }
}
